package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class CuentaDeAhorroServicioImpl implements CuentaDeAhorroServicio {
    @Override
    public CuentaDeAhorro editarIntereses(CuentaBancaria cuenta){
        CuentaDeAhorro cuentaEditada = new CuentaDeAhorro();
        cuentaEditada.setCuentaID(cuenta.getCuentaID());
        cuentaEditada.setTipo(cuenta.getTipo());
        cuentaEditada.setSaldo(cuenta.getSaldo());
        cuentaEditada.setTitular(cuenta.getTitular());
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el nuevo porcentaje de intereses: ");
        double intereses = datos.nextDouble();
        cuentaEditada.setIntereses(intereses);
        System.out.println("### porcentaje de intereses cambiado con éxito ###");
        System.out.println("---------------------------------------------");
        return cuentaEditada;
    }
    @Override
    public double generarIntereses(){
       return 0;
    }
}
