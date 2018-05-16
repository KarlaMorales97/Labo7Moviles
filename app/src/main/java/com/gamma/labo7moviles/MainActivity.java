package com.gamma.labo7moviles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gamma.labo7moviles.entidades.DBHelper;

public class MainActivity extends AppCompatActivity {

    private Button btnregistrar, btbconsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarControles();
        DBHelper.getInstance(this);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_registrar.class);
                startActivity(intent);
            }
        });

        btbconsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ModificarActivity.class);
                startActivity(intent);
            }
        });
    }
    public void inicializarControles(){
        btnregistrar = findViewById(R.id.mostrarRegistro);
        btbconsultar = findViewById(R.id.consultarUsuario);
    }
}
