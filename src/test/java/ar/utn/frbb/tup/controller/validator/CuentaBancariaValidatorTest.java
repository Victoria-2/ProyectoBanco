package ar.utn.frbb.tup.controller.validator;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.controller.CuentaBancariaDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CuentaBancariaValidatorTest {

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateSuccessArs(){
        CuentaBancariaDto cuentaBancariaDto = new CuentaBancariaDto();
        cuentaBancariaDto.setTipoCuenta("CA");
        cuentaBancariaDto.setMoneda("ARS");
        assertDoesNotThrow(() -> CuentaBancariaValidator.validate(cuentaBancariaDto));
    }

    @Test
    void validateTipoMonedaException(){
        CuentaBancariaDto cuentaBancariaDto = new CuentaBancariaDto();
        cuentaBancariaDto.setMoneda("JYP");
        assertThrows(IllegalArgumentException.class, () -> CuentaBancariaValidator.validate(cuentaBancariaDto));
    }

    @Test
    void validateTipoCuentaException(){
        CuentaBancariaDto cuentaBancariaDto = new CuentaBancariaDto();
        cuentaBancariaDto.setTipoCuenta("CO"); //?
        assertThrows(IllegalArgumentException.class, () -> CuentaBancariaValidator.validate(cuentaBancariaDto));
    }
}
