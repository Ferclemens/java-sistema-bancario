package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class MenuBancoServicioImpl implements MenuBancoServicio {
    //variable global para setear id's de cuentas Cliente
    public int ultimoIdCliente = 0;
    @Override
    public int proximoClienteId(Banco banco) {
        System.out.println("ultimoId Cliente = " + ultimoIdCliente);
        int id = 0;
        int longitudArray = banco.getClientes().toArray().length;
        if(longitudArray > ultimoIdCliente){
            ultimoIdCliente = longitudArray + 1;
            id = ultimoIdCliente;
        } else {
            ultimoIdCliente = ultimoIdCliente + 1;
            id = ultimoIdCliente;
            System.out.println("NUEVO ultimoId Cliente = " + ultimoIdCliente);
        }
        return id;
    }
    @Override
    public Cliente lecturaClienteNuevo(Banco banco) {
        Scanner datos = new Scanner(System.in);
        System.out.println("Ingrese nombre:");
        String nombre = datos.nextLine();
        System.out.println("Ingrese dirección:");
        String direccion = datos.nextLine();
        Cliente cliente = new Cliente(proximoClienteId(banco), nombre, direccion);
        return cliente;
    }
    @Override
    public Cliente lecturaClienteAEliminar(Banco banco, BancoServicioImpl bancoServicio){
        Scanner datos = new Scanner(System.in);
        bancoServicio.obtenerClientes(banco);
        System.out.println("seleccione el ID del cliente a eliminar: ");
        int id = datos.nextInt();
        Cliente clienteAEliminar = null;
        for (Cliente cliente: banco.getClientes()) {
            if(cliente.getId() == id){
                clienteAEliminar = cliente;
            }
        }
        return clienteAEliminar;
    }
    @Override
    public Cliente lecturaSeleccionarCliente(Banco banco, BancoServicioImpl bancoServicio) {
        Cliente clienteSeleccionado = null;
        bancoServicio.obtenerClientes(banco);
        do {
            Scanner datos = new Scanner(System.in);
            System.out.println("seleccione el ID del cliente: ");
            int id = datos.nextInt();
            for (Cliente cliente: banco.getClientes()) {
                if(cliente.getId() == id){
                    clienteSeleccionado = cliente;
                    break;
                }
            }
            if (clienteSeleccionado == null) {
                System.out.println("no existe cliente con ese ID, seleccione de nuevo.");
            }
        } while (clienteSeleccionado == null);

        return clienteSeleccionado;
    }
}
