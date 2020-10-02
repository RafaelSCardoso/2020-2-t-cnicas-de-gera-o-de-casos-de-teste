package com.mycompany.app;

public class DepComb {
    public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
    public enum TIPOPOSTO { COMUM, ESTRATEGICO }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) { 
        
     }

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
    /**
     * 
     * @param qtdade
     * @return -1 caso valor invalido
     */
    public int recebeAditivo(int qtdade) {
        return qtdade;
    }

    public int recebeGasolina(int qtdade) {
        return qtdade;
    }

    public int recebeAlcool(int qtdade) {
        return qtdade;
    }
    /**
     * OBS: tanques de alcool sao 'compartilhados', ambos possuem o mesmo tipo de fluido.
     * @param qtdade
     * @param tipoPosto
     * @return retorna um array com o restante de combustivel seguinte sequencia:
     *      [
     *          Aditivo,
     *          Gasolina,
     *          Alcool1,
     *          Alcool2
     *      ]
     * 
     * Caso de erros:
     *  - Imput invalido -> @return [-1,0,0,0] 
     *  - não puder ser atendido em função da “situação” (tanque <25% && TIPOPOSTO.COMUM) -> @return [-2,0,0,0] 
     *  - sem combustivel suficiente -> @return [-3,0,0,0]  postos estrategicos podem entregar tudo oq podem
     */
    public int[] encomendaCombustivel(int qtdade, TIPOPOSTO tipoPosto) {
        return null;
    }


}