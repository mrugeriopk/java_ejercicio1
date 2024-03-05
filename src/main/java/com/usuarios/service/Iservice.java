package com.usuarios.service;

import com.usuarios.model.input.Usuarios;
import org.springframework.http.ResponseEntity;

public interface Iservice {
    ResponseEntity<?> listaUsuarios();

    ResponseEntity<?> bajaUsuarios(Long idUsuario);
    ResponseEntity<?> buscaUsuario(Long idUsuario);
    ResponseEntity<?> agregaUsuario(Usuarios usuario);

}
