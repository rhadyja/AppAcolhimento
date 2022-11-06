package com.example.appacolhimento2.apiweb;

import java.io.Serializable;

public class EnderecoApi implements Serializable {

    private int id;
    private String equipamentoPublicoDisponivel;
    private String municipalEstadual;
    private String endereco;
    private String bairro;
    private Double latitude;
    private Double longitude;

    public EnderecoApi(int id, String bairro, String equipamentoPublicoDisponivel, String municipalEstadual, String endereco, Double latitude, Double longitude) {
        this.id = id;
        this.bairro = bairro;
        this.equipamentoPublicoDisponivel = equipamentoPublicoDisponivel;
        this.municipalEstadual = municipalEstadual;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipamentoPublicoDisponivel() {
        return equipamentoPublicoDisponivel;
    }

    public void setEquipamentoPublicoDisponivel(String equipamentoPublicoDisponivel) {
        this.equipamentoPublicoDisponivel = equipamentoPublicoDisponivel;
    }

    public String getMunicipalEstadual() {
        return municipalEstadual;
    }

    public void setMunicipalEstadual(String municipalEstadual) {
        this.municipalEstadual = municipalEstadual;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
