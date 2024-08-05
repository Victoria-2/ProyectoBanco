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
        cuentaService.actualizarCuentaCliente(prestamo);
        prestamoDao.almacenarDatosPrestamo(prestamo);

        return output(prestamo);
        //return prestamo.toOutput();
    }

    private double calculaIntereses(double monto, int valorInteres){
        return monto * ((double) valorInteres /12);
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
    private PrestamoOutputDto output(Prestamo prestamo){
        return new PrestamoOutputDto(prestamo);
    }

    private CuentaBancaria getCuentaPermitida(int dni, String moneda){
        List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        cuentas.addAll(clienteService.getCuentasCliente(dni));

        for (CuentaBancaria c : cuentas){
            if (c.getTipoCuenta().equals(TipoDeCuenta.CAJA_DE_AHORROS) && c.getMoneda().equals(TipoMoneda.fromString(moneda))){
                return c;
            }
        }
        return null;
    }
    public void validator(Prestamo prestamo) throws PrestamoNoOtorgadoException {
        if ((getCuentaPermitida((int) prestamo.getNumeroCliente(), prestamo.getMoneda())) == null){
            throw new PrestamoNoOtorgadoException("No posee una cuenta que sea Caja de Ahorros, o una Caja de Ahorros en esa moneda");
        }

        if (prestamo.getMontoPrestamo() >= 6000000){
            throw new PrestamoNoOtorgadoException("El monto a solicitar es mayor al que se le puede ofrecer en este momento");
        }

        if( (getPrestamosCliente((int)prestamo.getNumeroCliente())).size() > 3 ){
            throw new PrestamoNoOtorgadoException("Es deudor de 3 prestamos. Finalice el pago de los mencionados antes de solicitar otro prestamo");
        }

    }

    //--------------------
    public PrestamoConsultaDto pedirConsultaPrestamos(long dni) {
        PrestamoConsultaDto consulta = new PrestamoConsultaDto(dni);

        List<Prestamo> prestamosCliente = getPrestamosCliente((int) dni);
        if(prestamosCliente.isEmpty() || prestamosCliente.get(0) == null){
            throw new IllegalArgumentException("El cliente "+dni+" no ha pedido prestamos");
        }

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
            cantCuotas = cantCuotas + 1;
        }
        return cantCuotas;
    }
    private double calcularSaldoRestante(Prestamo prestamo, int pagosRealizados) {
        double saldoTotal = prestamo.getMontoPrestamo() + prestamo.getInteresTotal();
        double saldoActual = 0;
        if (pagosRealizados != 0) {
            saldoActual = (prestamo.getPlanPagos().get(0).getMonto()) * pagosRealizados;
        }

        return saldoTotal - saldoActual;

    }

}
