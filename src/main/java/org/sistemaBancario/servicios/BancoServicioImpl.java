package org.sistemaBancario.servicios;

import com.opencsv.CSVWriter;
import org.sistemaBancario.domain.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class BancoServicioImpl implements BancoServicio {
    //variable global para setear id's de cuentas Cliente
    public int ultimoIdCliente = 0;
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
    public void agregarCliente(Banco banco,Cliente cliente, CuentaBancaria cuenta){
        cliente.getCuentasBancarias().add(cuenta);
        banco.getClientes().add(cliente);
        System.out.println("---------------------------------------------");
        System.out.println("### Cliente nuevo creado con éxito ###");
        System.out.println("---------------------------------------------");
        //no tengo que cerrar el Scanner porque sino da error "NoSuchElementException"
        //datos.close();
    }

    public void obtenerClientes(Banco banco){
        System.out.println("### LISTA DE CLIENTES ###" );
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
    public void eliminarCliente(Banco banco) {
        System.out.println("### ELIMINAR CLIENTE ###" );
        Scanner datos = new Scanner(System.in);
        banco.listarClientes();
        System.out.println("seleccione el ID del cliente a eliminar: ");
        int id = datos.nextInt();
        Cliente clienteAEliminar = null;
        for (Cliente cliente: banco.getClientes()) {
            if(cliente.getId() == id){
                clienteAEliminar = cliente;
            }
        }
        if(clienteAEliminar != null) {
            banco.getClientes().remove(clienteAEliminar);
            System.out.println("---------------------------------------------");
            System.out.println("### cliente eliminado con éxito ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### cliente no existe ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void exportarListaDeClientes(Banco banco) {
        //Cambiar ruta para descargar en otro lado
        Scanner dato = new Scanner(System.in);
        System.out.println("Ingrese la ruta de descarga y el nombre del archivo - Ej: \n" +
                "C:\\Users\\Fer\\Desktop\\ClientesBancoPrintline.csv" + "\nSi no elije ruta, y solo pone un nombre de archivo." +
                "\nEj: datosBancarios.csv" + "\nEl archivo se descarga en la misma carpeta de la app");
        String ruta = dato.nextLine();
        try(CSVWriter destino = new CSVWriter(new FileWriter(ruta))){
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
            System.out.println("---------------------------------------------");
            System.out.println("Datos descargados en "+ ruta);
            System.out.println("---------------------------------------------");
        } catch(IOException e) {
            System.out.println("---------------------------------------------");
            System.out.println("Ocurrio un error " + e.getMessage());
            System.out.println("---------------------------------------------");
        }

    }
    @Override
    public Cliente seleccionarCliente(Banco banco) {
        Cliente clienteSeleccionado = null;
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
