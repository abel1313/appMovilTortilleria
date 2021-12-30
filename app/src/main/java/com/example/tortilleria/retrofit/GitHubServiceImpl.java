package com.example.tortilleria.retrofit;

import com.example.tortilleria.model.ConexionDB;
import com.example.tortilleria.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;

public class GitHubServiceImpl implements  IGitHubService{
    @Override
    public Call<List<Producto>> listRepos() {

        Retrofit retrofit =  new Retrofit.Builder()
                .baseUrl(new ConexionDB().obtenerDatosTest())
                .build();

        IGitHubService service = retrofit.create(IGitHubService.class);
        return service.listRepos();
    }
}
