package com.example.gabri.patmos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jober on 30/04/2017.
 */

public class Programas {
    public String nome;
    public int img;

    public Programas(String nome, int img){
        this.setNome(nome);
        this.setImg(img);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public static List<Programas> getProgramas(){
        List<Programas> progs = new ArrayList<>();
        progs.add(new Programas("Programa 01",R.drawable.img_padrao));
        progs.add(new Programas("Programa 02",R.drawable.img_padrao));
        progs.add(new Programas("Programa 03",R.drawable.img_padrao));
        progs.add(new Programas("Programa 04",R.drawable.img_padrao));
        progs.add(new Programas("Programa 05",R.drawable.img_padrao));

        return progs;
    }
}
