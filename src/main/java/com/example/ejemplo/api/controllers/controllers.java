package com.example.ejemplo.api.controllers;




import java.util.List;

import com.example.ejemplo.api.constante.apiConstante;
import com.example.ejemplo.api.models.models;

import com.example.ejemplo.api.services.userService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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


    

    // ***************BUSCAR TODOS ***********
    @GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_TODOS)
    public ResponseEntity<Object> listarUsuario(){
        return userService.listarUsuario();
    }


    // ***************BUSCAR POR ID ***********
    @GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_ID)
public ResponseEntity<Object>usuarioId(@PathVariable Long id){
    
    return userService.listaUsuariosId(id);
}


    // ***************ELIMINAR USUARIO ***********
@DeleteMapping(apiConstante.USUARIO_CONTROLADOR_API_DELETE)
public ResponseEntity<Object> elimnarUser(@PathVariable Long id){
     return userService.eliminarUsuario(id);
}


    // ***************BUSUCAR POR APELLIDO ***********
@GetMapping(apiConstante.USUARIO_CONTROLADOR_API_LISTAR_LIKE)
public ResponseEntity<Object> usuarioLikeApellido(@PathVariable String variable) {
    return userService.ListaUsuarioApellido(variable);

}



    // ***************GUARDAR USUARIO ***********
@PostMapping(apiConstante.USUARIO_CONTROLADOR_API_CREAR)
public ResponseEntity<Object> guardarUsuario (@RequestBody models usuario){
   return userService.guardarUsuario(usuario);
}



    // ***************ACTUALIZAR USUARIO ***********
@PutMapping(apiConstante.USUARIO_CONTROLADOR_API_ACTUALIZAR)
public ResponseEntity<Object> actualizarUsuario (@RequestBody models usuario){
   return userService.guardarUsuario(usuario);
}


@PatchMapping(apiConstante.USUARIO_CONTROLADOR_API_ACTUALIZAR_PATCH)
public models actualizarUSuarioPatch(@RequestParam Long id, String apellidos){
     return userService.crearUsuarioPatch(id,apellidos);

}

}
