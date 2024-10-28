package com.example.noteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Crear un ArrayList donde guardar las notas
    ArrayList<String> listaNotas = new ArrayList<>();

    EditText notas;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notas = findViewById(R.id.txtIngresarNotas);

        btn = findViewById(R.id.btnGuardar);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcion(notas.getText().toString());

            }
        });



    }

    public void funcion(String NotaIngresada){
        if (NotaIngresada.isEmpty()){
            Log.d("TAG","Por favor Ingrese Texto");



        }else{
            Log.d("TAG", "Exito!");
            listaNotas.add(NotaIngresada);


        }
    }


}
