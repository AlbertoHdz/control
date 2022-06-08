# control
Aqui se van a agregar las funcionalidades del proyecto que se pide realizar

A continuación se describe como es o debería ser el funcionamiento del presente proyecto.
Dado que el sistema debe permitir la gestion de examenes y estudiantes

Para la base de datos se tiene
- Una tabla para las preguntas
- una tabla para las ciudades
- Una tabla para las respuestas (opciones) en donde debe tener una columna para idLugar y zona horaria, y si es correcta
- una tabla de examenes, donde se vayan guardando las preguntas y cada pregunta con cuatro respuestas

Lo ideal es que se tenga un procedimiento almacenado para realizar la carga y guardado de 
- Nuevos estudiantes
- Nuevos examenes, un arreglo de preguntas y respuestas 

Servicios
Tener unas rutas para acceder a las funcionalidades

- GET  -> proyecto/control/estudiante/
- GET  -> proyecto/control/estudiante/{id}
- POST -> proyecto/control/estudiante/

- GET  -> proyecto/control/examen/
- GET  -> proyecto/control/examen/{id}
- POST -> proyecto/control/examen/
- POST -> proyecto/control/examen/validar/

