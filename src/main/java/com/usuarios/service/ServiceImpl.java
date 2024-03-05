package com.usuarios.service;



import com.usuarios.model.input.Hijos;
import com.usuarios.model.input.Usuarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceImpl implements Iservice{


    private final UsuariosRepository usuariosRepository;
    private final RelRepository relRepository;

    public ServiceImpl(UsuariosRepository usuariosRepository, RelRepository relRepository) {
        this.usuariosRepository = usuariosRepository;
        this.relRepository = relRepository;
    }

    private Hijos rel = new Hijos();
    @Override
    public ResponseEntity<?> listaUsuarios() {
        List<Usuarios> lista =usuariosRepository.findAll();
        if(lista.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> bajaUsuarios(Long idUsuario) {
        try {
            if(idUsuario!=1){
                usuariosRepository.deleteById(idUsuario);
                relRepository.actualizarRegistrosPorCondicion(1L, idUsuario);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>("No se puede eliminar usuario default",HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public ResponseEntity<?> buscaUsuario(Long idUsuario) {
        try {
            Usuarios usu= usuariosRepository.findById(idUsuario).get();
            return new ResponseEntity<>(usu,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }

    @Override
    public ResponseEntity<?> agregaUsuario(Usuarios usuario) {
        try {
            LocalDate fecha =LocalDate.now();
            usuario.setEdad(fecha.getYear() - usuario.getAnionacimiento());
            Usuarios usu=usuariosRepository.save(usuario);
            rel.setIdusuario(usu.getIdusuario());
            if(usu.getIdhijo()!=null){rel.setIdhijo(usu.getIdhijo());}else {rel.setIdhijo(1L);}
            relRepository.save(rel);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Nombre ya existente",HttpStatus.BAD_REQUEST);
        }
    }

}
