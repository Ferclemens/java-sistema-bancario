package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;

public interface MenuBancoServicio {
    int proximoClienteId(Banco banco);
    Cliente lecturaClienteNuevo(Banco banco);
    Cliente lecturaSeleccionarCliente(Banco banco, BancoServicioImpl bancoServicio);
    Cliente lecturaClienteAEliminar(Banco banco, BancoServicioImpl bancoServicio);
}
