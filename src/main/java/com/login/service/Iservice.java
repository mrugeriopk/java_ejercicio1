package com.login.service;

import com.login.model.input.Usuarios;
import org.springframework.http.ResponseEntity;

public interface Iservice {
    ResponseEntity<?> listaUsuarios();

    ResponseEntity<?> bajaUsuarios(Long idUsuario);
    ResponseEntity<?> buscaUsuario(Long idUsuario);
    ResponseEntity<?> agregaUsuario(Usuarios usuario);

}
