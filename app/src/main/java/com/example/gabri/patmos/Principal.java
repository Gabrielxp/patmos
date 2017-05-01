package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Principal extends android.support.v7.app.AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button btProg = (Button) findViewById(R.id.btProg);
        btProg.setOnClickListener(onClickBtProg());

    }

    private View.OnClickListener onClickBtProg() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                //Navega para a prox tela
                Intent intent = new Intent(Principal.this,Programacao.class);
                //Bundle params = new Bundle();
                //params.putString("nome","Jober Campos");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private Context getContext() {
        return this;
    }

}
