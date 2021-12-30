package com.example.tortilleria.ui.login.log;

import android.util.Log;
import android.widget.Toast;

import com.example.tortilleria.dto.InicioSesionDTO;
import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Usuario;
import com.example.tortilleria.retrofit.login.AdapterLogin;

import java.util.List;
import java.util.stream.Stream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OperacionPresenterImpl implements IOperacionPresenter
{

    private IOperacionView view;
    private IOperacionInteractor interactor;

    public OperacionPresenterImpl(IOperacionView view) {
        this.view = view;
        this.interactor = new OperacionInterceptiorImpl(this);
    }

    @Override
    public void loginPresenter(Usuario usuario) {

        if( usuario != null )
        {
            Call<RespuestaDTO<List<InicioSesionDTO>>> inicio = AdapterLogin.getApiService().login(usuario);
            inicio.enqueue(new Callback<RespuestaDTO<List<InicioSesionDTO>>>() {
                @Override
                public void onResponse(Call<RespuestaDTO<List<InicioSesionDTO>>> call, Response<RespuestaDTO<List<InicioSesionDTO>>> response) {
                    RespuestaDTO<List<InicioSesionDTO>> usuario = response.body();
                    interactor.loginInteractor(usuario);
                }

                @Override
                public void onFailure(Call<RespuestaDTO<List<InicioSesionDTO>>> call, Throwable t) {
                    Log.d("", "----------------------------------------------");
                    Log.d("", t.getMessage()+"");
                    Log.d("", "----------------------------------------------");
                }
            });
        }

    }

    @Override
    public void showResultPresenter(String result) {
        if (view != null) {
            view.showResultView(result);
        }
    }

    @Override
    public void invalidOperationPresenter() {
        if (view != null) {
            view.invalidOperationView();
        }
    }

    @Override
    public void addPresenter(int num1, int num2) {
        if (interactor != null) {
            interactor.addInteractor(num1, num2);
        }
    }

    @Override
    public void subtractPresenter(int num1, int num2) {
        if (interactor != null) {
            interactor.subtractInteractor(num1, num2);
        }
    }

    @Override
    public void multiplyPresenter(int num1, int num2) {
        if (interactor != null) {
            interactor.multiplyInteractor(num1, num2);
        }
    }

    @Override
    public void dividePresenter(int num1, int num2) {
        if (interactor != null) {
            interactor.divideInteractor(num1, num2);
        }
    }



}
