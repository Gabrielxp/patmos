package com.example.gabri.patmos;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;


public class Principal_Fragment extends Fragment{

    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        context = container.getContext();
        View view =  (LinearLayout) inflater.inflate( R.layout.activity_principal, container, false);

        ImageButton button = (ImageButton) view.findViewById(R.id.buttonPlay);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicou Play", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton buttonMenos = (ImageButton) view.findViewById(R.id.buttonDiminuirVolume);
        buttonMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicou Menos Volume", Toast.LENGTH_LONG).show();
            }
        });

        ImageButton buttonMais = (ImageButton) view.findViewById(R.id.buttonAumentarVolume);
        buttonMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Clicou Mais Volume", Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }







}
