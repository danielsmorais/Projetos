package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 02/11/16.
 */

public class GerenciarCadastroRemedio {

    private SQLiteDatabase bd;

    public GerenciarCadastroRemedio(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
        //bd = aux_bd.getReadableDatabase();
    }


    // ALTERAR A FORMA COMO SELECTA, POIS AQUI ELE ESTÁ ORGANIZANDO POR ORDEM DE ID,
    // MAS NO SPINNER É INTERESSANTE ORDENAR POR ALFABETO.


    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        // Select All Query
        String sql = "SELECT _id_remedio, nome FROM REMEDIO ORDER BY _id_remedio";

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






    ///para o resultado do click na lista de remédios

    public Cursor getRemedio(int id){

        // Select All Query
        String sql = "SELECT nome, quantidade, laboratorio, indicacoes, foto FROM REMEDIO WHERE _id_remedio = " + id;

        Cursor cursor = bd.rawQuery(sql,null);

        // looping through all rows and adding to list
        if(cursor!=null){
            cursor.moveToFirst();
        }

        // closing connection
        bd.close();

        // returning lables
        return cursor;
    }












    ///testes com cursor


    public ArrayList<Remedio> getAllLabels2(){
        ArrayList<Remedio> labels = new ArrayList<Remedio>();

        // Select All Query
        String sql = "SELECT _id_remedio, nome FROM REMEDIO ORDER BY _id_remedio";

        Cursor cursor = bd.rawQuery(sql,null);
        Remedio rem;

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                rem = new Remedio();
                rem.setId_remedio( Integer.parseInt(cursor.getString(0)));
                rem.setNome(cursor.getString(1));
                labels.add(rem);
            } while (cursor.moveToNext());

        }

        // closing connection
        cursor.close();
        bd.close();

        // returning lables
        return labels;
    }


    public Cursor carregaDados(){

        String sql = "SELECT _id_remedio, nome FROM REMEDIO ORDER BY _id_remedio";

        Cursor cursor = bd.rawQuery(sql,null);

        if(cursor!=null){
            cursor.moveToFirst();
        }

        bd.close();

        return cursor;
    }




    public int ultimoRemedio()
    {
        String sql = "SELECT _id_remedio FROM REMEDIO ORDER BY _id_remedio DESC LIMIT 1";
        Cursor cursor = bd.rawQuery(sql,null);
        cursor.moveToFirst();
        int dado = cursor.getInt(0);
        cursor.close();
        bd.close();
        return dado;
    }


    public void inserir(Remedio remedio)
    {
        ContentValues valores = new ContentValues();
        valores.put("nome", remedio.getNome());
        valores.put("indicacoes", remedio.getIndicacoes());
        valores.put("laboratorio", remedio.getLaboratorio());
        valores.put("quantidade", remedio.getQuantidade());
        valores.put("foto", remedio.getFoto());
        valores.put("id_usuario", remedio.getId_usuario());

        bd.insert("REMEDIO",null,valores);
    }
}
