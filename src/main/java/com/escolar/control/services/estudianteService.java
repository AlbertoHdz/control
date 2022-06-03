/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.services;

import com.escolar.control.model.CommonComponent;
import com.escolar.control.model.estudianteModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

/**
 *
 * @author Draxl
 */
public class estudianteService extends CommonComponent{
    
    private static final Logger LOGGER = Logger.getLogger(estudianteService.class);
    
    public Map registrarEstudiante(estudianteModel estudiante){
        Map estatus = new HashMap();
        
        return estatus;
    }
    
    public Map obtenerEstudiantes(){
        Map estatus = new HashMap();
        
        return estatus;
    }
    
    public Map obtenerEstudiante(int idEstudiante){
        Map estatus = new HashMap();
        try{
            MapSqlParameterSource parameterSource = new MapSqlParameterSource("idConvenio", idEstudiante);
            String statement = "SELECT * "
                    + "FROM convenio.vw_Convenio AS c "
                    + "INNER JOIN convenio.vw_ConvenioEntrega AS ce ON ce.idConvenio = c.idConvenio "
                    + "WHERE c.idEstudiante = :idEstudiante";
            Map<String, Object> registros = connectionByName.queryForMap(statement, parameterSource);
            return registros;
        }catch(Exception ex){
            estatus.put("codigo", 500);
            estatus.put("mensaje", ex.getLocalizedMessage());
        }
        return estatus;
    }
}
