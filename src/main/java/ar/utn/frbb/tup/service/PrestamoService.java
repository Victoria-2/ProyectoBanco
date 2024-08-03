package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoDto;
import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.PrestamoOutput;
import ar.utn.frbb.tup.model.exception.PrestamoNoOtorgadoException;
import ar.utn.frbb.tup.persistence.PrestamoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrestamoService {
    @Autowired
    ClienteService clienteService;

    @Autowired
    PrestamoDao prestamoDao;

    public PrestamoOutput pedirPrestamo(PrestamoDto prestamoDto) throws PrestamoNoOtorgadoException {
        Prestamo prestamo = new Prestamo(prestamoDto);
        validator(prestamo);

        //actualizarCuentaCliente(cbu, prestamo.getMonto);

        return generarRespuestaPrestamo();
    }

    //HACER LAS VALIDACIONES TMBN, tal vez seria mejor separarlo o no se (? (en realidad lso cheuqeos pueden estar todos en el mismo)
    public double calculaIntereses(double monto, int valorInteres){

        return 0.0;
    }

    public double calcularMontoCuota(double monto, int plazoMeses){
        return monto / plazoMeses;
    }

    public void validator(Prestamo prestamo) throws PrestamoNoOtorgadoException {
        clienteService.buscarSoloClientePorDni((int) prestamo.getNumeroCliente()); //A TESTEAR, igual q el otro pero esta en false

        if (ScoreCrediticioService.verificaScore(prestamo.getNumeroCliente()).equals("ERROR")){
            throw new PrestamoNoOtorgadoException("No posee el scoring suficiente para pedir un prestamo de este tipo");
        }

        if (prestamo.getMontoPrestamo() >= 6000000){
            throw new PrestamoNoOtorgadoException("El monto a solicitar es mayor al que se le puede ofrecer en este momento");
        }

        //VERIFICAR SI EL CLIENTE TIENE UNA CUENTA CON LA MONEDA QUE SE ESTA PIDIENDO
    } //FALTA UNA

    public PrestamoOutput generarRespuestaPrestamo(){
        PrestamoOutput prestamoRespuesta = new PrestamoOutput();
        return prestamoRespuesta;
    } //falta

}
