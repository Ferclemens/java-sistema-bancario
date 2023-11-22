package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;

public interface BancoServicios {
    void agregarCliente(Banco banco, Cliente cliente);

    void abrirCuenta(Banco banco);

    void exportarListaDeClientes(Banco banco);

    Cliente seleccionarCliente(Banco banco);
}
