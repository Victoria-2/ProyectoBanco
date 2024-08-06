package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.PrestamoDto;
import ar.utn.frbb.tup.model.Prestamo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CuotaServiceTest {

    private Prestamo prestamo = new Prestamo();

    @BeforeEach
    public void prestamoCOngif(){
        prestamo.setInteresTotal(7856.0);
        prestamo.setMontoPrestamo(15369.03);
        prestamo.setPlazoMeses(12);
    }

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void generarCuotasTest(){
        CuotaService.generarCuotas(prestamo);

        assertDoesNotThrow( () -> CuotaService.generarCuotas(prestamo));
        //assertFalse(prestamo.getPlanPagos().isEmpty());
        if (prestamo.getPlanPagos().isEmpty()){
            System.out.println("No se han generado cuotas de forma random");
        }

    }

    @Test
    void generarRandomCantCoutasTest(){
        int random = CuotaService.generarRandomCantCuotas(prestamo.getPlazoMeses());

        assertDoesNotThrow( () -> CuotaService.generarRandomCantCuotas(prestamo.getPlazoMeses()) );
        //assertNotEquals(0, random);
        assertNotEquals(prestamo.getPlazoMeses(), random);
    }

    @Test
    void calcularMontoCuotaTest(){
        double calculoTesteo = (15369.03 + 7856.0) / 12;
        double resultadoCalculo = CuotaService.calcularMontoCuota(prestamo);
        assertDoesNotThrow( () -> CuotaService.calcularMontoCuota(prestamo) );
        assertEquals(calculoTesteo, resultadoCalculo);
    }

}