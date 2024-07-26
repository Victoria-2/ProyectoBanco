package ar.utn.frbb.tup;

import ar.utn.frbb.tup.presentationNO.Banco;
import ar.utn.frbb.tup.presentationNO.input.MenuInput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main( String[] args )
    {
        /*Banco banco = new Banco();

        MenuInput menuInputProcessor = new MenuInput();
        menuInputProcessor.generarMenu(banco);*/

        SpringApplication.run(App.class, args);

    }
}
