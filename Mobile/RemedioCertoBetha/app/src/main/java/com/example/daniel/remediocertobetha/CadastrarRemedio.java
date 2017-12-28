package com.example.daniel.remediocertobetha;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.util.List;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;

import static android.provider.MediaStore.Files.FileColumns.MEDIA_TYPE_IMAGE;
import static android.provider.MediaStore.MediaColumns.TITLE;


public class CadastrarRemedio extends AppCompatActivity implements OnItemSelectedListener{

    public static final int IMAGEM_INTERNA=12;

    Spinner spinnerMed;
    int idmedico;        //GAMBIARRA
    String urlImagem = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_remedio);

        //Seleção do nome dos médicos no spinner
        spinnerMed = (Spinner) findViewById(R.id.spinnerRemedio);
        spinnerMed.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();
    }


    private void loadSpinnerData() {
        // database handler
        GerenciarCadastroMedico bd = new GerenciarCadastroMedico(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = bd.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerMed.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String label = parent.getItemAtPosition(position).toString();

        idmedico = position;

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "You selected: " + label + " " + position,
                Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }


    public void cadastrarRemedio(View v)
    {
        EditText nomeRemedio = (EditText) findViewById(R.id.nomeRemedio);
        EditText quantidade = (EditText) findViewById(R.id.quantidade);
        EditText laboratorio = (EditText) findViewById(R.id.laboratorio);
        EditText indicacoes = (EditText) findViewById(R.id.indicacoes);
        Spinner spinnerMedico = (Spinner) findViewById(R.id.spinnerRemedio);     //Para uso na tabela "INDICADO"

        //LEMBRAR DE SALVAR A IMAGEM

        if(nomeRemedio.getText().toString().isEmpty() || quantidade.getText().toString().isEmpty() || laboratorio.getText().toString().isEmpty())
        {
            Toast.makeText(this,"Campos obrigatórios não preenchidos!",Toast.LENGTH_LONG).show();
        }
        else
        {
            //**********************************************************************
            //                   Cadastro na tabela "REMEDIO"
            //**********************************************************************

            GerenciarCadastroRemedio bd = new GerenciarCadastroRemedio(this);
            Remedio remedio = new Remedio();

            remedio.setNome(nomeRemedio.getText().toString());
            remedio.setQuantidade(quantidade.getText().toString());
            remedio.setLaboratorio(laboratorio.getText().toString());
            remedio.setIndicacoes(indicacoes.getText().toString());
            remedio.setId_usuario(1);
            remedio.setFoto(urlImagem);
            bd.inserir(remedio);

            //**********************************************************************
            //                      Cadastro na tabela "INDICADO"
            //**********************************************************************

            GerenciarCadastroIndicado bd2 = new GerenciarCadastroIndicado(this);
            Indicado indicado = new Indicado();

            indicado.setId_medico(idmedico);                      // Pegar ID de médico selecionado no spinner
            indicado.setId_remedio(bd.ultimoRemedio());           // Pegar último id adicionado na tabela REMEDIO
            bd2.inserir(indicado);

            //**********************************************************************
            //                      FIM DE CADASTROS
            //**********************************************************************

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            super.finish();
        }
    }


    //**********************************************************************
    //                      MÉTODOS DE IMAGEM
    //**********************************************************************

    /**
     * Metodo que é chamado por botão quando queremos tirar uma foto
     * @param view
     */


    public void tirarFoto(View view)
    {
        // Criar intente e chamar a camera
        Intent intent= new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,0);


  }



    /**
     * Metodo que fica esperando o resultado da que foi da chamada da intent
     * @param RequestCode
     * @param ResultCode
     * @param intent
     */

    @Override
    protected void onActivityResult(int RequestCode, int ResultCode, Intent intent){
        // verificar se a intent é nula
        if(intent != null)
        {
            //pega os dados enviado pela câmera e seta no ImageView
            Bundle bundle=intent.getExtras();
            Bitmap img = (Bitmap) bundle.get("data");
            ImageView imageView= (ImageView) findViewById(R.id.iv);
            imageView.setImageBitmap(img);
            //Pega url e seta Em um EditText só para verrificar se está funcionando

            Uri myuri = intent.getData();
            urlImagem = Environment.getExternalStorageDirectory().getPath().toString();
            TextView lab = (TextView) findViewById(R.id.textURL);
            //Observação: no projeto iremos setar o atributo foto da classe remedio da forma como está abaixo:
            lab.setText(urlImagem.toString());
        }
    }
}
