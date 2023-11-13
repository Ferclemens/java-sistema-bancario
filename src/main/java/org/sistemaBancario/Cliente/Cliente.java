package org.sistemaBancario.Cliente;

import java.util.List;
import org.sistemaBancario.CuentaBancaria.CuentaBancaria;
public class Cliente {
    String nombre;
    String direccion;
    List<CuentaBancaria> cuentas;

    public Cliente() {
    }

    public Cliente(String nombre, String direccion, List<CuentaBancaria> cuentasBancarias) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.cuentas = cuentasBancarias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<CuentaBancaria> getCuentasBancarias() {
        return cuentas;
    }

    public void setCuentasBancarias(List<CuentaBancaria> cuentasBancarias) {
        this.cuentas = cuentasBancarias;
    }

    /*
    * agregarCuenta()
    * eliminarCuenta()
    * verSaldo()
    * */
}
