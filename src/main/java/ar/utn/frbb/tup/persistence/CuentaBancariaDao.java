package ar.utn.frbb.tup.persistence;

import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.persistence.entity.CuentaBancariaEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CuentaBancariaDao extends  AbstractBaseDao {
    public CuentaBancaria find(int id){
        if( (getInMemoryDatabase().get(id)) == null){
            return null;
        }
        return ((CuentaBancariaEntity)getInMemoryDatabase().get(id)).toCuentaBancaria();//busca y agarra la entidad y la pasa a una cuenta
    }

    public void save(CuentaBancaria cuenta){
        CuentaBancariaEntity entidadCB = new CuentaBancariaEntity(cuenta);
        getInMemoryDatabase().put(entidadCB.getTitular(), entidadCB);
    }

    public List<CuentaBancaria> getCuentasByCliente(Integer dni){
        List<CuentaBancaria> cuentasCliente = new ArrayList<>();

        for (Object valor : getInMemoryDatabase().values()){
            CuentaBancariaEntity cuenta = (CuentaBancariaEntity) valor;
            if(cuenta.getTitular().equals(dni)){
                cuentasCliente.add(cuenta.toCuentaBancaria());
            }
        }

        return cuentasCliente;
    }

    @Override
    protected String getEntityType() {
        return "Cuenta";
    }
}
