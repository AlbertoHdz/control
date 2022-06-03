/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.model;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author Draxl
 */
@Component
public class CommonComponent extends SQLException{

    @Autowired
    protected NamedParameterJdbcTemplate connectionByName;

    @Autowired
    protected JdbcTemplate connection;

}
