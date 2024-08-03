package ar.utn.frbb.tup.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ScoreCrediticioService {
    public static String verificaScore(long dni){
        Random random = new Random();

        if(sumarNumeros(dni) <= 5 || (!random.nextBoolean())){ //tiene un 50/50 de un true o false
            return "ERROR";
        }
        return "OK";
    }

    public static Long sumarNumeros(long num){
        if(num < 10){
            return num;
        }
        return (num%10 + sumarNumeros(num/10));
    }
}
