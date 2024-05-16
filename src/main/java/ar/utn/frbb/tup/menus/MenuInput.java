package ar.utn.frbb.tup.menus;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.entidades.Persona;

public class MenuInput extends Menu{
    private boolean menu;
    //constructor
    public MenuInput(){
        this.menu = true;
    }

    //metodos

    public void generarMenu(Banco banco){
        System.out.println("Bienveido a la aplicación de Banco!");
        System.out.println("Le vamos a pedir que ingrese informacion para empezar a operar");
        System.out.println("Ingrese el nombre de la entidad bancaria: \n");
        String nombreBanco = sc.next();
        banco.setNombre(nombreBanco);
        sc.nextLine();
        clearScreen(2);

        ClienteInput persona = new ClienteInput();
        persona.generarCliente(banco);

        while(menu = true){
            System.out.println("Bienveido a la aplicación de Banco "+banco.getNombre()+" !");
            //System.out.println("0. Mi cuenta");
            System.out.println("1. Crear una nueva Cuenta Bancaria");
            System.out.println("2. Generar un movimiento");
            System.out.println("3. Invitar a un amigo");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opción (1-4): ");

            int opcion = sc.nextInt();
            //sc.nextLine();

            switch (opcion) {
                case 1:
                    CuentaBancariaInput cuentaBancaria = new CuentaBancariaInput(); //PRUEBA
                    cuentaBancaria.generarCuentaBancaria(banco); //PRUEBA
                    break;

                case 2:
                    break;

                case 3:
                    ClienteInput clienteYPersona = new ClienteInput();
                    clienteYPersona.generarCliente(banco);
                    break;

                case 4:
                    System.out.print("\n Gracias por confiar en nosotros. Vuelva pronto !!");
                    menu = false;
                    break;
            
                default:
                    System.out.println("Opción inválida. Por favor seleccione entre los valores 1 y 4.");
            }
        }
    }
    
}