package ar.utn.frbb.tup.persistence.entity;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.CuentaBancaria;
import ar.utn.frbb.tup.model.TipoPersona;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClienteEntity extends  BaseEntity{
    private String nombre; //persona
    private String apellido;  //persona
    //private int dni; //persona -- no es necesario xq el id es el DNI
    private LocalDate nacimiento; //persona
    private String bancoCliente;
    private LocalDate fechaApertura;
    private TipoPersona tipoPersona;
    private List<String> cuentas = new ArrayList<>();

    public ClienteEntity(Cliente cliente) {
        super(cliente.getDni());
        this.nombre = cliente.getNombre();
        this.apellido = cliente.getApellido();
        this.nacimiento = cliente.getNacimiento();
        this.bancoCliente = cliente.getBancoCliente();
        this.fechaApertura = cliente.getFechaApertura();
        this.tipoPersona = cliente.getTipoPersona();
        addCuentasCliente(cliente);
    }

    public Cliente toCliente() { //MANEJAR LA EXCEPCION EN ALGUN LUGAR!!
        Cliente cliente = new Cliente();
        cliente.setNombre(this.nombre);
        cliente.setApellido(this.apellido);
        cliente.setDni(this.getId());
        cliente.setNacimiento(this.nacimiento);
        cliente.setBancoCliente(this.bancoCliente);
        cliente.setFechaApertura(this.fechaApertura);
        cliente.setTipoPersona(TipoPersona.fromString(String.valueOf(this.tipoPersona)));
        //por algun motivo no pasa las cuentas??? Es xq las busca dps??
        return cliente;
    }

    private void addCuentasCliente(Cliente cliente){
        if (cliente.getCuentasBancariasCliente() != null && !cliente.getCuentasBancariasCliente().isEmpty()) {
            for (CuentaBancaria c: cliente.getCuentasBancariasCliente()) {
                cuentas.add(c.getCbu());
            }
        }
    }
}
