package com.example.estadorealbeta.ui.perfil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.estadorealbeta.R;

import org.w3c.dom.Text;

public class PerfilFragment extends Fragment {

    private TextView documentoProp;
    private TextView apellidoProp;
    private TextView nombreProp;
    private TextView telefonoProp;
    private TextView correoProp;
    private TextView claveProp;
    private Button editar;
    private Propietario p;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        p = new Propietario("39465965","Gomez","leo","2664056564","leo@leo.com","1234");
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_perfil, container, false);

        documentoProp = root.findViewById(R.id.tbDocumento);
        apellidoProp = root.findViewById(R.id.tbApellidoEditar);
        nombreProp = root.findViewById(R.id.tbNombreProp);
        telefonoProp = root.findViewById(R.id.tbTelefono);
        correoProp = root.findViewById(R.id.tbCorreo);
        claveProp = root.findViewById(R.id.tbClaveEditar);
        editar = root.findViewById(R.id.btnEditar);


        documentoProp.setText(p.getDni());
        apellidoProp.setText(p.getApellido());
        nombreProp.setText(p.getNombre());
        telefonoProp.setText(p.getTelefono());
        correoProp.setText(p.getCorreo());


        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(documentoProp.getText().toString() != "" && apellidoProp.getText().toString() != ""
                && nombreProp.getText().toString() != "" && telefonoProp.getText().toString() != ""
                && correoProp.getText().toString() != "" && claveProp.getText().toString() != "") {

                    p.setDni(documentoProp.getText().toString());
                    p.setApellido(apellidoProp.getText().toString());
                    p.setNombre(nombreProp.getText().toString());
                    p.setTelefono(telefonoProp.getText().toString());
                    p.setCorreo(correoProp.getText().toString());
                    p.setClave(claveProp.getText().toString());
                    Toast.makeText(getContext(), "Cambios guardados", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(),"Campos vacios",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;

    }
}