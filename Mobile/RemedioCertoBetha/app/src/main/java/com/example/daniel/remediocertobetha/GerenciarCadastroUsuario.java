package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Mailson on 31/10/2016.
 */
public class GerenciarCadastroUsuario {
    private SQLiteDatabase bd;
    public GerenciarCadastroUsuario(Context context)
    {
        BDcore aux_bd = new BDcore(context);
        bd = aux_bd.getWritableDatabase();
    }

    public int verificaUsuario()
    {
        String sql = "SELECT count(*) FROM USUARIO";
        Cursor cursor = bd.rawQuery(sql,null);
        cursor.moveToFirst();
        int dado = cursor.getInt(0);
        cursor.close();
        bd.close();
        return dado;
    }


    public Usuario dadosUsuario(int id)
    {
        Usuario usuario = new Usuario();
        String sql = "SELECT * FROM USUARIO WHERE _id_usuario ="+ id ;
        Cursor cursor = bd.rawQuery(sql,null);
        cursor.moveToFirst();
        usuario.setId_usuario(cursor.getInt(0));
        usuario.setNome(cursor.getString(1));
        usuario.setData_de_nascimento(cursor.getString(2));
        usuario.setTipo_sanguineo(cursor.getString(3));

        cursor.close();
        bd.close();
        return usuario;
    }

    public void inserir(Usuario usuario)
    {
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("data", usuario.getData_de_nascimento());
        valores.put("tipo_sanguineo", usuario.getTipo_sanguineo());

        bd.insert("USUARIO",null,valores);
    }

}
