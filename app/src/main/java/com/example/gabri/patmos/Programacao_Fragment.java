package com.example.gabri.patmos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.List;

/**
 * Created by gabri on 01/05/2017.
 */
public class Programacao_Fragment extends Fragment {

    private ListView listv;

    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =  (LinearLayout) inflater.inflate( R.layout.activity_programacao, container, false);
        listv = (ListView) view.findViewById(R.id.listview);
        List<Programas> progs = Programas.getProgramas();
        listv.setAdapter(new Programacao_adapeter(this,progs));

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
