package com.example.my_portfolio_backend.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DataSourceConfig {

    @Bean
    @Primary
    public DataSource dataSource() {
        String databaseUrl = System.getenv("DATABASE_URL");

        // 1. If DATABASE_URL is missing, we are likely on Localhost
        if (databaseUrl == null || databaseUrl.isEmpty()) {
            return DataSourceBuilder.create()
                    .url("jdbc:postgresql://localhost:5432/portfolio_db")
                    .username("postgres")
                    .password("1234")
                    .build();
        }

        // 2. If it's a Render/Heroku URL (postgres:// or postgresql://), we fix it for
        // JDBC
        if (databaseUrl.startsWith("postgres://") || databaseUrl.startsWith("postgresql://")) {
            try {
                // Replacing with a standard format to avoid parsing issues if protocol varies
                String cleanUrl = databaseUrl.replace("postgresql://", "postgres://");
                URI uri = new URI(cleanUrl);

                String userInfo = uri.getUserInfo();
                String username = userInfo.split(":")[0];
                String password = userInfo.split(":")[1];

                // Building the JDBC URL. Handle missing port (Render internal URLs often omit
                // it)
                String host = uri.getHost();
                int port = uri.getPort();
                String path = uri.getPath();

                StringBuilder jdbcUrl = new StringBuilder("jdbc:postgresql://").append(host);
                if (port != -1) {
                    jdbcUrl.append(":").append(port);
                }
                jdbcUrl.append(path);

                if (uri.getQuery() != null) {
                    jdbcUrl.append("?").append(uri.getQuery());
                }

                return DataSourceBuilder.create()
                        .url(jdbcUrl.toString())
                        .username(username)
                        .password(password)
                        .build();
            } catch (URISyntaxException | ArrayIndexOutOfBoundsException e) {
                // Fallback: simple string replacement if complex parsing fails
                String fallbackJdbc = databaseUrl.replaceFirst("postgre(s|sql)://", "jdbc:postgresql://");
                return DataSourceBuilder.create()
                        .url(fallbackJdbc)
                        .build();
            }
        }

        // 3. If it already starts with jdbc: (manual override), use it as is
        return DataSourceBuilder.create()
                .url(databaseUrl)
                .build();
    }
}
