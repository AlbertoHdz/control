/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.services;

import com.escolar.control.RequestBase;
import com.escolar.control.model.CommonComponent;
import com.escolar.control.model.estudianteModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

/**
 *
 * @author Draxl
 */
@Service
public class estudianteService extends CommonComponent{
    
    private static final Logger LOGGER = Logger.getLogger(estudianteService.class);
    
    public Map registrarEstudiante(estudianteModel estudiante){
        String msg = "Estudiante registrado";
        
        return RequestBase.reportaSuccess(msg);
    }
    
    public Map obtenerEstudiantes(){
        String msg = "Estudiantes Obtenidos";
        List lista = new ArrayList<>();
        estudianteModel est = new estudianteModel();
        est.setNombre("Jorge Perez");
        est.setEdad(21);
        est.setCiudad(2);
        lista.add(est);
        est = new estudianteModel();
        est.setNombre("Pedro Dominguez");
        est.setEdad(21);
        est.setCiudad(1);
        lista.add(est);
        return RequestBase.reportaSuccess(lista,msg);
    }
    
    public Map obtenerEstudiante(int idEstudiante){
        try{
            MapSqlParameterSource parameterSource = new MapSqlParameterSource("idEstudiante", idEstudiante);
            String statement = "SELECT * "
                    + "FROM usuario AS c "
                    + "WHERE c.id = :idEstudiante";
            Map<String, Object> registros = connectionByName.queryForMap(statement, parameterSource);
            String msg = "Estudiante Obtenido";
            return RequestBase.reportaSuccess(registros,msg);
        }catch(Exception ex){
            return RequestBase.reportaError(ex.getMessage());
        }
        
    }
}
