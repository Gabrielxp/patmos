package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

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
                TextView txtNome = (TextView) findViewById(R.id.tNome);
                TextView txtEmail = (TextView) findViewById(R.id.tEmail);
                TextView txtTel = (TextView) findViewById(R.id.tTelefone);

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

                Toast.makeText(getContext(),sharedPreferences.getString("email",""),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Cadastro.this,MainActivity.class);

                startActivity(intent);

            }
        };
    }

    private Context getContext(){
        return this;
    }

}
