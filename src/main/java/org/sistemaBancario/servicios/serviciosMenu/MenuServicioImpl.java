package org.sistemaBancario.servicios.serviciosMenu;

import org.sistemaBancario.domain.*;
import org.sistemaBancario.servicios.serviciosBanco.BancoServicioImpl;
import org.sistemaBancario.servicios.serviciosCliente.ClienteServicioImpl;
import org.sistemaBancario.servicios.serviciosCuentaBancaria.CuentaBancariaServicioImpl;
import org.sistemaBancario.servicios.serviciosCuentaCorriente.CuentaCorrienteServicioImpl;
import org.sistemaBancario.servicios.serviciosCuentaDeAhorro.CuentaDeAhorroServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuBanco.MenuBancoServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuCliente.MenuClienteServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuCuentaBancaria.MenuCuentaBancariaServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuCuentaCorriente.MenuCuentaCorrienteServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuCuentaDeAhorro.MenuCuentaDeAhorroServicioImpl;
import org.sistemaBancario.servicios.serviciosMenu.menuExportarDatos.MenuExportarDatosImpl;

import java.util.Scanner;

public class MenuServicioImpl implements MenuServicio {
    public void desplegarMenu(){
        System.out.println("####### BIENVENIDOS AL BANCO PRINT-LINE ########");
        //inicializamos el Banco
        Banco bancoPrintLine = new Banco();
        //inicializamos los servicios
        BancoServicioImpl bancoServicio = new BancoServicioImpl();
        ClienteServicioImpl clienteServicio = new ClienteServicioImpl();
        CuentaBancariaServicioImpl cuentaServicio = new CuentaBancariaServicioImpl();
        CuentaCorrienteServicioImpl cuentaCorrienteServicio = new CuentaCorrienteServicioImpl();
        CuentaDeAhorroServicioImpl cuentaDeAhorroServicio = new CuentaDeAhorroServicioImpl();
        //inicializamos los servicios del menu
        MenuBancoServicioImpl menuBancoServicio = new MenuBancoServicioImpl();
        MenuClienteServicioImpl menuClienteServicio = new MenuClienteServicioImpl();
        MenuExportarDatosImpl menuExportarDatos = new MenuExportarDatosImpl();
        MenuCuentaBancariaServicioImpl menuCuentaBancariaServicio = new MenuCuentaBancariaServicioImpl();
        MenuCuentaCorrienteServicioImpl menuCuentaCorrienteServicio = new MenuCuentaCorrienteServicioImpl();
        MenuCuentaDeAhorroServicioImpl menuCuentaDeAhorroServicio = new MenuCuentaDeAhorroServicioImpl();
        //hardcode de clientes
        //cliente 1
        Cliente cliente1 = new Cliente(1,"Leo Messi","calle 123");
        bancoPrintLine.agregarCliente(cliente1);
        CuentaCorriente cuentaCliente1 = new CuentaCorriente(1,cliente1,"Cuenta corriente",2000,300.0);
        cliente1.agregarCuenta(cuentaCliente1);
        CuentaDeAhorro cuentaCliente2 = new CuentaDeAhorro(2,cliente1,"Cuenta de ahorro",8000,2.0);
        cliente1.agregarCuenta(cuentaCliente2);
        //cliente 2
        Cliente cliente2 = new Cliente(2,"Fernando Clemens","Calle 321");
        CuentaDeAhorro CuentaCliente3 = new CuentaDeAhorro(3,cliente2,"Cuenta de ahorro",2000, 5.0);
        bancoPrintLine.agregarCliente(cliente2);
        cliente2.agregarCuenta(CuentaCliente3);

        int seleccion;
        do {
            System.out.println("################ MENU PRINCIPAL ################");
            System.out.println("################################################");
            System.out.println("# 1. Agregar cliente                           #");
            System.out.println("# 2. Agregar cuenta a cliente existente        #");
            System.out.println("# 3. Listar clientes                           #");
            System.out.println("# 4. Ver saldo/s de cuenta/s                   #");
            System.out.println("# 5. Eliminar cliente                          #");
            System.out.println("# 6. Eliminar cuenta de cliente                #");
            System.out.println("# 7. Depositar dinero                          #");
            System.out.println("# 8. Retirar dinero                            #");
            System.out.println("# 9. Obtener lista de clientes                 #");
            System.out.println("# 10. Editar sobregiro                         #");
            System.out.println("# 11. Editar intereses                         #");
            System.out.println("# 12. generar intereses                        #");
            System.out.println("# 0. Salir                                     #");
            System.out.println("################################################");

            System.out.println("Ingrese una opción del menú: ");
            Scanner scan = new Scanner(System.in);
            seleccion = scan.nextInt();
            switch (seleccion){
                case 1:
                    //Agregar cliente nuevo
                    System.out.println("### CREAR CUENTA BANCARIA ###");
                    Cliente clienteNuevo = menuBancoServicio.lecturaClienteNuevo(bancoPrintLine);
                    CuentaBancaria cuentaNueva = menuClienteServicio.lecturaCuentaBancariaNueva(clienteNuevo);
                    bancoServicio.agregarCliente(bancoPrintLine, clienteNuevo, cuentaNueva);
                    break;
                case 2:
                    //Agregar cuenta a cliente existente
                    System.out.println("### AGREGAR CUENTA BANCARIA A CLIENTE EXISTENTE ###" );
                    Cliente clienteParaAgregarCuenta = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteParaAgregarCuenta != null){
                        CuentaBancaria nuevaCuenta = menuClienteServicio.lecturaCuentaBancariaNueva(clienteParaAgregarCuenta);
                        clienteServicio.agregarCuenta(clienteParaAgregarCuenta, nuevaCuenta);
                    } else {
                        break;
                    }
                    break;
                case 3:
                    //Listar clientes del banco
                    System.out.println("### LISTA DE CLIENTES ###" );
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    break;
                case 4:
                    //Ver saldo de cuentas de un cliente
                    System.out.println("### SALDO/S DE CUENTA/S DE CLIENTE/S ###" );
                    Cliente clienteParaVerSaldo = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    cuentaServicio.verSaldo(clienteParaVerSaldo);
                    break;
                case 5:
                    //Eliminar cliente
                    System.out.println("### ELIMINAR CLIENTE ###" );
                    Cliente clienteAEliminar = menuBancoServicio.lecturaClienteAEliminar(bancoPrintLine, bancoServicio);
                    bancoServicio.eliminarCliente(bancoPrintLine, clienteAEliminar);
                    break;
                case 6:
                    //Eliminar cuenta de cliente
                    System.out.println("### ELIMINAR CUENTA DE CLIENTE ###" );
                    Cliente clienteParaEliminarCuenta = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteParaEliminarCuenta != null) {
                        CuentaBancaria cuentaAEliminar = menuClienteServicio.lecturaCuentaAEliminar(clienteParaEliminarCuenta);
                        if(cuentaAEliminar != null) {
                            clienteServicio.eliminarCuenta(bancoPrintLine, clienteParaEliminarCuenta, cuentaAEliminar);
                        } else {
                            break;
                        }
                    } else{
                        break;
                    }
                    break;
                case 7:
                    //Depositar
                    System.out.println("### DEPOSITAR SALDO EN CUENTA ###" );
                    Cliente clienteParaDepositar = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteParaDepositar != null){
                        cuentaServicio.verSaldo(clienteParaDepositar);
                        CuentaBancaria cuentaParaDeposito = menuClienteServicio.lecturaSeleccionarCuenta(clienteParaDepositar);
                        if(cuentaParaDeposito != null){
                            Double deposito = menuCuentaBancariaServicio.lecturaMontoParaDepositar();
                            cuentaServicio.depositar(cuentaParaDeposito, deposito);
                        } else{
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 8:
                    //Retirar
                    System.out.println("### RETIRAR SALDO EN CUENTA ###" );
                    Cliente clienteParaRetiro = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteParaRetiro != null){
                        cuentaServicio.verSaldo(clienteParaRetiro);
                        CuentaBancaria cuentaParaRetiro = menuClienteServicio.lecturaSeleccionarCuenta(clienteParaRetiro);
                        if(cuentaParaRetiro != null){
                            Double retiro = menuCuentaBancariaServicio.lecturaMontoParaRetirar();
                            cuentaServicio.retirar(cuentaParaRetiro, retiro);
                        } else{
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 9:
                    //Exportar lista de clientes - test manual OK
                    System.out.println("### EXPORTAR DATOS DE CLIENTES ###" );
                    menuExportarDatos.exportarListaDeClientes(bancoPrintLine);
                    break;
                case 10:
                    //editar sobregiro de cuenta corriente
                    System.out.println("### EDITAR MONTO DE SOBREGIRO ###" );
                    Cliente clienteSeleccionadoSobregiro = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteSeleccionadoSobregiro != null){
                        cuentaServicio.verSaldo(clienteSeleccionadoSobregiro);
                        CuentaBancaria cuentaParaEditarSobregiro = menuClienteServicio.lecturaSeleccionarCuenta(clienteSeleccionadoSobregiro);
                        double nuevoSobregiro = 0;
                        if(cuentaParaEditarSobregiro != null) {
                            if(cuentaParaEditarSobregiro instanceof CuentaCorriente){
                                double sobregiro = menuCuentaCorrienteServicio.lecturaNuevoSobregiro();
                                nuevoSobregiro = sobregiro;
                            }
                            cuentaCorrienteServicio.editarSobregiro(cuentaParaEditarSobregiro, nuevoSobregiro);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 11:
                    //editar intereses de cuenta de ahorro
                    System.out.println("### EDITAR TASA DE INTERESES ###" );
                    Cliente clienteSeleccionadoIntereses = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteSeleccionadoIntereses != null) {
                        cuentaServicio.verSaldo(clienteSeleccionadoIntereses);
                        CuentaBancaria cuentaParaEditarIntereses = menuClienteServicio.lecturaSeleccionarCuenta(clienteSeleccionadoIntereses);
                        double nuevaTasaDeInteres = 0;
                        if(cuentaParaEditarIntereses != null) {
                            if(cuentaParaEditarIntereses instanceof CuentaDeAhorro){
                                double tasaDeInteres = menuCuentaDeAhorroServicio.lecturaNuevaTasaDeIntereses();
                                nuevaTasaDeInteres = tasaDeInteres;
                            }
                            cuentaDeAhorroServicio.editarIntereses(cuentaParaEditarIntereses, nuevaTasaDeInteres);
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                    break;
                case 12:
                    //generar intereses en cuenta de ahorro
                    System.out.println("### AGREGAR INTERESES A CUENTA ###" );
                    Cliente clienteSaldoConIntereses = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if (clienteSaldoConIntereses != null) {
                        cuentaServicio.verSaldo(clienteSaldoConIntereses);
                        CuentaBancaria cuentaParaSumarIntereses = menuClienteServicio.lecturaSeleccionarCuenta(clienteSaldoConIntereses);
                        if(cuentaParaSumarIntereses != null) {
                            cuentaDeAhorroServicio.SumarInteresesACuenta(cuentaParaSumarIntereses);
                        }
                    } else {
                        break;
                    }
                    break;
                default:
                    if(seleccion != 0){
                        System.out.println("### Opción inválida ###");
                        System.out.println("---------------------------------------------");
                        break;
                    }
            }
        } while (seleccion != 0);
        System.out.println("###### GRACIAS POR USAR BANCO PRINT-LINE #######");
    }
}
