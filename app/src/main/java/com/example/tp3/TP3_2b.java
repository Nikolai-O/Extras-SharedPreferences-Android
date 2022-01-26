package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class TP3_2b extends AppCompatActivity {
    private String[] lesNoms;
    private ListView laListe;
    TextView tv;
    String note3a;
    int notes[];
    int total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp32b);
        Intent intent = getIntent();
        tv = findViewById(R.id.nameTextView);
        tv.setText(intent.getStringExtra("name"));
        lesNoms = getResources().getStringArray(R.array.noms_array);
        laListe = findViewById(R.id.listView);
        laListe.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        laListe.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, lesNoms));
        Intent intent3a = new Intent(this, TP3_3a.class);
        Intent intent3b = new Intent(this, TP3_3b.class);
        Intent intent3c = new Intent(this, TP3_3c.class);
        laListe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(lesNoms[position]) {
                    case "Nikolai Olekhnovitch":
                        intent3a.putExtra("note3a", getIntent().getIntExtra("note3a", 0));
                        intent3a.putExtra("note3b", getIntent().getIntExtra("note3b", 0));
                        intent3a.putExtra("note3c", getIntent().getIntExtra("note3c", 0));
                        startActivity(intent3a);
                        break;
                    case "Axl Rose":
                        intent3b.putExtra("note3a", getIntent().getIntExtra("note3a", 0));
                        intent3b.putExtra("note3b", getIntent().getIntExtra("note3b", 0));
                        intent3b.putExtra("note3c", getIntent().getIntExtra("note3c", 0));
                        startActivity(intent3b);
                        break;
                    case "Tommy Lee":
                        intent3c.putExtra("note3a", getIntent().getIntExtra("note3a", 0));
                        intent3c.putExtra("note3b", getIntent().getIntExtra("note3b", 0));
                        intent3c.putExtra("note3c", getIntent().getIntExtra("note3c", 0));
                        startActivity(intent3c);
                }
            }
        });
        notes = new int[3];
    }

    public void back(View v) {
        if (getIntent().getExtras() != null) {
            notes[0] = getIntent().getIntExtra("note3a", 0);
            notes[1] = getIntent().getIntExtra("note3b", 0);
            notes[2] = getIntent().getIntExtra("note3c", 0);;
            for (int i = 0; i < 3; i++)
                total += notes[i];
        }
        Intent intentRetour = new Intent(this, MainActivity.class);
        intentRetour.putExtra("total", total);
        startActivity(intentRetour);
    }
}