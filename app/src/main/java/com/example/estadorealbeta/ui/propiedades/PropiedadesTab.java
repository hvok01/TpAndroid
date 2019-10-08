package com.example.estadorealbeta.ui.propiedades;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.estadorealbeta.R;

public class PropiedadesTab extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText domicilio;
    private EditText ambientes;
    private Spinner spinnerTpo;
    private Spinner spinneru;
    private EditText precio;
    private CheckBox cbDisponible;
    private Button editar;
    private Propiedad p;

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PropiedadesTab() {
        // Required empty public constructor
    }

    public PropiedadesTab(Propiedad p) {
        this.p = p;
        // Required empty public constructor
    }

    public static PropiedadesTab newInstance(String param1, String param2) {
        PropiedadesTab fragment = new PropiedadesTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_propiedades_tab, container, false);

        domicilio=root.findViewById(R.id.tbPropidadDomicilio);
        ambientes=root.findViewById(R.id.tbAmbientes);
        spinnerTpo=root.findViewById(R.id.spinnerTipo);
        spinneru=root.findViewById(R.id.spinnerUso);
        precio=root.findViewById(R.id.tbPrecioProp);
        cbDisponible=root.findViewById(R.id.cbDisponible);
        editar=root.findViewById(R.id.btnEditar);

        domicilio.setText(p.getDomicilio());
        ambientes.setText(p.getAmbientes());

        if(p.getTipo()=="Casa") {
            spinnerTpo.setSelection(1);
        } else if (p.getTipo()=="Local") {
            spinnerTpo.setSelection(0);
        }

        if(p.getUso()=="Comercial"){
            spinneru.setSelection(0);
        } else if(p.getUso()=="Recidencial") {
            spinneru.setSelection(1);
        }

        precio.setText(p.getPrecio()+"");

        if(p.isDisponible()){
            cbDisponible.setChecked(true);
        } else {
            cbDisponible.setChecked(false);
        }

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(domicilio.getText().toString()!="" && ambientes.getText().toString() != "" && precio.getText().toString()!="") {
                    p.setDomicilio(domicilio.getText().toString());
                    p.setAmbientes(ambientes.getText().toString());
                    p.setTipo(spinnerTpo.getSelectedItem().toString());
                    p.setUso(spinneru.getSelectedItem().toString());
                    p.setPrecio(Double.parseDouble(precio.getText().toString()));
                    if(cbDisponible.isChecked()){
                        p.setDisponible(true);
                    } else {
                        p.setDisponible(false);
                    }

                    Toast.makeText(getContext(), "Cambios guardados con exito", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getContext(), "Campos vacíos.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        return root;

    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
