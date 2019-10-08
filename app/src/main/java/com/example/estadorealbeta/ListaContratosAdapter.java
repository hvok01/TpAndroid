package com.example.estadorealbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.estadorealbeta.R;
import com.example.estadorealbeta.ui.contratos.Contrato;

import java.util.List;

public class ListaContratosAdapter extends ArrayAdapter<Contrato> {

    private Context context;
    private List<Contrato> lista;
    private LayoutInflater li;

    public ListaContratosAdapter(@NonNull Context context, int resource, @NonNull List<Contrato> objects, LayoutInflater li) {
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
            itemView=li.inflate(R.layout.lista_contratos,parent,false);

        }

        Contrato contrato = lista.get(position);

        TextView fechaInicio = itemView.findViewById(R.id.tvValueFechaInicioContrato);
        TextView finContrato = itemView.findViewById(R.id.tvValueFechaFinContrato);
        TextView precioPago = itemView.findViewById(R.id.tvValuePrecioContrato);

        fechaInicio.setText(contrato.getFechaInicio());
        finContrato.setText(contrato.getFechaFinalizacion());
        precioPago.setText(contrato.getPrecio()+"");

        return itemView;

    }
}
