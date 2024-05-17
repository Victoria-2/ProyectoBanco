package ar.utn.frbb.tup;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.menus.CuentaBancariaInput;
import ar.utn.frbb.tup.menus.MenuInput;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Banco banco = new Banco();

        MenuInput menuInputProcessor = new MenuInput();
        menuInputProcessor.generarMenu(banco);

    }
}
