package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.utn.frbb.tup.persistence.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteService {

    //ALGO PASA QUE TODOS POR ALGUN MOTIVO ME PONEN EL 'throws'
    @Autowired //no se si esto esta bien -- CAMBIADO
    ClienteDao clienteDao;

    public Cliente darDeAltaCliente(ClienteDto clienteDto) throws IllegalAccessException, ClienteAlreadyExistsException { //MANEJAR EL IllAccExp
        Cliente cliente = new Cliente(clienteDto);
        validatorAlta(cliente); //FIJARME SI TENGO QUE PONER UN IF, tipo, si lo guarda igual o no
        clienteDao.save(cliente);
        return cliente;
    }

    public void agregarCuenta(CuentaBancaria cuentaBancaria, int dni) throws IllegalAccessException, TipoCuentaAlreadyExistsException {
        Cliente titular = buscarClientePorDni(dni);
        cuentaBancaria.setTitular(titular); //REDUNDANTE, YA TIENE LA CUENTA UN TITULAR (?
        validatorAgregarCuenta(titular, cuentaBancaria); // de vuelta, no se si hay que poner un if y devolver un bool

        titular.addCuenta(cuentaBancaria);
        clienteDao.save(titular);
    }

    public Cliente buscarClientePorDni(int dni) throws IllegalAccessException{ //! LA EXCEPCION
        Cliente cliente = clienteDao.find(dni, true);
        if(cliente == null){
            throw  new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }


    private void validatorAlta(Cliente cliente) throws IllegalAccessException, ClienteAlreadyExistsException {
        if(clienteDao.find(cliente.getDni(), false) != null){
            throw  new ClienteAlreadyExistsException("Ya existe el cliente"+cliente.getDni());
        }

        if(cliente.getEdad() < 18){ //queda medio medio igual xq creo que con lo de las url's se pierde
            throw new IllegalAccessException("El cliente debe ser mayor de edad(18) para poder tener una cuenta bancaria");
        }
    }
    private  void validatorAgregarCuenta(Cliente titular, CuentaBancaria cuentaTitular) throws TipoCuentaAlreadyExistsException {
        if(titular.tieneCuenta(cuentaTitular.getTipoCuenta(), cuentaTitular.getMoneda())){
            throw new TipoCuentaAlreadyExistsException("El cliente ya posee una cuenta de ese tipo y moneda");
        }
    }

}
