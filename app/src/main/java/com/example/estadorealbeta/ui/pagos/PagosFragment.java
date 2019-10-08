package com.example.estadorealbeta.ui.pagos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.estadorealbeta.ListaInquilinosAdapter;
import com.example.estadorealbeta.ListaPagosAdapter;
import com.example.estadorealbeta.PagosExpandibleListViewAdapter;
import com.example.estadorealbeta.R;
import com.example.estadorealbeta.ui.inquilinos.Inquilino;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PagosFragment extends Fragment {

    private ExpandableListView expandableListView;
    private PagosExpandibleListViewAdapter expandableListViewAdapter;
    private List<String> listDataGroup;
    private HashMap<String, List<String>> listDataChild;

    private TextView numeroPago;
    private TextView fechaPago;
    private TextView importePago;
    private Pago p;

    private ArrayList<Pago> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_pagos, container, false);

        initViews(root);
        initListeners(root);
        initObjects();
        initListData();
        return root;
    }

    private void initViews(View v) {
        expandableListView = v.findViewById(R.id.pagosExpListView);
    }

    private void initListeners(final View view) {


        //hacer aqui la magia
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                numeroPago=view.findViewById(R.id.tvValueNumeroPago);
                fechaPago=view.findViewById(R.id.tvValueFecha);
                importePago=view.findViewById(R.id.tvValueImportePago);

                //San martin 225
                if(childPosition==1) {
                    setDefault();
                    cargarDatos1();
                    generarListView(view);
                } else {
                    setDefault();
                    cargarDatos2();
                    generarListView(view);
                }

                return false;
            }

        });

        //al seleccionar el nombre del grupo
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
            }
        });

        //cuando colapsa el grupo
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                setDefault();
            }
        });
    }

    private void initObjects() {

        // initializing the list of groups
        listDataGroup = new ArrayList<>();

        // initializing the list of child
        listDataChild = new HashMap<>();

        // initializing the adapter object
        expandableListViewAdapter = new PagosExpandibleListViewAdapter(getContext(), listDataGroup, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListViewAdapter);

    }

    private void initListData() {

        listDataGroup.add("Propiedades");

        String[] array;

        List<String> listaDePagos = new ArrayList<>();
        array = getResources().getStringArray(R.array.propiedadesPago);
        for (String item : array) {
            listaDePagos.add(item);
        }

        listDataChild.put(listDataGroup.get(0), listaDePagos);

        expandableListViewAdapter.notifyDataSetChanged();

    }

    public void setDefault() {
        lista.clear();
    }


    public void generarListView(View vista) {
        ArrayAdapter<Pago> adapter = new ListaPagosAdapter(getContext(),R.layout.lista_pagos,lista,getLayoutInflater());
        ListView lv = vista.findViewById(R.id.miListaPagos);
        lv.setAdapter(adapter);
    }


    public void cargarDatos1() {
        lista.add(new Pago(1,"05/08/2019",18000));
        lista.add(new Pago(2,"08/09/2019",18000));
    }

    public void cargarDatos2() {
        lista.add(new Pago(1,"07/08/2019",19000));
        lista.add(new Pago(2,"09/09/2019",19000));
    }



}