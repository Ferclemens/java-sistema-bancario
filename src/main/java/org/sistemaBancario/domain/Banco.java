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
    public void listarClientes(){
        System.out.println("### LISTA DE CLIENTES ###" );
        if (clientes.isEmpty()){
            System.out.println("---------------------------------------------");
            System.out.println("### No existen clientes ###");
            System.out.println("---------------------------------------------");
        } else {
            for (Cliente cliente: clientes) {
                cliente.detalle();
            }
        }
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
}
