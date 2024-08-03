package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CuentaBancariaServiceTest {
    @Mock
    private CuentaBancariaDao cuentaDao;

    @InjectMocks
    private CuentaBancariaService cuentaBancariaService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void actualizarCuentaClienteTest() throws InstantiationException, IllegalAccessException {
        CuentaBancaria cuentaMock = mock(CuentaBancaria.class);
        when(cuentaDao.find(1234567890)).thenReturn(cuentaMock);
        when(cuentaMock.getSaldo()).thenReturn(122.30);
        cuentaBancariaService.actualizarCuentaCliente("1234567890",1000.0);

        verify(cuentaMock).setSaldo(1122.30);
        verify(cuentaDao).find(1234567890);
        assertSame(cuentaMock, cuentaDao.find(1234567890));
    }
}
