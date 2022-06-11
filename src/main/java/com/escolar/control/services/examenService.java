/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.services;

import com.escolar.control.model.CommonComponent;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Draxl
 */
@Service
public class examenService extends CommonComponent{
    private static final Logger LOGGER = Logger.getLogger(examenService.class);
    
    public Map registrarExamen(String examen){
        Map estatus = new HashMap();
        
        return estatus;
    }
    
    public Map obtenerExamenes(){
        Map estatus = new HashMap();
        
        return estatus;
    }
    
    public Map obtenerExamen(int idExamen){
        Map estatus = new HashMap();
        try{
            MapSqlParameterSource parameterSource = new MapSqlParameterSource("idConvenio", idExamen);
            String statement = "SELECT * "
                    + "FROM examen AS c "
                    + "WHERE c.idExamen = :idExamen";
            Map<String, Object> registros = connectionByName.queryForMap(statement, parameterSource);
            return registros;
        }catch(Exception ex){
            estatus.put("codigo", 500);
            estatus.put("mensaje", ex.getLocalizedMessage());
        }
        return estatus;
    }
}
