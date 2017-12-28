package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;



public class GerenciarCadastroObservacao {
    private SQLiteDatabase bd;

    public GerenciarCadastroObservacao(Context context) {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }

    public void inserir(Observacao observacao) {
        ContentValues valores = new ContentValues();
        valores.put("descricao", observacao.getDescricao());
        valores.put("data", observacao.getData());
        valores.put("id_remedio", observacao.getId_remedio());

        bd.insert("OBSERVACAO", null, valores);
    }
}