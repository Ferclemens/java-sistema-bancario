package org.sistemaBancario.servicios;

import com.opencsv.CSVWriter;
import org.sistemaBancario.domain.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BancoServicioImpl implements BancoServicio {
    @Override
    public void agregarCliente(Banco banco,Cliente cliente, CuentaBancaria cuenta){
        cliente.getCuentasBancarias().add(cuenta);
        banco.getClientes().add(cliente);
        System.out.println("---------------------------------------------");
        System.out.println("### Cliente nuevo creado con éxito ###");
        System.out.println("---------------------------------------------");
    }
    @Override
    public void obtenerClientes(Banco banco){
        if (banco.getClientes().isEmpty()){
            System.out.println("---------------------------------------------");
            System.out.println("### No existen clientes ###");
            System.out.println("---------------------------------------------");
        } else {
            for (Cliente cliente: banco.getClientes()) {
                cliente.detalle();
            }
        }
    }
    @Override
    public void eliminarCliente(Banco banco, Cliente cliente) {
        if(cliente == null) {
            System.out.println("---------------------------------------------");
            System.out.println("### operación cancelada - cliente no existe ###");
            System.out.println("---------------------------------------------");
        } else {
            banco.getClientes().remove(cliente);
            System.out.println("---------------------------------------------");
            System.out.println("### cliente eliminado con éxito ###");
            System.out.println("---------------------------------------------");
        }
    }
}
