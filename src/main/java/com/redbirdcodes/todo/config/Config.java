package com.redbirdcodes.todo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Autowired
    Environment env;

    @Bean
    public DataSource getDataSource() {
        final DriverManagerDataSource sqliteDataSource = new DriverManagerDataSource();
        sqliteDataSource.setDriverClassName(env.getProperty("persistence.jdbc.driverClassName", "org.sqlite.JDBC"));
        sqliteDataSource.setUrl(env.getProperty("persistence.jdbc.url"));
        sqliteDataSource.setUsername(env.getProperty("persistence.jdbc.username"));
        sqliteDataSource.setPassword(env.getProperty("persistence.jdbc.password"));
        return sqliteDataSource;
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
