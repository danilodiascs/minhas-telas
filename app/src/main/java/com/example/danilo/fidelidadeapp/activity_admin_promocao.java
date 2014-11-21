package com.example.danilo.fidelidadeapp;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;


public class activity_admin_promocao extends ListActivity{

    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_promocoes);
        inicializarComponentes();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_admin_premio, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //region Funções Auxiliares

    private void inicializarComponentes(){

        getActionBar().hide(); //ocultando a actionbar

        //region populando a lista de promocao
        List<Promocao> lista_promocao = gerarPromocao();
        final ListaPromocaoAdapter PromocaoAdapter = new ListaPromocaoAdapter(activity_admin_promocao.this, lista_promocao);
        setListAdapter(PromocaoAdapter);
        //endregion

        //region Definindo uma ação para o botão de adicionar prêmios
        ImageView adicionar_promocao = (ImageView)findViewById(R.id.botao_plus);
        adicionar_promocao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getAlertDialog();
            }
        });
        //endregion

        //region Definindo uma ação para o botão de produtos
        ImageView call_produtos = (ImageView)findViewById(R.id.premios);
        call_produtos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(activity_admin_promocao.this, activity_admin_premio.class);
                startActivity(intent);
            }
        });
        //endregion

    }

    private List<Promocao> gerarPromocao() {
        List<Promocao> Promocao = new ArrayList<Promocao>();
        Date data = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        dateFormat.format(data);
        Promocao.add(new Promocao("Shane", "", data));
        Promocao.add(new Promocao("Hershel", "", data));
        Promocao.add(new Promocao("Glen", "", data));
        Promocao.add(new Promocao("Shane", "", data));
        Promocao.add(new Promocao("Hershel", "", data));
        Promocao.add(new Promocao("Glen", "", data));

        return Promocao;
    }

    public void getAlertDialog(){

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.admin_diag_incluirpromocao, null);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adicionar Promoção");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    //endregion

}