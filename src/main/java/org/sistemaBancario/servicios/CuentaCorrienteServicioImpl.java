package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;

import java.util.Scanner;

public class CuentaCorrienteServicioImpl implements CuentaCorrienteServicio{
    @Override
    public void editarSobregiro(CuentaBancaria cuenta){
        if(cuenta instanceof CuentaCorriente) {
            System.out.println("SOBREGIRO ACTUAL: " + ((CuentaCorriente)cuenta).getLimiteSobregiro());
            Scanner datos = new Scanner(System.in);
            System.out.println("ingrese el nuevo monto de sobregiro: ");
            double sobregiro = datos.nextDouble();
            ((CuentaCorriente)cuenta).setLimiteSobregiro(sobregiro);
            System.out.println("---------------------------------------------");
            System.out.println("### sobregiro cambiado con éxito ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("### cancelado - la cuenta no es del tipo Cuenta Corriente ###");
            System.out.println("-------------------------------------------------------------");
        }
    }
}
