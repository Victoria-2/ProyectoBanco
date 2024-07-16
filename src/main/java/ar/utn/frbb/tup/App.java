package ar.utn.frbb.tup;

import ar.utn.frbb.tup.model.*;
import ar.utn.frbb.tup.presentationNO.input.MenuInput;

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
