package com.example.danilo.fidelidadeapp;

import java.util.Date;

/**
 * Created by Danilo on 20/11/2014.
 */
public class Promocao {
    String Titulo;
    String Descricao;
    Date Validade;

    public Promocao(String titulo, String descricao, Date validade) {

        Titulo = titulo;
        Descricao = descricao;
        Validade = validade;
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

    public Date getValidade() {
        return Validade;
    }

    public void setValidade(Date validade) {
        Validade = validade;
    }
}
