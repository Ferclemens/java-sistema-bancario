package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;

public interface CuentaCorrienteServicio {

    void editarSobregiro(CuentaBancaria cuenta);
}
