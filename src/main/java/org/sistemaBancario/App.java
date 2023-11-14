package org.sistemaBancario;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("BIENVENIDOS AL BANCO X");
        //inicializamos el banco
        Banco banco = new Banco();
        //creamos un cliente
        Cliente cliente1 = new Cliente(1,"Fer", "Calle 123");
        banco.agregarCliente(cliente1);
        Cliente cliente2 = new Cliente(2,"Moncho", "Calle 3210");
        banco.agregarCliente(cliente2);
        //abrimos una cuenta al cliente creado
        //banco.abrirCuenta();
        //banco.agregarCuenta(cliente1);
        banco.eliminarCuenta(cliente1);
        banco.listarClientes();



    }
}
