package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class CuentaBancariaServicioImpl implements CuentaBancariaServicio {

    @Override
    public void verSaldo(Cliente cliente) {
        System.out.println("### VER SALDOS DE CLIENTE ###" );
        if(cliente != null){
            double saldoTotal = 0.0;
            System.out.println("---------------Saldos Cliente----------------" +
                    "\nID: "+ cliente.getId() + "| nombre: " + cliente.getNombre() +
                    "\nCuenta/s: ");
            for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
                saldoTotal += cuenta.getSaldo();
                System.out.println("ID: " + cuenta.getCuentaID() + " | tipo: " + cuenta.getTipo() +
                        " | saldo: " + cuenta.getSaldo());
                if (cuenta instanceof CuentaCorriente) {
                    System.out.println("Límite sobregiro : " + ((CuentaCorriente) cuenta).getLimiteSobregiro());
                } else if (cuenta instanceof CuentaDeAhorro) {
                    System.out.println("intereses: " + ((CuentaDeAhorro) cuenta).getIntereses());
                }
            }
            System.out.println("SALDO TOTAL: " + saldoTotal);
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("### cliente no encontrado ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void depositar(Cliente cliente){
        System.out.println("### DEPOSITAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        verSaldo(cliente);
        System.out.println("seleccione el ID de la cuenta para el deposito: ");
        int idCuenta = datos.nextInt();
        for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
            if(idCuenta != cuenta.getCuentaID()){
                //BUG: salta el print por mas que no se cumple la condiciooooon!! t.t
                System.out.println("### No existe cuenta elegida ###");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("ingrese el monto a depositar: ");
                double deposito = datos.nextDouble();
                cuenta.setSaldo(cuenta.getSaldo() + deposito);
                System.out.println("### Saldo cargado con éxito ### ");
                System.out.println("---------------------------------------------");

            }
        }

    }
    @Override
    public void retirar(Cliente cliente){
        System.out.println("### RETIRAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        verSaldo(cliente);
        System.out.println("seleccione el ID de la cuenta para el retiro: ");
        int idCuenta = datos.nextInt();
        for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
            if(idCuenta == cuenta.getCuentaID()){
                System.out.println("ingrese el monto a retirar: ");
                double retiro = datos.nextDouble();
                double nuevoSaldo = cuenta.getSaldo() - retiro;
                if(cuenta instanceof CuentaCorriente &&
                    nuevoSaldo < (((CuentaCorriente) cuenta).getLimiteSobregiro() * -1)){
                    System.out.println("retiro cancelado - El retiro excede el límite de sobregiro: "
                    + ((CuentaCorriente) cuenta).getLimiteSobregiro());
                    System.out.println("---------------------------------------------");
                } else {
                    cuenta.setSaldo(cuenta.getSaldo()-retiro);
                    System.out.println("### Saldo retirado con éxito ### ");
                    System.out.println("---------------------------------------------");
                    break;
                }
            } else {
                //BUG: salta el print iguaal!!
                System.out.println("### No existe cuenta elegida ###");
                System.out.println("---------------------------------------------");
            }
        }
    }

//    public CuentaBancaria obtenerCuentaCorriente(Cliente cliente) {
//        CuentaBancaria cuentaSeleccionada = null;
//        if (cliente != null) {
//            Scanner datos = new Scanner(System.in);
//            verSaldo(cliente);
//            System.out.println("seleccione el ID de la cuenta para el deposito: ");
//            int idCuenta = datos.nextInt();
//            for (CuentaBancaria cuenta : cliente.getCuentasBancarias()) {
//                if (idCuenta == cuenta.getCuentaID() && cuenta instanceof CuentaCorriente) {
//                    cuentaSeleccionada = cuenta;
//                } else {
//                    System.out.println("### No existe cuenta o no es tipo 'corriente'. ###");
//                    System.out.println("---------------------------------------------");
//                }
//            }
//        } else {
//            System.out.println("### No existe cliente elegida ###");
//            System.out.println("---------------------------------------------");
//        }
//        return cuentaSeleccionada;
//    }
}
