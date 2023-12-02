package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class ClienteServicioImpl implements ClienteServicio{
    //variable global para setear id's de CuentasBancarias de cliente
    public int ultimoIdCuenta = 0;
    public int proximaCuentaId(Cliente cliente) {
        System.out.println("ultimoId Cuenta = " + ultimoIdCuenta);
        int id = 0;
        int longitudArray = cliente.getCuentasBancarias().toArray().length;
        if(longitudArray > ultimoIdCuenta){
            ultimoIdCuenta = longitudArray + 1;
            id = ultimoIdCuenta;
        } else {
            ultimoIdCuenta = ultimoIdCuenta + 1;
            id = ultimoIdCuenta;
            System.out.println("NUEVO ultimoId Cuenta = " + ultimoIdCuenta);
        }
        return id;
    }
    @Override
    public void agregarCuenta(Cliente cliente, CuentaBancaria cuenta) {
        cliente.getCuentasBancarias().add(cuenta);
        System.out.println("---------------------------------------------");
        System.out.println("### Cuenta nueva creada con éxito ###");
        System.out.println("---------------------------------------------");
    }
    @Override
    public void eliminarCuenta(Banco banco) {
        Scanner datos = new Scanner(System.in);
        banco.listarClientes();
        System.out.println("seleccione el ID del cliente: ");
        int id = datos.nextInt();
        Cliente clienteParaEditarCuentas = null;
        for (Cliente cliente: banco.getClientes()) {
            if(cliente.getId() == id){
                clienteParaEditarCuentas = cliente;
            }
        }
        if(clienteParaEditarCuentas != null){
            System.out.println("---------------------Cuenta/s de " +clienteParaEditarCuentas.getNombre()
                    + "------------------------");
            for (CuentaBancaria cuentaPrint: clienteParaEditarCuentas.getCuentasBancarias() ) {
            System.out.println("ID: " + cuentaPrint.getCuentaID() + " | tipo: " + cuentaPrint.getTipo() +
                " | saldo: " + cuentaPrint.getSaldo());
            }
            System.out.println("seleccione el ID de la cuenta bancaria a eliminar: ");
            int cuentaId = datos.nextInt();
            CuentaBancaria cuentaAEliminar = null;
            for(CuentaBancaria cuenta: clienteParaEditarCuentas.getCuentasBancarias()){
                if (cuenta.getCuentaID() == cuentaId) {
                    cuentaAEliminar = cuenta;
                }
            }
            if(cuentaAEliminar != null) {
                clienteParaEditarCuentas.getCuentasBancarias().remove(cuentaAEliminar);
                System.out.println("---------------------------------------------");
                System.out.println("### cuenta eliminada con éxito ###");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("---------------------------------------------");
                System.out.println("### cuenta no encontrada ###");
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### cliente no existe ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public CuentaBancaria seleccionarCuenta(Cliente cliente) {
        CuentaBancaria cuentaSeleccionada = null;
        while (cuentaSeleccionada == null){
            Scanner datos = new Scanner(System.in);
            System.out.println("seleccione el ID de la cuenta: ");
            int id = datos.nextInt();
            for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
                if(cuenta.getCuentaID() == id){
                    cuentaSeleccionada = cuenta;
                }
            }
            if (cuentaSeleccionada == null) {
                System.out.println("no existe cuenta con ese ID, seleccione de nuevo.");
            }
        }
        return cuentaSeleccionada;
    }
}
