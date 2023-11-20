package org.sistemaBancario.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private List<CuentaBancaria> cuentas;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentas;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentas = cuentasBancarias;
    }

    public int proximaCuentaId() {
        int id = cuentas.toArray().length + 1;
        //System.out.println("Proximo ID " + id);
        return id;
    }
    public void detalle() {
        System.out.println("------------------Cliente-------------------" +
                "\nID: "+ id +" | nombre: " + nombre +" | dirección: " + direccion);
        System.out.println("--------------------------------------------");
//        for (CuentaBancaria cuenta: cuentas) {
//            System.out.println("ID: " + cuenta.getCuentaID() +  " | tipo: " + cuenta.getTipo() +
//                    " | saldo: " + cuenta.getSaldo());
//        }

    }
}
