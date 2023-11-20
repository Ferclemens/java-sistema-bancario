package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;

public interface Servicios {
    void agregarCliente(Cliente cliente);

    void abrirCuenta();

    void listarClientes();

    void agregarCuenta();

    void eliminarCuenta();

    void verSaldo();

    void depositar();

    void retirar();
}
