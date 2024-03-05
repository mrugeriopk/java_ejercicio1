package com.usuarios.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;

@Getter
@Setter
@Entity
@Table(name="usuarios")
public class Usuarios {
    @Id
    @Column(name="idusuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    @NotBlank (message = "El nombre no púede ser vacio")
    private String nombre;
    @NotBlank (message = "El apellido paterno no púede ser vacio")
    private String apellidop;
    @NotBlank (message = "El apellido materno no púede ser vacio")
    private String apellidom;
    @NotNull(message = "El anio de nacimiento no púede ser vacio")
    private Integer anionacimiento;
    private String direccion;
    @NotBlank (message = "el telefono no puede estar vacio")
    @Size(min = 10,max = 10, message = "Telefono debe tener minimo 10 digitos")
    private String telefono;
    @NotBlank (message = "El correo no púede ser vacio")
    @Email (message = "Correo invalido")
    private String correo;
    private Integer edad;
    private Long idhijo;
}
