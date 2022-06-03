/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.ws;

import java.util.HashMap;
import org.json.simple.JSONValue;
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
    
    @PostMapping(value = "/", consumes = "application/json; charset=utf-8")
    public String saveEstudiante(){
        HashMap salida = new HashMap();
        salida.put("codigo", 200);
        salida.put("mensaje", "Estudiante creado");
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/", consumes = "application/json; charset=utf-8")
    public String getEstudiantes(){
        HashMap salida = new HashMap();
        salida.put("codigo", 200);
        salida.put("estudiantes", "lista de estudiantes");
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/{idEstudiante}", consumes = "application/json; charset=utf-8")
    public String getEstudiante(@PathVariable(value = "idEstudiante") int idEstudiante){
        HashMap salida = new HashMap();
        salida.put("codigo", 200);
        salida.put("estudiante", "estudiantes: "+idEstudiante);
        
        return JSONValue.toJSONString(salida);
    }
}
