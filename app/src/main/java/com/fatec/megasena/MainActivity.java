package com.fatec.megasena;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private Button buttonSortear;
    private TextView textViewNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        buttonSortear = findViewById(R.id.buttonSortear);
        textViewNumbers = findViewById(R.id.textViewNumbers);

        buttonSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Set<Integer> numerosSorteados = sortearNumeros();
                String resultado = "Números sorteados: ";
                for (Integer numero : numerosSorteados) {
                    resultado += numero + " ";
                }
                textViewNumbers.setText(resultado);
            }
        });

    }
    private Set<Integer> sortearNumeros() {
        Set<Integer> numeros = new HashSet<>();
        Random random = new Random();
        while (numeros.size() < 6) {
            int numero = random.nextInt(60) + 1; // Gera números de 1 a 60
            numeros.add(numero);
        }
        return numeros;
    }
}