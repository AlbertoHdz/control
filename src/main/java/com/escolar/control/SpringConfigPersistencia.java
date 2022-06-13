/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control;

import javax.sql.DataSource;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author Draxl
 */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class SpringConfigPersistencia {
    static Logger logger = Logger.getLogger(SpringConfigPersistencia.class);
    
    @Autowired
    Environment environment;
    
    @Bean("dataSourceControl")
    @Primary
    public DataSource dataSource() {
        System.out.println("Definiendo DataSource para el servidor -> control demo");
        String servidor = "control";
        
        String driverClass = String.format("db.%s.driverClass", servidor),
        connectionString = String.format("db.%s.connectionString", servidor),
        username = String.format("db.%s.username", servidor),
        password = String.format("db.%s.password", servidor);
        
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getProperty(driverClass));
        dataSource.setUrl(environment.getProperty(connectionString));
        dataSource.setUsername(environment.getProperty(username));
        dataSource.setPassword(environment.getProperty(password));

        return dataSource;
    }
    
    @Bean("transactionManagerControl")
    @Primary
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager(dataSource());

        return dataSourceTransactionManager;
    }

    @Primary
    @Bean("connectionControl")
    public JdbcTemplate connection() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource());
        return jdbcTemplate;
    }

    @Primary
    @Bean("connectionByNameControl")
    public NamedParameterJdbcTemplate connectionByName() {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return jdbcTemplate;
    }
}
