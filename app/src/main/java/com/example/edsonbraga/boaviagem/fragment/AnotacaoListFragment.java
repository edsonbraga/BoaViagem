package com.example.edsonbraga.boaviagem.fragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.edsonbraga.boaviagem.R;
import com.example.edsonbraga.boaviagem.domain.Anotacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edson.braga on 15/08/2016.
 */
public class AnotacaoListFragment extends ListFragment
        implements AdapterView.OnItemClickListener, View.OnClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lista_anotacoes, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        List<Anotacao> anotacoes = listarAnotacoes();

        ArrayAdapter<Anotacao> adapter =
                new ArrayAdapter<Anotacao>(getActivity(),
                android.R.layout.simple_list_item_1,anotacoes);

        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

        Button button = (Button) getActivity().findViewById(R.id.nova_anotacao);
        button.setOnClickListener(this);
    }

    private List<Anotacao> listarAnotacoes() {
        List<Anotacao> anotacoes = new ArrayList<Anotacao>();

        for (int i = 1; i<= 20; i++){
            Anotacao anotacao = new Anotacao();
            anotacao.setDia(i);
            anotacao.setTitulo("Anotacao " +  i);
            anotacao.setDescricao("Descrição " + i);
            anotacoes.add(anotacao);
        }
        return anotacoes;
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
