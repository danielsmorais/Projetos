package com.example.daniel.remediocertobetha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.List;

import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class CadastrarTaxa extends AppCompatActivity implements OnItemSelectedListener{

    Spinner spinnerTipo;
    int idtipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_taxa);

        //Seleção do nome dos médicos no spinner
        spinnerTipo = (Spinner) findViewById(R.id.spinnerTipo);
        spinnerTipo.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();
    }

    private void loadSpinnerData() {
        // database handler
        GerenciarCadastroTipo bd = new GerenciarCadastroTipo(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = bd.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerTipo.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        idtipo = position;

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label + " " + position,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


    public void cadastrarTaxa(View v)
    {
        EditText valor = (EditText) findViewById(R.id.valor);
        EditText data = (EditText) findViewById(R.id.dataTaxa);

        if(valor.getText().toString().isEmpty() || data.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }
        else
        {
            //**********************************************************************
            //                   Cadastro na tabela "TAXA"
            //**********************************************************************

            GerenciarCadastroTaxa bd = new GerenciarCadastroTaxa(this);
            Taxa taxa = new Taxa();

            taxa.setValor(Float.parseFloat(valor.getText().toString()));
            taxa.setDate(data.getText().toString());
            taxa.setId_tipo(idtipo);
            taxa.setId_usuario(1);

            bd.inserir(taxa);

            //**********************************************************************
            //                      FIM DE CADASTROS
            //**********************************************************************

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            super.finish();
        }
    }
}
