package com.example.daniel.remediocertobetha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class CadastroUsuario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        GerenciarCadastroUsuario verifica = new GerenciarCadastroUsuario(this);

        if ( verifica.verificaUsuario() > 0){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            super.finish();
        }

    }

    public void CadastrarUsuario(View view)
    {
        Usuario usuario = new Usuario();

        EditText nome = (EditText) findViewById(R.id.nomeUsuario);
        EditText data = (EditText) findViewById(R.id.dataNascimento);
        EditText sangue = (EditText) findViewById(R.id.tipoSanguineo);
        GerenciarCadastroUsuario bd = new GerenciarCadastroUsuario(this);
        if(nome.getText().toString().isEmpty() || data.getText().toString().isEmpty()){

            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }else {
            usuario.setNome(nome.getText().toString());
            usuario.setData_de_nascimento(data.getText().toString());
            usuario.setTipo_sanguineo(sangue.getText().toString());
            bd.inserir(usuario);
            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            super.finish();
        }

    }






}
