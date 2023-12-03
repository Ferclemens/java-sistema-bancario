package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class MenuClienteServicioImpl implements MenuClienteServicio {
    //variable global para setear id's de CuentasBancarias de cliente
    public int ultimoIdCuenta = 0;
    @Override
    public int proximaCuentaId(Cliente cliente) {
        System.out.println("ultimoId Cuenta = " + ultimoIdCuenta);
        int id = 0;
        int longitudArray = cliente.getCuentasBancarias().toArray().length;
        if(longitudArray > ultimoIdCuenta){
            ultimoIdCuenta = longitudArray + 1;
            id = ultimoIdCuenta;
        } else {
            ultimoIdCuenta = ultimoIdCuenta + 1;
            id = ultimoIdCuenta;
            System.out.println("NUEVO ultimoId Cuenta = " + ultimoIdCuenta);
        }
        return id;
    }
    @Override
    public CuentaBancaria lecturaCuentaBancariaNueva(Cliente cliente){
        CuentaBancaria cuentaNueva = null;
        Scanner datos = new Scanner(System.in);
        System.out.println("Ingrese saldo en usd:");
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
            CuentaCorriente cuentaCorriente = new CuentaCorriente(proximaCuentaId(cliente), cliente, tipo, saldo, 100.0);
            System.out.println("Ingrese el límite de sobregiro en usd: ");
            double sobregiro = datos.nextDouble();
            cuentaCorriente.setLimiteSobregiro(sobregiro);
            //cliente.getCuentasBancarias().add(cuenta);
            cuentaNueva = cuentaCorriente;
        } else if ( eleccion == 1){
            String tipo = "Cuenta de ahorro";
            CuentaDeAhorro cuentaAhorro = new CuentaDeAhorro(proximaCuentaId(cliente), cliente, tipo, saldo,5.0);
            System.out.println("Ingrese la tasa de intereses (%): ");
            double intereses = datos.nextDouble();
            cuentaAhorro.setIntereses(intereses);
            //cliente.getCuentasBancarias().add(cuenta);
            cuentaNueva = cuentaAhorro;
        } else {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta: ");
        }
        return cuentaNueva;
    }
    @Override
    public CuentaBancaria lecturaCuentaAEliminar(Cliente cliente){
        CuentaBancaria cuentaAEliminar = null;
        Scanner datos = new Scanner(System.in);
        if(cliente != null){
            System.out.println("---------------------Cuenta/s de " + cliente.getNombre()
                    + "------------------------");
            for (CuentaBancaria cuenta: cliente.getCuentasBancarias() ) {
                System.out.println("ID: " + cuenta.getCuentaID() + " | tipo: " + cuenta.getTipo() +
                        " | saldo: " + cuenta.getSaldo());
            }
            System.out.println("seleccione el ID de la cuenta bancaria a eliminar: ");
            int cuentaId = datos.nextInt();
            for(CuentaBancaria cuenta: cliente.getCuentasBancarias()){
                if (cuenta.getCuentaID() == cuentaId) {
                    cuentaAEliminar = cuenta;
                }
            }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### cliente no existe ###");
            System.out.println("---------------------------------------------");
        }
        return cuentaAEliminar;
    }
    @Override
    public CuentaBancaria seleccionarCuenta(Cliente cliente) {
        CuentaBancaria cuentaSeleccionada = null;
        while (cuentaSeleccionada == null){
            Scanner datos = new Scanner(System.in);
            System.out.println("seleccione el ID de la cuenta: ");
            int id = datos.nextInt();
            for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
                if(cuenta.getCuentaID() == id){
                    cuentaSeleccionada = cuenta;
                }
            }
            if (cuentaSeleccionada == null) {
                System.out.println("no existe cuenta con ese ID, seleccione de nuevo.");
            }
        }
        return cuentaSeleccionada;
    }
}
