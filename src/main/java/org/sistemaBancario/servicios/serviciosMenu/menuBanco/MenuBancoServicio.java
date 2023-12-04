package org.sistemaBancario.servicios.serviciosMenu.menuBanco;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.servicios.serviciosBanco.BancoServicioImpl;

public interface MenuBancoServicio {
    int proximoClienteId(Banco banco);
    Cliente lecturaClienteNuevo(Banco banco);
    Cliente lecturaSeleccionarCliente(Banco banco, BancoServicioImpl bancoServicio);
    Cliente lecturaClienteAEliminar(Banco banco, BancoServicioImpl bancoServicio);
}
