package com.example.daniel.remediocertobetha;

/**
 * Created by Mailson on 30/10/2016.
 */
public class Observacao {
    private int id_observacao;
    private String data;
    private String descricao;
    private int id_remedio;

    public int getId_observacao() {
        return id_observacao;
    }

    public void setId_observacao(int id_observacao) {
        this.id_observacao = id_observacao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId_remedio() {
        return id_remedio;
    }

    public void setId_remedio(int id_remedio) {
        this.id_remedio = id_remedio;
    }
}
