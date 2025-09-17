package com.example.androidproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Vector;

public class Agenda extends AppCompatActivity {
    private ListView ayuda;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);
        ayuda = (ListView) findViewById(R.id.ayuda);

        ArrayList<String> result = new ArrayList<>();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Agenda ", null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                result.add(cursor.getString(0) + " " + cursor.getString(1)+ cursor.getString(2));
            }
            ArrayAdapter<String> datos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
            ayuda.setAdapter(datos);
        }
        db.close();
    }


    public void Nuevo(View view) {
        Intent i = new Intent(this, NuevoContacto.class);
        startActivity(i);
    }
    }