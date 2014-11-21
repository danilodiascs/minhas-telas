package com.example.danilo.fidelidadeapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class activity_admin_premio extends ListActivity{

    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_premios);
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

        //region populando a lista de premios
        List<Premio> lista_premio = gerarPremio();
        final ListaPremioAdapter PremioAdapter = new ListaPremioAdapter(activity_admin_premio.this, lista_premio);
        setListAdapter(PremioAdapter);
        //endregion

        //region Definindo uma ação para o botão de adicionar prêmios
        ImageView adicionar_premio = (ImageView)findViewById(R.id.botao_plus);
        adicionar_premio.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getAlertDialog();
            }
        });
        //endregion

        //region Definindo uma ação para o botão de produtos
        ImageView call_produtos = (ImageView)findViewById(R.id.premios);
        call_produtos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(activity_admin_premio.this, activity_admin_produto.class);
                startActivity(intent);
            }
        });
        //endregion

        //region Definindo uma ação para o botão de promocao
        ImageView call_promocao = (ImageView)findViewById(R.id.valores);
        call_promocao.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(activity_admin_premio.this, activity_admin_promocao.class);
                startActivity(intent);
            }
        });
        //endregion
    }

    private List<Premio> gerarPremio() {
        List<Premio> Premio = new ArrayList<Premio>();
        Premio.add(new Premio("Shane", "", 23));
        Premio.add(new Premio("Hershel", "", 23));
        Premio.add(new Premio("Glen", "", 23));
        Premio.add(new Premio("Shane", "", 23));
        Premio.add(new Premio("Hershel", "", 23));
        Premio.add(new Premio("Glen", "", 23));

        return Premio;
    }

    public void getAlertDialog(){

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.admin_diag_incluirpremio, null);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adicionar Prêmio");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    //endregion

}