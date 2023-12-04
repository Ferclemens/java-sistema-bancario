package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class MenuServicioImpl implements MenuServicio {
    public void desplegarMenu(){
        System.out.println("####### BIENVENIDOS AL BANCO PRINT-LINE ########");
        //inicializamos el banco y los servicios
        //Banco
        Banco bancoPrintLine = new Banco();
        //Servicios
        BancoServicioImpl bancoServicio = new BancoServicioImpl();
        ClienteServicioImpl clienteServicio = new ClienteServicioImpl();
        CuentaBancariaServicioImpl cuentaServicio = new CuentaBancariaServicioImpl();
        CuentaCorrienteServicioImpl cuentaCorrienteServicio = new CuentaCorrienteServicioImpl();
        CuentaDeAhorroServicioImpl cuentaDeAhorroServicio = new CuentaDeAhorroServicioImpl();
        //Servicios del menu
        MenuBancoServicioImpl menuBancoServicio = new MenuBancoServicioImpl();
        MenuClienteServicioImpl menuClienteServicio = new MenuClienteServicioImpl();
        MenuExportarDatosImpl menuExportarDatos = new MenuExportarDatosImpl();
        MenuCuentaBancariaServicioImpl menuCuentaBancariaServicio = new MenuCuentaBancariaServicioImpl();
        MenuCuentaCorrienteServicioImpl menuCuentaCorrienteServicio = new MenuCuentaCorrienteServicioImpl();
        MenuCuentaDeAhorroServicioImpl menuCuentaDeAhorroServicio = new MenuCuentaDeAhorroServicioImpl();
        //hardcode de clientes
        Cliente cliente1 = new Cliente(1,"Leo Messi","calle 123");
        bancoPrintLine.agregarCliente(cliente1);
        CuentaCorriente cuentaCliente1 = new CuentaCorriente(1,cliente1,"Cuenta corriente",2000,300.0);
        cliente1.agregarCuenta(cuentaCliente1);
        CuentaDeAhorro cuentaCliente2 = new CuentaDeAhorro(2,cliente1,"Cuenta de ahorro",8000,2.0);
        cliente1.agregarCuenta(cuentaCliente2);

        Cliente cliente2 = new Cliente(2,"Fernando Clemens","Calle 321");
        CuentaDeAhorro CuentaCliente3 = new CuentaDeAhorro(1,cliente2,"Cuenta de ahorro",2000, 5.0);
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
                    //Agregar cliente nuevo - test manual OK
                    System.out.println("### CREAR CUENTA BANCARIA ###");
                    Cliente clienteNuevo = menuBancoServicio.lecturaClienteNuevo(bancoPrintLine);
                    CuentaBancaria cuentaNueva = menuClienteServicio.lecturaCuentaBancariaNueva(clienteNuevo);
                    bancoServicio.agregarCliente(bancoPrintLine, clienteNuevo, cuentaNueva);
                    break;
                case 2:
                    //Agregar cuenta a cliente existente - test manual OK
                    System.out.println("### AGREGAR CUENTA BANCARIA A CLIENTE EXISTENTE ###" );
                    Cliente clienteParaAgregarCuenta = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    CuentaBancaria nuevaCuenta = menuClienteServicio.lecturaCuentaBancariaNueva(clienteParaAgregarCuenta);
                    clienteServicio.agregarCuenta(clienteParaAgregarCuenta, nuevaCuenta);
                    break;
                case 3:
                    //Listar clientes del banco - test manual OK
                    System.out.println("### LISTA DE CLIENTES ###" );
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    break;
                case 4:
                    //Ver saldo de cuentas de un cliente - test manual OK
                    System.out.println("### SALDO/S DE CUENTA/S DE CLIENTE/S ###" );
                    Cliente clienteParaVerSaldo = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    cuentaServicio.verSaldo(clienteParaVerSaldo);
                    break;
                case 5:
                    //Eliminar cliente - test manual OK
                    System.out.println("### ELIMINAR CLIENTE ###" );
                    Cliente clienteAEliminar = menuBancoServicio.lecturaClienteAEliminar(bancoPrintLine, bancoServicio);
                    bancoServicio.eliminarCliente(bancoPrintLine, clienteAEliminar);
                    break;
                case 6:
                    //Eliminar cuenta de cliente - test manual OK
                    System.out.println("### ELIMINAR CUENTA DE CLIENTE ###" );
                    Cliente clienteParaEliminarCuenta = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    CuentaBancaria cuentaAEliminar = menuClienteServicio.lecturaCuentaAEliminar(clienteParaEliminarCuenta);
                    clienteServicio.eliminarCuenta(bancoPrintLine, clienteParaEliminarCuenta, cuentaAEliminar);
                    break;
                case 7:
                    //Depositar
                    System.out.println("### DEPOSITAR SALDO EN CUENTA ###" );
                    Cliente clienteParaDepositar = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    if(clienteParaDepositar != null){
                        cuentaServicio.verSaldo(clienteParaDepositar);
                        CuentaBancaria cuentaParaDeposito = menuClienteServicio.seleccionarCuenta(clienteParaDepositar);
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
                        CuentaBancaria cuentaParaRetiro = menuClienteServicio.seleccionarCuenta(clienteParaRetiro);
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
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteSeleccionadoSobregiro = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    cuentaServicio.verSaldo(clienteSeleccionadoSobregiro);
                    CuentaBancaria cuentaParaEditarSobregiro = menuClienteServicio.seleccionarCuenta(clienteSeleccionadoSobregiro);
                    double nuevoSobregiro = menuCuentaCorrienteServicio.lecturaNuevoSobregiro();
                    cuentaCorrienteServicio.editarSobregiro(cuentaParaEditarSobregiro, nuevoSobregiro);
                    break;
                case 11:
                    //editar intereses de cuenta de ahorro
                    System.out.println("### EDITAR TASA DE INTERESES ###" );
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteSeleccionadoIntereses = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    cuentaServicio.verSaldo(clienteSeleccionadoIntereses);
                    CuentaBancaria cuentaParaEditarIntereses = menuClienteServicio.seleccionarCuenta(clienteSeleccionadoIntereses);
                    double nuevaTasaDeInteres = menuCuentaDeAhorroServicio.lecturaNuevaTasaDeIntereses();
                    cuentaDeAhorroServicio.editarIntereses(cuentaParaEditarIntereses, nuevaTasaDeInteres);
                    break;
                case 12:
                    //generar intereses en cuenta de ahorro
                    System.out.println("### AGREGAR INTERESES A CUENTA ###" );
                    bancoServicio.obtenerClientes(bancoPrintLine);
                    Cliente clienteSaldoConIntereses = menuBancoServicio.lecturaSeleccionarCliente(bancoPrintLine, bancoServicio);
                    cuentaServicio.verSaldo(clienteSaldoConIntereses);
                    CuentaBancaria cuentaParaSumarIntereses = menuClienteServicio.seleccionarCuenta(clienteSaldoConIntereses);
                    cuentaDeAhorroServicio.SumarInteresesACuenta(cuentaParaSumarIntereses);
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
