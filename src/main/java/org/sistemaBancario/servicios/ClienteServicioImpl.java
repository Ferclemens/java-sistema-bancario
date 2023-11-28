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
    public void agregarCuenta(Banco banco) {
        System.out.println("### AGREGAR CUENTA BANCARIA A CLIENTE EXISTENTE ###" );
        Scanner datos = new Scanner(System.in);
        banco.listarClientes();
        System.out.println("seleccione el ID del cliente para agregar una cuenta nueva: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado = null;
        for (Cliente cliente: banco.getClientes()) {
            if (cliente.getId() == id) {
                clienteSeleccionado = cliente;
            }
        }
        if(clienteSeleccionado == null){
            System.out.println("---------------------------------------------");
            System.out.println("### No existe cliente ###");
            System.out.println("---------------------------------------------");
        }
        if(clienteSeleccionado != null){
            System.out.println("Ingrese saldo en usd:");
            double saldo = datos.nextDouble();
            System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
            int eleccion = datos.nextInt();
            while(eleccion != 1 && eleccion != 2){
                System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
                System.out.println("1- Cuenta de ahorro\n2- Cuenta Corriente");
                eleccion = datos.nextInt();
            }
            if (eleccion == 2) {
                String tipo = "Cuenta Corriente";
                CuentaCorriente cuenta = new CuentaCorriente(proximaCuentaId(clienteSeleccionado), clienteSeleccionado, tipo, saldo, 0.0);
                System.out.println("Ingrese el límite de sobregiro en usd: ");
                double sobregiro = datos.nextDouble();
                cuenta.setLimiteSobregiro(sobregiro);
                clienteSeleccionado.getCuentasBancarias().add(cuenta);
            } else if (eleccion == 1) {
                String tipo = "Cuenta de ahorro";
                CuentaDeAhorro cuenta = new CuentaDeAhorro(proximaCuentaId(clienteSeleccionado), clienteSeleccionado, tipo, saldo, 0.0);
                System.out.println("Ingrese la tasa de intereses (%): ");
                double intereses = datos.nextDouble();
                cuenta.setIntereses(intereses);
                clienteSeleccionado.getCuentasBancarias().add(cuenta);
            }
            System.out.println("---------------------------------------------");
            System.out.println("### Cuenta nueva creada con éxito ###");
            System.out.println("---------------------------------------------");
        }
    }
    @Override
    public void eliminarCuenta(Banco banco) {
        System.out.println("### ELIMINAR CUENTA DE CLIENTE ###" );
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
