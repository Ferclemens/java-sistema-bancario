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
        //Cliente cliente1 = new Cliente("Fer", "Calle 123");
        //Cliente cliente2 = new Cliente("Moncho", "Calle 3210");
        //abrimos una cuenta al cliente creado
        banco.abrirCuenta();
        banco.listarClientes();


    }
}
