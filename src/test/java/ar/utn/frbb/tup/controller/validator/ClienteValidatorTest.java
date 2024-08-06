package ar.utn.frbb.tup.controller.validator;

import ar.utn.frbb.tup.controller.ClienteDto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteValidatorTest {

    @InjectMocks
    private ClienteValidator clienteValidator;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void validateSuccess(){
        //ClienteDto clienteDtoMock = mock(ClienteDto.class);
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setTipoPersona("F");
        clienteDto.setNacimiento("1993-01-15");
        //verify(clienteValidator, times(1)).validateTipoMoneda(clienteDto); //no me deja hacerlo porque es estatico
        assertDoesNotThrow(() -> clienteValidator.validate(clienteDto));
    }

    @Test
    void validateTipoPersonaException(){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setTipoPersona("A");
        assertThrows(IllegalArgumentException.class, () -> clienteValidator.validate(clienteDto));
    }

    @Test
    void validateFechaNacimientoException(){
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNacimiento("1993-01-15");
        assertThrows(IllegalArgumentException.class, () -> clienteValidator.validate(clienteDto));

    }

}
