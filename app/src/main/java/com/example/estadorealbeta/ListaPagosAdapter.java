package com.example.estadorealbeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.estadorealbeta.ui.pagos.Pago;

import org.w3c.dom.Text;

import java.util.List;

public class ListaPagosAdapter extends ArrayAdapter<Pago> {

    private Context context;
    private List<Pago> lista;
    private LayoutInflater li;

    public ListaPagosAdapter(@NonNull Context context, int resource, @NonNull List<Pago> objects, LayoutInflater li) {
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
            itemView=li.inflate(R.layout.lista_pagos,parent,false);

        }

        Pago pago = lista.get(position);

        TextView numeroPago = itemView.findViewById(R.id.tvValueNumeroPago);
        TextView fechaPago = itemView.findViewById(R.id.tvValueFecha);
        TextView importePago = itemView.findViewById(R.id.tvValueImportePago);

        numeroPago.setText(pago.getNumeroPago()+"");
        fechaPago.setText(pago.getFechaPago());
        importePago.setText(pago.getImporte()+"");

        return itemView;

    }

}


