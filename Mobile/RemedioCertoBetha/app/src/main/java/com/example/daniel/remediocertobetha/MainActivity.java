package com.example.daniel.remediocertobetha;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void cadastrarMedico(View v)
    {
        Intent intent = new Intent(this, CadastrarMedico.class);
        startActivity(intent);
        //finish();
    }

    public void cadastrarRemedio(View v)
    {
        Intent intent = new Intent(this, CadastrarRemedio.class);
        startActivity(intent);
        //finish();
    }

    public void observacao(View v)
    {
        Intent intent = new Intent(this, CadastrarObservacao.class);
        startActivity(intent);
        //finish();
    }

    public void cadastrarTipo(View v)
    {
        Intent intent = new Intent(this, CadastrarTipo.class);
        startActivity(intent);
        //finish();
    }

    public void cadastrarTaxa(View v)
    {
        Intent intent = new Intent(this, CadastrarTaxa.class);
        startActivity(intent);
        //finish();
    }

    public void consultarRemedio(View v)
    {
        Intent intent = new Intent(this, ConsultarRemedio.class);
        startActivity(intent);
        //finish();
    }


}
