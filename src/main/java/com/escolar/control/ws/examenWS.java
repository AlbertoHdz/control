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
@RequestMapping("/examen")
public class examenWS {
    
    @PostMapping(value = "/", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String crear(){
        HashMap salida = new HashMap();
        String msg = "Agregado con exito";
        salida.put("codigo", 200);
        salida.put("mensaje", msg);
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String extraertodos(){
        HashMap salida = new HashMap();
        salida.put("codigo", 200);
        salida.put("examenes", "lista de examnes");
        return JSONValue.toJSONString(salida);
    }
    
    @GetMapping(value = "/{idExamen}", consumes = "application/json; charset=utf-8", produces = "application/json; charset=utf-8")
    public String extraerExamen(@PathVariable(value = "idExamen") int idExamen){
        HashMap salida = new HashMap();
        salida.put("codigo", 200);
        salida.put("examen", "examen: "+idExamen);
        return JSONValue.toJSONString(salida);
    }
}
