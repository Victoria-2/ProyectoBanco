package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoConsultaDto;
import ar.utn.frbb.tup.model.Cuota;
import ar.utn.frbb.tup.model.Prestamo;
import ar.utn.frbb.tup.model.PrestamoConsultaCliente;
import ar.utn.frbb.tup.persistence.PrestamoDao;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrestamoServiceTest {

    @Mock
    private PrestamoDao prestamoDao;

    @InjectMocks
    private PrestamoService prestamoService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void calculaInteresesTest(){
        double calculo = 1562.30 * ((double) 5 /12);
        double calculoMetodo = prestamoService.calculaIntereses(1562.30, 5);

        assertDoesNotThrow( () -> prestamoService.calculaIntereses(1562.30, 5));
        assertEquals(calculo, calculoMetodo);
    }


    @Test
    void pedirConsultaPrestamosSuccessTest(){
        Cuota cuota1 = new Cuota(1,1562.3);
        Cuota cuota2 = new Cuota(2,1562.3);
        List<Cuota> cuotasLista = new ArrayList<Cuota>(List.of(cuota1, cuota2));

        Prestamo prestamo = new Prestamo();
        prestamo.setMontoPrestamo(1569.30);
        prestamo.setInteresTotal(562.19);
        prestamo.setPlazoMeses(6);
        prestamo.setPlanPagos(cuotasLista);

        List<Prestamo> prestamosCliente = new ArrayList<Prestamo>();
        prestamosCliente.add(prestamo);

        when(prestamoDao.getPrestamosByCliente(anyInt())).thenReturn(prestamosCliente);

        assertNotNull(prestamoDao.getPrestamosByCliente(123456789));
        assertEquals(prestamoDao.getPrestamosByCliente(123456789).size(), prestamosCliente.size());
        assertDoesNotThrow(() -> prestamoService.pedirConsultaPrestamos(123456789));
        assertTrue( (prestamoService.pedirConsultaPrestamos(123456789) instanceof PrestamoConsultaDto));
    }

    @Test
    void pedirConsultaPrestamosFailureTest(){
        List<Prestamo> prestamosCliente = new ArrayList<Prestamo>();

        when(prestamoDao.getPrestamosByCliente(anyInt())).thenReturn(prestamosCliente);
        assertThrows(IllegalArgumentException.class, () -> { prestamoService.pedirConsultaPrestamos(123456789); });}
}