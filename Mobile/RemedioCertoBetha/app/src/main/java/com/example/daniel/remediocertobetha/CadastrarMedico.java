package com.example.daniel.remediocertobetha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarMedico extends AppCompatActivity {

    Medico medico = new Medico();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_medico);
    }
    public void CadastrarMedico(View view)
    {
        EditText nome = (EditText) findViewById(R.id.nomeUsuario);
        EditText especilidade = (EditText) findViewById(R.id.dataNascimento);
        EditText crm = (EditText) findViewById(R.id.tipoSanguineo);
        GerenciarCadastroMedico bd = new GerenciarCadastroMedico(this);
        if(nome.getText().toString().isEmpty() || especilidade.getText().toString().isEmpty() || crm.getText().toString().isEmpty()  ){

            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }else {
            medico.setNome(nome.getText().toString());
            medico.setEspecialidade(especilidade.getText().toString());
            medico.setCRM(crm.getText().toString());
            bd.inserir(medico);
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
