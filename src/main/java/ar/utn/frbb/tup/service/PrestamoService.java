package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoDto;
import ar.utn.frbb.tup.controller.PrestamoOutput;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.model.TipoMoneda;
import ar.utn.frbb.tup.model.exception.PrestamoNoOtorgadoException;
import ar.utn.frbb.tup.persistence.PrestamoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrestamoService {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CuentaBancariaService cuentaService;

    @Autowired
    PrestamoDao prestamoDao;

    public PrestamoOutput pedirPrestamo(PrestamoDto prestamoDto) throws PrestamoNoOtorgadoException {
        Prestamo prestamo = new Prestamo(prestamoDto);
        validator(prestamo);

        prestamo.setEstado(calcularScoring(prestamo.getNumeroCliente()));
        establecerMensajeScoring(prestamo);
        prestamo.setInteresTotal(calculaIntereses(prestamo.getMontoPrestamo(), 5));
        CuotaService.generarCuotas(prestamo); //SI ES RECHAZADO NO DEBERIA DE GENERAR LAS CUOTAS !!!

        //cuentaService.actualizarCuentaCliente( (findCuentaPermitida((int)prestamo.getNumeroCliente(), prestamo.getMoneda())) , prestamo.getMontoPrestamo());
        prestamoDao.almacenarDatosPrestamo(prestamo);

        //return prestamo.toOutput();
        return prestamo.output();

    }

    private double calculaIntereses(double monto, int valorInteres){
        return monto * ((double) valorInteres /12);
    }

    private String findCuentaPermitida(int dni, String moneda){
        List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        cuentas.addAll(clienteService.getCuentasCliente(dni));

        String cbu = null;
        for (CuentaBancaria c : cuentas){
            if (c.getTipoCuenta().equals(TipoDeCuenta.CAJA_DE_AHORROS) && c.getMoneda().equals(TipoMoneda.fromString(moneda))){
                cbu = c.getCbu();
            }
        }
        return cbu;
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
        //me olvide poner el if x si lo encontraba o no

        if (prestamo.getMontoPrestamo() >= 6000000){
            throw new PrestamoNoOtorgadoException("El monto a solicitar es mayor al que se le puede ofrecer en este momento");
        }
        //validar q el tipo de moneda exista tmbn
        //VERIFICAR SI EL CLIENTE TIENE UNA CUENTA CON LA MONEDA QUE SE ESTA PIDIENDO
        // verificar q la cuenta sea CA
        //verificar q el cliente no tenga mas de 3 prestamos al mismo tiempo
    } //FALTAN VARIAS

}
