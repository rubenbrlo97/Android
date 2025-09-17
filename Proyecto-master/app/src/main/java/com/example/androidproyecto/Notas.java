package com.example.androidproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Notas extends AppCompatActivity {
    private ListView ayuda;
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
        et1 = (EditText) findViewById(R.id.Nombre);
        ayuda = (ListView) findViewById(R.id.ayuda);

        ArrayList<String> result = new ArrayList<>();

        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,
                "administracion", null, 1);

        SQLiteDatabase db = admin.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Notas ", null);
        if(cursor.moveToFirst()){
            while (cursor.moveToNext()) {
                result.add(cursor.getString(0));
            }
            ArrayAdapter<String> datos = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, result);
            ayuda.setAdapter(datos);
        }
        db.close();
    }


    public void Guardar(View view) {


    AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

    SQLiteDatabase bd = admin.getWritableDatabase();

    String Nombre = et1.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("Nombre", Nombre);

        bd.insert("Notas", null, registro);

        bd.close();

        // ponemos los campos a vacío para insertar el siguiente usuario
        et1.setText("");
        Toast.makeText(this, "Datos cargados", Toast.LENGTH_SHORT).show();
}
    public void Atras(View view) {
        Intent i = new Intent(this, Agenda.class);
        startActivity(i);
        Toast.makeText(this, "Salida",

                Toast.LENGTH_SHORT).show();

    }
}
