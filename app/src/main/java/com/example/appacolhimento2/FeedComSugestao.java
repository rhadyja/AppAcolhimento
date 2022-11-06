package com.example.appacolhimento2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedComSugestao extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sugestao_com_feed);

        String[] endereco = new String[3];
        Button buttonVoltar = findViewById(R.id.buttonVoltar2);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        EditText textRua = findViewById(R.id.editTextRua);
        EditText textNumero = findViewById(R.id.editTextNumero);
        EditText textBairro = findViewById(R.id.editTextBairro);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onBackPressed();
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                endereco[0] = textRua.getText().toString();
                endereco[1] = textNumero.getText().toString();
                endereco[2] = textBairro.getText().toString();

                if(endereco[0].length() >= 3 && !endereco[1].isEmpty() && endereco[2].length() >= 3){

                    String sugestao = endereco[0] + ", " + endereco[1] + ", " + endereco[2];
                    //Fazer o envio para o banco de dados ou adicionar aos endereços conseguidos na internet
                    //API.send(sugestao);

                    textRua.getText().clear();
                    textNumero.getText().clear();
                    textBairro.getText().clear();

                }else{
                    Toast.makeText(FeedComSugestao.this, "Insira informações válidas", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}