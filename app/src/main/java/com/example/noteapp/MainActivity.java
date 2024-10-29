package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Crear un ArrayList donde guardar las notas
    ArrayList<String> listaNotas = new ArrayList<>();

    EditText notas;
    Button btn;
    ListView listViewNotas;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notas = findViewById(R.id.txtIngresarNotas);
        btn = findViewById(R.id.btnGuardar);
        listViewNotas = findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNotas);
        listViewNotas.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcion(notas.getText().toString());
            }
        });
    }

    public void funcion(String NotaIngresada) {
        if (NotaIngresada.isEmpty()) {
            Log.d("TAG", "Por favor Ingrese Texto");
        } else {
            Log.d("TAG", "Éxito!");
            listaNotas.add(NotaIngresada);
            adapter.notifyDataSetChanged();
            notas.setText("");
        }
    }
}
