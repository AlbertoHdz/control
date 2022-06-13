/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.dao;

import com.escolar.control.model.CommonComponent;
import com.escolar.control.model.preguntaModel;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Draxl
 */
@Repository
public class examenDao extends CommonComponent{
    
    public Map registrarExamen(String model){
        Map salida = new HashMap();
        try {
            SimpleJdbcCall storeProcedure = new SimpleJdbcCall(connection)
                    .withProcedureName("usp_RegistrarExamen")
                    .declareParameters(
                            new SqlOutParameter("idExamen", Types.INTEGER),
                            new SqlParameter("examen", Types.VARCHAR)
                    );

            MapSqlParameterSource parametrosIn = new MapSqlParameterSource();
            parametrosIn.addValue("examen", model);
            Map<String, Object> parametrosOut = storeProcedure.execute(parametrosIn);

            int idExamen = (int) parametrosOut.get("idExamen");
            salida.put("codigo", 200);
            salida.put("mensaje", "Examen guardado correctamente");
            salida.put("examen", idExamen);
        } catch (Exception ex) {
            salida.put("codigo", 500);
            salida.put("mensaje", "Hubo un error al guardar examen:  "+ex.getLocalizedMessage());
        }
        return salida;
    }
    
    private boolean guardarPreguntas(List opc, int idExamen){
        for(int i = 0; i< opc.size();i++){
            preguntaModel item = (preguntaModel) opc.get(i);
            SimpleJdbcCall storeProcedure = new SimpleJdbcCall(connection)
                    .withProcedureName("usp_RegistrarPregunta")
                    .declareParameters(
                            //new SqlOutParameter("id", Types.INTEGER),
                            new SqlParameter("idExamen", Types.VARCHAR)
                    );

            MapSqlParameterSource parametrosIn = new MapSqlParameterSource();
            parametrosIn.addValue("idExamen", idExamen);
            parametrosIn.addValue("idExamen", item.getDescripcion());
            Map<String, Object> parametrosOut = storeProcedure.execute(parametrosIn);

        }
        return true;
    }
    
    private boolean guardarRespuestas(List opc, int idPregunta){
        for(int i = 0; i< opc.size();i++){
            preguntaModel item = (preguntaModel) opc.get(i);
            SimpleJdbcCall storeProcedure = new SimpleJdbcCall(connection)
                    .withProcedureName("usp_RegistrarRespuesta")
                    .declareParameters(
                            new SqlParameter("idPregunta", Types.INTEGER),
                            new SqlParameter("idPregunta", Types.INTEGER),
                            new SqlParameter("idPregunta", Types.INTEGER),
                            new SqlParameter("idPregunta", Types.INTEGER),
                            new SqlParameter("idPregunta", Types.INTEGER)
                    );

            MapSqlParameterSource parametrosIn = new MapSqlParameterSource();
            parametrosIn.addValue("idPregunta", idPregunta);
            parametrosIn.addValue("idExamen", item.getDescripcion());
            Map<String, Object> parametrosOut = storeProcedure.execute(parametrosIn);

        }
        return true;
    }
}
