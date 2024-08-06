package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.Cuota;

import java.util.Random;

public class CuotaService {

    public static void generarCuotas(Prestamo prestamo){
        double mensualidad = calcularMontoCuota(prestamo);
        int random = generarRandomCantCuotas(prestamo.getPlazoMeses());

        for (int i = 1; i < random; i++) {
            Cuota cuota = new Cuota(i, mensualidad);
            prestamo.addCuota(cuota);
        }
    }

    static int generarRandomCantCuotas(int cantCuotas){
        int intRandom = 0;
        do{
            Random random = new Random(System.currentTimeMillis());
            intRandom = random.nextInt(6);
        } while (intRandom == 0 && intRandom > cantCuotas);
        return intRandom;
    }

    static double calcularMontoCuota(Prestamo prestamo){
        return ( prestamo.getMontoPrestamo() + prestamo.getInteresTotal() ) / prestamo.getPlazoMeses();
    }
}
