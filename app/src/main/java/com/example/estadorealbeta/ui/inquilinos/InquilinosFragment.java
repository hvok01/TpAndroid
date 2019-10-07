package com.example.estadorealbeta.ui.inquilinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.estadorealbeta.ListaInquilinosAdapter;
import com.example.estadorealbeta.R;

import java.util.ArrayList;

public class InquilinosFragment extends Fragment {

    private ArrayList<Inquilino> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_inquilinos, container, false);

        cargarDatos();
        generarListView(root);

        return root;
    }

    public void generarListView(View vista) {
        ArrayAdapter<Inquilino> adapter = new ListaInquilinosAdapter(getContext(),R.layout.lista_inquilinos,lista,getLayoutInflater());
        ListView lv = vista.findViewById(R.id.miLista);
        lv.setAdapter(adapter);
    }

    public void cargarDatos() {
        lista.add(new Inquilino(36345456,"juan","cito","San Martin 334","2664345463"));
        lista.add(new Inquilino(34546345,"mario","perez","Belgrano 223","2664345463"));
    }
}