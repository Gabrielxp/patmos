package com.example.gabri.patmos;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Jober on 16/05/2017.
 */

public class TesteJober extends AppCompatActivity {

    private String filename = "arquivo3.txt";
    EditText texto;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste_jober);

        texto = (EditText) findViewById(R.id.edt_texto);
        Button btSalvar = (Button) findViewById(R.id.btSalvar);
        Button btLer = (Button) findViewById(R.id.btLer);

        //btSalvar.setOnClickListener(onClickSalvar());
        btLer.setOnClickListener(onClickLer());

    }
    /*
    private View.OnClickListener onClickSalvar() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = texto.getText().toString();
                try{
                    File f = getFileStreamPath(filename);
                    if(f.exists()){
                        //Cria o gerador do AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(this);
                        //define o titulo
                        builder.setTitle("O arquivo ja existe!");
                        //define a mensagem
                        builder.setMessage("Deseja substituir ?");
                        //define um botão como positivo
                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(TesteJober.this, "positivo=" + arg1, Toast.LENGTH_SHORT).show();
                            }
                        });
                        //define um botão como negativo.
                        builder.setNegativeButton("Negativo", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                Toast.makeText(TesteJober.this, "negativo=" + arg1, Toast.LENGTH_SHORT).show();
                            }
                        });
                        //cria o AlertDialog
                        alerta = builder.create();
                        //Exibe
                        alerta.show();
                    }
                    FileOutputStream fOut = openFileOutput(filename,MODE_PRIVATE);
                    fOut.write(data.getBytes());
                    fOut.flush();
                    fOut.close();
                    Toast.makeText(getBaseContext(),"Arquivo salvo!",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        };
    }
    */

    private View.OnClickListener onClickLer() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    FileInputStream fIn = openFileInput(filename);
                    int c;
                    String temp="";
                    while ((c = fIn.read()) != -1){
                        temp = temp + Character.toString((char)c);
                    }

                    Toast.makeText(getBaseContext(),"Arquivo Lido!",Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        };
    }



}
