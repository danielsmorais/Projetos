package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by daniel on 22/11/16.
 */

public class GerenciarCadastroTaxa {

    private SQLiteDatabase bd;
    public GerenciarCadastroTaxa(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }


    public void inserir(Taxa taxa)
    {
        ContentValues valores = new ContentValues();
        valores.put("valor", taxa.getValor());
        valores.put("data", taxa.getDate().toString());
        valores.put("id_tipo", taxa.getId_tipo());
        valores.put("id_usuario", taxa.getId_usuario());
        bd.insert("TAXA",null,valores);
    }
}
