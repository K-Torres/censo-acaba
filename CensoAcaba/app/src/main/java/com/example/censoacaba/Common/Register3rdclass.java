package com.example.censoacaba.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.censoacaba.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Register3rdclass extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ImageView backBtn;
    Button next;
    TextView titleText;
    Spinner victimaSpinner, discapacidadSpinner, nivelescolarSpinner, etniaSpinner, sangreSpinner, parentescoSpiner;

    TextInputLayout eps;

    RadioGroup radioGroupCabezaFamilia;
    RadioButton selectedCabezaFamilia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3rdclass);

        victimaSpinner = findViewById(R.id.victima_spinner);
        discapacidadSpinner = findViewById(R.id.discapacidad_spinner);
        nivelescolarSpinner = findViewById(R.id.nivelescolar_spinner);
        etniaSpinner = findViewById(R.id.etnia_spinner);
        sangreSpinner = findViewById(R.id.sangre_spinner);
        parentescoSpiner = findViewById(R.id.parentesco_spinner);

        radioGroupCabezaFamilia = findViewById(R.id.radiogoup_cabeza_familia);
        eps = findViewById(R.id.eps);

        ArrayAdapter<CharSequence> victimaadapter = ArrayAdapter.createFromResource(this, R.array.tipo_victima, R.layout.spinner_item);
        victimaadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        victimaSpinner.setAdapter( victimaadapter);
        victimaSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> discapacidadadapter = ArrayAdapter.createFromResource(this, R.array.discapacidad, R.layout.spinner_item);
        discapacidadadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        discapacidadSpinner.setAdapter(discapacidadadapter);
        discapacidadSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> nivelescolardapter = ArrayAdapter.createFromResource(this, R.array.nivel_Escolar, R.layout.spinner_item);
        nivelescolardapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        nivelescolarSpinner.setAdapter(nivelescolardapter);
        nivelescolarSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> etniaadapter = ArrayAdapter.createFromResource(this, R.array.etnia, R.layout.spinner_item);
        etniaadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        etniaSpinner.setAdapter(etniaadapter);
        etniaSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> sangreadapter = ArrayAdapter.createFromResource(this, R.array.tipo_sangre, R.layout.spinner_item);
        sangreadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        sangreSpinner.setAdapter(sangreadapter);
        sangreSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> parentescoadapter = ArrayAdapter.createFromResource(this, R.array.parentesco, R.layout.spinner_item);
        parentescoadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        parentescoSpiner.setAdapter(parentescoadapter);
        parentescoSpiner.setOnItemSelectedListener(this);

    }


    public void callNextRegisterScreen(View view) {

        if (!validarCabezaFamilia() | !validarEps() ) {
            return;
        }

        selectedCabezaFamilia = findViewById(radioGroupCabezaFamilia.getCheckedRadioButtonId());

        String _parentesco = parentescoSpiner.getSelectedItem().toString();
        String _cabeza_familia = selectedCabezaFamilia.getText().toString();
        String _tipo_sangre =  sangreSpinner.getSelectedItem().toString();
        String _nivel_escolar =  nivelescolarSpinner.getSelectedItem().toString();
        String _discapacidad =  discapacidadSpinner.getSelectedItem().toString();
        String _tipo_victima =  victimaSpinner.getSelectedItem().toString();
        String _etnia =  etniaSpinner.getSelectedItem().toString();
        String _eps = eps.getEditText().getText().toString();


        String _nombre = getIntent().getStringExtra("nombre");
        String _primer_apellido = getIntent().getStringExtra("primer_apellido");
        String _segundo_apellido = getIntent().getStringExtra("segundo_apellido");
        String _correo = getIntent().getStringExtra("correo");
        String _genero = getIntent().getStringExtra("genero");
        String _fechanacimiento = getIntent().getStringExtra("fechanacimiento");
        String _telefono = getIntent().getStringExtra("telefono");
        String _tipodocumento = getIntent().getStringExtra("tipodocumento");
        String  _numerodocumento = getIntent().getStringExtra("numerodocumento");
        String _departamento =  getIntent().getStringExtra("departamento");
        String _municipio = getIntent().getStringExtra("municipio");
        String _consejo = getIntent().getStringExtra("consejo");
        String _comunidad = getIntent().getStringExtra("comunidad");
        String _permanencia = getIntent().getStringExtra("permanencia");
        String _fechaexpedicion =  getIntent().getStringExtra("fechaexpedicion");
        String  _troncofamiliar = getIntent().getStringExtra("troncofamiliar");
        String  _idfamiliar = getIntent().getStringExtra("idfamiliar");


        Intent intent = new Intent(getApplicationContext(), FinishRegisterActivity.class);

        intent.putExtra("nombre",_nombre);
        intent.putExtra("primer_apellido",_primer_apellido);
        intent.putExtra("segundo_apellido",_segundo_apellido);
        intent.putExtra("correo",_correo);
        intent.putExtra("genero",_genero);
        intent.putExtra("fechanacimiento",_fechanacimiento);
        intent.putExtra("telefono",_telefono);
        intent.putExtra("tipodocumento",_tipodocumento);
        intent.putExtra("numerodocumento",_numerodocumento);
        intent.putExtra("departamento",_departamento);
        intent.putExtra("municipio",_municipio);
        intent.putExtra("consejo",_consejo);
        intent.putExtra("comunidad",_comunidad);
        intent.putExtra("permanencia",_permanencia);
        intent.putExtra("fechaexpedicion",_fechaexpedicion);
        intent.putExtra("troncofamiliar",_troncofamiliar);
        intent.putExtra("idfamiliar",_idfamiliar);
        intent.putExtra("parentesco",_parentesco);
        intent.putExtra("cabeza_familia",_cabeza_familia);
        intent.putExtra("nivel_escolar",_nivel_escolar);
        intent.putExtra("tipo_sangre",_tipo_sangre);
        intent.putExtra("discapacidad",_discapacidad);
        intent.putExtra("tipo_victima",_tipo_victima);
        intent.putExtra("etnia",_etnia);
        intent.putExtra("eps",_eps);

        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair(backBtn, "transition_back_btn");
        pairs[1] = new Pair(next, "transition_next_btn");
        pairs[2] = new Pair(titleText, "transition_title_text");

            startActivity(intent);

    }

    private boolean validarCabezaFamilia() {

        if (radioGroupCabezaFamilia.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecciona si eres cabeza de familia", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validarEps() {
        String val = eps.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            eps.setError("Este campo no puede estar vacio");
            return false;
        } else {
            eps.setError(null);
            eps.setErrorEnabled(false);
            return true;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String doctext = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), doctext, Toast.LENGTH_SHORT);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}