package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class MenuCuentaDeAhorroServicioImpl implements MenuCuentaDeAhorroServicio{
    @Override
    public double lecturaNuevaTasaDeIntereses(){
        double nuevaTasa = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese la nueva tasa de intereses (%): ");
        double tasaIntereses = datos.nextDouble();
        nuevaTasa = tasaIntereses;
        return nuevaTasa;
    }
}
