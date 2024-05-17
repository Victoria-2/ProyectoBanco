package ar.utn.frbb.tup.menus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.entidades.Cliente;
import ar.utn.frbb.tup.entidades.CuentaBancaria;
import ar.utn.frbb.tup.entidades.movimientos.TiposDeOperaciones.Transferencia;

public class OperacionInput extends Menu {
    private boolean menu;
    //constructor
    public OperacionInput(){
        this.menu = true;
    }
    //metodos

    public void generarOperacion(/*CuentaBancaria cuentaBancaria*/ Banco banco){
        

        while (menu == true){
            
            System.out.println("\n=====MENU DE OPERACIONES=====");
            System.out.println("1. Consulta de saldo");
            System.out.println("2. Ingresar dinero");
            System.out.println("3. Realizar una transferencia");
            System.out.println("4. Hacer un deposito");
            System.out.println("5. Retirar dinero");
            System.out.println("0. Salir");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    
                    break;

                case 2:
                    
                    break;

                case 3:
                    System.out.println("En estos momentos no se pueden realizar transferencias. Por favor intente mas tarde");
                    System.out.println("Ingrese el DNI de la persona a la que quiere hacerle una transferencia:");
                    int buscarDNI2 = sc.nextInt();
                    Cliente cliente2 = (Cliente) (banco.getUsuariosRegistrados()).get(buscarDNI2);

                    if (cliente2 == null){
                        System.out.println("\n No se ha encontrado la cuenta, por favor intente otra vez o utilice la opcion de 'Invitar Amigos' ");
                        break;
                    }  

                    System.out.println("\nIngrese el monto que desea transferir:");
                    int montoTransferencia = sc.nextInt();

                    Transferencia transferencia = new Transferencia();
                    //transferencia.generarTransferencia(cuenta, montoTransferencia, cliente2);


                    break;
                
                case 4:
                    
                    break;
                
                case 5:
                    
                    break;

                case 0:
                    clearScreen();
                    menu = false;
                    break;
            
                default:
                    System.out.println("Opción inválida. Por favor seleccione entre los valores 0 y 5.");
                    break;
            }

        }


    }

    
}
