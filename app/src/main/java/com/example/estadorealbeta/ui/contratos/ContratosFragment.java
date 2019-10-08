package com.example.estadorealbeta.ui.contratos;

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

import com.example.estadorealbeta.ContratosExpandibleListViewAdapter;
import com.example.estadorealbeta.ListaContratosAdapter;
import com.example.estadorealbeta.ListaPagosAdapter;
import com.example.estadorealbeta.PagosExpandibleListViewAdapter;
import com.example.estadorealbeta.R;
import com.example.estadorealbeta.ui.pagos.Pago;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ContratosFragment extends Fragment {

    private ExpandableListView expandableListView;
    private ContratosExpandibleListViewAdapter expandableListViewAdapter;
    private List<String> listDataGroup;
    private HashMap<String, List<String>> listDataChild;

    private TextView inicioContrato;
    private TextView finContrato;
    private TextView precioContrato;
    private Contrato c;

    private ArrayList<Contrato> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_contratos, container, false);

        initViews(root);
        initListeners(root);
        initObjects();
        initListData();

        return root;
    }

    private void initViews(View v) {
        expandableListView = v.findViewById(R.id.contratosExpListView);
    }

    private void initListeners(final View view) {


        //hacer aqui la magia
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                inicioContrato=view.findViewById(R.id.tvValueFechaInicioContrato);
                finContrato=view.findViewById(R.id.tvValueFechaFinContrato);
                precioContrato=view.findViewById(R.id.tvValuePrecioContrato);

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
        expandableListViewAdapter = new ContratosExpandibleListViewAdapter(getContext(), listDataGroup, listDataChild);

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
        ArrayAdapter<Contrato> adapter = new ListaContratosAdapter(getContext(),R.layout.lista_contratos,lista,getLayoutInflater());
        ListView lv = vista.findViewById(R.id.miListaContratos);
        lv.setAdapter(adapter);
    }

    public void cargarDatos1() {
        lista.add(new Contrato("05/09/2019","01/03/2020",22000));
        lista.add(new Contrato("01/03/2019","01/06/2020",22000));
    }

    public void cargarDatos2() {
        lista.add(new Contrato("09/09/2019","01/03/2020",23000));
        lista.add(new Contrato("01/03/2019","01/06/2020",23000));
    }

}