package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;

import java.util.Scanner;

public class CuentaCorrienteServicioImpl implements CuentaCorrienteServicio{
    @Override
    public CuentaCorriente cambiarSobregiro(CuentaBancaria cuenta){
        CuentaCorriente cuentaEditada = new CuentaCorriente();
        cuentaEditada.setCuentaID(cuenta.getCuentaID());
        cuentaEditada.setTipo(cuenta.getTipo());
        cuentaEditada.setSaldo(cuenta.getSaldo());
        cuentaEditada.setTitular(cuenta.getTitular());
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el nuevo monto de sobregiro: ");
        double sobregiro = datos.nextDouble();
        cuentaEditada.setLimiteSobregiro(sobregiro);
        return cuentaEditada;
    }
}
