package com.example.tortilleria.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public final class ConexionDB
{
    private  String urlDB;
    private final String host;
    private final String port;


    public ConexionDB()
    {
        this.port = "8080";
        this.host = "http://192.168.1.64:"+this.port+"/proyecto/";
        this.urlDB = this.host;
    }
    public String obtenerDatosTest()
    {
        return this.urlDB;
    }
}
