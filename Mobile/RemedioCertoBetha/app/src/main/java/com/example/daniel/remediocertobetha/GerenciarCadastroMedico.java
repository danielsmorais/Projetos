package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mailson on 31/10/2016.
 */
public class GerenciarCadastroMedico {
    private SQLiteDatabase bd;
    public GerenciarCadastroMedico(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }

    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String sql = "SELECT _id_medico, nome FROM MEDICO ORDER BY _id_medico";

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


    public void inserir(Medico medico)
    {
        ContentValues valores = new ContentValues();
        valores.put("nome", medico.getNome().toString());
        valores.put("especialidade", medico.getEspecialidade().toString());
        valores.put("CRM", medico.getCRM().toString());
        bd.insert("MEDICO",null,valores);
    }
}
