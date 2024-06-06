package ar.utn.frbb.tup.persistence;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ar.utn.frbb.tup.model.Cliente;
import ar.utn.frbb.tup.service.Movimiento;

public class GuardarEnBase {

    public void guardar (Cliente cliente, Movimiento movimiento){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("prueba.txt"));
            writer.write(cliente);
            writer.write("\n" + movimiento);
            writer.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
}
