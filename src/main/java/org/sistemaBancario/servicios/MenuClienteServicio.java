package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface MenuClienteServicio {
    int proximaCuentaId(Cliente cliente);
    CuentaBancaria lecturaCuentaBancariaNueva(Cliente cliente);
    CuentaBancaria lecturaCuentaAEliminar(Cliente cliente);
    CuentaBancaria seleccionarCuenta(Cliente cliente);
}
