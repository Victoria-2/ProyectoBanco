package ar.utn.frbb.tup.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.google.gson.Gson;

import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrestamoTest {
    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void toOutputTest(){
        Cuota cuotaMock = mock(Cuota.class);

        Prestamo prestamo = new Prestamo();
        prestamo.setNumeroCliente(123452L);
        prestamo.setPlazoMeses(3);
        prestamo.setMontoPrestamo(150.3);
        prestamo.setMoneda("ARS");
        prestamo.setEstado("APROBADO");
        prestamo.setMensaje("aprobado");
        prestamo.addCuota(cuotaMock);
        prestamo.setInteresTotal(3.5);

        System.out.println(prestamo);

        Gson gson = new Gson();
        String json = gson.toJson(prestamo.toOutput());
        System.out.println("JSON: " + json);

    }

}