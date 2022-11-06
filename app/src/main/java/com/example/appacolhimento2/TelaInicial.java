package com.example.appacolhimento2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaInicial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicial_tela);

        Button buttonLocais = findViewById(R.id.buttonLocais);
        Button buttonSocorros = findViewById(R.id.buttonSocorros);
        Button buttonSugestao = findViewById(R.id.buttonSugestao);

        //Dependendo de qual botão for apertado, passará para uma activity diferente
        buttonLocais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, RecebeEndereco.class);
                startActivity(intent);

            }
        });

        buttonSocorros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, PrimeirosSocorros.class);
                startActivity(intent);
            }
        });

        buttonSugestao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaInicial.this, FeedComSugestao.class);
                startActivity(intent);
            }
        });

    }
}