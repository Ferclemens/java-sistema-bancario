package org.sistemaBancario.domain;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    public Banco() {
        this.clientes = new ArrayList<>();
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
