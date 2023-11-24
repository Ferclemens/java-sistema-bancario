package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class ClienteServicioImpl implements ClienteServicio{
    @Override
    public void agregarCuenta(Banco banco) {
        System.out.println("### AGREGAR CUENTA BANCARIA A CLIENTE EXISTENTE ###" );
        Scanner datos = new Scanner(System.in);
        banco.listarClientes();
        System.out.println("seleccione el ID del cliente para agregar una cuenta nueva: ");
        int id = datos.nextInt();
        Cliente clienteSeleccionado;
        for (Cliente cliente: banco.getClientes()) {
            if(cliente.getId() != id){
                System.out.println("No existe cliente");
                System.out.println("---------------------------------------------");
            } else {
                clienteSeleccionado = cliente;
                System.out.println("Ingrese saldo:");
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
                    CuentaCorriente cuenta = new CuentaCorriente(cliente.proximaCuentaId(), clienteSeleccionado, tipo, saldo, 0.0);
                    System.out.println("Ingrese el límite de sobregiro: ");
                    double sobregiro = datos.nextDouble();
                    cuenta.setLimiteSobregiro(sobregiro);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                } else if (eleccion == 1) {
                    String tipo = "Cuenta de ahorro";
                    CuentaDeAhorro cuenta = new CuentaDeAhorro(cliente.proximaCuentaId(), clienteSeleccionado, tipo, saldo, 0.0);
                    System.out.println("Ingrese el porcentaje de intereses: ");
                    double intereses = datos.nextDouble();
                    cuenta.setIntereses(intereses);
                    clienteSeleccionado.getCuentasBancarias().add(cuenta);
                }
                System.out.println("--------------------------------------------------");
            }
        }
        System.out.println("### Cuenta nueva creada con éxito ###");
        System.out.println("---------------------------------------------");
    }



    @Override
    public void eliminarCuenta(Banco banco) {
        System.out.println("### ELIMINAR CUENTA DE CLIENTE ###" );
        Scanner datos = new Scanner(System.in);
        banco.listarClientes();
        System.out.println("seleccione el ID del cliente: ");
        int id = datos.nextInt();
        CuentaBancaria cuentaAEliminar = null;
        for (Cliente cliente: banco.getClientes()) {
            if(cliente.getId() != id){
                System.out.println("### cliente no encontrado ###");
                System.out.println("---------------------------------------------");
            } else {
                System.out.println("seleccione el ID de la cuenta bancaria a eliminar: ");
                int cuentaId = datos.nextInt();
                for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
                    if (cuenta.getCuentaID() != cuentaId){
                        //BUG: salta este print por mas que el id coincida (true)
                        System.out.println("### cuenta no encontrada ###");
                        System.out.println("---------------------------------------------");
                    } else {
                        cuentaAEliminar = cuenta;
                    }
                }
                cliente.getCuentasBancarias().remove(cuentaAEliminar);
                System.out.println("### cuenta eliminada con éxito ###");
                System.out.println("---------------------------------------------");
            }
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
                } else {
                    System.out.println("no existe cuenta con ese ID, seleccione de nuevo.");
                }
            }
        }
        return cuentaSeleccionada;
    }
}
