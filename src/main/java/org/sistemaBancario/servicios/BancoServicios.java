package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;
import org.sistemaBancario.domain.Cliente;

public interface BancoServicios {

    void abrirCuenta(Banco banco);

    void eliminarCuenta(Banco banco);

    void exportarListaDeClientes(Banco banco);

    Cliente seleccionarCliente(Banco banco);
}
