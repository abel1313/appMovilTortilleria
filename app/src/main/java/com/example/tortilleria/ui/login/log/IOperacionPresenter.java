package com.example.tortilleria.ui.login.log;

import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Usuario;

public interface IOperacionPresenter {

    void loginPresenter(Usuario usuario);
    void showResultPresenter(String result);
    void invalidOperationPresenter();
    void addPresenter(int num1, int num2);
    void subtractPresenter(int num1, int num2);
    void multiplyPresenter(int num1, int num2);
    void dividePresenter(int num1, int num2);

}
