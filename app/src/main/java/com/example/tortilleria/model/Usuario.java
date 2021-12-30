package com.example.tortilleria.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Usuario extends Base{

    private String nombreUsuario;
    private String contrasenaUsuario;
    private List<Permisos> permisos;

}
