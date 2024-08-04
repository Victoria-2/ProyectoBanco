package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoConsultaDto;
import ar.utn.frbb.tup.controller.PrestamoOutputDto;
import ar.utn.frbb.tup.model.*;
import ar.utn.frbb.tup.controller.PrestamoDto;
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

    public PrestamoOutputDto pedirPrestamo(PrestamoDto prestamoDto) throws PrestamoNoOtorgadoException {
        Prestamo prestamo = new Prestamo(prestamoDto);
        validator(prestamo);

        prestamo.setEstado(calcularScoring(prestamo.getNumeroCliente()));
        establecerMensajeScoring(prestamo);
        if(prestamo.getEstado().equals("RECHAZADO")){
            return output(prestamo);
        }

        prestamo.setInteresTotal(calculaIntereses(prestamo.getMontoPrestamo(), 5));
        CuotaService.generarCuotas(prestamo);
        //cuentaService.actualizarCuentaCliente( (findCuentaPermitida((int)prestamo.getNumeroCliente(), prestamo.getMoneda())) , prestamo.getMontoPrestamo());
        prestamoDao.almacenarDatosPrestamo(prestamo);

        return output(prestamo);
        //return prestamo.toOutput();
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
    } //FALTA ENCONTRAR EL ERROR CON EL CBU

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
    private PrestamoOutputDto output(Prestamo prestamo){
        return new PrestamoOutputDto(prestamo);
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

    //--------------------
    public PrestamoConsultaDto pedirConsultaPrestamos(long dni){
        PrestamoConsultaDto consulta = new PrestamoConsultaDto(dni);

        List<Prestamo> prestamosCliente = getPrestamosCliente((int) dni);
        for (Prestamo p : prestamosCliente) {
            PrestamoConsultaDto.PrestamoConsultaCliente prestamoCliente = new PrestamoConsultaDto.PrestamoConsultaCliente(p);
            prestamoCliente.setPagosRealizados(calcularPagosRealizados(p.getPlanPagos()));
            prestamoCliente.setSaldoRestante(calcularSaldoRestante(p, prestamoCliente.getPagosRealizados()));
            consulta.addPrestamos(prestamoCliente);
        }

        return consulta; //por algun motivo nada mas retorna el ultimo (?? -- ES XQ NO SOLUCIONE LO DE ALMACENAR LA INFO CON EL CBU
    }

    private List<Prestamo> getPrestamosCliente(int dni){
        return prestamoDao.getPrestamosByCliente(dni);
    }

    private int calcularPagosRealizados(List<Cuota> cuotasPrestamo){
        int cantCuotas = 0;
        for (Cuota cuota : cuotasPrestamo) {
            cantCuotas =+ 1;
        }
        return cantCuotas;
    }
    private double calcularSaldoRestante(Prestamo prestamo, int pagosRealizados){
        double saldoTotal = prestamo.getMontoPrestamo() + prestamo.getInteresTotal();
        double saldoActual = ( prestamo.getPlanPagos().get(0).getMonto() ) * pagosRealizados;

        return saldoTotal - saldoActual;

    }

}
