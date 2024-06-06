package ar.utn.frbb.tup.presentation.verificaciones;

public abstract class VerificacionClienteInput {

    public boolean validatorNombre(String nombre){ // que arroje una excepcion, no se si poner un try/catch
        if (nombre == null){
            System.out.println("\nNo se ha ingresado nada. Vuelva a intentarlo");
            return false;
        } else if (nombre.length() > 15){
            System.out.println("\nNombre invalido, valor maximo de letras: 15");
            return false;
        }

        
        return true;
    }
}
