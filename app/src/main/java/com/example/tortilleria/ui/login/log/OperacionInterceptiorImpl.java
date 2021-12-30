package com.example.tortilleria.ui.login.log;

import com.example.tortilleria.dto.InicioSesionDTO;
import com.example.tortilleria.dto.RespuestaDTO;

import java.util.List;
import java.util.stream.Stream;

public class OperacionInterceptiorImpl implements IOperacionInteractor
{
    private int result;
    private IOperacionPresenter iOperacionPresenter;

    public OperacionInterceptiorImpl ( final IOperacionPresenter iOperacionPresenter)
    {
        this.iOperacionPresenter = iOperacionPresenter;
    }

    @Override
    public void loginInteractor(RespuestaDTO<List<InicioSesionDTO>> usuario) {
        if( usuario.getCode() == "200 OK")
        {

        }
        this.iOperacionPresenter.showResultPresenter(usuario.getMensaje());

    }

    @Override
    public void addInteractor(int num1, int num2) {
        result =  num1 + num2;
        iOperacionPresenter.showResultPresenter(Integer.toString(result));
    }

    @Override
    public void subtractInteractor(int num1, int num2) {
        result = num1 - num2;
        iOperacionPresenter.showResultPresenter(Integer.toString(result));
    }

    @Override
    public void multiplyInteractor(int num1, int num2) {

        result = num1 * num2;
        iOperacionPresenter.showResultPresenter(Integer.toString(result));
    }

    @Override
    public void divideInteractor(int num1, int num2) {
        if (num2 == 0) {
            result = num1 / num2;
            iOperacionPresenter.showResultPresenter(Integer.toString(result));
        } else {
            iOperacionPresenter.invalidOperationPresenter();
        }
    }
}
