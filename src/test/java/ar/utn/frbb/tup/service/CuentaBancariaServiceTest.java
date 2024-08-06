package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.CuentaBancariaDto;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.model.TipoMoneda;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CuentaBancariaServiceTest {
    @Mock
    private CuentaBancariaDao cuentaDao;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private CuentaBancariaService cuentaBancariaService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void actualizarCuentaClienteTest() throws InstantiationException, IllegalAccessException {
        Prestamo prestamo = new Prestamo();
        prestamo.setMoneda(TipoMoneda.PESO_ARGENTINO.getDescripcion());
        prestamo.setNumeroCliente(12345678L);
        prestamo.setMontoPrestamo(1000.0);

        CuentaBancaria cuentaMock = mock(CuentaBancaria.class);
        List<CuentaBancaria> cuentas = new ArrayList<CuentaBancaria>();
        cuentas.add(cuentaMock);

        when(clienteService.getCuentasCliente(anyInt())).thenReturn(cuentas);
        when(cuentaMock.getTipoCuenta()).thenReturn(TipoDeCuenta.CAJA_DE_AHORROS);
        when(cuentaMock.getMoneda()).thenReturn(TipoMoneda.PESO_ARGENTINO);
        when(cuentaMock.getSaldo()).thenReturn(122.30);

        cuentaBancariaService.actualizarCuentaCliente(prestamo);

        verify(cuentaMock).setSaldo(1122.30);
    }

    @Test
    void tipoCuentaEstaSoportadaSuccess(){
        CuentaBancariaDto cuenta1 = new CuentaBancariaDto();
        cuenta1.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS.getDescripcion());
        cuenta1.setMoneda("ARS");

        CuentaBancariaDto cuenta2 = new CuentaBancariaDto();
        cuenta2.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS.getDescripcion());
        cuenta2.setMoneda("USD");

        CuentaBancariaDto cuenta3 = new CuentaBancariaDto();
        cuenta3.setTipoCuenta(TipoDeCuenta.CUENTA_CORRIENTE.getDescripcion());
        cuenta3.setMoneda("ARS");

        assertDoesNotThrow( () -> cuentaBancariaService.tipoCuentaEstaSoportada(cuenta1) );
        assertTrue(cuentaBancariaService.tipoCuentaEstaSoportada(cuenta1));
        assertDoesNotThrow( () -> cuentaBancariaService.tipoCuentaEstaSoportada(cuenta1) );
        assertTrue(cuentaBancariaService.tipoCuentaEstaSoportada(cuenta2));
        assertDoesNotThrow( () -> cuentaBancariaService.tipoCuentaEstaSoportada(cuenta1) );
        assertTrue(cuentaBancariaService.tipoCuentaEstaSoportada(cuenta3));

    }
}
