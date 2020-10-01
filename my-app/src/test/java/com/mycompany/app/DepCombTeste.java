package com.mycompany.app;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

public class DepCombTeste {
    private DepComb tanques;
    private enum TIPOPOSTO { COMUM, ESTRATEGICO }

    @BeforeAll
    public void setup() {
    }

    // ----------------------  >=50%  ----------------------
    
    @Test
    public void extraTanqueTest() {
        int[] quantTanque={
            501,
            10001,
            1251,
            1251
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        int [] result = {-1,0,0,0};
        // testa posto comum
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));

        // testa posto estrategico
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    @Test
    public void primeiroTest() {
        int[] quantTanque={
            500,
            10000,
            1250,
            1250
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        int [] result =
            {
                (int)(quantTanque[0]-(pedido*.05)),
                (int)(quantTanque[1]-(pedido*.7)),
                (int)(quantTanque[2]-(pedido*.25)),
            // quantTanque[2],
            // quantTanque[3]-(pedido*.25),
            quantTanque[3]

            };
        // testa posto comum
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));

        // testa posto estrategico
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    // implementar secondTest? Excel

    @Test
    // sobrecarga no pedido
    public void terceiroTest() {
        int[] quantTanque={
            500,
            10000,
            1250,
            1250
        };
        int pedido = 10500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        // testa posto comum
        int [] resultComum = {-3,0,0,0};
        Assertions.assertEquals(resultComum, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));
        
        int [] result =
            {
            0,
            (int)(quantTanque[1]-(pedido*.7)),
            0,
            0

            };
        // testa posto estrategico
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }



    // ----------------------  <50%  ----------------------

    @Test
    public void quartoTest() {
        int[] quantTanque={
            249,
            4999,
            1250,
            1250
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        int [] result =
            {
                (int)(quantTanque[0]-(pedido/2*.05)),
                (int)(quantTanque[1]-(pedido/2*.7)),
                (int)(quantTanque[2]-(pedido/2*.25)),
            // quantTanque[2],
            // quantTanque[3]-(pedido*.25),
            quantTanque[3]

            };
        // testa posto comum
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));

        // testa posto estrategico
        int [] result2 =
            {
                (int)(quantTanque[0]-(pedido*.05)),
                (int)(quantTanque[1]-(pedido*.7)),
                (int)(quantTanque[2]-(pedido*.25)),
            // quantTanque[2],
            // quantTanque[3]-(pedido*.25),
            quantTanque[3]
            };
            
        Assertions.assertEquals(result2, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    @Test
    public void quintoTest() {
        int[] quantTanque={
            125,
            2500,
            313,
            313
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        int [] result =
            {
                (int)(quantTanque[0]-(pedido*.05)),
                (int)(quantTanque[1]-(pedido*.7)),
                (int)(quantTanque[2]-(pedido*.25)),
            // quantTanque[2],
            // quantTanque[3]-(pedido*.25),
            quantTanque[3]

            };
        // testa posto comum
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));

        // testa posto estrategico
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    // ----------------------  <25%  ----------------------

    @Test
    public void sextoTest() {
        int[] quantTanque={
            124,
            2500,
            313,
            313
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        // testa posto comum
        int [] resultComum = {-2,0,0,0};
        Assertions.assertEquals(resultComum, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));
        
        // testa posto estrategico
        int [] result =
            {
                (int)(quantTanque[0]-(pedido*.05)),
                (int)(quantTanque[1]-(pedido*.7)),
                (int)(quantTanque[2]-(pedido*.25)),
            // quantTanque[2],
            // quantTanque[3]-(pedido*.25),
            quantTanque[3]

            };
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    @Test
    public void decimoTest() {
        int[] quantTanque={
            20,
            90,
            100,
            30
        };
        int pedido = 500;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        // testa posto comum
        int [] resultComum = {-2,0,0,0};
        Assertions.assertEquals(resultComum, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));
        
        // testa posto estrategico
        int [] result = {0,0,0,0};
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }

    @Test
    public void decimoPrimeiroTest() {
        int[] quantTanque={
            20,
            90,
            100,
            30
        };
        int pedido = -50;

        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
        int [] result = {-1,0,0,0};

        // testa posto comum
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.COMUM));
        
        // testa posto estrategico
        Assertions.assertEquals(result, tanques.encomendaCombustivel(pedido, DepComb.TIPOPOSTO.ESTRATEGICO));
        tanques = new DepComb(quantTanque[0], quantTanque[1], quantTanque[2], quantTanque[3]);
    }
}
