package ar.utn.frbb.tup.databaseNO;

import java.util.HashMap;

import ar.utn.frbb.tup.presentationNO.Banco;
import ar.utn.frbb.tup.model.CuentaBancaria;

public class BaseDeDatosBanco extends Banco{
    protected static HashMap<Integer, HashMap<String, CuentaBancaria> > HoboDataBase = new HashMap<>();
}
