package org.sistemaBancario.domain;


import org.sistemaBancario.domain.Cliente;

public class CuentaBancaria {
    private int cuentaID;
    private Cliente titular;
    private String tipo;
    private double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int cuentaID, Cliente titular, String tipo, double saldo) {
        this.cuentaID = cuentaID;
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public int getCuentaID() {
        return cuentaID;
    }
    public void setCuentaID(int cuentaID) {
        this.cuentaID = cuentaID;
    }
    public Cliente getTitular() {
        return titular;
    }
    public void setTitular(Cliente titular) {
        this.titular = titular;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}