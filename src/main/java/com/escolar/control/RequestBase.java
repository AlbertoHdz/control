/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONValue;

/**
 *
 * @author Draxl
 */
public class RequestBase {
    
    public static Map reportaError(String desc){
        Map salida = new HashMap();
        salida.put("mensaje", "Ha ocurrido un error al realizar la operación");
        salida.put("estatus", "error");
        salida.put("exception", desc);
        return salida;
    }
    
    public static Map reportaSuccess(Object datos,String desc){
        Map salida = new HashMap();
        salida.put("mensaje", "La operación se ha realizado con exito. "+desc);
        salida.put("estatus", "OK");
        salida.put("datos", JSONValue.toJSONString(datos));
        return salida;
    }
    
    public static Map reportaSuccess(Object datos){
        return reportaSuccess(datos, " :D ");
    }
    
    public static Map reportaSuccess(String desc){
        return reportaSuccess(new ArrayList(), desc);
    }
}
