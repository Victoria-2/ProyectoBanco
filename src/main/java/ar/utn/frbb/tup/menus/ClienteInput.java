package ar.utn.frbb.tup.menus;

import ar.utn.frbb.tup.entidades.Banco;
import ar.utn.frbb.tup.entidades.Cliente;
import ar.utn.frbb.tup.entidades.Direccion;
import ar.utn.frbb.tup.entidades.Persona;

public class ClienteInput extends Menu{

    public Cliente generarCliente(Banco banco){
        System.out.println("Bienveido a la aplicación de Banco "+banco.getNombre()+" !");
        System.out.println("Vamos a registrarnos!");
        clearScreen(2);

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = sc.next();
        System.out.println("Ingrese el apellido del cliente:");
        String apellido = sc.next();

        System.out.println("Ingrese la direccion cliente\n Calle:");
        String calle = sc.next();
        System.out.println("Numero de calle:");
        int numero = sc.nextInt();
        System.out.println("Localidad:");
        String localidad = sc.next();

        System.out.println("Ingrese el telefono del cliente:\n Formato: 15xxxxxxx");
        int numeroTelefono = sc.nextInt();
        System.out.println("Ingrese el DNI del cliente:");
        int dni = sc.nextInt();

        Direccion direccion = new Direccion(calle, numero, localidad);
        Persona persona = new Persona(nombre,apellido,direccion,numeroTelefono,dni);
        Cliente cliente = new Cliente(persona);
        banco.agregarUsuarios(dni, cliente);

        return cliente;
    }
}