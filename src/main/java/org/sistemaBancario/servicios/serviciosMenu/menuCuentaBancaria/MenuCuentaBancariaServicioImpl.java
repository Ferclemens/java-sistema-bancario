package org.sistemaBancario.servicios.serviciosMenu.menuCuentaBancaria;

import java.util.Scanner;

public class MenuCuentaBancariaServicioImpl implements MenuCuentaBancariaServicio {
    @Override
    public double lecturaMontoParaDepositar(){
        double montoADepositar = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el monto (usd) a depositar: ");
        double deposito = datos.nextDouble();
        montoADepositar = deposito;
        return montoADepositar;
    }
    @Override
    public double lecturaMontoParaRetirar(){
        double montoARetirar = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el monto (usd) a retirar: ");
        double retiro = datos.nextDouble();
        montoARetirar = retiro;
        return montoARetirar;
    }
}
