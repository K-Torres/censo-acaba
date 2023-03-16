package com.example.censoacaba.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.censoacaba.HelperClasses.ConexionSqliteHelper;
import com.example.censoacaba.HelperClasses.Utilidades;
import com.example.censoacaba.R;

public class FinishRegisterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_register);


    }

    public void callMainScreen(View view) {

        RegistrarUsuarios();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    private void RegistrarUsuarios() {

        String _nombre = getIntent().getStringExtra("nombre");
        String _primer_apellido = getIntent().getStringExtra("primer_apellido");
        String _segundo_apellido = getIntent().getStringExtra("segundo_apellido");
        String _correo = getIntent().getStringExtra("correo");
        String _genero = getIntent().getStringExtra("genero");
        String _fechanacimiento = getIntent().getStringExtra("fechanacimiento");
        String _telefono = getIntent().getStringExtra("telefono");
        String _tipodocumento = getIntent().getStringExtra("tipodocumento");
        String  _numerodocumento = getIntent().getStringExtra("numerodocumento");
        int _departamento =  getIntent().getIntExtra("departamento",1);
        int _municipio = getIntent().getIntExtra("municipio",1);
        int _consejo = getIntent().getIntExtra("consejo",1);
        int _comunidad = getIntent().getIntExtra("comunidad",1);
        String _permanencia = getIntent().getStringExtra("permanencia");
        String _fechaexpedicion =  getIntent().getStringExtra("fechaexpedicion");
        String  _troncofamiliar = getIntent().getStringExtra("troncofamiliar");
        String  _idfamiliar = getIntent().getStringExtra("idfamiliar");
        String _parentesco = getIntent().getStringExtra("parentesco");
        String _cabeza_familia = getIntent().getStringExtra("cabeza_familia");
        String _tipo_sangre =  getIntent().getStringExtra("tipo_sangre");
        String _nivel_escolar =  getIntent().getStringExtra("nivel_escolar");
        String _discapacidad =  getIntent().getStringExtra("discapacidad");
        String _tipo_victima =  getIntent().getStringExtra("tipo_victima");
        String _etnia =  getIntent().getStringExtra("etnia");
        String _eps = getIntent().getStringExtra("eps");

        ConexionSqliteHelper conn = new ConexionSqliteHelper(this, "bd_usuarios", null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, 0);
        values.put(Utilidades.CAMPO_NOMBRE, _nombre);
        values.put(Utilidades.CAMPO_PRIMER_APELLIDO, _primer_apellido);
        values.put(Utilidades.CAMPO_SEGUNDO_APELLIDO, _segundo_apellido);
        values.put(Utilidades.CAMPO_CORREO, _correo);
        values.put(Utilidades.CAMPO_TELEFONO, Integer.parseInt(_telefono));
        values.put(Utilidades.CAMPO_GENERO, _genero);
        values.put(Utilidades.CAMPO_FECHA_NACIMIENTO, _fechanacimiento);
        values.put(Utilidades.CAMPO_TIPO_DOCUMENTO, _tipodocumento);
        values.put(Utilidades.CAMPO_NUMERO_DOCUMENTO, Integer.parseInt(_numerodocumento));
        values.put(Utilidades.CAMPO_FECHA_EXPEDICION, _fechaexpedicion);
        values.put(Utilidades.CAMPO_DEPARTAMENTO, _departamento);
        values.put(Utilidades.CAMPO_MUNICIPIO, _municipio);
        values.put(Utilidades.CAMPO_CONSEJO, _consejo);
        values.put(Utilidades.CAMPO_COMUNIDAD, _comunidad);
        values.put(Utilidades.CAMPO_TRONCO_FAMILIAR, Integer.parseInt(_troncofamiliar));
        values.put(Utilidades.CAMPO_ID_FAMILIAR, Integer.parseInt(_idfamiliar));
        values.put(Utilidades.CAMPO_PERMANENCIA_TERRITORIAL, _permanencia);
        values.put(Utilidades.CAMPO_PARENTESCO, _parentesco);
        values.put(Utilidades.CAMPO_CABEZA_FAMILIA, _cabeza_familia);
        values.put(Utilidades.CAMPO_ETNIA, _etnia);
        values.put(Utilidades.CAMPO_TIPO_SANGRE, _tipo_sangre);
        values.put(Utilidades.CAMPO_NIVEL_ESCOLAR, _nivel_escolar);
        values.put(Utilidades.CAMPO_DISCAPACIDAD, _discapacidad);
        values.put(Utilidades.CAMPO_TIPO_VICTIMA, _tipo_victima);
        values.put(Utilidades.CAMPO_EPS, _eps);
        values.put(Utilidades.CAMPO_STATUS, 0);


        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(),"Id Registro "+idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }
}