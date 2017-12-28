package com.example.daniel.remediocertobetha;

/**
 * Created by Mailson on 30/10/2016.
 */
public class Taxa {
    private int id_taxa;
    private float valor;
    private String date;
    private int id_usuario;
    private int id_tipo;

    public int getId_taxa() {
        return id_taxa;
    }

    public void setId_taxa(int id_taxa) {
        this.id_taxa = id_taxa;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }
}
