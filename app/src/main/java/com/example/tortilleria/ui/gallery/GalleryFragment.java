package com.example.tortilleria.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tortilleria.R;
import com.example.tortilleria.databinding.FragmentGalleryBinding;
import com.example.tortilleria.model.ConexionDB;
import com.example.tortilleria.model.Producto;
import com.example.tortilleria.retrofit.GitHubServiceImpl;
import com.example.tortilleria.retrofit.IGitHubService;
import com.example.tortilleria.retrofit.MyAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

//    private TextView textView = null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);


        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGallery;
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

//                textView.setText(new ConexionDB().obtenerDatosTest());

                Call<List<Producto>> lista = MyAdapter.getApiService().listRepos();
                    lista.enqueue(new Callback<List<Producto>>() {
                        @Override
                        public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {
                            textView.setText("aqui andamos "+ response.body());
                        }

                        @Override
                        public void onFailure(Call<List<Producto>> call, Throwable t) {

                            textView.setText("mal andamos "+ t.getMessage());
                        }
                    });



            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}