package ar.utn.frbb.tup.controller.validator;

import ar.utn.frbb.tup.controller.ClienteDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ClienteValidator {
    public void validate(ClienteDto clienteDto){
        validateTipoPersona(clienteDto);
        validateFechaNacimiento(clienteDto);
    }

    private void validateTipoPersona(ClienteDto clienteDto){
        if(!"F".equals(clienteDto.getTipoPersona()) || (!"J".equals(clienteDto.getTipoPersona()))){
            throw new IllegalArgumentException("El tipo de persona "+clienteDto.getTipoPersona()+" no es aceptado"); //no se si hay que hacer un toString para que lo muestre
        }
    }
    private void validateFechaNacimiento(ClienteDto clienteDto){
        try{
            LocalDate.parse(clienteDto.getNacimiento());
        } catch (Exception e){
            throw new IllegalArgumentException("Fecha de nacimiento con el formato erroneo");
        }
    }
}
