package com.example.estadorealbeta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InicioSesion extends AppCompatActivity {

    private Button btnAcceder;
    private EditText user;
    private EditText tbPassword;

    private TextView nombreUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        btnAcceder = findViewById(R.id.btnAcceder);

        user = findViewById(R.id.user);
        tbPassword = findViewById(R.id.tbPassword);

        btnAcceder.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //lo que se tenga que hacer.
                if(user.getText().toString().equals("leo") && tbPassword.getText().toString().equals("1234")) {

                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("nombreUsuario", user.getText().toString());
                    startActivity(i);

                } else {
                    Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
