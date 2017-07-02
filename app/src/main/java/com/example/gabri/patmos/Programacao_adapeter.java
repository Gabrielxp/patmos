package com.example.gabri.patmos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jober on 30/04/2017.
 */

public class Programacao_adapeter extends BaseAdapter {
    private final Fragment context;
    private List<Programas> programas = new ArrayList<>();

    public Programacao_adapeter(Fragment context, List<Programas> programas){
        this.context = context;
        this.programas = programas;
    }

    @Override
    public int getCount() {
        return programas != null ? programas.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return programas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi = context.getLayoutInflater(new Bundle()).inflate(R.layout.programacao_adapter,viewGroup,false);



        if(vi != null){
                TextView t = (TextView)vi.findViewById(R.id.tNomePrograma);
                TextView thr = (TextView)vi.findViewById(R.id.tHoraPrograma);
                ImageView img = (ImageView)vi.findViewById(R.id.imgPrograma);

                Programas p = programas.get(i);
                t.setText(p.getNome());
                img.setImageResource(p.img);
                img.setImageBitmap(p.getImg_bmp());
                thr.setText(p.getHorario());
           }
        return vi;
    }


}
