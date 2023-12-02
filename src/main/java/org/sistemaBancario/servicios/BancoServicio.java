package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface BancoServicio {
    void agregarCliente(Banco banco,Cliente cliente, CuentaBancaria cuenta);
    void eliminarCliente(Banco banco, Cliente cliente);
    Cliente seleccionarCliente(Banco banco);
}
