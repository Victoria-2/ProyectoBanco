package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.Cuota;

import java.util.Random;

public class CuotaService {

    public static void generarCuotas(Prestamo prestamo){
        double mensualidad = calcularMontoCuota(prestamo);;
        int random = generarRandomCantCuotas(prestamo.getPlazoMeses());

        for (int i = 1; i < random; i++) {
            Cuota cuota = new Cuota(i, mensualidad);
            prestamo.addCuota(cuota);
        }
    }

    private static int generarRandomCantCuotas(int cantCuotas){
        Random random = new Random(System.currentTimeMillis());
        int intRandom = random.nextInt(6);
        if(intRandom == 0){
            return generarRandomCantCuotas(cantCuotas);
        }
        if(cantCuotas < intRandom){ //xq no quiero q salga q esta pagado
            return generarRandomCantCuotas(cantCuotas);
        }
        return intRandom;
    }

    private static double calcularMontoCuota(Prestamo prestamo){ //TAL VEZ ES PARA CUOTA MAS Q SERVICE
        return ( prestamo.getMontoPrestamo() + prestamo.getInteresTotal() ) / prestamo.getPlazoMeses();
    }
}
