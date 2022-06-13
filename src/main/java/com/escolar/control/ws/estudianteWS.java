/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.ws;

import com.escolar.control.model.estudianteModel;
import com.escolar.control.services.estudianteService;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Draxl
 */
@RestController
@RequestMapping(value = "/estudiante")
public class estudianteWS {
    
    @Autowired
    estudianteService estudianteService;
    
    @PostMapping(value = "/", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String saveEstudiante(estudianteModel student){
        Map salida = estudianteService.registrarEstudiante(student);
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String getEstudiantes(){
        Map salida = estudianteService.obtenerEstudiantes();
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/{idEstudiante}", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String getEstudiante(@PathVariable(value = "idEstudiante") int idEstudiante){
        Map salida = estudianteService.obtenerEstudiante(idEstudiante);
        return JSONValue.toJSONString(salida);
    }
}
