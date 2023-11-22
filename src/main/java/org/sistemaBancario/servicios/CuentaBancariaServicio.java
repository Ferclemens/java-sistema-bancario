package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;

public interface CuentaBancariaServicio {
    void verSaldo(Cliente cliente);
    void depositar(Cliente cliente);
    void retirar(Cliente cliente);
}
