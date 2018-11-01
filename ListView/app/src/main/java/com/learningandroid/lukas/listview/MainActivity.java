package com.learningandroid.lukas.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private String[] itens = { "Marcelo Lomba12",
            "Fabiano",
            "Víctor Cuesta",
            "Emerson Santos",
            "Klaus",
            "Iago",
            "Rodrigo Dourado",
            "Edenílson",
            "Patrick",
            "D'Alessandro10",
            "Wellington Silva",
            "Nico López",
            "William Pottker",
            "Leandro Damião",
            "Odair Hellmann"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = (ListView) findViewById(R.id.listviewid);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
          getApplicationContext(),
          android.R.layout.simple_list_item_1,
          android.R.id.text1,
          itens
        );

        lista.setAdapter( adapter );

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), lista.getItemAtPosition( position ).toString(), Toast.LENGTH_SHORT).show;
            }
        });
    }
}
