package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Banco;

public interface ClienteServicio {
    void agregarCuenta(Banco banco);
    void eliminarCuenta(Banco banco);

}
