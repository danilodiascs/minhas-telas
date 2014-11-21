package com.example.danilo.fidelidadeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Danilo on 20/11/2014.
 */
public class ListaPremioAdapter extends ArrayAdapter<Premio> {

    Context contexto;
    List<Premio> lista_premios = null;
    AlertDialog alerta;

    public ListaPremioAdapter(Context contexto, List<Premio> lista_premios) {
        super(contexto, 0, lista_premios);
        this.lista_premios = lista_premios;
        this.contexto = contexto;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Premio premio = lista_premios.get(position);

        if(view == null)
            view = LayoutInflater.from(contexto).inflate(R.layout.item_list_premios, null);

        TextView textViewPremio = (TextView) view.findViewById(R.id.textView_premios);
        textViewPremio.setText(String.valueOf(premio.getTitulo() + " " + premio.getPontos()));

        ImageView imageViewPremio_excluir = (ImageView) view.findViewById(R.id.imageview_excluir_premios);
        imageViewPremio_excluir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //View view = LayoutInflater.from(contexto).inflate(R.layout.admin_diag_incluirpremio, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
                builder.setTitle("Excluir Prêmio");
                builder.setMessage("Deseja excluir este prêmio?");
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
