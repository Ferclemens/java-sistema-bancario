package org.sistemaBancario.domain;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public class CuentaCorriente extends CuentaBancaria {
    private double limiteSobregiro;
    private static final String tipo = "Cuenta corriente";

    public CuentaCorriente(int cuentaID, Cliente titular, String tipo, double saldo, double limiteSobregiro) {
        super(cuentaID, titular,tipo, saldo);
        this.limiteSobregiro = limiteSobregiro;
    }

    public double getLimiteSobregiro() {
        return limiteSobregiro;
    }

    public void setLimiteSobregiro(double limiteSobregiro) {
        this.limiteSobregiro = limiteSobregiro;
    }
    public String getTipo() {
        return tipo;
    }
    public void detalle() {
        System.out.println("Id:" + getCuentaID());
    }
    /*
     * sobregiro()
     * */
}
