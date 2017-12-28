package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by daniel on 02/11/16.
 */

public class GerenciarCadastroIndicado {
    private SQLiteDatabase bd;

    public GerenciarCadastroIndicado(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }

    public void inserir(Indicado indicado)
    {
        ContentValues valores = new ContentValues();
        valores.put("id_remedio", indicado.getId_remedio());
        valores.put("id_medico", indicado.getId_medico());

        bd.insert("INDICADO",null,valores);
    }

}
