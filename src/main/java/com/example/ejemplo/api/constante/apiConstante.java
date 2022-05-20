package com.example.ejemplo.api.constante;

public final class apiConstante {
    

    public static final String USUARIO_CONTROLADOR_API = "/api/usuario/";
    public static final String USUARIO_CONTROLADOR_API_DELETE = "/delete/{id}";
    public static final String USUARIO_CONTROLADOR_API_LISTAR_TODOS = "listar-todos";
    public static final String USUARIO_CONTROLADOR_API_LISTAR_ID = "listar-id/{id}";
    public static final String USUARIO_CONTROLADOR_API_LISTAR_LIKE = "listar-like/{variable}";
    public static final String USUARIO_CONTROLADOR_API_CREAR = "crear";
    public static final String USUARIO_CONTROLADOR_API_ACTUALIZAR = "actualizar";
    public static final String USUARIO_CONTROLADOR_API_ACTUALIZAR_PATCH = "actualizar-patch/{id}/{apellido}";

 


    //********RESPUESTAS DTO ***********//


    //OK
   public static final String DTO_OK = "Exito en la consulta";
   public static final String DTO_OK_CREACION = "Exito en la creacion";
   public static final String DTO_OK_ACTUALIZACION = "Exito en la actualizacion";
   public static final String DTO_OK_DELETE = "Exito en la eliminacion";

    //ERROR
    public static final String DTO_ERROR = "Exito en la consulta";
    public static final String DTO_ERROR_CREACION = "Exito en la creacion";
    public static final String DTO_ERROR_ACTUALIZACION = "Exito en la actualizacion";
    public static final String DTO_ERROR_DELETE = "ERROR AL ELIMINAR";
}
