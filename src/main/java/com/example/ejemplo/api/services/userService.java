package com.example.ejemplo.api.services;

import java.util.List;

import com.example.ejemplo.api.DTO.respuestaDTO;
import com.example.ejemplo.api.models.models;
import com.example.ejemplo.api.repositories.repository;
import com.example.ejemplo.api.constante.apiConstante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import net.bytebuddy.asm.Advice.Return;


@Service
public class userService {
    
    @Autowired
    private repository repository;


        // ***************LISTAR TODOS ***********
    public ResponseEntity<Object> listarUsuario(){

        ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);

        try {
        Iterable<models> usuario = repository.findAll();
        respuestaDTO respuestadto = new respuestaDTO(HttpStatus.OK, apiConstante.DTO_OK,usuario);
        response = new ResponseEntity<>(respuestadto,HttpStatus.OK);

        } catch (Exception e) {
            respuestaDTO respuestadto = new respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR, apiConstante.DTO_ERROR);
            response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;

    }



    // ***************LISTAR POR ID ***********
    public ResponseEntity<Object> listaUsuariosId(Long id){
     
        ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);


        try {

            models usuario = repository.findById(id).get();
            respuestaDTO respuestadto = new  respuestaDTO(HttpStatus.OK,apiConstante.DTO_OK, usuario);
            response = new ResponseEntity<>(respuestadto,HttpStatus.OK);
        //  return new ResponseEntity<models>(usuario,HttpStatus.OK);


        } catch (Exception e) {
            respuestaDTO respuestadto = new  respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR,apiConstante.DTO_ERROR);
            response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
        }



    // ***************LISTAR POR APELLIDO ***********
        public ResponseEntity<Object> ListaUsuarioApellido(String variable){

                ResponseEntity<Object> response =  ResponseEntity.ok(HttpStatus.OK);
            try {

                List<models> usuario = repository.obtenerApellido(variable);
                respuestaDTO respuestadto = new  respuestaDTO(HttpStatus.OK,apiConstante.DTO_OK, usuario);
                response = new ResponseEntity<>(respuestadto,HttpStatus.OK);


            } catch (Exception e) {

                respuestaDTO respuestadto = new  respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR,apiConstante.DTO_ERROR);
                response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);

            }

            return response;
            }



    // ***************GUARDAR USUARIO ***********
        public ResponseEntity<Object> guardarUsuario(models usuario){
                ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);
            try {
                repository.save(usuario);
                respuestaDTO respuestadto = new respuestaDTO(HttpStatus.OK, apiConstante.DTO_OK_CREACION,usuario);
                response = new ResponseEntity<>(respuestadto,HttpStatus.OK);
            } catch (Exception e) {
                respuestaDTO respuestadto = new respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR, apiConstante.DTO_ERROR_CREACION);
                response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);
            }
        return response;
        }



    // ***************LISTAR POR APELLIDO ***********
        public models crearUsuarioPatch(Long id, String apellidos) {

            models usuario = repository.findById(id).get();
            usuario.setApellido(apellidos);
            return repository.save(usuario);
            
            }


                // ***************ELIMINAR USUARIO***********
            public ResponseEntity<Object> eliminarUsuario(Long id){

                ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);
                try {
                    repository.deleteById(id);
                    respuestaDTO respuestadto = new respuestaDTO(HttpStatus.OK, apiConstante.DTO_OK_DELETE);
                    response = new ResponseEntity<>(respuestadto,HttpStatus.OK);
                } catch (Exception e) {
                    respuestaDTO respuestadto = new respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR, apiConstante.DTO_ERROR_DELETE);
                    response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);
                }
                return response;
            }
        
}
