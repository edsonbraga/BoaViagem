package com.example.edsonbraga.boaviagem.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.edsonbraga.boaviagem.AnotacaoListener;
import com.example.edsonbraga.boaviagem.Constantes;
import com.example.edsonbraga.boaviagem.R;
import com.example.edsonbraga.boaviagem.domain.Anotacao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edson.braga on 15/08/2016.
 */
public class AnotacaoListFragment extends ListFragment
        implements AdapterView.OnItemClickListener, View.OnClickListener{

    private AnotacaoListener callback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.lista_anotacoes, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Button button = (Button) getActivity().findViewById(R.id.nova_anotacao);
        button.setOnClickListener(this);
        getListView().setOnItemClickListener(this);
        listarAnotacoesPorViagem(getArguments());
    }

    public void listarAnotacoesPorViagem(Bundle bundle) {
        if(bundle != null &&
                bundle.containsKey(Constantes.VIAGEM_SELECIONADA)){

            //utilize a informacao do bundle para buscar
            // as anotacoes no banco de dados
            List<Anotacao> anotacoes = listarAnotacoes();

            ArrayAdapter<Anotacao> adapter =
                    new ArrayAdapter<Anotacao>(getActivity(),
                            android.R.layout.simple_list_item_1,
                            anotacoes);

            setListAdapter(adapter);
        }
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
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (AnotacaoListener) activity;
    }

    @Override
    public void onClick(View view) {
        callback.novaAnotacao();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Anotacao anotacao = (Anotacao) getListAdapter().getItem(position);
        callback.anotacaoSelecionada(anotacao);
    }
}
