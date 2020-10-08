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

        int[] returnArray = new int[4];

        if (qtdade <= 0){
            returnArray[0] = -1;
            return returnArray;
        }
        if((getSituacao() == SITUACAO.EMERGENCIA) && (tipoPosto == TIPOPOSTO.COMUM)){
            returnArray[0] = -2;
            return returnArray;
        }

        double tmpGas = 0.7*qtdade;
        double tmpAlc1 = 0.125*qtdade;
        double tmpAlc2 = 0.125*qtdade;
        double tmpAdi = 0.05*qtdade;

        if ((getSituacao() == SITUACAO.SOBRAVISO) && (tipoPosto == TIPOPOSTO.COMUM)){
            tmpAdi *= 0.5;
            tmpGas *= 0.5;
            tmpAlc1 *= 0.5;
            tmpAlc2 *= 0.5;
        }

        if((tmpGas < gettGasolina()) && (tmpAlc1 < gettAlcool1()) && (tmpAlc2 < gettAlcool2())){
            returnArray[1] = (gettGasolina() - (int)tmpGas);
            returnArray[2] = (gettAlcool1() - (int)tmpAlc1);
            returnArray[3] = (gettAlcool2() - (int)tmpAlc2);

            // Se entendi corretamente, durante EMERGENCIA, se for um posto ESTRATEGICO, e nao tem aditivo o suficiente, entrega sem aditivo mesmo, tem que dar uma olhada melhor nesse if
            // Os outros casos devem estar corretos, eu espero

            if ((tmpAdi > gettAditivo()) && (getSituacao() == SITUACAO.EMERGENCIA) && (tipoPosto == TIPOPOSTO.ESTRATEGICO))
                returnArray[0] = gettAditivo();
            else
                returnArray[0] = gettAditivo()-(int)tmpAdi;

            return returnArray;
            
        } else {
            returnArray[0] = -3;
            return returnArray;
        }
    }


}