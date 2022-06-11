/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escolar.control.dao;

import com.escolar.control.model.CommonComponent;
import com.escolar.control.model.estudianteModel;
import java.sql.Types;
import java.util.HashMap;
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
public class estudianteDao extends CommonComponent{
 
    public Map registrarEstudiante(estudianteModel model){
        Map salida = new HashMap();
        try {
            SimpleJdbcCall storeProcedure = new SimpleJdbcCall(connection)
                    .withProcedureName("usp_RegistrarEstudiante")
                    .declareParameters(
                            new SqlOutParameter("idEstudiante", Types.INTEGER),
                            new SqlParameter("estudiante", Types.VARCHAR)
                    );

            MapSqlParameterSource parametrosIn = new MapSqlParameterSource();
            parametrosIn.addValue("estudiante", model);
            Map<String, Object> parametrosOut = storeProcedure.execute(parametrosIn);

            int idEstudiante = (int) parametrosOut.get("idEstudiante");
            salida.put("codigo", 200);
            salida.put("mensaje", "Estudiante guardado correctamente");
            salida.put("estudiante", idEstudiante);
        } catch (Exception ex) {
            salida.put("codigo", 500);
            salida.put("mensaje", "Hubo un error al guardar estudiante:  "+ex.getLocalizedMessage());
        }
        return salida;
    }
}
