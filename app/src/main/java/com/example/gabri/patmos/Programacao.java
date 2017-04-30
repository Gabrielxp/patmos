package com.example.gabri.patmos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Jober on 25/04/2017.
 */

public class Programacao extends android.support.v7.app.AppCompatActivity {
    private ListView listv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programacao);

        listv = (ListView) findViewById(R.id.listview);
        List<Programas> progs = Programas.getProgramas();
        listv.setAdapter(new Programacao_adapeter(this,progs));

    }

}
