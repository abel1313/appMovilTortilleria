package com.example.tortilleria.retrofit.login;

import com.example.tortilleria.dto.InicioSesionDTO;
import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Producto;
import com.example.tortilleria.model.Usuario;

import java.util.List;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ILogin {

    @POST("usuarios/iniciarSesion")
    Call<RespuestaDTO<List<InicioSesionDTO>>> login(@Body Usuario usuario);

}
