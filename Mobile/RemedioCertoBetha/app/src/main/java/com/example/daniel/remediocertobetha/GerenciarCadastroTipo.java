package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 22/11/16.
 */

public class GerenciarCadastroTipo {

    private SQLiteDatabase bd;
    public GerenciarCadastroTipo(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }

    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String sql = "SELECT _id_tipo, nome FROM TIPO ORDER BY _id_tipo";

        Cursor cursor = bd.rawQuery(sql,null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        bd.close();

        // returning lables
        return labels;
    }

    public void inserir(Tipo tipo)
    {
        ContentValues valores = new ContentValues();
        valores.put("nome", tipo.getNome().toString());
        valores.put("range", tipo.getRange().toString());
        bd.insert("TIPO",null,valores);
    }

}
