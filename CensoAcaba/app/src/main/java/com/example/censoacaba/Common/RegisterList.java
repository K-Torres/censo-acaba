package com.example.censoacaba.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.censoacaba.HelperClasses.ConexionSqliteHelper;
import com.example.censoacaba.HelperClasses.Usuario;
import com.example.censoacaba.HelperClasses.Utilidades;
import com.example.censoacaba.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RegisterList extends AppCompatActivity  {

    Button sincrozinarbtn;

    ListView listaPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;
    ConexionSqliteHelper conn;

    ProgressDialog progressDialog;

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_list);

        request = Volley.newRequestQueue(this);

        sincrozinarbtn = findViewById(R.id.sincronizarbtn);

        listaPersonas = findViewById(R.id.listaPersonas);
        conn = new ConexionSqliteHelper(this, "bd_usuarios", null, 1);

        consultarListaPersonas();

        ArrayAdapter adapter = new ArrayAdapter(this , R.layout.center_list, listaInformacion);
        listaPersonas.setAdapter(adapter);

        sincrozinarbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarWebService();
            }
        });
    }

    public void callShowRegisterList2(View view) {
        Intent intent = new Intent(getApplicationContext(), RegisterList2.class);
        startActivity(intent);
    }

    private void cargarWebService() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Cargando...");
        progressDialog.show();

        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuariosync = null;

        Cursor cursorsync = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);

        while (cursorsync.moveToNext()) {

            usuariosync = new Usuario();
            usuariosync.setId(cursorsync.getInt(0));
            usuariosync.setNombre(cursorsync.getString(1));
            usuariosync.setPrimerApellido(cursorsync.getString(2));
            usuariosync.setSegundoApellido(cursorsync.getString(3));
            usuariosync.setCorreo(cursorsync.getString(4));
            usuariosync.setGenero(cursorsync.getString(6));
            usuariosync.setTelefono(cursorsync.getString(5));
            usuariosync.setFechaNacimiento(cursorsync.getString(7));
            usuariosync.setTipoDoc(cursorsync.getString(8));
            usuariosync.setDocumento(cursorsync.getInt(9));
            usuariosync.setFechaExpedicion(cursorsync.getString(10));
            usuariosync.setDepartamento(cursorsync.getString(11));
            usuariosync.setMunicipio(cursorsync.getString(12));
            usuariosync.setConsejo(cursorsync.getString(13));
            usuariosync.setComunidad(cursorsync.getString(14));
            usuariosync.setTroncoFamiliar(cursorsync.getInt(15));
            usuariosync.setIdFamiliar(cursorsync.getInt(16));
            usuariosync.setPermanenciaTerritorial(cursorsync.getString(17));
            usuariosync.setParentesco(cursorsync.getString(18));
            usuariosync.setCabezaFamilia(cursorsync.getString(19));
            usuariosync.setEtnia(cursorsync.getString(20));
            usuariosync.setTipoSangre(cursorsync.getString(21));
            usuariosync.setNivelEscolar(cursorsync.getString(22));
            usuariosync.setDiscapacidad(cursorsync.getString(23));
            usuariosync.setTipoVictima(cursorsync.getString(24));
            usuariosync.setEps(cursorsync.getString(25));

            final String nombre = usuariosync.getNombre();
            final String primer_apellido = usuariosync.getPrimerApellido();
            final String segundo_apellido = usuariosync.getSegundoApellido();
            final String correo = usuariosync.getCorreo();
            final String genero = usuariosync.getGenero();
            final String telefono = usuariosync.getTelefono();
            final String fecha_nacimiento = usuariosync.getFechaNacimiento();
            final String tipo_documento = usuariosync.getTipoDoc();
            final int num_documento_identidad = usuariosync.getDocumento();
            final String fecha_expedicion = usuariosync.getFechaExpedicion();
            final String departamento = usuariosync.getDepartamento();
            final String municipio = usuariosync.getMunicipio();
            final String consejo = usuariosync.getConsejo();
            final String comunidad = usuariosync.getComunidad();
            final int tronco_familiar = usuariosync.getTroncoFamiliar();
            final int id_familiar = usuariosync.getIdFamiliar();
            final String permanencia_territorial = usuariosync.getPermanenciaTerritorial();
            final String parentesco = usuariosync.getParentesco();
            final String cabeza_familia = usuariosync.getCabezaFamilia();
            final String etnia = usuariosync.getEtnia();
            final String tipo_sangre = usuariosync.getTipoSangre();
            final String escolaridad = usuariosync.getNivelEscolar();
            final String tipo_discapacidad = usuariosync.getDiscapacidad();
            final String tipo_victima = usuariosync.getTipoVictima();
            final String eps = usuariosync.getEps();

            String url = "https://acaba.com.co/conexion.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(RegisterList.this, "Se ha registrado exitosamente", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();

                            SQLiteDatabase db = conn.getWritableDatabase();

                            db.execSQL("UPDATE " + Utilidades.TABLA_USUARIO + " SET " + Utilidades.CAMPO_STATUS + " =  1" );
                            //UPDATE theTable SET Column1 = someNewValue

                            Intent intent = getIntent();
                            finish();
                            startActivity(intent);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(RegisterList.this, "No se pudo registrar", Toast.LENGTH_SHORT).show();
                            progressDialog.hide();
                            Log.i("ERROR",error.toString());
                        }
                    }) {

                @Override
                protected Map<String, String> getParams() {

                    Map<String, String> params = new HashMap<String, String>();
                    params.put("nombres", nombre.toUpperCase());
                    params.put("primer_apellido", primer_apellido.toUpperCase());
                    params.put("segundo_apellido", segundo_apellido.toUpperCase());
                    params.put("tipo_documento", tipo_documento.toUpperCase());
                    params.put("num_doc_identidad", "" + num_documento_identidad);
                    params.put("genero", genero.toUpperCase());
                    params.put("correo", correo.toUpperCase());
                    params.put("telefono", telefono);
                    params.put("orientacion_sexual", "HETERO");
                    params.put("fecha_nacimiento", fecha_nacimiento);
                    params.put("fecha_expedicion", fecha_expedicion);
                    params.put("tipo_sangre", tipo_sangre.toUpperCase());
                    params.put("etnia", etnia.toUpperCase());
                    params.put("escolaridad", escolaridad.toUpperCase());
                    params.put("eps", eps.toUpperCase());
                    params.put("tipo_discapacidad", tipo_discapacidad.toUpperCase());
                    params.put("tipo_victima", tipo_victima.toUpperCase());
                    params.put("estado_permanencia_territ", permanencia_territorial.toUpperCase());
                    params.put("departamento_id", departamento);
                    params.put("municipio_id", municipio);
                    params.put("consejo_comunitario_id", consejo);
                    params.put("comunidad_id", comunidad);
                    params.put("fecha_registro", "1111-11-11");
                    params.put("usuario_registro_id", "1");

                    /*params.put("tronco_familiar", "" + tronco_familiar);
                    params.put("id_familiar", "" + id_familiar);
                    params.put("parentesco", parentesco);
                    params.put("cabeza_familia", cabeza_familia);*/

                    return params;
                }
            };

            RequestQueue requestQueue = Volley.newRequestQueue(RegisterList.this);
            requestQueue.add(stringRequest);

        }
    }


    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

        Usuario usuario;
        listaUsuarios = new ArrayList<Usuario>();

        Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setPrimerApellido(cursor.getString(2));
            usuario.setSegundoApellido(cursor.getString(3));
            usuario.setDocumento(cursor.getInt(9));
            usuario.setStatus(cursor.getInt(26));

            listaUsuarios.add(usuario);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size(); i++){

            if (listaUsuarios.get(i).getStatus()==0){
                listaInformacion.add(( " NOMBRES: " +listaUsuarios.get(i).getNombre()+" \n"
                        +" APELLIDOS: " +listaUsuarios.get(i).getPrimerApellido()+" "
                        +listaUsuarios.get(i).getSegundoApellido()+" \n "
                        +listaUsuarios.get(i).getTipoDoc() +": "+listaUsuarios.get(i).getDocumento() ));
            }

        }
    }

}