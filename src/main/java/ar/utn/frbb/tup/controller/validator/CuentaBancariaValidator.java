package ar.utn.frbb.tup.controller.validator;

import ar.utn.frbb.tup.controller.CuentaBancariaDto;
import ar.utn.frbb.tup.model.TipoDeCuenta;
import ar.utn.frbb.tup.model.TipoMoneda;
import org.springframework.stereotype.Component;


@Component
public class CuentaBancariaValidator {
    public static void validate(CuentaBancariaDto cuentaDto){
        //-->Hay q validar q nada este vacio, es con @Valid y @NotNull en 'model'
        validateTipoMoneda(cuentaDto);
        validateTipoCuenta(cuentaDto);
    }


    private static void validateTipoMoneda(CuentaBancariaDto cuentaDto){
        cuentaDto.setMoneda(TipoMoneda.valueOf(cuentaDto.getMoneda().toUpperCase()));
        if( (!"ARS".equals(cuentaDto.getMoneda())) && (!"USD".equals(cuentaDto.getMoneda()))) {
            throw new IllegalArgumentException("La moneda: "+cuentaDto.getMoneda()+" no soportada");
        }
    }
    private static void validateTipoCuenta(CuentaBancariaDto cuentaDto){
        cuentaDto.setTipoCuenta(TipoDeCuenta.valueOf(cuentaDto.getTipoCuenta().toUpperCase()));
        if((!"CA".equals(cuentaDto.getTipoCuenta())) && (!"CC".equals(cuentaDto.getTipoCuenta()))){
            throw  new IllegalArgumentException("La cuenta del tipo "+cuentaDto.getTipoCuenta()+"no es soportada");
        }
    }
}
