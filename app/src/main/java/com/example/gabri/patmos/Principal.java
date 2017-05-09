package com.example.gabri.patmos;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class Principal extends AppCompatActivity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        setContentView(R.layout.activity_principal);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Patmos Web Rádio");


        Button btProg = (Button) findViewById(R.id.btProg);
        btProg.setOnClickListener(onClickBtProg());

    }

    private View.OnClickListener onClickBtProg() {
        return new Button.OnClickListener() {
            public void onClick(View v){
                //Navega para a prox tela
                Intent intent = new Intent(Principal.this,MainActivity.class);
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
