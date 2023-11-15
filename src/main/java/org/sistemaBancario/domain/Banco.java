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
    public int proximoClienteId() {
        int id = clientes.toArray().length + 1;
        //System.out.println("Proximo ID " + id);
        return id;
    }
    public void abrirCuenta(){
        Scanner datos = new Scanner(System.in);
        System.out.println("### CREAR CUENTA BANCARIA ###");
        System.out.println("Ingrese nombre:");
        String nombre = datos.next();
        System.out.println("Ingrese dirección:");
        String direccion = datos.next();
        //int proximoID = clientes.
        Cliente cliente = new Cliente(proximoClienteId(), nombre, direccion);
        System.out.println("Ingrese saldo:");
        double saldo = datos.nextDouble();
        System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
        /*
        * desarrollar loop de eleccion de cuenta
        * */
        int eleccion = datos.nextInt();
        if( eleccion == 2){
            String tipo = "Cuenta Corriente";
            CuentaCorriente cuenta = new CuentaCorriente(cliente.proximaCuentaId(), cliente, tipo, saldo, 100.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else if ( eleccion == 1){
            String tipo = "Cuenta de ahorro";
            CuentaDeAhorro cuenta = new CuentaDeAhorro(cliente.proximaCuentaId(), cliente, tipo, saldo,5.0);
            cliente.getCuentasBancarias().add(cuenta);
        } else {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
            System.out.println("--------------------------------------------------");
        }
        getClientes().add(cliente);
        System.out.println("### Cliente nuevo creado con éxito ###");
        System.out.println("---------------------------------------------");
        listarClientes();
        //no tengo que cerrar el Scanner porque sino da error "NoSuchElementException"
        //datos.close();
    }
    public void listarClientes(){
        System.out.println("### LISTA DE CLIENTES ###" );
        for (Cliente cliente: clientes) {
            cliente.detalle();
        }
    }
    public void agregarCuenta() {
        System.out.println("### AGREGAR CUENTA BANCARIA A CLIENTE EXISTENTE ###" );
        Scanner datos = new Scanner(System.in);
        listarClientes();
        System.out.println("seleccione el ID del cliente para agregar una cuenta nueva: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado;
        for (Cliente cliente: clientes) {
            if(cliente.getId() == id){
                clienteSeleccionado = cliente;
                System.out.println("Ingrese saldo:");
                double saldo = datos.nextDouble();
                System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
                /*
                 * desarrollar loop de eleccion de cuenta
                 * */
                int eleccion = datos.nextInt();
                if (eleccion == 2) {
                    String tipo = "Cuenta Corriente";
                    CuentaCorriente cuenta = new CuentaCorriente(1, clienteSeleccionado, tipo, saldo, 100.0);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                } else if (eleccion == 1) {
                    String tipo = "Cuenta de ahorro";
                    CuentaDeAhorro cuenta = new CuentaDeAhorro(1, clienteSeleccionado, tipo, saldo, 5.0);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                } else {
                    System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
                    System.out.println("--------------------------------------------------");
                }
            } else {
                System.out.println("No existe cliente");
                System.out.println("---------------------------------------------");
            }
        }
        System.out.println("### Cuenta nueva creada con éxito ###");
        System.out.println("--------------------------------");
        //no tengo que cerrar el Scanner porque si agrego 2 cuentas de seguido da error "NoSuchElementException"
        //datos.close();
    }
    public void eliminarCuenta() {
        System.out.println("### ELIMINAR CUENTA DE CLIENTE ###" );
        Scanner datos = new Scanner(System.in);
        listarClientes();
        System.out.println("seleccione el ID del cliente a eliminar: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado;
        for (Cliente cliente: clientes) {
            if(cliente.getId() == id){
                clienteSeleccionado = cliente;
                clientes.remove(clienteSeleccionado);
                System.out.println("### cliente eliminado con éxito ###");
                System.out.println("---------------------------------------------");
                break;
            } else {
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            }
        }
    }
    public void verSaldo() {
        System.out.println("### VER SALDOS DE CLIENTE ###" );
        Scanner datos = new Scanner(System.in);
        listarClientes();
        System.out.println("seleccione el ID del cliente para ver saldos: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado;
        for (Cliente cliente: clientes) {
            if(cliente.getId() == id){
                clienteSeleccionado = cliente;
                double saldoTotal = 0.0;
                System.out.println("---------------Saldos Cliente----------------" +
                        "\nID: "+ clienteSeleccionado.getId() + "| nombre: " + clienteSeleccionado.getNombre() +
                        "\nCuenta/s: ");
                for (CuentaBancaria cuenta: clienteSeleccionado.getCuentasBancarias()) {
                    saldoTotal += cuenta.getSaldo();
                    System.out.println("ID: " + cuenta.getCuentaID() + " | tipo: " + cuenta.getTipo() +
                            " | saldo: " + cuenta.getSaldo());
                }
                System.out.println("SALDO TOTAL: " + saldoTotal);
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            }
        }
    }
    public void depositar(){
        System.out.println("### DEPOSITAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        listarClientes();
        System.out.println("seleccione el ID del cliente para el deposito: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado;
        for (Cliente cliente: clientes) {
            if(cliente.getId() == id) {
                clienteSeleccionado = cliente;
                System.out.println("---------------Cliente seleccionado----------------" +
                        "\nID: "+ clienteSeleccionado.getId() + "| nombre: " + clienteSeleccionado.getNombre() +
                        "\nCuenta/s: ");
                for (CuentaBancaria cuenta: clienteSeleccionado.getCuentasBancarias()) {
                    System.out.println("ID: " + cuenta.getCuentaID() + " | tipo: " + cuenta.getTipo() +
                            " | saldo: " + cuenta.getSaldo());
                }
                System.out.println("seleccione el ID de la cuenta para el deposito: ");
                int idCuenta = datos.nextInt();
                System.out.println("ingrese el monto a depositar: ");
                double deposito = datos.nextDouble();
                for (CuentaBancaria cuenta: clienteSeleccionado.getCuentasBancarias()) {
                    if(idCuenta == cuenta.getCuentaID()){
                        cuenta.setSaldo(cuenta.getSaldo() + deposito);
                        System.out.println("### Saldo cargado con éxito ### ");
                        System.out.println("---------------------------------------------");
                    } else {
                        System.out.println("### No existe cuenta elegida ###");
                        System.out.println("---------------------------------------------");
                    }
                }
            } else {
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            }
        }
    }
}
