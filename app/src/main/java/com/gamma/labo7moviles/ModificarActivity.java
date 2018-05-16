package com.gamma.labo7moviles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gamma.labo7moviles.Datos.Persona;
import com.gamma.labo7moviles.entidades.DBHelper;

public class ModificarActivity extends AppCompatActivity {

    EditText id, nombre;
    Button btnBuscar, btnEliminar, btnActualizar, btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        inicializarControles();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Persona p = DBHelper.myDB.findUser(id.getText().toString());
                if(p == null){
                    Toast.makeText(getApplicationContext(), "El usuario no fue encontrado", Toast.LENGTH_SHORT).show();
                    limpiar();
                }else {
                    nombre.setText(p.getNombre());
                }
            }
        });


        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.editUser(new Persona(id.getText().toString(), nombre.getText().toString()));
            }
        });


        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper.myDB.deleteUser(id.getText().toString());
                limpiar();
            }
        });


        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar();
            }
        });
    }

    public void inicializarControles(){
        id = findViewById(R.id.txtIdM);
        nombre = findViewById(R.id.txtNombreM);
        btnBuscar = findViewById(R.id.btbBuscarM);
        btnEliminar = findViewById(R.id.btbEliminarM);
        btnActualizar = findViewById(R.id.btbActualizarM);
        btnLimpiar = findViewById(R.id.btbLimpiarM);
    }

    public void limpiar(){
        nombre.setText("");
        id.setText("");
    }
}
