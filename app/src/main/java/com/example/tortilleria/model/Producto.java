package com.example.tortilleria.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Producto extends Base
{

    private String nombreProducto;

    private double precioProducto;

    private String descripcionProducto;

    private String kiloProducto;

}
