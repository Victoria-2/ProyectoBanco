package ar.utn.frbb.tup.controller.validator;

import ar.utn.frbb.tup.controller.PrestamoDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PrestamoValidatorTest {

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateSuccess() {
        PrestamoDto prestamoDto = new PrestamoDto();
        prestamoDto.setMontoPrestamo(1520.30);
        PrestamoValidator.validate(prestamoDto);
        assertDoesNotThrow( () -> PrestamoValidator.validate(prestamoDto) );
    }

    @Test
    void validateZeroException() {
        PrestamoDto prestamoDto = new PrestamoDto();
        prestamoDto.setMontoPrestamo(0);
        assertThrows(IllegalArgumentException.class, () -> PrestamoValidator.validate(prestamoDto));
    }

    @Test
    void validateNegativeException() {
        PrestamoDto prestamoDto = new PrestamoDto();
        prestamoDto.setMontoPrestamo(-1520.30);
        assertThrows(IllegalArgumentException.class, () -> PrestamoValidator.validate(prestamoDto));
    }

}