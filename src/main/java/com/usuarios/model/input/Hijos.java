package com.usuarios.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="hijos")
public class Hijos {
    @Id
    @Column(name="idrelacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idrelacion;
    private Long idusuario;
    private Long idhijo;
}
