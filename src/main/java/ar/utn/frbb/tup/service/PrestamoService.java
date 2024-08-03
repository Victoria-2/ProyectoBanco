package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoDto;
import ar.utn.frbb.tup.model.Prestamo;
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

    public Prestamo pedirPrestamo(PrestamoDto prestamoDto) throws PrestamoNoOtorgadoException {
        Prestamo prestamo = new Prestamo(prestamoDto);
        validator(prestamo);

        prestamo.setEstado(calcularScoring(prestamo.getNumeroCliente()));
        establecerMensajeScoring(prestamo);



        //actualizarCuentaCliente(cbu, prestamo.getMonto);
        prestamoDao.almacenarDatosPrestamo(prestamo);

        toOutput(prestamo);
        return prestamo;

    }

    //HACER LAS VALIDACIONES TMBN, tal vez seria mejor separarlo o no se (? (en realidad lso cheuqeos pueden estar todos en el mismo)
    private double calculaIntereses(double monto, int valorInteres){

        return 0.0;
    }

    private double calcularMontoCuota(double monto, int plazoMeses){
        return monto / plazoMeses;
    }

    private String calcularScoring(Long dni){
        String scoring = ScoreCrediticioService.verificaScore(dni);
        if (scoring.equals("ERROR")){
            return "RECHAZADO";
        }
        return "APROBADO";
    }
    private void establecerMensajeScoring(Prestamo prestamo){
        if (prestamo.getEstado().equals("RECHAZADO")){
            prestamo.setMensaje("No posee el scoring suficiente para pedir un prestamo de este tipo");
        }
        if(prestamo.getEstado().equals("APROBADO")){
            prestamo.setMensaje("El monto del prestamo fue acreditado a su cuenta");
        }
    }

    public void validator(Prestamo prestamo) throws PrestamoNoOtorgadoException {
        clienteService.buscarSoloClientePorDni((int) prestamo.getNumeroCliente()); //A TESTEAR, igual q el otro pero esta en false

        if (prestamo.getMontoPrestamo() >= 6000000){
            throw new PrestamoNoOtorgadoException("El monto a solicitar es mayor al que se le puede ofrecer en este momento");
        }
        //validar q el tipo de moneda exista tmbn
        //VERIFICAR SI EL CLIENTE TIENE UNA CUENTA CON LA MONEDA QUE SE ESTA PIDIENDO
    } //FALTAN VARIAS

    public void toOutput(Prestamo prestamo){
        prestamo.setNumeroCliente(null);
        prestamo.setPlazoMeses(null);
        prestamo.setMontoPrestamo(null);
        prestamo.setMoneda(null);
        prestamo.setInteresMensual(null);
    }


}
