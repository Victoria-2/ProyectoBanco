package ar.utn.frbb.tup.presentationNO.input;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.presentationNO.Menu;

public class AMBclienteInput extends Menu{
    private boolean menu;
    private boolean menu2;
    //constructor
    public AMBclienteInput(){
        this.menu = true;
        this.menu2 = true;
    }

    //metodos
    private void verCliente(Cliente cliente){
        System.out.println(cliente);
    }

    private void bajaCliente(Cliente cliente){
        cliente.bajaCliente();
        System.out.println("Lamentamos que se vaya :("+cliente.getNombre()+" "+cliente.getApellido()+"\nSe ha dado de baja el cliente");
    }

    private void modificacionCliente(Cliente cliente){
        while(menu == true){
            System.out.println("Que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Direccion");
            System.out.println("4. Numero de telefono");
            System.out.println("0. Volver");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("\nIngrese nuevo nombre:");
                    String nombre = sc.next();
                    cliente.setNombre(nombre);
                    break;

                case 2:
                    System.out.println("\nIngrese nuevo apellido:");
                    String apellido = sc.next();
                    cliente.setApellido(apellido);
                    break;

                case 3:
                    System.out.println("Ingrese la nueva direccion \nCalle:");
                    String calle = sc.next();
                    sc.nextLine();
                    System.out.println("Numero de calle:");
                    int numero = sc.nextInt();
                    System.out.println("Localidad:");
                    String localidad = sc.nextLine();
                    sc.nextLine(); 

                    Direccion direccion = new Direccion(calle, numero, localidad);
                    cliente.setDireccion(direccion);
                    break;

                case 4:
                    System.out.println("\nIngrese nuevo apellido:");
                    int numTelefono = sc.nextInt();
                    cliente.setNumTelefono(numTelefono);
                    break;

                case 0:
                    clearScreen();
                    menu = false;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione entre los valores 0 y 4.");
                        clearScreen(2);
                    break;
            }
        }
        




    }


    public void menuAMB(Cliente cliente){
        while (menu2 == true) {
            System.out.println("\n=====MENU DE CUENTA CLIENTE=====");
            System.out.println("1. Ver mi cuenta"); 
            System.out.println("2. Dar de baja"); 
            System.out.println("3. Modificar mi cuenta"); 
            System.out.println("0. Volver"); 
            int opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1:
                    verCliente(cliente);
                    break;
                
                case 2:
                    bajaCliente(cliente);
                    break;

                case 3:
                    modificacionCliente(cliente);
                    break;

                case 0:
                    clearScreen();
                    menu2 = false;
                    break;
            
                default:
                    System.out.println("Opción inválida. Por favor seleccione entre los valores 0 y 4.");
                        clearScreen(2);
                    break;
            }
        }
    }
}
