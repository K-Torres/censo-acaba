package com.example.censoacaba.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.censoacaba.HelperClasses.ConexionSqliteHelper;
import com.example.censoacaba.HelperClasses.Usuario;
import com.example.censoacaba.HelperClasses.Utilidades;
import com.example.censoacaba.R;
import java.util.ArrayList;


public class RegisterList2 extends AppCompatActivity  {

    ListView listaPersonas;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuarios;
    ConexionSqliteHelper conn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_list2);

        listaPersonas = findViewById(R.id.listaPersonas);
        conn = new ConexionSqliteHelper(this, "bd_usuarios", null, 1);

        consultarListaPersonas();

        ArrayAdapter adapter = new ArrayAdapter(this , R.layout.center_list,  listaInformacion);
        listaPersonas.setAdapter(adapter);

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
            usuario.setTipoDoc(cursor.getString(8));
            usuario.setDocumento(cursor.getInt(9));
            usuario.setStatus(cursor.getInt(26));

            listaUsuarios.add(usuario);
        }

        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();

        for (int i=0; i<listaUsuarios.size(); i++){

            if (listaUsuarios.get(i).getStatus()==1){
                listaInformacion.add(( "NOMBRES: " +listaUsuarios.get(i).getNombre()+" \n"
                        +" APELLIDOS: " +listaUsuarios.get(i).getPrimerApellido()+" "
                        +listaUsuarios.get(i).getSegundoApellido()+" \n "
                        +listaUsuarios.get(i).getTipoDoc() +": "+listaUsuarios.get(i).getDocumento() ));
            }

        }
    }

}