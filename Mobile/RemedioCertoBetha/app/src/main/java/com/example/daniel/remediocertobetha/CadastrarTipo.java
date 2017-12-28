package com.example.daniel.remediocertobetha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarTipo extends AppCompatActivity {

    Tipo tipo = new Tipo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_tipo);
    }

    public void CadastrarTipo(View view)
    {
        EditText nome = (EditText) findViewById(R.id.nome);
        EditText range = (EditText) findViewById(R.id.range);

        GerenciarCadastroTipo bd = new GerenciarCadastroTipo(this);
        if(nome.getText().toString().isEmpty() || range.getText().toString().isEmpty()){

            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }else {
            tipo.setNome(nome.getText().toString());
            tipo.setRange(range.getText().toString());

            bd.inserir(tipo);
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }






}
