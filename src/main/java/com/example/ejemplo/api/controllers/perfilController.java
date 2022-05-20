package com.example.ejemplo.api.controllers;


import com.example.ejemplo.api.services.perfilService;

import java.util.List;

import com.example.ejemplo.api.models.perfilEntidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class perfilController {
    
    @Autowired
    perfilService perfilService;
    @GetMapping("/perfil")
    public ResponseEntity<Object> listarperfil(){
        return perfilService.listarPerfil();
    }

    @DeleteMapping("/perfil/{id}")
    public void eliminarPerfil (@PathVariable Integer id){
        perfilService.eliminarPerfil(id);
    }
    


}
