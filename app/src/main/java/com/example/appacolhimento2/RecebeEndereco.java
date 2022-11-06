package com.example.appacolhimento2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appacolhimento2.R;
import com.example.appacolhimento2.apiweb.ComunicaComApi;
import com.example.appacolhimento2.apiweb.EnderecoApi;

import org.json.JSONException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class RecebeEndereco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.endereco_recebe);
        //permite conexÃ£o com a Internet na Thread principal
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


        EditText editTextBairro = findViewById(R.id.editTextBairro);
        Button buttonPesquisar = findViewById(R.id.buttonPesquisar);

        //disparando o botao
        //acessar a api
        //pegar dados do edit text
        buttonPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (ActivityCompat.checkSelfPermission(RecebeEndereco.this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) { //verificar se tem permissao de internet
                        ActivityCompat.requestPermissions(RecebeEndereco.this, new String[]{Manifest.permission.INTERNET}, 1); //requisitando permissao
                    } else {
                        String bairro = editTextBairro.getText().toString(); //pegar bairro do usuario
                        ArrayList<EnderecoApi> localizacaoPorBairro = ComunicaComApi.retornarLocalizacaoPorBairro(bairro);
                        if(localizacaoPorBairro.size() == 0){
                            Toast.makeText(RecebeEndereco.this,"Nenhum endereço foi encontrado", Toast.LENGTH_LONG).show();
                        }else{
                            Intent intent = new Intent(RecebeEndereco.this, ListaLocaisProximos.class);
                            intent.putExtra("listaLocaisProximos", (Serializable) localizacaoPorBairro);
                            startActivity(intent);
                        }
                    };
                } catch (Exception e) {
                    Toast.makeText(RecebeEndereco.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                try {
                    Toast.makeText(this,"Connected", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Não vai funcionar!!!", Toast.LENGTH_LONG).show();
            }
        }
    }
}