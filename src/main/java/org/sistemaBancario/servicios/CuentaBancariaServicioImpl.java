package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class CuentaBancariaServicioImpl implements CuentaBancariaServicio {

    @Override
    public void verSaldo(Cliente cliente) {
        if(cliente != null){
            double saldoTotal = 0.0;
            System.out.println("----------- Saldo/s de cuenta/s de " + cliente.getNombre() + " -----------" +
                    "\nCUENTA/S: ");
            System.out.println("---------------------------------------------");
            for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
                saldoTotal += cuenta.getSaldo();
                System.out.println("ID: " + cuenta.getCuentaID() + " | tipo: " + cuenta.getTipo() +
                        " | saldo usd: " + cuenta.getSaldo());
                if (cuenta instanceof CuentaCorriente) {
                    System.out.println("Límite sobregiro : " + ((CuentaCorriente) cuenta).getLimiteSobregiro());
                    System.out.println("---------------------------------------------");
                } else if (cuenta instanceof CuentaDeAhorro) {
                    System.out.println("intereses: " + ((CuentaDeAhorro) cuenta).getIntereses());
                    System.out.println("---------------------------------------------");
                }
            }
            System.out.println("SALDO TOTAL USD: " + saldoTotal);
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### cliente no encontrado ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void depositar(CuentaBancaria cuenta, double deposito){
        if(cuenta != null){
            cuenta.setSaldo(cuenta.getSaldo() + deposito);
            System.out.println("---------------------------------------------");
            System.out.println("### Deposito realizado con éxito. ###");
            System.out.println("### Nuevo saldo (usd): "+ cuenta.getSaldo() +"###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### No existe cuenta elegida ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void retirar(Cliente cliente){
        System.out.println("### RETIRAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        verSaldo(cliente);
        System.out.println("seleccione el ID de la cuenta para el retiro: ");
        int idCuenta = datos.nextInt();
        CuentaBancaria cuentaParaRetirar = null;
        for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
            if(idCuenta == cuenta.getCuentaID()){
                cuentaParaRetirar = cuenta;
            }
        }
        if (cuentaParaRetirar != null) {
            System.out.println("ingrese el monto a retirar: ");
            double retiro = datos.nextDouble();
            double nuevoSaldo = cuentaParaRetirar.getSaldo() - retiro;
            if(cuentaParaRetirar instanceof CuentaCorriente &&
                    nuevoSaldo < (((CuentaCorriente) cuentaParaRetirar).getLimiteSobregiro() * -1)){
                System.out.println("------------------------------------------------------------------");
                System.out.println("Retiro cancelado - El retiro excede el saldo disponible: " + cuentaParaRetirar.getSaldo()
                        + " usd" + "\n + el límite de sobregiro: " + ((CuentaCorriente) cuentaParaRetirar).getLimiteSobregiro()
                        + " usd");
                System.out.println("------------------------------------------------------------------");
                } else if (cuentaParaRetirar instanceof CuentaDeAhorro && retiro > cuentaParaRetirar.getSaldo()) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Retiro cancelado - El retiro excede el saldo disponible: " + cuentaParaRetirar.getSaldo()
                        + " usd");
                System.out.println("------------------------------------------------------------------");
            } else {
                    cuentaParaRetirar.setSaldo(cuentaParaRetirar.getSaldo()-retiro);
                    System.out.println("---------------------------------------------");
                    System.out.println("### Saldo retirado con éxito ### ");
                    System.out.println("---------------------------------------------");
                }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### No existe cuenta elegida ###");
            System.out.println("---------------------------------------------");
        }
    }
}

