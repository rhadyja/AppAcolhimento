package com.example.appacolhimento2.apiweb;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ComunicaComApi {

    private static String readStream(InputStream in){ //ler bytes e transforma em string
        BufferedReader r = new BufferedReader(new InputStreamReader(in));
        StringBuilder total = new StringBuilder();
        String line;

        try {
            while ((line = r.readLine()) != null) {
                total.append(line).append('n');
            }
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        return total.toString();
    }

    private static String requisicao(String stringUrl) throws MalformedURLException { //passa a url que escolhi, se conecta a url e ler os bytes que a url transfere
        URL url = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(stringUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            return readStream(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return "";
    }

    public static ArrayList<EnderecoApi> retornarLocalizacaoPorBairro(String bairro) throws JSONException, IOException{
        String resposta = requisicao("http://dados.recife.pe.gov.br/api/3/action/datastore_search?resource_id=4f318be2-007e-4884-98fc-ef2cea34d6ee&q={\"bairro\":\"" + bairro + "\"}");
        JSONObject obj = new JSONObject(resposta);
        JSONArray listaDeEnderecosJSON = obj.getJSONObject("result").getJSONArray("records");
        ArrayList<EnderecoApi> enderecosArray = new ArrayList<>();

        for (int i = 0; i < listaDeEnderecosJSON.length(); i++) {
            JSONObject enderecoObj = listaDeEnderecosJSON.getJSONObject(i);
            int id = (int) enderecoObj.get("_id"); //alterar o get para o que tem no json
            String equipamentoPublicoDisponivel = enderecoObj.get("equipamento_publico_disponivel").toString();
            String municipalEstadual = enderecoObj.get("municipal_estadual").toString();
            String endereco = enderecoObj.get("endereco").toString();
            Double latitude = (Double) enderecoObj.get("latitude");
            Double longitude = (Double) enderecoObj.get("longitude");
            EnderecoApi novoEndereco = new EnderecoApi(id, bairro, equipamentoPublicoDisponivel, municipalEstadual, endereco, latitude, longitude);
            enderecosArray.add(novoEndereco);
        }

        return enderecosArray;
    }
}