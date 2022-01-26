package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences msp;
    private String validPW;
    private int notes[];
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if ( getIntent().getExtras() != null) {
//            notes[0] = getIntent().getIntExtra("note3a", 0);
//        }
        msp = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editeur = msp.edit();
        editeur.putString("password", "12345");
        editeur.apply();

        validPW = msp.getString("password", "12345");

        tv = findViewById(R.id.noteTextView);
        if (getIntent().getExtras() != null)
            tv.setText(getResources().getString(R.string.finalGrade) +
                    getIntent().getIntExtra("total", 0));
    }

    public void onClick(View v) {
        String pw, name;
        name = ((EditText)findViewById(R.id.nameEditText)).getText().toString();
        pw = ((EditText)findViewById(R.id.pwEditText)).getText().toString();
        Intent intent2a = new Intent(this, TP3_2a.class);
        Intent intent2b = new Intent(this, TP3_2b.class);

        intent2b.putExtra("name", name);

        if (pw.equals(validPW))
            startActivity(intent2b);
        else
            startActivity(intent2a);
    }
}