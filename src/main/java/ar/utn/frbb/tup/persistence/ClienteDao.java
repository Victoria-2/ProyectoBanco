package ar.utn.frbb.tup.persistence;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.persistence.entity.ClienteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteDao extends  AbstractBaseDao{

    @Autowired
    CuentaBancariaDao cuentaBancariaDao;

    public Cliente find(int dni, boolean loadComplete) {
        if(getInMemoryDatabase().get(dni) == null){
            return null;
        }

        Cliente cliente = (((ClienteEntity) getInMemoryDatabase().get(dni)).toCliente());
        if(loadComplete){
            for (CuentaBancaria cuenta : cuentaBancariaDao.getCuentasByCliente(dni)){
                cliente.addCuenta(cuenta);
            }
        }

        return cliente;
    }

    public void save(Cliente cliente){
        ClienteEntity clienteEntity = new ClienteEntity(cliente);
        getInMemoryDatabase().put(clienteEntity.getId(),clienteEntity);
    }

    @Override
    protected String getEntityType() {
        return "CLIENTE";
    }
}
