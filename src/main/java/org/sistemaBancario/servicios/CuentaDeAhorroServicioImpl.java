package org.sistemaBancario.servicios;

import java.util.Scanner;

public class CuentaDeAhorroServicioImpl implements CuentaDeAhorroServicio {
    @Override
    public double intereses(){
        Scanner datos = new Scanner(System.in);
        System.out.println("porcentaje de intereses por mantener la cuenta de ahorro: ");
        double intereses = datos.nextDouble();
        return intereses;
    }
    @Override
    public double generarIntereses(){
       return 0;
    }
}
