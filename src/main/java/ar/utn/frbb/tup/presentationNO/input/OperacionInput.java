package ar.utn.frbb.tup.presentationNO.input;


import ar.utn.frbb.tup.presentationNO.Banco;
import ar.utn.frbb.tup.presentationNO.Menu;
import ar.utn.frbb.tup.presentationNO.BusquedaClienteYCuentaBancaria;
import ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones.ConsultaDeSaldo;
import ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones.IngresarDinero;
import ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones.Retiro;
import ar.utn.frbb.tup.model.movimientos.TiposDeOperaciones.Transferencia;

public class OperacionInput extends Menu {
    private boolean menu;
    //constructor
    public OperacionInput(){
        this.menu = true;
    }
    //metodos

    public void generarOperacion(/*CuentaBancaria cuentaBancaria*/ Banco banco){
        System.out.println("Por cuestiones de seguridad, ingrese su DNI para comenzar la operacion:");
        int dni = sc.nextInt();
        BusquedaClienteYCuentaBancaria cliente = new BusquedaClienteYCuentaBancaria();
        /*Cliente cliente = buscar.*/cliente.buscarCliente(banco, dni);
        /*if ((cliente.buscarCuentaBancaria()) == null){
            System.out.println("No ha registrado una cuenta para poder operar!");
        }*/ //hacer una verificacion para que haya cuentas
        /*CuentaBancaria cuentaBancaria = buscar.*/cliente.buscarCuentaBancaria();
        

        while (menu == true){
            
            System.out.println("\n=====MENU DE OPERACIONES=====");
            System.out.println("1. Consulta de saldo"); //X
            System.out.println("2. Ingresar dinero"); //X
            System.out.println("3. Realizar una transferencia"); //X
            System.out.println("4. Hacer un deposito"); //X
            System.out.println("5. Retirar dinero"); //X
            System.out.println("6. Operaciones con mi cuenta de cliente del banco");
            System.out.println("7. Consultar operaciones");//X
            System.out.println("0. Volver"); //X
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Su saldo actual de la cuenta"+ (cliente.getCuentaBancariaEncontrada()).getCbu()+" es: "); //poner en que moneda es, hay que generar un get
                    ConsultaDeSaldo consultarSaldo = new ConsultaDeSaldo();
                    System.out.println(consultarSaldo.generarConsultaSaldo(cliente.getCuentaBancariaEncontrada()));
                    clearScreen(3);
                    break;

                case 2:
                    System.out.println("Ingrese la cantiad de dinero que desea ingresar a la cuenta:");
                    double dinero = sc.nextInt();
                    IngresarDinero ingreso = new IngresarDinero();
                    ingreso.generarIngresarDinero(cliente.getCuentaBancariaEncontrada(), dinero);
                    System.out.println("\nSe ha ingresado el dinero correctamente.");
                    clearScreen(2);
                    break;

                case 4: //lo dejo igual porque su codigo es igual al de transferencia, dps en capas lo divido bien
                case 3:
                    //System.out.println("En estos momentos no se pueden realizar transferencias. Por favor intente mas tarde");
                    System.out.println("Ingrese el DNI de la persona a la que quiere hacerle una transferencia:");
                    int dni2 = sc.nextInt();
                    BusquedaClienteYCuentaBancaria cliente2 = new BusquedaClienteYCuentaBancaria();

                    cliente2.buscarCliente(banco, dni2);
                    /*if (cliente2.getClienteEncontrado() == null){
                        System.out.println("\n No se ha encontrado la cuenta, por favor intente otra vez o utilice la opcion de 'Invitar Amigos' ");
                        break;
                    }  */
                    cliente2.buscarCuentaBancaria();

                    System.out.println("\nIngrese el monto que desea transferir:");
                    int montoTransferencia = sc.nextInt();
                    
                    //aca tendria que haber una validacion de q ambas cuentas tengan dinero o no || pasarlo a una validacion despues
                    if ((cliente.getCuentaBancariaEncontrada()).getSaldo() == 0){
                        System.out.println("Dinero insuficiente para realizar la operacion. Utilice la opcion 'Ingresar Dinero' ");
                        break;
                    }

                    Transferencia transferencia = new Transferencia();
                    transferencia.generarTransferencia(cliente.getCuentaBancariaEncontrada(), montoTransferencia, cliente2.getCuentaBancariaEncontrada());
                    System.out.println("\nLa transferencia se ha realizado correctamente");
                    clearScreen(2);
                    break;
                
                /*case 4:
                    
                    break;*/
                
                case 5: //hacer verificacion de q la cuenta tenga mas de lo q va a retirar
                    System.out.println("Ingrese la cantiad de dinero que desea retirar:");
                    double dineroARetirar = sc.nextInt();
                    //IngresarDinero ingreso = new IngresarDinero();
                    //ingreso.generarIngresarDinero(cliente.getCuentaBancariaEncontrada(), dinero);
                    Retiro retirar = new Retiro();
                    retirar.generarRetirarDinero(cliente.getCuentaBancariaEncontrada(),dineroARetirar);
                    System.out.println("\nSe ha retirado el dinero correctamente.");
                    clearScreen(2);
                    break;
                
                case 6:
                    System.out.println("En estos momentos estamos trabajando en mejorar el sistema, si sus cambios no se ven reflejados, estamos en ello. Vuelva a intentarlo mas tarde");
                    AMBclienteInput amb = new AMBclienteInput();
                    amb.menuAMB(cliente.getClienteEncontrado());

                    break;

                case 7:
                    System.out.println("\nOperaciones Realizadas:");
                    System.out.println((cliente.getCuentaBancariaEncontrada()).getMovimientosRealizados());
                    System.out.println();
                    clearScreen(8);
                    break;

                case 0:
                    clearScreen();
                    menu = false;
                    break;
            
                default:
                    System.out.println("Opción inválida. Por favor seleccione entre los valores 0 y 7.");
                    clearScreen(2);
                    break;
            }

        }


    }

    
}
