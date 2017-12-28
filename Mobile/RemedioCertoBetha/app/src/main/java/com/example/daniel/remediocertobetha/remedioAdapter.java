package com.example.daniel.remediocertobetha;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by daniel on 29/11/16.
 */

public class remedioAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Remedio> lista;

    public remedioAdapter(Context context, ArrayList<Remedio> lista)
    {
        this.context = context;
        this.lista = lista;
    }
    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return lista.get(i).getId_remedio();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Remedio rem = lista.get(i);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout = inflater.inflate(R.layout.list_view, null);

        TextView idd = (TextView) layout.findViewById(R.id.idT);
        idd.setText(rem.getId_usuario());

        TextView nome = (TextView) layout.findViewById(R.id.nomeT);
        nome.setText(rem.getNome());

        return layout;
    }
}
