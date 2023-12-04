package org.sistemaBancario.servicios.serviciosCliente;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface ClienteServicio {
    void agregarCuenta(Cliente cliente, CuentaBancaria cuenta);
    void eliminarCuenta(Banco banco,Cliente cliente, CuentaBancaria cuenta);

}
