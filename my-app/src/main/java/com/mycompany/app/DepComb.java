package com.mycompany.app;

public class DepComb {
    public enum SITUACAO { NORMAL, SOBRAVISO, EMERGENCIA }
    public enum TIPOPOSTO { COMUM, ESTRATEGICO }

    public static final int MAX_ADITIVO = 500;
    public static final int MAX_ALCOOL = 2500;
    public static final int MAX_GASOLINA = 10000;

    private int tAditivo;
	private int tGasolina;
	private int tAlcool1;
	private int tAlcool2;

    private SITUACAO sit;

    public DepComb(int tAditivo, int tGasolina, int tAlcool1, int tAlcool2) { 
        this.tAditivo = tAditivo;
        this.tGasolina = tGasolina;
        this.tAlcool1 = tAlcool1;
        this.tAlcool2 = tAlcool2;     
        defineSituacao(); 
     }

    public void defineSituacao(){
        double percentAditivo = tAditivo/MAX_ADITIVO*1.0;
        double percentGasolina = tGasolina/MAX_GASOLINA*1.0;
        double percentAlcool = (tAlcool1+tAlcool2)/MAX_ALCOOL*1.0;

        if ((percentAditivo >= 0.5) && (percentGasolina >= 0.5) && (percentAlcool >= 0.5)){
            sit = SITUACAO.NORMAL;
        } else{
            if((percentAditivo <= 0.25) || (percentGasolina <= 0.25) || (percentAlcool <= 0.25)){
                sit = SITUACAO.EMERGENCIA;
            } else {
                sit = SITUACAO.SOBRAVISO;
            }
        }
     }

    public SITUACAO getSituacao(){
        return sit;
    }

    public int gettGasolina(){
        return tGasolina;
    }

    public int gettAditivo(){
        return tAditivo;
    }

    public int gettAlcool1(){
        return tAlcool1;
    }

    public int gettAlcool2(){
        return tAlcool2;
    }
    /**
     * @param qtdade
     * @return -1 caso valor invalido
     */
    public int recebeAditivo(int qtdade) {
        if (qtdade <= 0){
            return -1;
        }
        int qntToFill = MAX_ADITIVO-gettAditivo();
        int qtdadeAux = qtdade;
        qntToFill -= qtdade;
        if (qntToFill >= 0) {
            return qtdade;
        }
        qtdade = qtdadeAux + qntToFill;
        return qtdade;
    }

    public int recebeGasolina(int qtdade) {
        if(qtdade<1){
            return -1;
        }
        int qntToFill = MAX_GASOLINA-gettGasolina();
        int qtdadeAux = qtdade;
        qntToFill -= qtdade;
        if (qntToFill >= 0) {
            return qtdade;
        }
        qtdade = qtdadeAux + qntToFill;
        return qtdade;
    }

    public int recebeAlcool(int qtdade) {
        if(qtdade<1){
            return -1;
        }
        int qntToFill = MAX_ALCOOL - (gettAlcool1()+gettAlcool2());
        int qtdadeAux = qtdade;
        qntToFill -= qtdade;
        if (qntToFill >= 0) {
            return qtdade;
        }
        qtdade = qtdadeAux + qntToFill;
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
        
        //DepComb x = new DepComb(aditivo, gasolina, alcool1, alcool2);
        


        return null;
    }


}