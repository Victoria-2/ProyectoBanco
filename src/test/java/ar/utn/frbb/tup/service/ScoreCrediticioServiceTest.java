package ar.utn.frbb.tup.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCrediticioServiceTest {

    @Test
    public void verificaScoreTest(){
        long dni = 123456789;
        System.out.println(ScoreCrediticioService.verificaScore(dni));
    }

    @Test
    public void sumarNumerosTest(){
        long num = 1000000001;
        System.out.println(ScoreCrediticioService.sumarNumeros(num));
    }

}