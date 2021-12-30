package com.example.tortilleria.ui.login.log;

import com.example.tortilleria.dto.InicioSesionDTO;
import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Usuario;

import java.util.List;
import java.util.stream.Stream;

public interface IOperacionInteractor {

    void loginInteractor(RespuestaDTO<List<InicioSesionDTO>> usuario);
    void addInteractor(int num1, int num2);
    void subtractInteractor(int num1, int num2);
    void multiplyInteractor(int num1, int num2);
    void divideInteractor(int num1, int num2);

}
