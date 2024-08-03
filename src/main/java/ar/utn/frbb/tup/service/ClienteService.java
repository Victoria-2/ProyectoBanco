package ar.utn.frbb.tup.service;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.exception.ClienteAlreadyExistsException;
import ar.utn.frbb.tup.model.exception.TipoCuentaAlreadyExistsException;
import ar.utn.frbb.tup.persistence.ClienteDao;
import ar.utn.frbb.tup.persistence.CuentaBancariaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteDao clienteDao;

    @Autowired
    CuentaBancariaDao cuentaBancariaDao;

    public Cliente darDeAltaCliente(ClienteDto clienteDto) throws  ClienteAlreadyExistsException {
        Cliente cliente = new Cliente(clienteDto);
        validatorAlta(cliente);
        clienteDao.save(cliente);
        return cliente;
    }

    public void agregarCuenta(CuentaBancaria cuentaBancaria, int dni) throws TipoCuentaAlreadyExistsException {
        Cliente titular = buscarClientePorDni(dni);
        cuentaBancaria.setTitular(titular.getDni());
        validatorAgregarCuenta(titular, cuentaBancaria);

        titular.addCuenta(cuentaBancaria);
        cuentaBancariaDao.save(cuentaBancaria);
        //clienteDao.save(titular);
    }

    public Cliente buscarClientePorDni(int dni) {
        Cliente cliente = clienteDao.find(dni, true);
        if(cliente == null){
            throw  new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }
    public Cliente buscarSoloClientePorDni(int dni) {
        Cliente cliente = clienteDao.find(dni, false);
        if(cliente == null){
            throw  new IllegalArgumentException("El cliente solicitado no existe");
        }
        return cliente;
    }

    public List<CuentaBancaria> getCuentasCliente(Integer dni){
        return cuentaBancariaDao.getCuentasByCliente(dni);
    }

    private void validatorAlta(Cliente cliente) throws ClienteAlreadyExistsException {
        if(clienteDao.find(cliente.getDni(), false) != null){
            throw new ClienteAlreadyExistsException("Ya existe el cliente"+cliente.getDni());
        }

        if(cliente.getEdad() < 18){
            throw new IllegalArgumentException("El cliente debe ser mayor de edad(18) para poder tener una cuenta bancaria");
        }
    }
    private  void validatorAgregarCuenta(Cliente titular, CuentaBancaria cuentaTitular) throws TipoCuentaAlreadyExistsException {
        if(titular.tieneCuenta(cuentaTitular.getTipoCuenta(), cuentaTitular.getMoneda())){
            throw new TipoCuentaAlreadyExistsException("El cliente ya posee una cuenta de ese tipo y moneda");
        }
    }

}
