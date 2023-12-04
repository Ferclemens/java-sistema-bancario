package org.sistemaBancario.servicios.serviciosCuentaCorriente;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;

public class CuentaCorrienteServicioImpl implements CuentaCorrienteServicio{
    @Override
    public void editarSobregiro(CuentaBancaria cuenta, double sobregiro){
        if(cuenta instanceof CuentaCorriente) {
            System.out.println("SOBREGIRO ACTUAL: " + ((CuentaCorriente) cuenta).getLimiteSobregiro());
            ((CuentaCorriente)cuenta).setLimiteSobregiro(sobregiro);
            System.out.println("---------------------------------------------");
            System.out.println("### sobregiro cambiado con éxito ###");
            System.out.println("### Nuevo monto sobregiro: "+ ((CuentaCorriente) cuenta).getLimiteSobregiro() + " usd ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("-------------------------------------------------------------");
            System.out.println("### cancelado - la cuenta no es del tipo Cuenta Corriente ###");
            System.out.println("-------------------------------------------------------------");
        }
    }
}
