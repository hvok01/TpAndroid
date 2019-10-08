package com.example.estadorealbeta.ui.salir;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.estadorealbeta.InicioSesion;
import com.example.estadorealbeta.MainActivity;
import com.example.estadorealbeta.R;

public class SalirFragment extends Fragment {

    //161616
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        Intent i = new Intent(getContext(),InicioSesion.class);
        startActivity(i);

        View root = inflater.inflate(R.layout.fragment_salir, container, false);
        return root;
    }
}