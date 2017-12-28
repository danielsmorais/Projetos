package com.example.daniel.remediocertobetha;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mailson on 29/10/2016.
 */

public class BDcore extends SQLiteOpenHelper {
    private static final String BD_NAME="RemedioCerto";
    private static final int BD_VERCAO=5;
    public BDcore(Context ctx)
    {
        super(ctx,BD_NAME, null, BD_VERCAO);
    }
    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table USUARIO(_id_usuario integer primary key autoincrement, nome text, data text, tipo_sanguineo text);");
        bd.execSQL("create table REMEDIO(_id_remedio integer primary key autoincrement, foto text, indicacoes text, laboratorio text, quantidade integer,nome text,id_usuario integer, FOREIGN KEY(id_usuario) REFERENCES USUARIO(_id_usuario) );");
        bd.execSQL("create table OBSERVACAO(_id_observacao integer primary key autoincrement, data text,descricao text, id_remedio integer, FOREIGN KEY(id_remedio) REFERENCES REMEDIO(_id_remedio));");
        bd.execSQL("create table TIPO(_id_tipo integer primary key autoincrement, nome text, range text);");
        bd.execSQL("create table TAXA(_id_taxa integer primary key autoincrement,valor real, data text, id_usuario integer, id_tipo integer,FOREIGN KEY(id_usuario) REFERENCES USUARIO(_id_usuario),FOREIGN KEY(id_tipo) REFERENCES TIPO(_id_tipo));");
        bd.execSQL("create table MEDICO(_id_medico integer primary key autoincrement, nome text, especialidade text, CRM text);");
        bd.execSQL("create table INDICADO(id_remedio integer , id_medico integer, FOREIGN KEY(id_remedio) REFERENCES REMEDIO(_id_remedio),FOREIGN KEY(id_medico) REFERENCES MEDICO(_id_medico));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int i, int i1) {
        bd.execSQL("drop table INDICADO;");
        bd.execSQL("drop table MEDICO;");
        bd.execSQL("drop table TAXA;");
        bd.execSQL("drop table TIPO;");
        bd.execSQL("drop table OBSERVACAO;");
        bd.execSQL("drop table REMEDIO;");
        bd.execSQL("drop table USUARIO;");
        onCreate(bd);
    }
}
