package com.login.service;

import com.login.model.input.Hijos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface RelRepository extends JpaRepository<Hijos,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE Hijos m SET m.idhijo = :nuevoValor WHERE m.idhijo = :condicion")
    int actualizarRegistrosPorCondicion(Long nuevoValor, Long condicion);


}
