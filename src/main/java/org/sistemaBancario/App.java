package org.sistemaBancario;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("### BIENVENIDOS AL BANCO PRINT-LINE ###");
        //inicializamos el banco
        Banco banco = new Banco();

        //hardcode cliente1
        Cliente cliente1 = new Cliente(1,"Fernando Clemens", "Calle 123");
        banco.agregarCliente(cliente1);
        CuentaDeAhorro cuenta1 = new CuentaDeAhorro(1, cliente1, "Cuenta de ahorro", 1000, 5.0);
        cliente1.agregarCuentaBancaria(cuenta1);
        CuentaCorriente cuenta2 = new CuentaCorriente(2, cliente1, "Cuenta Corriente", 2000, 100.0);
        cliente1.agregarCuentaBancaria(cuenta2);
        //hardcode cliente2
        Cliente cliente2 = new Cliente(2,"Ruben Roman", "Calle 3211");
        banco.agregarCliente(cliente2);
        CuentaDeAhorro cuenta3 = new CuentaDeAhorro(1, cliente2, "Cuenta de ahorro", 500, 5.0);
        cliente2.agregarCuentaBancaria(cuenta3);
        CuentaCorriente cuenta4 = new CuentaCorriente(2, cliente2, "Cuenta Corriente", 3000, 100.0);
        cliente2.agregarCuentaBancaria(cuenta4);

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
            System.out.println("8. Obtener lista de clientes");
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
                case 7:
                    banco.retirar();
                    break;
                case 8:
                    banco.exportarListaDeClientes();
                    break;
                default:
                    if(seleccion != 0){
                        System.out.println("### Opción inválida ###");
                        System.out.println("---------------------------------------------");
                        break;
                    }
            }
        } while (seleccion != 0);
        System.out.println("### GRACIAS POR USAR BANCO PRINT-LINE ###");

        //hardcodeamos clientes
        //Cliente cliente1 = new Cliente(1, "Fernando", "Calle123");
        //banco.agregarCliente(cliente1);
        //Cliente cliente2 = new Cliente(2, "Ramon", "Calle321");


        //WIP:
        //  (-)  que sea editable intereses y sobregiro
        //  (-)  aplicar intereses
        //  (-)  funcion exportar CSV
        //  (x)  aplicar interface
        //  (x)  BUG: IDs de cuentas no funciona.
        //  (x)  BUG: se dispara el else en varios if de selección.
    }
}
