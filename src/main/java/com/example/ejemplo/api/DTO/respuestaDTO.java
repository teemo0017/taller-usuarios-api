package com.example.ejemplo.api.DTO;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

public class respuestaDTO {
    private int codigo;
    private String descripcion;
    private String estado;
    private String respuesta;


    private Object objetoRespuesta;


  




    public respuestaDTO(HttpStatus estado, String descripcion, Object objetoRespuesta) {
        this.codigo = estado.value();
        this.descripcion = descripcion;
        this.estado = estado.name();
        this.respuesta = OffsetDateTime.now().toString();
        this.objetoRespuesta = objetoRespuesta;
    }

    public respuestaDTO(HttpStatus estado , String descripcion) {
        this.codigo = estado.value();
        this.descripcion = descripcion;
        this.estado = estado.name();
        this.respuesta = OffsetDateTime.now().toString();
    }



    


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public String getDescripcion() {
        return descripcion;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getRespuesta() {
        return respuesta;
    }


    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }


    public Object getObjetoRespuesta() {
        return objetoRespuesta;
    }


    public void setObjetoRespuesta(Object objetoRespuesta) {
        this.objetoRespuesta = objetoRespuesta;
    }
}
