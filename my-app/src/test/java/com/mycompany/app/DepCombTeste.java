package com.mycompany.app;

import java.util.Collection;
import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class DepCombTeste {
    private DepComb tanques;

    @BeforeAll
    public void setup() {
        
    }
    // ----------------------  Teste Construtor DepComb ----------------------


    @Test
    public void construtorTest() {
        int[] quantTanque={
            250,
            5000,
            625,
            625
        };
        new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtorExceptionNegativoTest() {
        int[] quantTanque={
            -1,
            -2,
            -3,
            -4
        };
        new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        
    }

    @Test(expected = IllegalArgumentException.class)
    public void construtorExceptionOverflowTest() {
        int[] quantTanque={
            501,
            10001,
            1251,
            1251
        };
        new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        
    }

    
       
    
    // ----------------------  Tests recebe ----------------------
    @ParameterizedTest
    @CsvSource({
        "0,0,0,0,500,500,10000,10000,2500,2500",
        "250,5000,625,625,250,500,5000,6000,1250,2000",
        "500,10000,1250,1250,0,1,0,1,0,1",
        "500,10000,1250,1250,-1,-50,-1,-50,-1,-50",
    })
    public void testeRecebe(
        int quantTAditivo,int  quantTGasolina,int  quantTAlcool1,int  quantTAlcool2,
        int respAditivo, int enviaAditivo,
        int respGasolina, int enviaGasolina,
        int respAlcool, int enviaAlcool
        ){
            tanques = new DepComb(quantTAditivo, quantTGasolina, quantTAlcool1, quantTAlcool2);
            Assertions.assertEquals(respAditivo, tanques.recebeAditivo(enviaAditivo));
            Assertions.assertEquals(respGasolina, tanques.recebeGasolina(enviaGasolina));
            Assertions.assertEquals(respAlcool, tanques.recebeAlcool(enviaAlcool));
        
    }
     
    // ----------------------  Tests encomendaCombustivel ----------------------
    
    @ParameterizedTest
    @CsvSource({
        //Quant. I. Tanques         Quant. F. Comum         Quant. F. Estrategica   Pedido
        // ----------------------  >=50%  ----------------------
        "500,10000,1250,1250,       475,9650,1125,1250,     475,9650,1125,1250,     500",
        "500,10000,1250,1250,       -3,0,0,0,               0,7000,0,0,             10500",
        
        // ----------------------  <50%  ----------------------
        "499,4999,1250,1250,        237,4987,1238,1250,     224,4974,1225,1250,     500",
        "125,2500,313,313,          113,2488,300,313,       100,2475,288,313,       500",

        // ----------------------  <25%  ----------------------
        "124,2500,313,313,          -2,0,0,0,               99,2475,288,313,        500",
        "20,90,100,30,              -1,0,0,0,               -1,0,0,0,               -50",


    })
    public void testeEncomenda(
        int quantTAditivo,int  quantTGasolina,int  quantTAlcool1,int  quantTAlcool2,
        int quantTAditivoResultComum,int  quantTGasolinaResultComum,int  quantTAlcool1ResultComum,int  quantTAlcool2ResultComum,
        int quantTAditivoResultEstrategico,int  quantTGasolinaResultEstrategico,int  quantTAlcool1ResultEstrategico,int  quantTAlcool2ResultEstrategico,
        int pedido
        ){
            tanques = new DepComb(quantTAditivo, quantTGasolina, quantTAlcool1, quantTAlcool2);
            int[] resultComum = {quantTAditivoResultComum, quantTGasolinaResultComum, quantTAlcool1ResultComum, quantTAlcool2ResultComum}; 
            Assertions.assertEquals(resultComum, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));
            
            tanques = new DepComb(quantTAditivo, quantTGasolina, quantTAlcool1, quantTAlcool2);
            int[] resultEstrategico = {quantTAditivoResultEstrategico, quantTGasolinaResultEstrategico, quantTAlcool1ResultEstrategico, quantTAlcool2ResultEstrategico};
            Assertions.assertEquals(resultEstrategico, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        
    }

}
