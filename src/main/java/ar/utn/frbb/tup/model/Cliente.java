package ar.utn.frbb.tup.model;

import ar.utn.frbb.tup.controller.ClienteDto;
import ar.utn.frbb.tup.persistence.ClienteDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Cliente extends Persona {
    @Autowired
    ClienteDao clienteDao;

    private String bancoCliente;
    private LocalDate fechaApertura;
    private TipoPersona tipoPersona;
    private Set<CuentaBancaria> cuentasBancariasCliente = new HashSet<>();

    //constructores
    public Cliente(){
        super();
    }
    public Cliente(ClienteDto clienteDto){
        super(clienteDto.getNombre(), clienteDto.getApellido(), clienteDto.getDni(), clienteDto.getNacimiento());
        fechaApertura = LocalDate.now();
        bancoCliente = clienteDto.getBancoCliente();
        tipoPersona = TipoPersona.fromString(clienteDto.getTipoPersona());
    }

    //metodos
    //BANCO CLIENTE
    public String getBancoCliente() {
        return bancoCliente;
    }
    public void setBancoCliente(String bancoCliente) {
        this.bancoCliente = bancoCliente;
    }

    //FECHA APERTURA
    public LocalDate getFechaApertura() {
        return fechaApertura;
    }
    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    //TIPO PERSONA
    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    //CUENTAS BANCARIAS
    public Set<CuentaBancaria> getCuentasBancariasCliente() {
        return cuentasBancariasCliente;
    }
    public void addCuenta(CuentaBancaria cuenta){
        cuenta.setTitular(this);
        this.cuentasBancariasCliente.add(cuenta);
    }
    public boolean tieneCuenta(TipoDeCuenta tipoDeCuenta, TipoMoneda tipoMoneda){
        for(CuentaBancaria cuenta : cuentasBancariasCliente){
            if ( tipoDeCuenta.equals(cuenta.getTipoCuenta()) && tipoMoneda.equals(cuenta.getMoneda())){
                return true;
            }
        }
        return false;
    }
    
}
