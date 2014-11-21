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

import java.util.ArrayList;
import java.util.List;


public class activity_admin_produto extends ListActivity{

    AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_produtopontuacao);
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

        //region populando a lista de produtos
        List<Produto> lista_produto = gerarProduto();
        final ListaProdutoAdapter ProdutoAdapter = new ListaProdutoAdapter(activity_admin_produto.this, lista_produto);
        setListAdapter(ProdutoAdapter);
        //endregion

        //region Definindo uma ação para o botão de adicionar produtos
        ImageView adicionar_produto = (ImageView)findViewById(R.id.botao_plus);
        adicionar_produto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                getAlertDialog();
            }
        });
        //endregion

        //region Definindo uma ação para o botão de produtos
        ImageView call_produtos = (ImageView)findViewById(R.id.premios);
        call_produtos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent(activity_admin_produto.this, activity_admin_premio.class);
                startActivity(intent);
            }
        });
        //endregion

    }

    private List<Produto> gerarProduto() {
        List<Produto> Produto = new ArrayList<Produto>();
        Produto.add(new Produto("Shane", "", 23));
        Produto.add(new Produto("Hershel", "", 23));
        Produto.add(new Produto("Glen", "", 23));
        Produto.add(new Produto("Shane", "", 23));
        Produto.add(new Produto("Hershel", "", 23));
        Produto.add(new Produto("Glen", "", 23));

        return Produto;
    }

    public void getAlertDialog(){

        LayoutInflater li = getLayoutInflater();
        View view = li.inflate(R.layout.admin_diag_incluirproduto, null);
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                alerta.dismiss();
            }
        });

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Adicionar Produto");
        builder.setView(view);
        alerta = builder.create();
        alerta.show();
    }

    //endregion

}