package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface ClienteServicio {
    int proximaCuentaId(Cliente cliente);
    void agregarCuenta(Banco banco);
    void eliminarCuenta(Banco banco);
    CuentaBancaria seleccionarCuenta(Cliente cliente);

}
