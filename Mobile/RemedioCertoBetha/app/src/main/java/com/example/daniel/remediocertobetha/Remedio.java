package com.example.daniel.remediocertobetha;

/**
 * Created by Mailson on 30/10/2016.
 */
public class Remedio {
    private int id_remedio;
    private String foto;
    private String indicacoes;
    private String laboratorio;
    private String quantidade;
    private String nome;
    private int id_usuario;

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getIndicacoes() {
        return indicacoes;
    }

    public void setIndicacoes(String indicacoes) {
        this.indicacoes = indicacoes;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}
