package com.example.tortilleria.retrofit.login;

import com.example.tortilleria.dto.InicioSesionDTO;
import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.ConexionDB;
import com.example.tortilleria.model.Usuario;
import com.example.tortilleria.retrofit.IGitHubService;

import java.util.List;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Body;

public class LoginImpl implements ILogin{
    @Override
    public Call<RespuestaDTO<List<InicioSesionDTO>>> login(@Body Usuario usuario) {
        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(new ConexionDB().obtenerDatosTest())
                .build();

        ILogin service = retrofit.create(ILogin.class);
        return service.login(usuario);
    }
}
