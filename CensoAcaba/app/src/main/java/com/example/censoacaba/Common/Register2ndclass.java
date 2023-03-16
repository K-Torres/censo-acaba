package com.example.censoacaba.Common;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.example.censoacaba.R;
import com.example.censoacaba.databinding.ActivityRegister2ndclassBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Register2ndclass extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    ImageView backBtn;
    Button next;
    TextView troncoText, titleText;
    Spinner docSpinner, departamentoSpinner, municipioSpinner, consejoSpinner, comunidadSpinner, permanenciaSpinner;
    DatePicker datePicker;

    TextInputLayout numerodocumento, troncofamiliarvar, idfamiliar;



    ActivityRegister2ndclassBinding binding;

    ArrayList<String> arrayList_municipios;

    ArrayList<String> arrayList_altobaudo, arrayList_mediobaudo, arrayList_bajobaudo, arrayList_canton_sampablo, arrayList_rio_quito;

    ArrayList<String> arrayList_Amparrado, arrayList_Ampora, arrayList_Batatal, arrayList_BocaDeApartado, arrayList_BocaDeLeon, arrayList_Chachajo, arrayList_Chigorodo, arrayList_Cocalito, arrayList_LaPlaya, arrayList_LasDelicias, arrayList_Nauca, arrayList_PeñaAzul, arrayList_PieDePato, arrayList_PuertoCarmelo, arrayList_PuertoCordoba, arrayList_PuertoMartinez, arrayList_PuertoValencia, arrayList_Pureza, arrayList_SantaRita, arrayList_Yucal;
    ArrayList<String> arrayList_Almendro, arrayList_AltoCurundo, arrayList_Arenal, arrayList_BellaVistaDeBerreberre, arrayList_Beriguado, arrayList_BerrecuyCarretera, arrayList_BocaDeBaudocito, arrayList_BocaDePepe, arrayList_CurundoLaBanca, arrayList_Ogodo, arrayList_PuertoCordobaLaCalle, arrayList_PuertoMeluk, arrayList_PuertoOlivia, arrayList_PuertoPlatanares, arrayList_RíoTierfe, arrayList_RíoTorrido, arrayList_SanJoseDeQuera, arrayList_SanMiguel, arrayList_UnionMisara;
    ArrayList<String> arrayList_comunidad_bajobaudo, arrayList_comunidad_canton_sampablo, arrayList_comunidad_rio_quito;

    ArrayAdapter<String> arrayAdapter_municipios;
    ArrayAdapter<String> arrayAdapter_consejos;
    ArrayAdapter<String> arrayAdapter_comunidades;

    int position_selected_municipio;
    int position_selected_consejo;
    int position_selected_comunidad;
    int troncofamiliar;
    String tronco, selected_municipios="", selected_consejos="", selected_comunidades="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegister2ndclassBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        backBtn = findViewById(R.id.register_back_btn);
        next = findViewById(R.id.register_next_btn);
        titleText = findViewById(R.id.register_title_text);
        troncoText = findViewById(R.id.tronco_familiar_tv);
        numerodocumento = findViewById(R.id.numerodocumento);
        troncofamiliarvar = findViewById(R.id.troncofamiliar);
        idfamiliar = findViewById(R.id.idfamiliar);

        //Spinners
        docSpinner = findViewById(R.id.docspinner);
        departamentoSpinner = findViewById(R.id.departamento_spinner);
        municipioSpinner = findViewById(R.id.municipio_spinner);
        consejoSpinner = findViewById(R.id.consejo_spinner);
        comunidadSpinner = findViewById(R.id.comunidad_spinner);
        permanenciaSpinner = findViewById(R.id.permanencia_spinner);

        //Seteando fecha maxima
        datePicker = findViewById(R.id.date_picker);
        datePicker.setMaxDate(new Date().getTime());

        //Seteando spinner
        ArrayAdapter<CharSequence> docadapter = ArrayAdapter.createFromResource(this, R.array.tipo_cedula, R.layout.spinner_item);
        docadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        docSpinner.setAdapter(docadapter);
        docSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> departamentoadapter = ArrayAdapter.createFromResource(this, R.array.departamento, R.layout.spinner_item);
        departamentoadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        departamentoSpinner.setAdapter(departamentoadapter);
        departamentoSpinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence>permanenciaadapter = ArrayAdapter.createFromResource(this, R.array.permanencia_territorial, R.layout.spinner_item);
        permanenciaadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        permanenciaSpinner.setAdapter(permanenciaadapter);
        permanenciaSpinner.setOnItemSelectedListener(this);

        comunidades_list();

        load_initial();



        binding.municipioSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                /*selected_municipios = binding.municipioSpinner.getSelectedItem().toString().trim()+"";*/
                position_selected_municipio = position;

                if (position == 0)
                {
                    arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_altobaudo);
                }
                if (position == 1)
                {
                    arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_bajobaudo);
                }
                if (position == 2)
                {
                    arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_canton_sampablo);
                }
                if (position == 3)
                {
                    arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_mediobaudo);
                }
                if (position == 4)
                {
                    arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_rio_quito);
                }

                arrayAdapter_consejos.setDropDownViewResource(R.layout.spinner_dropdown_item);
                binding.consejoSpinner.setAdapter(arrayAdapter_consejos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        binding.consejoSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_consejos = binding.consejoSpinner.getSelectedItem().toString().trim()+"";
                position_selected_consejo = position;
                                                                                        //Alto baudo
                if(selected_consejos.equals(arrayList_altobaudo.get(0))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Amparrado);}
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(1))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Ampora); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(2))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Batatal); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(3))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BocaDeApartado); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(4))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BocaDeLeon); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(5))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Chachajo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(6))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Chigorodo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(7))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Cocalito); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(8))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_LaPlaya); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(9))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_LasDelicias); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(10))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Nauca); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(11))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PeñaAzul); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(12))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PieDePato); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(13))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoCarmelo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(14))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoCordoba); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(15))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoMartinez); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(16))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoValencia); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(17))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Pureza); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(18))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_SantaRita); }
                if(selected_consejos.equalsIgnoreCase(arrayList_altobaudo.get(19))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Yucal); }
                                                                                            //Medio baudo
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(0))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Almendro); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(1))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_AltoCurundo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(2))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Arenal); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(3))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BellaVistaDeBerreberre); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(4))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Beriguado); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(5))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BerrecuyCarretera); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(6))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BocaDeBaudocito); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(7))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_BocaDePepe); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(8))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_CurundoLaBanca); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(9))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_Ogodo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(10))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoCordobaLaCalle); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(11))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoMeluk); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(12))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoOlivia); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(13))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_PuertoPlatanares); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(14))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_RíoTierfe); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(15))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_RíoTorrido); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(16))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_SanJoseDeQuera); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(17))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_SanMiguel); }
                if(selected_consejos.equalsIgnoreCase(arrayList_mediobaudo.get(18))){ arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_UnionMisara); }
                                                                                             //Bajo baudo, canton de sampablo y rio quito
                if(selected_consejos.equalsIgnoreCase(arrayList_bajobaudo.get(0))) { arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_comunidad_bajobaudo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_canton_sampablo.get(0))) { arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_comunidad_canton_sampablo); }
                if(selected_consejos.equalsIgnoreCase(arrayList_rio_quito.get(0))) { arrayAdapter_comunidades=new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_comunidad_rio_quito); }

                arrayAdapter_comunidades.setDropDownViewResource(R.layout.spinner_dropdown_item);

                binding.comunidadSpinner.setAdapter(arrayAdapter_comunidades);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        binding.comunidadSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selected_comunidades = binding.comunidadSpinner.getSelectedItem().toString().trim()+"";
                position_selected_comunidad = position;
                tronco = "" + position_selected_municipio + position_selected_consejo + position_selected_comunidad;
                troncoText.setText(" "+tronco+" - ");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    void comunidades_list(){

        //======================================= MUNICIPIOS ======================

        arrayList_municipios = new ArrayList<>();
        arrayList_municipios.add("Alto Baudó");
        arrayList_municipios.add("Bajo Baudó");
        arrayList_municipios.add("El Cantón de Sampablo");
        arrayList_municipios.add("Medio Baudó");
        arrayList_municipios.add("Río Quito");



        //======================================= CONSEJOS ======================

        arrayList_altobaudo = new ArrayList<>();
        arrayList_altobaudo.add("Amparrado"); arrayList_altobaudo.add("Ampora"); arrayList_altobaudo.add("Batatal"); arrayList_altobaudo.add("Boca De Apartado");
        arrayList_altobaudo.add("Boca De Leon"); arrayList_altobaudo.add("Chachajo"); arrayList_altobaudo.add("Chigorodo"); arrayList_altobaudo.add("Cocalito");
        arrayList_altobaudo.add("La Playa"); arrayList_altobaudo.add("Las Delicias"); arrayList_altobaudo.add("Nauca"); arrayList_altobaudo.add("Peña Azul");
        arrayList_altobaudo.add("Pie De Pato"); arrayList_altobaudo.add("Puerto Carmelo"); arrayList_altobaudo.add("Puerto Cordoba"); arrayList_altobaudo.add("Puerto Martinez");
        arrayList_altobaudo.add("Puerto Valencia"); arrayList_altobaudo.add("Pureza"); arrayList_altobaudo.add("Santa Rita"); arrayList_altobaudo.add("Yucal");

        arrayList_mediobaudo = new ArrayList<>();
        arrayList_mediobaudo.add("Almendro"); arrayList_mediobaudo.add("Alto Curundo"); arrayList_mediobaudo.add("Arenal"); arrayList_mediobaudo.add("Bella Vista De Berreberre");
        arrayList_mediobaudo.add("Beriguado"); arrayList_mediobaudo.add("Berrecuy Carretera"); arrayList_mediobaudo.add("Boca De Baudocito"); arrayList_mediobaudo.add("Boca De Pepe");
        arrayList_mediobaudo.add("Curundo La Banca"); arrayList_mediobaudo.add("Ogodo"); arrayList_mediobaudo.add("Puerto Cordoba La Calle"); arrayList_mediobaudo.add("Puerto Meluk");
        arrayList_mediobaudo.add("Puerto Olivia"); arrayList_mediobaudo.add("Puerto Platanares"); arrayList_mediobaudo.add("Río Tierfe"); arrayList_mediobaudo.add("Río Torrido");
        arrayList_mediobaudo.add("San Jose De Quera"); arrayList_mediobaudo.add("San Miguel"); arrayList_mediobaudo.add("Union Misara");

        arrayList_bajobaudo = new ArrayList<>();
        arrayList_bajobaudo.add("Bajo baudó");

        arrayList_canton_sampablo = new ArrayList<>();
        arrayList_canton_sampablo.add("El cantón de Sampablo");

        arrayList_rio_quito = new ArrayList<>();
        arrayList_rio_quito.add("Rio Quito");


        //======================================= COMUNIDADES ======================

        //======================================= COMUNIDADES ALTO BAUDO======================

         arrayList_Amparrado = new ArrayList<>(); arrayList_Amparrado.add("Amparrado");
         arrayList_Ampora = new ArrayList<>(); arrayList_Ampora.add("Ampora");
         arrayList_Batatal = new ArrayList<>(); arrayList_Batatal.add("Batatal");
         arrayList_BocaDeApartado = new ArrayList<>(); arrayList_BocaDeApartado.add("Boca De Apartado");
         arrayList_BocaDeLeon = new ArrayList<>(); arrayList_BocaDeLeon.add("Boca De Leon");
         arrayList_Chachajo = new ArrayList<>(); arrayList_Chachajo.add("Chachajo");
         arrayList_Chigorodo = new ArrayList<>(); arrayList_Chigorodo.add("Chigorodo");
         arrayList_Cocalito = new ArrayList<>(); arrayList_Cocalito.add("Cocalito");
         arrayList_LaPlaya = new ArrayList<>(); arrayList_LaPlaya.add("La Playa");
         arrayList_LasDelicias = new ArrayList<>(); arrayList_LasDelicias.add("Las Delicias");
         arrayList_Nauca = new ArrayList<>(); arrayList_Nauca.add("Nauca");
         arrayList_PeñaAzul = new ArrayList<>(); arrayList_PeñaAzul.add("Peña Azul");
         arrayList_PieDePato = new ArrayList<>(); arrayList_PieDePato.add("Pie De Pato");
         arrayList_PuertoCarmelo = new ArrayList<>(); arrayList_PuertoCarmelo.add("Puerto Carmelo");
         arrayList_PuertoCordoba = new ArrayList<>(); arrayList_PuertoCordoba.add("Puerto Cordoba");
         arrayList_PuertoMartinez = new ArrayList<>(); arrayList_PuertoMartinez.add("Puerto Martinez");
         arrayList_PuertoValencia = new ArrayList<>(); arrayList_PuertoValencia.add("Puerto Valencia");
         arrayList_Pureza = new ArrayList<>(); arrayList_Pureza.add("Pureza");
         arrayList_SantaRita = new ArrayList<>(); arrayList_SantaRita.add("Santa Rita");
         arrayList_Yucal = new ArrayList<>(); arrayList_Yucal.add("Yucal");

        //======================================= COMUNIDADES MEDIO BAUDO======================

        arrayList_Almendro = new ArrayList<>(); arrayList_Almendro.add("Almendro");
        arrayList_AltoCurundo = new ArrayList<>(); arrayList_AltoCurundo.add("Alto Curundo");
        arrayList_Arenal = new ArrayList<>(); arrayList_Arenal.add("Arenal");
        arrayList_BellaVistaDeBerreberre = new ArrayList<>(); arrayList_BellaVistaDeBerreberre.add("Bella Vista De Berreberre");
        arrayList_Beriguado = new ArrayList<>(); arrayList_Beriguado.add("Beriguado");
        arrayList_BerrecuyCarretera = new ArrayList<>(); arrayList_BerrecuyCarretera.add("Berrecu y Carretera");
        arrayList_BocaDeBaudocito = new ArrayList<>(); arrayList_BocaDeBaudocito.add("Boca De Baudocito");
        arrayList_BocaDePepe = new ArrayList<>(); arrayList_BocaDePepe.add("Boca De Pepe");
        arrayList_CurundoLaBanca = new ArrayList<>(); arrayList_CurundoLaBanca.add("Curundo La Banca");
        arrayList_Ogodo = new ArrayList<>(); arrayList_Ogodo.add("Ogodo");
        arrayList_PuertoCordobaLaCalle = new ArrayList<>(); arrayList_PuertoCordobaLaCalle.add("Puerto Cordoba La Calle");
        arrayList_PuertoMeluk = new ArrayList<>(); arrayList_PuertoMeluk.add("Puerto Meluk");
        arrayList_PuertoOlivia = new ArrayList<>(); arrayList_PuertoOlivia.add("Puerto Olivia");
        arrayList_PuertoPlatanares = new ArrayList<>(); arrayList_PuertoPlatanares.add("Puerto Platanares");
        arrayList_RíoTierfe = new ArrayList<>(); arrayList_RíoTierfe.add("Río Tierfe");
        arrayList_RíoTorrido = new ArrayList<>(); arrayList_RíoTorrido.add("Río Torrido");
        arrayList_SanJoseDeQuera = new ArrayList<>(); arrayList_SanJoseDeQuera.add("San Jose De Quera");
        arrayList_SanMiguel = new ArrayList<>(); arrayList_SanMiguel.add("San Miguel");
        arrayList_UnionMisara = new ArrayList<>(); arrayList_UnionMisara.add("Union Misara");


        //======================================= OTRAS COMUNIDADES ==============================

        arrayList_comunidad_bajobaudo = new ArrayList<>(); arrayList_comunidad_bajobaudo.add("Bajo baudo");
        arrayList_comunidad_canton_sampablo = new ArrayList<>(); arrayList_comunidad_canton_sampablo.add("El cantón de Sampablo");
        arrayList_comunidad_rio_quito  = new ArrayList<>(); arrayList_comunidad_rio_quito.add("Rio Quito");;
    }

    void load_initial(){

        arrayAdapter_municipios = new ArrayAdapter<>(Register2ndclass.this,R.layout.spinner_item, arrayList_municipios);
        arrayAdapter_municipios.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.municipioSpinner.setAdapter(arrayAdapter_municipios);

        arrayAdapter_consejos = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_altobaudo);
        arrayAdapter_consejos.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.consejoSpinner.setAdapter(arrayAdapter_consejos);

        arrayAdapter_comunidades = new ArrayAdapter<>(Register2ndclass.this, R.layout.spinner_item, arrayList_Amparrado);
        arrayAdapter_comunidades.setDropDownViewResource(R.layout.spinner_dropdown_item);
        binding.comunidadSpinner.setAdapter(arrayAdapter_comunidades);

    }


    public void callNextRegisterScreen(View view) {

        if (!validarIdFamiliar() | !validarNumeroDocumento() | !validarTroncofamiliar() | !validarFechaExpedicion()) {
            return;
        }

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1;
        int year = datePicker.getYear();

        String _tipodocumento = docSpinner.getSelectedItem().toString();
        String _departamento =  departamentoSpinner.getSelectedItem().toString();
        String _municipio = Integer.toString(position_selected_municipio);
        String _consejo = Integer.toString( position_selected_consejo);
        String _comunidad = Integer.toString(position_selected_comunidad);
        String _permanencia = permanenciaSpinner.getSelectedItem().toString();
        String _fechaexpedicion =  year+"-"+month+"-"+day;
        String  _numerodocumento = numerodocumento.getEditText().getText().toString();
        String  _troncofamiliar = tronco+troncofamiliarvar.getEditText().getText().toString();
        String  _idfamiliar = idfamiliar.getEditText().getText().toString();

        String _nombre = getIntent().getStringExtra("nombre");
        String _primer_apellido = getIntent().getStringExtra("primer_apellido");
        String _segundo_apellido = getIntent().getStringExtra("segundo_apellido");
        String _correo = getIntent().getStringExtra("correo");
        String _genero = getIntent().getStringExtra("genero");
        String _fechanacimiento = getIntent().getStringExtra("fechanacimiento");
        String _telefono = getIntent().getStringExtra("telefono");

        Intent intent = new Intent(getApplicationContext(), Register3rdclass.class);

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


        Pair[] pairs = new Pair[3];

        pairs[0] = new Pair(backBtn, "transition_back_btn");
        pairs[1] = new Pair(next, "transition_next_btn");
        pairs[2] = new Pair(titleText, "transition_title_text");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register2ndclass.this, pairs);
            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent);
        }

    }

    private boolean validarNumeroDocumento() {
        String val = numerodocumento.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            numerodocumento.setError("Ingresa un numero valido");
            return false;
        } else {
            numerodocumento.setError(null);
            numerodocumento.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validarTroncofamiliar() {
        String val = troncofamiliarvar.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            troncofamiliarvar.setError("Ingresa un numero valido");
            return false;
        } else {
            troncofamiliarvar.setError(null);
            troncofamiliarvar.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validarFechaExpedicion() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int userYear = datePicker.getYear();
        int userMonth = datePicker.getMonth();
        int userDay = datePicker.getDayOfMonth();

        if (currentYear == userYear && currentMonth == userMonth && currentDay == userDay) {
            Toast.makeText(this, "Selecciona la fecha de expedicion", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    private boolean validarIdFamiliar() {
        String val = idfamiliar.getEditText().getText().toString().trim();

        if (val.isEmpty()) {
            idfamiliar.setError("Ingresa un numero valido");
            return false;
        } else {
            idfamiliar.setError(null);
            idfamiliar.setErrorEnabled(false);
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

