/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.ws;

import java.util.HashMap;
import org.json.simple.JSONValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Draxl
 */
@RestController
public class index {
    
    @GetMapping(value = "/")
    public String index(){
        return "Proyecto ejecutandose";
    }
    
    @GetMapping(value = "/version",consumes = "application/json; charset=utf-8")
    public String demo(){
        HashMap salida = new HashMap();
        salida.put("version", "0.1");
        salida.put("descripcion", "inicio de proyecto");
        return JSONValue.toJSONString(salida);
    }
    
    @PostMapping(value = "/validar", consumes = "application/json; charset=utf-8")
    public String validar(@RequestParam(value = "idUsuario") int idUsuario,@RequestParam(value = "idPregunta") int idPregunta,
                        @RequestParam(value = "idOpcion") int idOpcion,@RequestParam(value = "zonahoraria") int zonahoraria){
        HashMap salida =  new HashMap();
        salida.put("codigo", 200);
        salida.put("respuesta", "prueba");
        return JSONValue.toJSONString(salida);
    }
}
