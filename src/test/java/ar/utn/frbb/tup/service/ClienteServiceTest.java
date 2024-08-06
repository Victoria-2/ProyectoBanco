package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.utn.frbb.tup.persistence.ClienteDao;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.TipoPersona;
import ar.utn.frbb.tup.model.TipoMoneda;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClienteServiceTest {
    @Mock
    private ClienteDao clienteDao;

    @InjectMocks
    private ClienteService clienteService;

    @InjectMocks
    private CuentaBancariaDao cuentaBancariaDao;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testClienteSuccess0() throws ClienteAlreadyExistsException {
        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNombre("pepe");
        clienteDto.setApellido("rino");
        clienteDto.setNacimiento("1978-03-25");
        clienteDto.setDni(29857643);
        clienteDto.setTipoPersona("F");
        Cliente cliente = clienteService.darDeAltaCliente(clienteDto);

        verify(clienteDao, times(1)).save(cliente);
        System.out.println(clienteDto.getTipoPersona());
        System.out.println(TipoPersona.fromString(clienteDto.getTipoPersona()));
    }

    @Test
    public void testClienteMenor18Anios() {
        ClienteDto clienteMenorDeEdad = new ClienteDto();
        //when(clienteDao.find(any(Long.class)))
        clienteMenorDeEdad.setNacimiento(String.valueOf(LocalDate.of(2020, 2, 7)));
        assertThrows(IllegalArgumentException.class, () -> clienteService.darDeAltaCliente(clienteMenorDeEdad));
    }

    @Test
    public void testClienteSuccess() throws ClienteAlreadyExistsException {
        ClienteDto cliente = new ClienteDto();
        cliente.setNacimiento(String.valueOf(LocalDate.of(1978,3,25)));
        cliente.setDni(29857643);
        cliente.setTipoPersona("F");
        clienteService.darDeAltaCliente(cliente);

        Cliente clienteSave = new Cliente(cliente);
        clienteDao.save(clienteSave);

        verify(clienteDao, times(1)).save(clienteSave);
    }

    @Test
    public void testClienteAlreadyExistsException() throws ClienteAlreadyExistsException {
        ClienteDto pepeRino = new ClienteDto();
        pepeRino.setDni(26456437);
        pepeRino.setNombre("Pepe");
        pepeRino.setApellido("Rino");
        pepeRino.setNacimiento(String.valueOf(LocalDate.of(1978, 3,25)));
        pepeRino.setTipoPersona("F");

        when(clienteDao.find(26456437, false)).thenReturn(new Cliente());

        assertThrows(ClienteAlreadyExistsException.class, () -> clienteService.darDeAltaCliente(pepeRino));
    }



    //Completar este test unitario
    /*@Test
    public void testAgregarCuentaAClienteSuccess() throws TipoCuentaAlreadyExistsException {
        Cliente pepeRino = new Cliente();
        pepeRino.setDni(26456439);
        pepeRino.setNombre("Pepe");
        pepeRino.setApellido("Rino");
        pepeRino.setNacimiento(LocalDate.of(1978, 3,25));
        pepeRino.setTipoPersona(TipoPersona.PERSONA_FISICA);

        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta.setSaldo(500000);
        cuenta.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);

        when(clienteDao.find(26456439, true)).thenReturn(pepeRino);

        clienteService.agregarCuenta(cuenta, pepeRino.getDni());

        assertEquals(1, pepeRino.getCuentasBancariasCliente().size());
        assertEquals(pepeRino.getDni(), cuenta.getTitular());
    }

    // ---------------------

    //Agregar una CA$ y agregar otra cuenta con mismo tipo y moneda --> fallar (assertThrows)
    @Test
    public void testAgregaCuentaAClienteFail() throws TipoCuentaAlreadyExistsException{
        Cliente luciano = new Cliente();
        luciano.setDni(12345678);
        luciano.setNombre("Lucho");
        luciano.setApellido("Rino");
        luciano.setNacimiento(LocalDate.of(2002, 5,3));
        luciano.setTipoPersona(TipoPersona.PERSONA_FISICA);

        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta.setSaldo(500000);
        cuenta.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);



        when(clienteDao.find(12345678, true)).thenReturn(luciano);

        clienteService.agregarCuenta(cuenta, luciano.getDni());

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta2.setSaldo(500000);
        cuenta2.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);

        when(clienteDao.find(12345678, true)).thenReturn(luciano);

        assertThrows(TipoCuentaAlreadyExistsException.class, () -> clienteService.agregarCuenta(cuenta2, luciano.getDni()));

        assertEquals(1, luciano.getCuentasBancariasCliente().size());
        assertEquals(luciano.getDni(), cuenta.getTitular());



    }


    //Agregar una CA$ y CC$ --> success 2 cuentas, titular peperino
    //Agregar una CA$ y CAU$S --> success 2 cuentas, titular peperino...
    //Testear clienteService.buscarPorDni

    // ----------------------


    //Agregar una CA$ y CC$ --> success 2 cuentas, titular peperino --- *1. Agregar una CA$ y CC$ → se puede agregar y se debe
    //verificar que el cliente tenga 2 cuentas, titular sea el cliente que se creó

    @Test
    public void testAgregarDosCuentasSucess() throws TipoCuentaAlreadyExistsException{
        Cliente luciano = new Cliente();
        luciano.setDni(12345678);
        luciano.setNombre("Pepe");
        luciano.setApellido("Rino");
        luciano.setNacimiento(LocalDate.of(2002, 5,3));
        luciano.setTipoPersona(TipoPersona.PERSONA_FISICA);

        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta.setSaldo(500000);
        cuenta.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);

        when(clienteDao.find(12345678, true)).thenReturn(luciano);
        clienteService.agregarCuenta(cuenta, luciano.getDni());

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta.setSaldo(2500000);
        cuenta.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);

        when(clienteDao.find(12345678, true)).thenReturn(luciano);
        clienteService.agregarCuenta(cuenta2, luciano.getDni());

        assertEquals(2, luciano.getCuentasBancariasCliente().size());

        // chequea el tipo de cuenta
        assertEquals(TipoDeCuenta.CAJA_DE_AHORROS, cuenta.getTipoCuenta());
        assertEquals(TipoDeCuenta.CUENTA_CORRIENTE, cuenta2.getTipoCuenta());

        assertEquals(luciano.getDni(), cuenta.getTitular());
        assertEquals(luciano.getDni(), cuenta2.getTitular());

    }



    //Agregar una CA$ y CAU$S --> success 2 cuentas, titular peperino... ||| 2. Agregar una CA$ y CAU$S → se puede agregar y se debe
    //verificar que el cliente tenga 2 cuentas, titular sea el cliente que se creó
    @Test
    public void agregarDosCajasDeAhorroDifMonedaSucess() throws TipoCuentaAlreadyExistsException{
        Cliente luciano = new Cliente();
        luciano.setDni(12345678);
        luciano.setNombre("Pepe");
        luciano.setApellido("Rino");
        luciano.setNacimiento(LocalDate.of(2002, 5,3));
        luciano.setTipoPersona(TipoPersona.PERSONA_FISICA);

        CuentaBancaria cuenta = new CuentaBancaria();
        cuenta.setMoneda(TipoMoneda.PESO_ARGENTINO);
        cuenta.setSaldo(500000);
        cuenta.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);


        when(clienteDao.find(12345678, true)).thenReturn(luciano);
        //clienteService.agregarCuenta(cuenta, luciano.getDni());

        CuentaBancaria cuenta2 = new CuentaBancaria();
        cuenta2.setMoneda(TipoMoneda.DOLAR);
        cuenta2.setSaldo(250);
        cuenta2.setTipoCuenta(TipoDeCuenta.CAJA_DE_AHORROS);

        when(clienteDao.find(12345678, true)).thenReturn(luciano);
        clienteService.agregarCuenta(cuenta2, luciano.getDni());

        // chequea el tipo de cuenta
        assertEquals(TipoDeCuenta.CAJA_DE_AHORROS, cuenta.getTipoCuenta());
        assertEquals(TipoDeCuenta.CAJA_DE_AHORROS, cuenta2.getTipoCuenta());

        // chequea las monedas de las cuentas
        assertEquals(TipoMoneda.PESO_ARGENTINO, cuenta.getMoneda());
        assertEquals(TipoMoneda.DOLAR, cuenta2.getMoneda());

        //chequea los titulares de las cuentas
        assertEquals(luciano.getDni(), cuenta.getTitular());
        assertEquals(luciano.getDni(), cuenta2.getTitular());
    }*/


    //Testear clienteService.buscarPorDni ||| 3. Testear el método buscarPorDni (cómo mínimo son dos casos de test: casos de
    //éxito y de falla)

    @Test
    public void buscarClientePorDniSuccess(){
        Cliente luciano = new Cliente();
        luciano.setDni(12345678);
        luciano.setNombre("Pepe");
        luciano.setApellido("Rino");
        luciano.setNacimiento(LocalDate.of(2003, 5,31));
        luciano.setTipoPersona(TipoPersona.PERSONA_FISICA);

        //mock
        when(clienteDao.find(12345678, true)).thenReturn(luciano); //no me deja pasarlo con false

        clienteService.buscarClientePorDni(luciano.getDni());

        assertEquals("Pepe", luciano.getNombre());
        assertEquals(12345678, luciano.getDni());

    }

    @Test
    public void buscarClientePorDniFailure(){

        //mock
        when(clienteDao.find(12345678, true)).thenReturn(null);

        //ClienteService clienteService = new ClienteService(clienteDao);

        assertThrows(IllegalArgumentException.class, () -> clienteService.buscarClientePorDni(12345678));
    }
}
