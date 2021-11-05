package com.example.prontuariocovid;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Paciente {

    private String nome;
    private int idade;
    private double temperatura;
    private int tosse;
    private int dorCabeca;
    private int diasItalia;
    private int diasChina;
    private int diasIndonesia;
    private int diasPortugal;
    private int diasEua;
    private boolean italia;
    private boolean china;
    private boolean indonesia;
    private boolean portugal;
    private boolean eua;



    public Paciente (){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getTosse() {
        return tosse;
    }

    public void setTosse(int tosse) {
        this.tosse = tosse;
    }

    public int getDorCabeca() {
        return dorCabeca;
    }

    public void setDorCabeca(int dorCabeca) {
        this.dorCabeca = dorCabeca;
    }


    public int getDiasItalia() {
        return diasItalia;
    }

    public void setDiasItalia(int diasItalia) {
        this.diasItalia = diasItalia;
    }

    public int getDiasChina() {
        return diasChina;
    }

    public void setDiasChina(int diasChina) {
        this.diasChina = diasChina;
    }

    public int getDiasIndonesia() {
        return diasIndonesia;
    }

    public void setDiasIndonesia(int diasIndonesia) {
        this.diasIndonesia = diasIndonesia;
    }

    public int getDiasPortugal() {
        return diasPortugal;
    }

    public void setDiasPortugal(int diasPortugal) {
        this.diasPortugal = diasPortugal;
    }

    public int getDiasEua() {
        return diasEua;
    }

    public void setDiasEua(int diasEua) {
        this.diasEua = diasEua;
    }

    public boolean isItalia() {
        return italia;
    }

    public void setItalia(boolean italia) {
        this.italia = italia;
    }

    public boolean isChina() {
        return china;
    }

    public void setChina(boolean china) {
        this.china = china;
    }

    public boolean isIndonesia() {
        return indonesia;
    }

    public void setIndonesia(boolean indonesia) {
        this.indonesia = indonesia;
    }

    public boolean isPortugal() {
        return portugal;
    }

    public void setPortugal(boolean portugal) {
        this.portugal = portugal;
    }

    public boolean isEua() {
        return eua;
    }

    public void setEua(boolean eua) {
        this.eua = eua;
    }
}
