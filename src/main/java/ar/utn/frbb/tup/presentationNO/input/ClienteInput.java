package ar.utn.frbb.tup.presentationNO.input;

import ar.utn.frbb.tup.model.Banco;
import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.model.Direccion;
import ar.utn.frbb.tup.model.Menu;
import ar.utn.frbb.tup.model.Persona;

public class ClienteInput extends Menu{

    public Cliente generarCliente(Banco banco){
        System.out.println("Bienveido a la aplicación de Banco "+banco.getNombre()+" !");
        System.out.println("Vamos a registrarnos!");
        clearScreen(2);

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.next();
        sc.nextLine();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = sc.next();
        sc.nextLine();

        System.out.println("Ingrese la direccion cliente \nCalle:");
        String calle = sc.next();
        sc.nextLine();
        System.out.println("Numero de calle:");
        int numero = sc.nextInt();
        System.out.println("Localidad:");
        String localidad = sc.nextLine();
        sc.nextLine();

        System.out.println("Ingrese el telefono del cliente: (Formato: 15xxxxxxx)");
        int numeroTelefono = Integer.parseInt(sc.next());
        //estatura=Float.parseFloat(teclado.nextLine());

        //estatura=Float.parseFloat(teclado.nextLine());

        sc.nextLine();
        System.out.println("Ingrese el DNI del cliente:");
        int dni = sc.nextInt();

        Direccion direccion = new Direccion(calle, numero, localidad);
        Persona persona = new Persona(nombre,apellido,direccion,numeroTelefono,dni);
        Cliente cliente = new Cliente(persona);
        banco.agregarUsuarios(dni, cliente);

        clearScreen();
        System.out.println("\n Su cuenta se ha registrado correctamente! Recuerde generar una Cuenta Bancaria para operar");
        clearScreen(2);

        return cliente;
    }
}
