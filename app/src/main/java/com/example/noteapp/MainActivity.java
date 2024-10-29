package com.example.noteapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Crear un ArrayList donde guardar las notas
    ArrayList<String> listaNotas = new ArrayList<>();

    EditText notas;
    Button btnGuardar, btnEliminar;
    ListView listViewNotas;
    ArrayAdapter<String> adapter;
    int selectedPosition = ListView.INVALID_POSITION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notas = findViewById(R.id.txtIngresarNotas);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnEliminar = findViewById(R.id.btnEliminar);
        listViewNotas = findViewById(R.id.listview);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, listaNotas);
        listViewNotas.setAdapter(adapter);
        listViewNotas.setChoiceMode(ListView.CHOICE_MODE_SINGLE); // Set choice mode

        // Handle the click event on the ListView items
        listViewNotas.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition = position; // Update the selected position
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                funcion(notas.getText().toString());
            }
        });

        // Handle delete button click
        btnEliminar.setOnClickListener(v -> {
            if (selectedPosition != ListView.INVALID_POSITION) {
                listaNotas.remove(selectedPosition);
                adapter.notifyDataSetChanged();
                listViewNotas.clearChoices(); // Clear selection if desired
                selectedPosition = ListView.INVALID_POSITION; // Reset selected position
                Toast.makeText(MainActivity.this, "Nota eliminada", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Seleccione una nota para eliminar", Toast.LENGTH_SHORT).show();
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
