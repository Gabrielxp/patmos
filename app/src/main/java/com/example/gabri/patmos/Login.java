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

}
