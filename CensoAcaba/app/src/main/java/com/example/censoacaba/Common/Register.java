package com.example.censoacaba.Common;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.censoacaba.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {

    ImageView backBtn;
    Button next;
    TextView titleText;
    RadioGroup radioGroupGender;
    DatePicker datePicker;
    RadioButton selectedGender;


    //variables datos
    TextInputLayout nombre, primer_apellido, segundo_apellido, correo, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        datePicker = findViewById(R.id.date_picker);
        datePicker.setMaxDate(new Date().getTime());

        radioGroupGender = findViewById(R.id.radiogoup_gender);

        backBtn = findViewById(R.id.register_back_btn);
        next = findViewById(R.id.register_next_btn);
        titleText = findViewById(R.id.register_title_text);


        nombre = findViewById(R.id.nombres);
        primer_apellido = findViewById(R.id.primer_apellido);
        segundo_apellido = findViewById(R.id.segundo_apellido);
        correo = findViewById(R.id.correo);
        telefono = findViewById(R.id.telefono);
    }


    public void callNextRegisterScreen(View view) {

        if ( !validarNombre() | !validarPrimerApellido() | !validarSegundoApellido() | !validarGenero() | !validatarEdad()) {
            return;
        }

        selectedGender = findViewById(radioGroupGender.getCheckedRadioButtonId());

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        String _nombre = nombre.getEditText().getText().toString();
        String _primer_apellido = primer_apellido.getEditText().getText().toString();
        String _segundo_apellido = segundo_apellido.getEditText().getText().toString();
        String _correo = correo.getEditText().getText().toString().trim();
        String _fechanacimiento = year+"-"+month+"-"+day;
        String _genero = selectedGender.getText().toString();
        _genero = String.valueOf(_genero.charAt(0));
        String  _telefono = telefono.getEditText().getText().toString();

        Intent intent = new Intent(getApplicationContext(), Register2ndclass.class);

        intent.putExtra("nombre",_nombre);
        intent.putExtra("primer_apellido",_primer_apellido);
        intent.putExtra("segundo_apellido",_segundo_apellido);
        intent.putExtra("correo",_correo);
        intent.putExtra("genero",_genero);
        intent.putExtra("fechanacimiento",_fechanacimiento);
        intent.putExtra("telefono",_telefono);

        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair(backBtn, "transition_back_btn");
        pairs[1] = new Pair(next, "transition_next_btn");
        pairs[2] = new Pair(titleText, "transition_title_text");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    private boolean validarNombre() {
        String val = nombre.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            nombre.setError("Este campo no puede estar vacio");
            return false;
        } else {
            nombre.setError(null);
            nombre.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validarPrimerApellido() {
        String val = primer_apellido.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";


        if (val.isEmpty()) {
            primer_apellido.setError("Este campo no puede estar vacio");
            return false;
        } else if (!val.matches(checkspaces)) {
            primer_apellido.setError("No están permitidos los espacios en este campo");
            return false;
        } else {
            primer_apellido.setError(null);
            primer_apellido.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validarSegundoApellido() {
        String val = segundo_apellido.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,20}\\z";


        if (val.isEmpty()) {
            segundo_apellido.setError("Este campo no puede estar vacio");
            return false;
        } else if (!val.matches(checkspaces)) {
            segundo_apellido.setError("No están permitidos los espacios en este campo");
            return false;
        } else {
            segundo_apellido.setError(null);
            segundo_apellido.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validarGenero() {

        if (radioGroupGender.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Por favor, selecciona un género", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validatarEdad() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 1) {
            Toast.makeText(this, "Tu edad no es legible", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }


}