package org.sistemaBancario.servicios.serviciosCuentaDeAhorro;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaDeAhorro;

public interface CuentaDeAhorroServicio {
    void editarIntereses(CuentaBancaria cuenta, double nuevaTasa);

    void SumarInteresesACuenta(CuentaBancaria cuenta);
}
