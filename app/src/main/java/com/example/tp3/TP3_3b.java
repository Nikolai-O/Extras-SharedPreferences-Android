package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TP3_3b extends AppCompatActivity {
    int note;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tp33b);
    }

    public void back(View v) {
        if ( TextUtils.isEmpty(((EditText)findViewById(R.id.grade3bTextNumber)).getText().toString()) == false ) {
            if (Integer.parseInt(((EditText) findViewById(R.id.grade3bTextNumber)).getText().toString()) > 3)
                Toast.makeText(this, getResources().getString(R.string.badGradeString), Toast.LENGTH_LONG).show();

            else {
                Intent intentRetour = new Intent(this, TP3_2b.class);
                note = Integer.parseInt(((EditText) findViewById(R.id.grade3bTextNumber)).getText().toString());
                intentRetour.putExtra("note3b", note);
                intentRetour.putExtra("note3a", getIntent().getIntExtra("note3a", 0));
                intentRetour.putExtra("note3c", getIntent().getIntExtra("note3c", 0));
                startActivity(intentRetour);
            }
        }
        else {
            Intent intentRetour = new Intent(this, TP3_2b.class);
            intentRetour.putExtra("note3b", getIntent().getIntExtra("note3b", 0));
            intentRetour.putExtra("note3a", getIntent().getIntExtra("note3a", 0));
            intentRetour.putExtra("note3c", getIntent().getIntExtra("note3c", 0));
            startActivity(intentRetour);
        }
    }
}