package org.sistemaBancario.servicios.serviciosCuentaBancaria;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

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
        }
    }
    @Override
    public void depositar(CuentaBancaria cuenta, double deposito){
        if(cuenta != null){
            cuenta.setSaldo(cuenta.getSaldo() + deposito);
            System.out.println("---------------------------------------------");
            System.out.println("### Deposito realizado con éxito. ###");
            System.out.println("### Nuevo saldo: "+ cuenta.getSaldo() +" usd. ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### operacion cancelada - No existe cuenta con ese ID. ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void retirar(CuentaBancaria cuenta, double retiro){
        if (cuenta != null) {
            if(cuenta instanceof CuentaCorriente){
                double limiteCC = ((CuentaCorriente) cuenta).getLimiteSobregiro() + cuenta.getSaldo();
                //System.out.println("limite CC " + limiteCC);
                if(retiro > limiteCC){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Retiro cancelado - El retiro excede el límite: " + limiteCC
                            + " usd");
                    System.out.println("------------------------------------------------------------------");
                } else {
                    cuenta.setSaldo(cuenta.getSaldo() - retiro);
                    System.out.println("---------------------------------------------");
                    System.out.println("### Saldo retirado con éxito. ### ");
                    System.out.println("---------------------------------------------");
                }
            } else if (cuenta instanceof CuentaDeAhorro) {
                double limiteCA = cuenta.getSaldo();
                //System.out.println("limite CA " + limiteCA);
                if(retiro > limiteCA){
                    System.out.println("------------------------------------------------------------------");
                    System.out.println("Retiro cancelado - El retiro excede el saldo disponible: " + limiteCA
                            + " usd");
                    System.out.println("------------------------------------------------------------------");
                } else {
                    cuenta.setSaldo(cuenta.getSaldo() - retiro);
                    System.out.println("---------------------------------------------");
                    System.out.println("### Saldo retirado con éxito. ### ");
                    System.out.println("---------------------------------------------");
                }
            }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### operacion cancelada - No existe cuenta con ese ID. ###");
            System.out.println("---------------------------------------------");
        }
    }
}

