package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ClienteServiceTest {
    @Test
    public void testClienteSuccess() {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setFechaNacimiento("1978-03-25");
        clienteDto.setDni(29857643);
        clienteDto.setTipoPersona("PERSONA_FISICA");
        Cliente cliente = clienteService.darDeAltaCliente(clienteDto);

        verify(clienteDao, times(1)).save(cliente);
    }
}
