package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaDeAhorro;

public interface CuentaDeAhorroServicio {
    CuentaDeAhorro editarIntereses(CuentaBancaria cuenta);

    double generarIntereses();
}
