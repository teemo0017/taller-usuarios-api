package com.example.ejemplo.api.controllers;




import java.util.List;

import com.example.ejemplo.api.constante.apiConstante;
import com.example.ejemplo.api.models.models;

import com.example.ejemplo.api.services.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(apiConstante.USUARIO_CONTROLADOR_API)
@RestController
public class controllers {

    @Autowired
    userService userService;


    @GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_TODOS)
    public List<models> listarUsuario(){
        return userService.listarUsuario();
    }

    @GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_ID)
public ResponseEntity<models>usuarioId(@PathVariable Long id){
    
    return userService.listaUsuariosId(id);
}

@GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_LIKE)
public ResponseEntity<List<models>> usuarioLikeApellido(@PathVariable String variable) {
    return userService.listaUsuariosId(variable);

}

@PostMapping(apiConstante.USUARIO_CONTROLADOR_API_CREAR)
public models crearUsuario(@RequestBody models usuario){
   return userService.crearUsuario(usuario);
}

@PutMapping(apiConstante.USUARIO_CONTROLADOR_API_ACTUALIZAR)
public models actualizarUsuario(@RequestBody models usuario){
   return userService.crearUsuario(usuario);
}


@PatchMapping(apiConstante.USUARIO_CONTROLADOR_API_ACTUALIZAR_PATCH)
public models actualizarUSuarioPatch(@RequestParam Long id, String apellidos){
     return userService.crearUsuarioPatch(id,apellidos);

}

}
