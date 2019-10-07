package com.example.estadorealbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.estadorealbeta.ui.inquilinos.Inquilino;

import org.w3c.dom.Text;

import java.util.List;

public class ListaInquilinosAdapter extends ArrayAdapter<Inquilino> {

    private Context context;
    private List<Inquilino> lista;
    private LayoutInflater li;

    public ListaInquilinosAdapter(@NonNull Context context, int resource, @NonNull List<Inquilino> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = convertView;

        if(itemView==null) {
            itemView=li.inflate(R.layout.lista_inquilinos,parent,false);

        }

        Inquilino inquilino = lista.get(position);

        TextView dniInquilino = itemView.findViewById(R.id.tvDniInquilino2);
        TextView apellidoInquilino = itemView.findViewById(R.id.tvValueApellidoInq);
        TextView nombreInquilino = itemView.findViewById(R.id.tvValueNombreInq);
        TextView direccionInquilino = itemView.findViewById(R.id.tvValueDireccionInq);
        TextView telefonoInquilino = itemView.findViewById(R.id.tvValueTelefonoInq);

        dniInquilino.setText(inquilino.getDni()+"");
        apellidoInquilino.setText(inquilino.getApellido());
        nombreInquilino.setText(inquilino.getNombre());
        direccionInquilino.setText(inquilino.getDireccion());
        telefonoInquilino.setText(inquilino.getTelefono());

        return itemView;

    }
}
