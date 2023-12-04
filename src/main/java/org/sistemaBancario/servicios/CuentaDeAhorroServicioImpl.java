package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaDeAhorro;


import java.util.Scanner;

public class CuentaDeAhorroServicioImpl implements CuentaDeAhorroServicio {
    @Override
    public void editarIntereses(CuentaBancaria cuenta, double nuevaTasa){
        if(cuenta instanceof CuentaDeAhorro) {
            System.out.println("TASA INTERESES ACTUAL: " + ((CuentaDeAhorro)cuenta).getIntereses());
            ((CuentaDeAhorro)cuenta).setIntereses(nuevaTasa);
            System.out.println("---------------------------------------------");
            System.out.println("### Tasa de interes cambiada con éxito ###");
            System.out.println("### Nueva Tasa de interes: "+((CuentaDeAhorro)cuenta).getIntereses()+" % ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("### cancelado - la cuenta no es del tipo Cuenta de Ahorro ###");
            System.out.println("-------------------------------------------------------------");
        }
    }
    @Override
    public void SumarInteresesACuenta(CuentaBancaria cuenta){
        if(cuenta instanceof CuentaDeAhorro){
            double tasaIntereses = ((CuentaDeAhorro) cuenta).getIntereses();
            double saldoActual = cuenta.getSaldo();
            System.out.println("-------------------------------------------------------------");
            System.out.println("Saldo actual usd: " + saldoActual);
            System.out.println("intereses generados usd: " + saldoActual * ((tasaIntereses/100)));
            double saldoActualizado = saldoActual * (1+(tasaIntereses/100));
            System.out.println("Nuevo saldo usd: " + saldoActualizado);
            cuenta.setSaldo(saldoActualizado);
            System.out.println("-------------------------------------------------------------");
            System.out.println("### Intereses en cuenta generados con éxito ###");
            System.out.println("-------------------------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("### Cancelado - la cuenta no es del tipo Cuenta de Ahorro ###");
            System.out.println("-------------------------------------------------------------");
        }
    }
}

