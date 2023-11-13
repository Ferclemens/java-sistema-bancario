package org.sistemaBancario.Banco;

import org.sistemaBancario.Cliente.Cliente;

import java.util.List;

public class Banco {
    String nombre;
    List<Cliente> clientes;

    public Banco() {
    }

    public Banco(String nombre, List<Cliente> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    /*
     * abrirCuenta()
     * listarClientes()
     * */
}
