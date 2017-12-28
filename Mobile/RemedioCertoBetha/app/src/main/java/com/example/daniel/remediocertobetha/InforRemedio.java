package com.example.daniel.remediocertobetha;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

public class InforRemedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor_remedio);

        String idremedio = getIntent().getStringExtra("idremedio");
        Context context = getApplicationContext();

        //Toast.makeText(context, "You selected:::: " + idremedio, Toast.LENGTH_LONG).show();


        int id = Integer.parseInt(idremedio);

        TextView nomeR = (TextView) findViewById(R.id.nomeR);
        TextView quantidadeR = (TextView) findViewById(R.id.quantidadeR);
        TextView laboratorioR = (TextView) findViewById(R.id.laboratorioR);
        TextView indicacoesR = (TextView) findViewById(R.id.indicacoesR);


        GerenciarCadastroRemedio consulta = new GerenciarCadastroRemedio(this);
        Cursor cursor = consulta.getRemedio(id);

        // 0-nome, 1-quantidade, 2-laboratório, 3-indicacoes, 4-foto

        nomeR.setText("Nome: " + cursor.getString(0));
        quantidadeR.setText("Quantidade: " + cursor.getString(1));
        laboratorioR.setText("Laboratório: " + cursor.getString(2));
        indicacoesR.setText("Indicações: " + cursor.getString(3));

        Uri urlImagem = Uri.parse(cursor.getString(4));

        ImageView iv = (ImageView) findViewById(R.id.iv);

        iv.setImageURI(urlImagem);

        //Bitmap bMap = BitmapFactory.decodeFile(urlImagem.toString());
        //iv.setImageBitmap(bMap);


    }
}
