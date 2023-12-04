package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaDeAhorro;

public interface CuentaDeAhorroServicio {
    void editarIntereses(CuentaBancaria cuenta, double nuevaTasa);

    void SumarInteresesACuenta(CuentaBancaria cuenta);
}
