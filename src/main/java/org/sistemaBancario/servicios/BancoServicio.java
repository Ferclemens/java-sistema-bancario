package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;

public interface BancoServicio {

    void agregarCliente(Banco banco, ClienteServicioImpl clienteServicio);

    void eliminarCliente(Banco banco);

    void exportarListaDeClientes(Banco banco);

    Cliente seleccionarCliente(Banco banco);
}
