package com.example.appacolhimento2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Toast;

import com.example.appacolhimento2.maps.LocalizacaoUsuario;

import java.io.Serializable;

public class MostrarMaps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_maps);

        WebView googleMaps = findViewById(R.id.webViewMaps);
        double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        double longitude = getIntent().getDoubleExtra("longitude", 0.0);
        googleMaps.loadUrl("http://www.google.com/maps/place/" + latitude + "," + longitude);
    }
}