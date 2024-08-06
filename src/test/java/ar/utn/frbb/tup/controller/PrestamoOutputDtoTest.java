package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.model.Cuota;
import ar.utn.frbb.tup.model.Prestamo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrestamoOutputDtoTest {

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void prestamoOutputDtoConstructorAprobado(){
        Cuota cuota1 = new Cuota(1,1562.3);
        Cuota cuota2 = new Cuota(2,1562.3);
        List<Cuota> cuotasLista = new ArrayList<Cuota>(List.of(cuota1, cuota2));

        Prestamo prestamo = new Prestamo();
        prestamo.setEstado("APROBADO");
        prestamo.setMensaje("El monto del préstamo fue acreditado en su cuenta");
        prestamo.setPlanPagos(cuotasLista);

        PrestamoOutputDto prestamoOutputDto = new PrestamoOutputDto(prestamo);
        assertEquals("APROBADO", prestamoOutputDto.getEstado());
        assertEquals("El monto del préstamo fue acreditado en su cuenta", prestamoOutputDto.getMensaje());
        assertEquals(cuotasLista, prestamoOutputDto.getPlanPagos());
    }

    @Test
    void prestamoOutputDtoConstructorRechazado(){
        Prestamo prestamo = new Prestamo();
        prestamo.setEstado("RECHAZADO");
        prestamo.setMensaje("No posee el scoring suficiente para pedir un prestamo de este tipo");

        PrestamoOutputDto prestamoOutputDto = new PrestamoOutputDto(prestamo);
        assertEquals("RECHAZADO", prestamoOutputDto.getEstado());
        assertEquals("No posee el scoring suficiente para pedir un prestamo de este tipo", prestamoOutputDto.getMensaje());
        assertTrue(prestamoOutputDto.getPlanPagos().isEmpty());
    }

}