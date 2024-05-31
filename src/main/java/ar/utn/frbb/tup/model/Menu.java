package ar.utn.frbb.tup.model;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {
    //metodos constructores
    protected Menu(){}
    //metodos
    protected Scanner sc = new Scanner(System.in);

    //Borrar pantalla
    protected static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    protected static void clearScreen(int segundos) {
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.print("\033[H\033[2J");
        System.out.flush();

        
    }
}
