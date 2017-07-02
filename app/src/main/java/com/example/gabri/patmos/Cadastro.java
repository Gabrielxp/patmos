package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jober on 01/05/2017.
 */

public class Cadastro extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadusuario);

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);

        Button btCad = (Button) findViewById(R.id.btCadastrar);
        btCad.setOnClickListener(onClickBtCad());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private View.OnClickListener onClickBtCad() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                EditText txtNome = (EditText) findViewById(R.id.tNome);
                EditText txtEmail = (EditText) findViewById(R.id.tEmail);
                EditText txtTel = (EditText) findViewById(R.id.tTelefone);

                String nome = txtNome.getText().toString();
                String email = txtEmail.getText().toString();
                String tel = txtTel.getText().toString();

                sharedPreferences = getSharedPreferences("PREF-CADASTRO", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("nome",nome);
                editor.putString("email",email);
                editor.putString("telefone",tel);

                editor.apply();

                sharedPreferences = getSharedPreferences("IS_LOGADO", Context.MODE_PRIVATE);
                editor = sharedPreferences.edit();
                editor.putString("email",email);
                editor.apply();

                ///------------------ Requisição para cadastrar

                new Async().execute();

                /// --------------------------------

                Toast.makeText(getContext(),sharedPreferences.getString("email","") + " está logado :)",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Cadastro.this,MainActivity.class);

                startActivity(intent);

                finish();

            }
        };
    }

    private Context getContext(){
        return this;
    }




    private class Async extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected Void doInBackground(Void... params) {

            EditText txtNome = (EditText) findViewById(R.id.tNome);
            EditText txtEmail = (EditText) findViewById(R.id.tEmail);
            EditText txtTel = (EditText) findViewById(R.id.tTelefone);

            String nome = txtNome.getText().toString();
            String email = txtEmail.getText().toString();
            String tel = txtTel.getText().toString();

            try {
                new NetworkUtils().cadUsuarioPost(email,nome,tel);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

    }

}
