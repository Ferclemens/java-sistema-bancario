package org.sistemaBancario.domain;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco implements org.sistemaBancario.servicios.Servicios {
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
    @Override
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public int proximoClienteId() {
        int id = clientes.toArray().length + 1;
        //System.out.println("Proximo ID " + id);
        return id;
    }
    @Override
    public void abrirCuenta(){
        Scanner datos = new Scanner(System.in);
        System.out.println("### CREAR CUENTA BANCARIA ###");
        System.out.println("Ingrese nombre:");
        String nombre = datos.nextLine();
        System.out.println("Ingrese dirección:");
        String direccion = datos.nextLine();
        //int proximoID = clientes.
        Cliente cliente = new Cliente(proximoClienteId(), nombre, direccion);
        System.out.println("Ingrese saldo:");
        double saldo = datos.nextDouble();
        System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
        int eleccion = datos.nextInt();
        while(eleccion != 1 && eleccion != 2) {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
            System.out.println("1- Cuenta de ahorro\n2- Cuenta Corriente");
            eleccion = datos.nextInt();
        }
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
    @Override
    public void listarClientes(){
        System.out.println("### LISTA DE CLIENTES ###" );
        if (clientes.isEmpty()){
            System.out.println("### No existen clientes ###");
            System.out.println("---------------------------------------------");
        } else {
            for (Cliente cliente: clientes) {
                cliente.detalle();
            }
        }
    }
    @Override
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
                int eleccion = datos.nextInt();
                while(eleccion != 1 && eleccion != 2){
                    System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
                    System.out.println("1- Cuenta de ahorro\n2- Cuenta Corriente");
                    eleccion = datos.nextInt();
                }
                if (eleccion == 2) {
                    String tipo = "Cuenta Corriente";
                    CuentaCorriente cuenta = new CuentaCorriente(cliente.proximaCuentaId(), clienteSeleccionado, tipo, saldo, 100.0);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                } else if (eleccion == 1) {
                    String tipo = "Cuenta de ahorro";
                    CuentaDeAhorro cuenta = new CuentaDeAhorro(cliente.proximaCuentaId(), clienteSeleccionado, tipo, saldo, 5.0);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                }
                System.out.println("--------------------------------------------------");
                break;
            } else {
                System.out.println("No existe cliente");
                System.out.println("---------------------------------------------");
            }
        }
        System.out.println("### Cuenta nueva creada con éxito ###");
        System.out.println("---------------------------------------------");
        //no tengo que cerrar el Scanner porque si agrego 2 cuentas de seguido da error "NoSuchElementException"
        //datos.close();
    }
    @Override
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
            } else {
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            }
        }
    }
    @Override
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
                    if (cuenta instanceof CuentaCorriente) {
                        System.out.println("Límite sobregiro : " + ((CuentaCorriente) cuenta).getLimiteSobregiro());
                    } else if (cuenta instanceof CuentaDeAhorro) {
                        System.out.println("intereses: " + ((CuentaDeAhorro) cuenta).getIntereses());
                    }
                }
                System.out.println("SALDO TOTAL: " + saldoTotal);
                System.out.println("---------------------------------------------");
                break;
            } else {
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            }
        }
    }
    @Override
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
                        break;
                        //el else salta aunque no corresponda
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
    @Override
    public void retirar(){
        System.out.println("### RETIRAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        listarClientes();
        System.out.println("seleccione el ID del cliente para el retiro: ");
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
                System.out.println("seleccione el ID de la cuenta para el retiro: ");
                int idCuenta = datos.nextInt();
                System.out.println("ingrese el monto a retirar: ");
                double retiro = datos.nextDouble();
                for (CuentaBancaria cuenta: clienteSeleccionado.getCuentasBancarias()) {
                    if(idCuenta == cuenta.getCuentaID()){
                        double nuevoSaldo = cuenta.getSaldo() - retiro;
                        if(cuenta instanceof CuentaCorriente &&
                                nuevoSaldo < (((CuentaCorriente) cuenta).getLimiteSobregiro() * -1)){
                            System.out.println("retiro cancelado - El retiro excede el límite de sobregiro: "
                                    + ((CuentaCorriente) cuenta).getLimiteSobregiro());
                            System.out.println("---------------------------------------------");
                        } else {
                            cuenta.setSaldo(cuenta.getSaldo()-retiro);
                            System.out.println("### Saldo retirado con éxito ### ");
                            System.out.println("---------------------------------------------");
                            break;
                        }
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
    @Override
    public void exportarListaDeClientes() {
        try(CSVWriter destino = new CSVWriter(new FileWriter("C:\\Users\\Fer\\Desktop\\ClientesBanco.csv"))){
            //encabezados
            String[] encabezado = {"ID", "Nombre", "direccion","CuentaID", "Tipo", "saldo"};
            destino.writeNext(encabezado);
            //datos

            for (Cliente cliente: clientes) {
                ArrayList<String> datos= new ArrayList<>();
                datos.add(String.valueOf(cliente.getId()));
                datos.add(cliente.getNombre());
                datos.add(cliente.getDireccion());
                for(CuentaBancaria cuenta: cliente.getCuentasBancarias()){
                    datos.add(String.valueOf(cuenta.getCuentaID()));
                    datos.add(cuenta.getTipo());
                    datos.add(String.valueOf(cuenta.getSaldo()));
                }
                destino.writeNext(datos.toArray(new String[0]));
            }

        } catch(IOException e) {
            System.out.println("Ocurrio un error " + e.getMessage());
        }

    }
}
