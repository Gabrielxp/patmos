package com.example.gabri.patmos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jober on 30/04/2017.
 */

public class Programas {
    public String nome;
    public int img;
    public String horario;

    public Programas(String nome, int img, String horario){
        this.setNome(nome);
        this.setImg(img);
        this.setHorario(horario);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        progs.add(new Programas("Programa 01",R.drawable.img_padrao,"00:00:00 - 05:00:00"));
        progs.add(new Programas("Programa 02",R.drawable.img_padrao,"06:00:00 - 07:00:00"));
        progs.add(new Programas("Programa 03",R.drawable.img_padrao,"07:00:00 - 08:00:00"));
        progs.add(new Programas("Programa 04",R.drawable.img_padrao,"08:00:00 - 09:00:00"));
        progs.add(new Programas("Programa 05",R.drawable.img_padrao,"09:00:00 - 10:00:00"));

        return progs;
    }
}
