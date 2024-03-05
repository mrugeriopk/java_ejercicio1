package com.login.controller;

import com.login.model.input.Usuarios;
import com.login.service.Iservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsuarioController {

    @Autowired
    Iservice service;
    @GetMapping("/lista")
    public ResponseEntity<?> listaUsuarios(){
        return service.listaUsuarios();
    }

    @GetMapping("/busca/{idUsuario}")
    public ResponseEntity<?> buscaUsuarios(@PathVariable Long idUsuario){
        return service.buscaUsuario(idUsuario);
    }

    @DeleteMapping("/borrar/{idUsuario}")
    public ResponseEntity<?> eliminaUsuario(@PathVariable Long idUsuario){
        return service.bajaUsuarios(idUsuario);
    }

    @PostMapping("/agrega")
    public ResponseEntity<?> eliminaUsuario(@RequestBody @Valid Usuarios usuario){
        return service.agregaUsuario(usuario);
    }
}
