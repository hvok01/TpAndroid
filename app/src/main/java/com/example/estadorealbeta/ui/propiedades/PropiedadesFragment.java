package com.example.estadorealbeta.ui.propiedades;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.estadorealbeta.Nav_prop;
import com.example.estadorealbeta.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

public class PropiedadesFragment extends Fragment {

    private EditText domicilio;
    private EditText ambientes;
    private Spinner spinnerTpo;
    private Spinner spinneru;
    private EditText precio;
    private CheckBox cbDisponible;
    private Button editar;
    private Propiedad p;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);

        p = new Propiedad("San Martin 223","3","Local","Comercial",18000,true);

        domicilio = root.findViewById(R.id.tbPropidadDomicilio);
        ambientes = root.findViewById(R.id.tbAmbientes);
        precio = root.findViewById(R.id.tbPrecioProp);
        spinnerTpo = root.findViewById(R.id.spinnerTipo);
        spinneru = root.findViewById(R.id.spinnerUso);
        cbDisponible = root.findViewById(R.id.cbDisponible);
        editar = root.findViewById(R.id.btnEditar);

        domicilio.setText(p.getDomicilio());
        ambientes.setText(p.getAmbientes());
        precio.setText(p.getPrecio()+"");

        if(p.isDisponible()) {
            cbDisponible.setChecked(true);
        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(domicilio.getText().toString() != "" && ambientes.getText().toString() != ""
                        && precio.getText().toString() != "") {

                    p.setDomicilio(domicilio.getText().toString());
                    p.setAmbientes(ambientes.getText().toString());
                    p.setPrecio(parseDouble(precio.getText().toString()));
                    p.setTipo(spinnerTpo.getSelectedItem().toString());
                    p.setUso(spinneru.getSelectedItem().toString());
                    if(cbDisponible.isChecked()) {
                        p.setDisponible(true);
                    } else {
                        p.setDisponible(false);
                    }
                    Toast.makeText(getContext(), "Cambios guardados con exito", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Campos vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;

    }

}