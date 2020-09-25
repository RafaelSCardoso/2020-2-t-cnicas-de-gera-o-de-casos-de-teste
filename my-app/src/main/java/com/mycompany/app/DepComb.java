package com.mycompany.app;

public class DepComb {
    public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
    public enum TIPOPOSTO { COMUM, ESTRATEGICO }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) {  }

    public void defineSituacao(){  }

    public SITUACAO getSituacao(){
        return null;
    }

    public int gettGasolina(){
        return 0;
    }

    public int gettAditivo(){
        return 0;
    }

    public int gettAlcool1(){
        return 0;
    }

    public int gettAlcool2(){
        return 0;
    }

    public int recebeAditivo(int qtdade) {
        return qtdade;
    }

    public int recebeGasolina(int qtdade) {
        return qtdade;
    }

    public int recebeAlcool(int qtdade) {
        return qtdade;
    }

    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        return null;
    }
}

