package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface MenuBancoServicio {
    Cliente lecturaClienteNuevo(Banco banco, BancoServicioImpl bancoServicio);
    CuentaBancaria lecturaCuentaBancariaNueva(Cliente cliente, ClienteServicioImpl clienteServicio);
}
