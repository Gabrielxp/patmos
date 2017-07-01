package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    EditText txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if( getSharedPreferences("IS_LOGADO", Context.MODE_PRIVATE).getString("email","") != null){
            setContentView(R.layout.activity_login);
            Intent intent = new Intent(Login.this,Cadastro.class);
            startActivity(intent);
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button btProg = (Button) findViewById(R.id.btLogar);
        btProg.setOnClickListener(onClickBtProg());

        Button btCad = (Button) findViewById(R.id.btCadastrar);
        btCad.setOnClickListener(onClickBtCad());

        Button btSite = (Button) findViewById(R.id.botao_site);
        btSite.setOnClickListener(onClickBtSite());

        txtEmail = (EditText) findViewById(R.id.txEmail);

    }

    private View.OnClickListener onClickBtProg() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                Intent intent = new Intent(Login.this,MainActivity.class);
                //EditText editText = (EditText) findViewById(R.id.txEmail);

                sharedPreferences = getSharedPreferences("IS_LOGADO", Context.MODE_PRIVATE);

                editor = sharedPreferences.edit();

                editor.putString("email", txtEmail.getText().toString());


                editor.apply();

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

    private class Async extends AsyncTask<String, Void, Boolean> {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Boolean doInBackground(String... strings) {

            EditText txtEmail = (EditText) findViewById(R.id.txEmail);
            String email = txtEmail.getText().toString();

            Boolean b = false;

            try {
                b = new NetworkUtils().logar(email);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return b;
        }

    }

}
