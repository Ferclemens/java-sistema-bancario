package org.sistemaBancario.servicios;

import com.opencsv.CSVWriter;
import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuExportarDatosImpl implements MenuExportarDatos{
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
}
