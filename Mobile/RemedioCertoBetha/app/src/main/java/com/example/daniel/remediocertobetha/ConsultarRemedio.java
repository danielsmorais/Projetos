package com.example.daniel.remediocertobetha;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.icu.text.IDNA;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static com.example.daniel.remediocertobetha.R.id.listView;

public class ConsultarRemedio extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_remedio);


        ///=================================================== funciona

        GerenciarCadastroRemedio crud = new GerenciarCadastroRemedio(getBaseContext());
        List<String> cursor = crud.getAllLabels();


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, cursor);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {

                //pegar id e fazer a busca na Activity de aparecer os dados.... embrar de acrescentar +1 ao id

                Toast.makeText(adapter.getContext(), "You selected: " + (pos+1),
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(ConsultarRemedio.this, InforRemedio.class);
                intent.putExtra("idremedio", String.valueOf(pos+1));
                startActivity(intent);
                //finish();
            }
        });


        ///===================================================

/*        GerenciarCadastroRemedio crud = new GerenciarCadastroRemedio(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[] {"_id_remedio", "nome"};
        int[] idViews = new int[] {R.id.idT, R.id.nomeT};

        SimpleCursorAdapter adaptador = new SimpleCursorAdapter(getBaseContext(),R.layout.list_view,cursor,nomeCampos,idViews, 0);
        ListView listView = (ListView)findViewById(R.id.listView);
        //ListView listView = getListView();
        listView.setAdapter(adaptador);

*/



/*        GerenciarCadastroRemedio crud = new GerenciarCadastroRemedio(this);
        ArrayList<Remedio> rem = (ArrayList<Remedio>) crud.getAllLabels2();

        ListView listView = (ListView)findViewById(R.id.listView);

        listView.setAdapter(new remedioAdapter(this,rem));

*/


    }

}
