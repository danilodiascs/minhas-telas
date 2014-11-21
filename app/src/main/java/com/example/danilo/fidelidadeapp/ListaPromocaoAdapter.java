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
public class ListaPromocaoAdapter extends ArrayAdapter<Promocao> {

    Context contexto;
    List<Promocao> lista_promocao = null;
    AlertDialog alerta;

    public ListaPromocaoAdapter(Context contexto, List<Promocao> lista_promocao) {
        super(contexto, 0, lista_promocao);
        this.lista_promocao = lista_promocao;
        this.contexto = contexto;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Promocao promocao = lista_promocao.get(position);

        if(view == null)
            view = LayoutInflater.from(contexto).inflate(R.layout.item_list_promocao, null);

        TextView textViewPromocao = (TextView) view.findViewById(R.id.textView_promocao);
        textViewPromocao.setText(String.valueOf(promocao.getTitulo() + " " + promocao.getValidade()));

        ImageView imageViewPromocao_excluir = (ImageView) view.findViewById(R.id.imageview_excluir_promocao);
        imageViewPromocao_excluir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //View view = LayoutInflater.from(contexto).inflate(R.layout.admin_diag_incluirpromocao, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Excluir Promocao");
                builder.setMessage("Deseja excluir esta promoção?");
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
