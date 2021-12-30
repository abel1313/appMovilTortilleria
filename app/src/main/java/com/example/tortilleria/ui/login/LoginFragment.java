package com.example.tortilleria.ui.login;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tortilleria.R;
import com.example.tortilleria.databinding.LoginFragmentBinding;
import com.example.tortilleria.dto.RespuestaDTO;
import com.example.tortilleria.model.Permisos;
import com.example.tortilleria.model.Usuario;
import com.example.tortilleria.retrofit.login.AdapterLogin;
import com.example.tortilleria.retrofit.login.ILogin;
import com.example.tortilleria.ui.login.log.IOperacionPresenter;
import com.example.tortilleria.ui.login.log.IOperacionView;
import com.example.tortilleria.ui.login.log.OperacionPresenterImpl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment implements IOperacionView {

    private LoginViewModel mViewModel;
    private LoginViewModel loginViewModel;
    private LoginFragmentBinding binding;
    private IOperacionPresenter iOperacionPresenter;

    private Button btnUsuario, btnRegistrarse;
    private EditText txtUsuario, txtContrasena;


    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtUsuario =  view.findViewById(R.id.txtUsuario);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        iOperacionPresenter = new OperacionPresenterImpl(this);
        loginViewModel =
                new ViewModelProvider(this).get(LoginViewModel.class);


        binding = LoginFragmentBinding.inflate(inflater, container, false);
        btnUsuario = binding.btnAcceder;
        btnRegistrarse =binding.btnRegistrarse;
        txtUsuario = binding.txtUsuario;
        txtContrasena = binding.txtContrasena;

        btnUsuario.setOnClickListener(clic->{
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(txtUsuario.getText()+"");
            usuario.setContrasenaUsuario(txtContrasena.getText()+"");
            iOperacionPresenter.loginPresenter(usuario);
        });

        View root = binding.getRoot();
        final TextView textView = binding.textLogin;
        loginViewModel.getText().observe(getViewLifecycleOwner(), (String s)->{
            textView.setText(s+" ");
        });



        return root;
    }


    @Override
    public void logisListoView(RespuestaDTO<Usuario> usuario) {

        Toast.makeText(this.getContext(), usuario.getMensaje(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void showResultView(String result) {
//        txtResult.setText(result);
        Toast.makeText(this.getContext(), result, Toast.LENGTH_LONG).show();

    }

    @Override
    public void invalidOperationView() {
        Toast.makeText(this.getContext(), "Invalid operation", Toast.LENGTH_LONG).show();
    }
}