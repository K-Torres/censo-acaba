package com.example.censoacaba.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.censoacaba.R;

public class LoginActivity extends AppCompatActivity {

    private EditText eName, ePassword;
    private TextView Tittle;
    private Button Loginbutton;
    private String Username=" ";
    private String Password=" ";

    boolean isValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etpassword);
        Tittle = findViewById(R.id.tvTittle);
        Loginbutton = findViewById(R.id.btnLogin);

        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(LoginActivity.this, "Por favor ingresa los credenciales", Toast.LENGTH_SHORT).show();
                } else {
                    isValid = validate(inputName, inputPassword);

                    if(!isValid) {
                        Toast.makeText(LoginActivity.this, "Credenciales Incorrectos", Toast.LENGTH_SHORT).show();

                    }else{
                        Toast.makeText(LoginActivity.this, "Credenciales Correctos", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                }
            }
        });
    }

    private boolean validate(String name, String password){

        if(name.equals(Username) && password.equals(Password))
        {
            return true;
        }

        return false;
    }
}