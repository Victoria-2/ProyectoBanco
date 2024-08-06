package ar.utn.frbb.tup.controller;

import ar.utn.frbb.tup.controller.validator.PrestamoValidator;
import ar.utn.frbb.tup.model.exception.PrestamoNoOtorgadoException;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import ar.utn.frbb.tup.service.PrestamoService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrestamoControllerTest {

    @Mock
    private PrestamoService prestamoService;

    public PrestamoDto prestamoDto = new PrestamoDto();

    @BeforeEach
    public void prestamoDtoSetting(){

        prestamoDto.setNumeroCliente(45423402L);
        prestamoDto.setPlazoMeses(36);
        prestamoDto.setMontoPrestamo(4568.31);
        prestamoDto.setMoneda("ARS");
    }

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void solicitarPrestamoSuccess() throws PrestamoNoOtorgadoException {
        PrestamoOutputDto prestamoOutputDtoMock = mock(PrestamoOutputDto.class);
        Mockito.when(prestamoService.pedirPrestamo(prestamoDto)).thenReturn(prestamoOutputDtoMock);

        prestamoService.pedirPrestamo(prestamoDto);

        assertEquals(prestamoService.pedirPrestamo(prestamoDto), prestamoOutputDtoMock);
        assertDoesNotThrow( () -> prestamoService.pedirPrestamo(prestamoDto) );
        assertDoesNotThrow( () -> PrestamoValidator.validate(prestamoDto) );
    }

    @Test
    void retonarPrestamosCliente() {
        long clienteDni = 45423402L;
        PrestamoConsultaDto prestamoConsultaDtoMock = mock(PrestamoConsultaDto.class);
        Mockito.when(prestamoService.pedirConsultaPrestamos(clienteDni)).thenReturn(prestamoConsultaDtoMock);

        prestamoService.pedirConsultaPrestamos(clienteDni);

        assertDoesNotThrow( () -> prestamoService.pedirConsultaPrestamos(clienteDni));
        assertEquals(prestamoService.pedirConsultaPrestamos(clienteDni), prestamoConsultaDtoMock);

    }
}