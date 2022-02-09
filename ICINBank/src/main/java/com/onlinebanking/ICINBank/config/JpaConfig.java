package com.onlinebanking.ICINBank.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
@ConfigurationProperties(prefix="spring.datasource")
public class JpaConfig {

    @Bean
    public DataSource getDataSource() throws SQLException {
        return
        DataSourceBuilder.create()
                        .driverClassName("com.mysql.cj.jdbc.Driver")
                        .url("jdbc:mysql://localhost:3306/onlinebanking")
                        .username("onlinebankinguser")
                        .password("password")
                        .build();
    }
}

