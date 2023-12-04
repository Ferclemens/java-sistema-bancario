package org.sistemaBancario.servicios.serviciosCliente;

import org.sistemaBancario.domain.*;

public class ClienteServicioImpl implements ClienteServicio{
    @Override
    public void agregarCuenta(Cliente cliente, CuentaBancaria cuenta) {
        cliente.getCuentasBancarias().add(cuenta);
        System.out.println("---------------------------------------------");
        System.out.println("### Cuenta nueva creada con éxito ###");
        System.out.println("---------------------------------------------");
    }
    @Override
    public void eliminarCuenta(Banco banco,Cliente cliente, CuentaBancaria cuenta) {
        if(cuenta != null) {
            cliente.getCuentasBancarias().remove(cuenta);
            System.out.println("---------------------------------------------");
            System.out.println("### cuenta eliminada con éxito ###");
            System.out.println("---------------------------------------------");
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### cuenta no encontrada ###");
            System.out.println("---------------------------------------------");
        }
    }
}
