package ar.utn.frbb.tup.database;

import java.util.HashMap;

import ar.utn.frbb.tup.model.Banco;
import ar.utn.frbb.tup.model.CuentaBancaria;

public class BaseDeDatosBanco extends Banco{
    protected static HashMap<Integer, HashMap<String, CuentaBancaria> > HoboDataBase = new HashMap<>();
}
