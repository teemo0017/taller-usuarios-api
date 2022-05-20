package com.example.ejemplo.api.services;

import java.util.List;

import com.example.ejemplo.api.DTO.respuestaDTO;
import com.example.ejemplo.api.constante.apiConstante;
import com.example.ejemplo.api.models.perfilEntidad;
import com.example.ejemplo.api.repositories.perfilRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class perfilService {
    

    @Autowired
    perfilRepository perfilRepository;

    
    public ResponseEntity<Object> listarPerfil(){

        ResponseEntity<Object> response = ResponseEntity.ok(HttpStatus.OK);

        try {
        Iterable<perfilEntidad> usuario = perfilRepository.findAll();
        respuestaDTO respuestadto = new respuestaDTO(HttpStatus.OK, apiConstante.DTO_OK,usuario);
        response = new ResponseEntity<>(respuestadto,HttpStatus.OK);

        } catch (Exception e) {
            respuestaDTO respuestadto = new respuestaDTO(HttpStatus.INTERNAL_SERVER_ERROR, apiConstante.DTO_ERROR);
            response = new ResponseEntity<>(respuestadto,HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;

    }

    public void eliminarPerfil(Integer id){
        perfilRepository.deleteById(id);
    }

}
