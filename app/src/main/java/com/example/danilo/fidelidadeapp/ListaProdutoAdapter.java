package com.example.danilo.fidelidadeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Danilo on 20/11/2014.
 */
public class ListaProdutoAdapter extends ArrayAdapter<Produto> {

    Context contexto;
    List<Produto> lista_produtos = null;
    AlertDialog alerta;

    public ListaProdutoAdapter(Context contexto, List<Produto> lista_produtos) {
        super(contexto, 0, lista_produtos);
        this.lista_produtos = lista_produtos;
        this.contexto = contexto;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Produto produto = lista_produtos.get(position);

        if(view == null)
            view = LayoutInflater.from(contexto).inflate(R.layout.item_list_produtos, null);

        TextView textViewProduto = (TextView) view.findViewById(R.id.textView_produto);
        textViewProduto.setText(String.valueOf(produto.getTitulo() + " " + produto.getPontos()));

        ImageView imageViewProduto_excluir = (ImageView) view.findViewById(R.id.imageview_excluir_produto);
        imageViewProduto_excluir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //View view = LayoutInflater.from(contexto).inflate(R.layout.admin_diag_incluirproduto, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Excluir Produto");
                builder.setMessage("Deseja excluir este produto?");
                builder.setPositiveButton("Sim",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int BUTTON_POSITIVE) {
                        Toast.makeText(contexto, "alerta.dismiss()", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Não",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int BUTTON_NEGATIVE) {
                        alerta.dismiss();
                    }
                });

                //builder.setView(view);
                alerta = builder.create();
                alerta.show();
            }
        });

        return view;
    }
}
