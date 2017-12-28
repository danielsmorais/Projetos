package com.example.daniel.remediocertobetha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;


public class CadastrarObservacao extends AppCompatActivity implements OnItemSelectedListener
{
    Spinner spinnerRemedio;
    int idremedio;        //GAMBIARRA

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_observacao);

        //Seleção do nome dos médicos no spinner

        spinnerRemedio = (Spinner) findViewById(R.id.spinnerRemedio);
        spinnerRemedio.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();
    }

    private void loadSpinnerData() {
        // database handler
        GerenciarCadastroRemedio bd = new GerenciarCadastroRemedio(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = bd.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerRemedio.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        idremedio = position;

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label + " " + position,
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


    public void cadastrarObservacao(View v)
    {
        EditText descricao = (EditText) findViewById(R.id.descricao);
        EditText data = (EditText) findViewById(R.id.dataDescricao);
        spinnerRemedio = (Spinner) findViewById(R.id.spinnerRemedio);


        if(descricao.getText().toString().isEmpty() || data.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }
        else
        {
            //**********************************************************************
            //                   Cadastro na tabela "OBSERVACAO"
            //**********************************************************************

            GerenciarCadastroObservacao bd = new GerenciarCadastroObservacao(this);
            Observacao observacao = new Observacao();

            observacao.setDescricao(descricao.getText().toString());
            observacao.setData(data.getText().toString());
            observacao.setId_remedio(idremedio);

            bd.inserir(observacao);

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
