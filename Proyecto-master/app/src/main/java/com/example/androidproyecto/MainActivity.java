package com.example.androidproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void Agenda(View view) {
        Intent i = new Intent(this, Agenda.class);
        startActivity(i);
    }
    public void Calendario(View view) {
        Intent i = new Intent(this, Calendario.class);
        startActivity(i);
    }
    public void Notas(View view) {
        Intent i = new Intent(this, Notas.class);
        startActivity(i);
    }
}
