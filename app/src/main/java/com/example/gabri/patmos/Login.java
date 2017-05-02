package com.example.gabri.patmos;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        Button btProg = (Button) findViewById(R.id.btLogar);
        btProg.setOnClickListener(onClickBtProg());

        Button btCad = (Button) findViewById(R.id.btCadastrar);
        btCad.setOnClickListener(onClickBtCad());

    }

    private View.OnClickListener onClickBtProg() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                //Navega para a prox tela
                Intent intent = new Intent(Login.this,Principal.class);
                //Bundle params = new Bundle();
                //params.putString("nome","Jober Campos");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickBtCad() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                //Navega para a prox tela
                Intent intent = new Intent(Login.this,Cadastro.class);
                //Bundle params = new Bundle();
                //params.putString("nome","Jober Campos");
                //intent.putExtras(params);
                startActivity(intent);
            }
        };
    }

}
