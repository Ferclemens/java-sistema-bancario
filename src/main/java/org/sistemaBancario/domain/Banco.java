package org.sistemaBancario.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public int proximoClienteId(List<Cliente> clientes) {
        int id = clientes.toArray().length + 1;
        System.out.println("Proximo ID " + id);
        return id;
    }
    public void abrirCuenta(){
        Scanner datos = new Scanner(System.in);
        System.out.println("### CREAR CUENTA BANCARIA ###");
        System.out.println("Ingrese nombre completo:");
        String nombre = datos.next();
        System.out.println("Ingrese dirección:");
        String direccion = datos.next();
        //int proximoID = clientes.
        Cliente cliente = new Cliente(proximoClienteId(clientes), nombre, direccion);
        System.out.println("Ingrese saldo:");
        double saldo = datos.nextDouble();
        System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
        /*
        * desarrollar loop de eleccion de cuenta
        * */
        int eleccion = datos.nextInt();
        if( eleccion == 2){
            String tipo = "Cuenta Corriente";
            CuentaCorriente cuenta = new CuentaCorriente(proximoClienteId(clientes), cliente, tipo, saldo, 100.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else if ( eleccion == 1){
            String tipo = "Cuenta de ahorro";
            CuentaDeAhorro cuenta = new CuentaDeAhorro(1, cliente, tipo, saldo,5.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
        }

        getClientes().add(cliente);
        System.out.println("Cliente nuevo creado con éxito");
        datos.close();
    }
    public void listarClientes(){
        for (Cliente cliente: clientes) {
            cliente.detalle();
        }
    }
    public void agregarCuenta(Cliente cliente) {
        Scanner datos = new Scanner(System.in);
        System.out.println("### AGREGAR CUENTA BANCARIA PARA " + cliente.getNombre() + " ###" );
        System.out.println("Ingrese saldo:");
        double saldo = datos.nextDouble();
        System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
        /*
         * desarrollar loop de eleccion de cuenta
         * */
        int eleccion = datos.nextInt();
        if (eleccion == 2) {
            String tipo = "Cuenta Corriente";
            CuentaCorriente cuenta = new CuentaCorriente(1, cliente, tipo, saldo, 100.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else if (eleccion == 1) {
            String tipo = "Cuenta de ahorro";
            CuentaDeAhorro cuenta = new CuentaDeAhorro(1, cliente, tipo, saldo, 5.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
        }
        System.out.println("Cuenta nueva creada con éxito");
        datos.close();
    }
    public void eliminarCuenta(Cliente cliente) {
        if(clientes.contains(cliente)){
            clientes.remove(cliente);
            System.out.println("cliente eliminado con exito");
        } else {
            System.out.println("cliente no encontrado");
        }
    }
    /*
     * abrirCuenta() --> OK
     * listarClientes() --> OK
     * agregarCuenta(cliente) --> OK
     * eliminarCuenta() --> OK
     * verSaldo()
     * */
}
