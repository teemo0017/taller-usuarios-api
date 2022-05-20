package com.example.ejemplo.api.services;

import java.util.List;

import com.example.ejemplo.api.models.models;
import com.example.ejemplo.api.repositories.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class userService {
    
    @Autowired
    private repository repository;

    public List<models> listarUsuario(){
        return (List<models>)repository.findAll();
    }


    public ResponseEntity<models> listaUsuariosId(Long id){
     

        try {
            models usuario = repository.findById(id).get();
         return new ResponseEntity<models>(usuario,HttpStatus.OK);
        } catch (Exception e) {
        return new ResponseEntity<models>(HttpStatus.NOT_FOUND);
        }
        }

        public ResponseEntity<List<models>> listaUsuariosId(String variable){
     

            try {
                List<models> usuario = repository.obtenerApellido(variable);
             return new ResponseEntity<List<models>>(usuario,HttpStatus.OK);
            } catch (Exception e) {
            return new ResponseEntity<List<models>>(HttpStatus.NOT_FOUND);
            }
            }

        public models crearUsuario(models usuario){
            return repository.save(usuario);
        }

        public models crearUsuarioPatch(Long id, String apellidos) {

            models usuario = repository.findById(id).get();
            usuario.setApellido(apellidos);
            return repository.save(usuario);
            
            }
}
