package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface MenuClienteServicio {
    CuentaBancaria lecturaCuentaBancariaNueva(Cliente cliente, ClienteServicioImpl clienteServicio);
}
