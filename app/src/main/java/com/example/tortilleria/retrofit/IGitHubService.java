package com.example.tortilleria.retrofit;

import com.example.tortilleria.model.Producto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IGitHubService {
    @GET("productos")
    Call<List<Producto>> listRepos();


}
