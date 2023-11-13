package org.sistemaBancario.CuentaBancaria;


import org.sistemaBancario.Cliente.Cliente;

public class CuentaBancaria {
    int cuentaID;
    Cliente titular;
    double saldo;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int cuentaID, Cliente titular, double saldo) {
        this.cuentaID = cuentaID;
        this.titular = titular;
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

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /*
    * depositar()
    * retirar()
    * verSaldo()
    * */
}