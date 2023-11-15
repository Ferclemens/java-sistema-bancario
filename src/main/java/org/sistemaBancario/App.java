package org.sistemaBancario;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("### BIENVENIDOS AL BANCO PRINT-LINE ###");
        //inicializamos el banco
        Banco banco = new Banco();
        int seleccion;
        do {
            System.out.println("### MENU PRINCIPAL ###");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar cuenta a cliente existente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Ver saldo/s de cuenta/s");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Depositar dinero");
            System.out.println("7. Retirar dinero");
            System.out.println("0. Salir");

            System.out.println("Ingrese una opción: ");
            Scanner scan = new Scanner(System.in);
            seleccion = scan.nextInt();
            switch (seleccion){
                case 1:
                    banco.abrirCuenta();
                    break;
                case 2:
                    banco.agregarCuenta();
                    break;
                case 3:
                    banco.listarClientes();
                    break;
                case 4:
                    banco.verSaldo();
                    break;
                case 5:
                    banco.eliminarCuenta();
                    break;
                case 6:
                    banco.depositar();
                    break;
                default:
                    System.out.println("### Opción inválida ###");
                    System.out.println("---------------------------------------------");
            }
        } while (seleccion != 0);
        System.out.println("### GRACIAS POR USAR BANCO PRINT-LINE ###");
        //creamos clientes hardcode
        //Cliente cliente1 = new Cliente(1, "Fernando", "Calle123");
        //banco.agregarCliente(cliente1);
        //Cliente cliente2 = new Cliente(2, "Ramon", "Calle321");
        //banco.agregarCliente(cliente2);


        //banco.agregarCuenta(cliente1);
        //banco.agregarCuenta(cliente1);
        //banco.eliminarCuenta(cliente1);
        //banco.listarClientes();
        //banco.verSaldo(cliente1);


    }
}
