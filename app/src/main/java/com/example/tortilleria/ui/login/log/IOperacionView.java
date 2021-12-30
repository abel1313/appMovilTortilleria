package com.example.tortilleria.ui.login.log;

import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Usuario;

public interface IOperacionView {

    void logisListoView(RespuestaDTO<Usuario> usuario);
    void showResultView(String result);
    void invalidOperationView();
}
