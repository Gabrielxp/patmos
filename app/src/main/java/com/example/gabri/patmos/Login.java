package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

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

        Button btSite = (Button) findViewById(R.id.botao_site);
        btSite.setOnClickListener(onClickBtSite());

    }

    private View.OnClickListener onClickBtProg() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Login.this,MainActivity.class);

                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickBtCad() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Login.this,Cadastro.class);

                startActivity(intent);
            }
        };
    }

    private View.OnClickListener onClickBtSite() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                Toast.makeText(getContext(), "Abriu Site", Toast.LENGTH_LONG).show();
            }
        };
    }

    private Context getContext(){
        return this;
    }

}
