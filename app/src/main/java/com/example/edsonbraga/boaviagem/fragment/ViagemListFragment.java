package com.example.edsonbraga.boaviagem.fragment;

import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edson.braga on 12/08/2016.
 */
public class ViagemListFragment extends ListFragment implements AdapterView.OnItemClickListener{

    @Override
    public void onStart() {
        super.onStart();
        List<String> viagens = Arrays.asList("Campo Grande", "São Paulo", "Miami");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, viagens);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
}
