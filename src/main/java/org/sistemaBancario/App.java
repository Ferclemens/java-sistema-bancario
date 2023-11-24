package org.sistemaBancario;

import org.sistemaBancario.domain.*;
import org.sistemaBancario.servicios.*;

import java.util.Scanner;

public class App
{
    public static void main( String[] args ) {
        System.out.println("### BIENVENIDOS AL BANCO PRINT-LINE ###");
        //inicializamos el banco y los servicios
        Banco bancoPrintLine = new Banco();
        BancoServicioImpl bancoServicio = new BancoServicioImpl();
        ClienteServicioImpl clienteServicio = new ClienteServicioImpl();
        CuentaBancariaServicioImpl cuentaServicio = new CuentaBancariaServicioImpl();
        CuentaCorrienteServicioImpl cuentaCorrienteServicio = new CuentaCorrienteServicioImpl();

        //hardcode de clientes
        Cliente cliente1 = new Cliente(1,"Fernando Clemens","Calle 123");
        bancoPrintLine.agregarCliente(cliente1);
        Cliente cliente2 = new Cliente(2,"Leo Messi","calle 321");
        bancoPrintLine.agregarCliente(cliente2);

        int seleccion;
        do {
            System.out.println("### MENU PRINCIPAL ###");
            System.out.println("1. Agregar cliente");
            System.out.println("2. Agregar cuenta a cliente existente");
            System.out.println("3. Listar clientes");
            System.out.println("4. Ver saldo/s de cuenta/s");
            System.out.println("5. Eliminar cliente");
            System.out.println("6. Eliminar cuenta de cliente");
            System.out.println("7. Depositar dinero");
            System.out.println("8. Retirar dinero");
            System.out.println("9. Obtener lista de clientes");
            System.out.println("0. Salir");

            System.out.println("Ingrese una opción: ");
            Scanner scan = new Scanner(System.in);
            seleccion = scan.nextInt();
            switch (seleccion){
                case 1:
                    //Abrir nueva cuenta bancaria - OK
                    bancoServicio.abrirCuenta(bancoPrintLine);
                    break;
                case 2:
                    //AgregarCuenta - OK
                    clienteServicio.agregarCuenta(bancoPrintLine);
                    break;
                case 3:
                    //Listar clientes del banco - OK
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    break;
                case 4:
                    //Ver saldo de cuentas de un cliente - OK
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteParaVerSaldo = bancoServicio.seleccionarCliente(bancoPrintLine);
                    cuentaServicio.verSaldo(clienteParaVerSaldo);
                    break;
                case 5:
                    //Eliminar cliente - OK
                    bancoServicio.eliminarCuenta(bancoPrintLine);
                    break;
                case 6:
                    //Eliminar cuenta de cliente - OK
                    clienteServicio.eliminarCuenta(bancoPrintLine);
                    break;
                case 7:
                    //Depositar -OK
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteParaDepositar = bancoServicio.seleccionarCliente(bancoPrintLine);
                    cuentaServicio.depositar(clienteParaDepositar);
                    break;
                case 8:
                    //Retirar - OK
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteParaRetirar = bancoServicio.seleccionarCliente(bancoPrintLine);
                    cuentaServicio.retirar(clienteParaRetirar);
                    break;
                case 9:
                    //Exportar lista de clientes -OK
                    bancoServicio.exportarListaDeClientes(bancoPrintLine);
                    break;
                case 10:
                    //editar sobregiro de cuenta corriente
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteSeleccionado = bancoServicio.seleccionarCliente(bancoPrintLine);
                    CuentaBancaria cuentaParaEditarSobregiro = clienteServicio.seleccionarCuenta(clienteSeleccionado);
                    cuentaCorrienteServicio.cambiarSobregiro(cuentaParaEditarSobregiro);
                case 11:
                    //generar intereses en cuenta de ahorro
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

        //WIP:
        //  (-)  Elaborar el README
        //  (x)  que sea editable intereses y sobregiro
        //  (-)  aplicar intereses
        //  (x)  funcion exportar CSV
        //  (x)  aplicar interface
        //  (x)  BUG: IDs de cuentas no funciona.
        //  (x)  BUG: se dispara el else en varios if de selección.
        //  (x)  REFACTORIZAR.
    }
}
