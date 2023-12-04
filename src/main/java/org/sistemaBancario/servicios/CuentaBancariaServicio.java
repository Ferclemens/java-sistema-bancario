package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;

public interface CuentaBancariaServicio {
    void verSaldo(Cliente cliente);
    void depositar(CuentaBancaria cuenta, double deposito);
    void retirar(CuentaBancaria cuenta, double retiro);

}
