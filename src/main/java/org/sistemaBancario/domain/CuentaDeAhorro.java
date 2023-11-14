package org.sistemaBancario.domain;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public class CuentaDeAhorro extends CuentaBancaria {
    private double intereses;

    private static final String tipo = "Cuenta de ahorro";

    public CuentaDeAhorro(int cuentaID, Cliente titular, String tipo, double saldo, double intereses) {
        super(cuentaID, titular, tipo, saldo);
        this.intereses = intereses;
    }

    public double getIntereses() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses = intereses;
    }
    public String getTipo() {
        return tipo;
    }
    /*
    * interesesGenerados()
    * */
}
