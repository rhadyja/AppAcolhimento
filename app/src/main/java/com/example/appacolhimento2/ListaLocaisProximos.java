package com.example.appacolhimento2;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.appacolhimento2.apiweb.EnderecoApi;

import java.util.ArrayList;

public class ListaLocaisProximos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_locais_proximos);

        TableLayout locaisProximosListagem = findViewById(R.id.listView);
        ArrayList<EnderecoApi> enderecosRecebidos = (ArrayList<EnderecoApi>) getIntent().getSerializableExtra("listaLocaisProximos");
        for (int i = 0; i < enderecosRecebidos.size(); i++) {
            EnderecoApi este = enderecosRecebidos.get(i);
            TableRow enderecoItem = new TableRow(this);
            TextView nomeDoEndereco = new TextView(this);
            TextView nomeDoLocal = new TextView(this);
            nomeDoLocal.setText(enderecosRecebidos.get(i).getEquipamentoPublicoDisponivel());
            nomeDoLocal.setTextSize(16);
            nomeDoEndereco.setText(enderecosRecebidos.get(i).getEndereco() + ", " + enderecosRecebidos.get(i).getBairro().toUpperCase());
            nomeDoEndereco.setTextSize(12);
            enderecoItem.addView(nomeDoLocal);
            enderecoItem.addView(nomeDoEndereco);
            enderecoItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(ListaLocaisProximos.this, MostrarMaps.class);
                    intent.putExtra("latitude", este.getLatitude());
                    intent.putExtra("longitude", este.getLongitude());
                    startActivity(intent);
                }
            });
            locaisProximosListagem.addView(enderecoItem);
        }


    }
}