package com.example.androidproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NuevoContacto extends Activity {
    private EditText et1, et2, et3, et4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);

        et1 = (EditText) findViewById(R.id.Nombre);
        et2 = (EditText) findViewById(R.id.Apellido);
        et3 = (EditText) findViewById(R.id.Telefono);
        et4 = (EditText) findViewById(R.id.Apodo);
    }

    public void Guardar(View view) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);

        SQLiteDatabase bd = admin.getWritableDatabase();

        String Nombre = et1.getText().toString();
        String Apellido = et2.getText().toString();
        String Telefono = et3.getText().toString();
        String Apodo = et4.getText().toString();

        ContentValues registro = new ContentValues();

        registro.put("Nombre", Nombre);
        registro.put("Apellido", Apellido);
        registro.put("Telefono", Telefono);
        registro.put("Apodo", Apodo);

        bd.insert("Agenda", null, registro);

        bd.close();

        // ponemos los campos a vacío para insertar el siguiente usuario
        et1.setText("");
        et2.setText("");
        et3.setText("");
        et4.setText("");

        Toast.makeText(this, "Datos del usuario cargados", Toast.LENGTH_SHORT).show();


    }


    public void Atras(View view) {
    Intent i = new Intent(this, Agenda.class);
    startActivity(i);
        Toast.makeText(this, "Salida",

                Toast.LENGTH_SHORT).show();

}
}
