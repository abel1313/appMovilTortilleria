package com.example.tortilleria.dto;


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
public class RespuestaDTO <T>
{
    private String code;
    private Integer codeValue;
    private String mensaje;
    private T t;


}
