package com.example.danilo.fidelidadeapp;

/**
 * Created by Danilo on 20/11/2014.
 */
public class Produto {
    String Titulo;
    String Descricao;
    int pontos;

    public Produto(String titulo, String descricao, int pontos) {
        Titulo = titulo;
        Descricao = descricao;
        this.pontos = pontos;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}
