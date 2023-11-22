package org.sistemaBancario.servicios;

import com.opencsv.CSVWriter;
import org.sistemaBancario.domain.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BancoServicioImpl implements BancoServicios{
    @Override
    public void abrirCuenta(Banco banco){
        Scanner datos = new Scanner(System.in);
        System.out.println("### CREAR CUENTA BANCARIA ###");
        System.out.println("Ingrese nombre:");
        String nombre = datos.nextLine();
        System.out.println("Ingrese dirección:");
        String direccion = datos.nextLine();
        //int proximoID = clientes.
        Cliente cliente = new Cliente(proximoClienteId(banco), nombre, direccion);
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
        banco.getClientes().add(cliente);
        System.out.println("### Cliente nuevo creado con éxito ###");
        System.out.println("---------------------------------------------");
        //no tengo que cerrar el Scanner porque sino da error "NoSuchElementException"
        //datos.close();
    }
    @Override
    public void agregarCliente(Banco banco, Cliente cliente){

        banco.getClientes().add(cliente);
    }
    public int proximoClienteId(Banco banco) {
        int id = banco.getClientes().toArray().length + 1;
        //System.out.println("Proximo ID " + id);
        return id;
    }
    public void obtenerClientes(Banco banco){
        System.out.println("### LISTA DE CLIENTES ###" );
        if (banco.getClientes().isEmpty()){
            System.out.println("### No existen clientes ###");
            System.out.println("---------------------------------------------");
        } else {
            for (Cliente cliente: banco.getClientes()) {
                cliente.detalle();
            }
        }
    }
    @Override
    public void exportarListaDeClientes(Banco banco) {
        try(CSVWriter destino = new CSVWriter(new FileWriter("C:\\Users\\Fer\\Desktop\\ClientesBanco.csv"))){
            //encabezados
            String[] encabezado = {"ID", "Nombre", "direccion","CuentaID", "Tipo", "saldo"};
            destino.writeNext(encabezado);
            //datos
            for (Cliente cliente: banco.getClientes()) {
                for(CuentaBancaria cuenta: cliente.getCuentasBancarias()){
                    //creamos un array list para guardar los datos de cada cliente
                    ArrayList<String> datos= new ArrayList<>();
                    datos.add(String.valueOf(cliente.getId()));
                    datos.add(cliente.getNombre());
                    datos.add(cliente.getDireccion());
                    datos.add(String.valueOf(cuenta.getCuentaID()));
                    datos.add(cuenta.getTipo());
                    datos.add(String.valueOf(cuenta.getSaldo()));
                    //escribimos los datos guardados en el exportable
                    destino.writeNext(datos.toArray(new String[0]));
                }
            }
            System.out.println("### Datos descargados con éxito ###");
            System.out.println("---------------------------------------------");
        } catch(IOException e) {
            System.out.println("Ocurrio un error " + e.getMessage());
        }

    }


    @Override
    public Cliente seleccionarCliente(Banco banco) {
        Cliente clienteSeleccionado = null;
        while (clienteSeleccionado == null){
            Scanner datos = new Scanner(System.in);
            System.out.println("seleccione el ID del cliente: ");
            int id = datos.nextInt();
            for (Cliente cliente: banco.getClientes()) {
                if(cliente.getId() == id){
                    clienteSeleccionado = cliente;
                } else {
                    System.out.println("no existe cliente con ese ID, seleccione de nuevo.");
                    }
                }
            }
            return clienteSeleccionado;
        }
    }
