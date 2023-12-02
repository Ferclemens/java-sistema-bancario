package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class MenuClienteServicioImpl {
    public CuentaBancaria lecturaCuentaBancariaNueva(Cliente cliente, ClienteServicioImpl clienteServicio){
        CuentaBancaria cuenta = null;
        Scanner datos = new Scanner(System.in);
        System.out.println("Ingrese saldo en usd:");
        double saldo = datos.nextDouble();
        System.out.println("Seleccione tipo de cuenta:\n1- Cuenta de ahorro\n2- Cuenta Corriente");
        int eleccion = datos.nextInt();
        while(eleccion != 1 && eleccion != 2) {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta.");
            System.out.println("1- Cuenta de ahorro\n2- Cuenta Corriente");
            eleccion = datos.nextInt();
        }
        if( eleccion == 2){
            String tipo = "Cuenta Corriente";
            CuentaCorriente cuentaCorriente = new CuentaCorriente(clienteServicio.proximaCuentaId(cliente), cliente, tipo, saldo, 100.0);
            System.out.println("Ingrese el límite de sobregiro en usd: ");
            double sobregiro = datos.nextDouble();
            cuentaCorriente.setLimiteSobregiro(sobregiro);
            //cliente.getCuentasBancarias().add(cuenta);
            cuenta = cuentaCorriente;
        } else if ( eleccion == 1){
            String tipo = "Cuenta de ahorro";
            CuentaDeAhorro cuentaAhorro = new CuentaDeAhorro(clienteServicio.proximaCuentaId(cliente), cliente, tipo, saldo,5.0);
            System.out.println("Ingrese la tasa de intereses (%): ");
            double intereses = datos.nextDouble();
            cuentaAhorro.setIntereses(intereses);
            //cliente.getCuentasBancarias().add(cuenta);
            cuenta = cuentaAhorro;
        } else {
            System.out.println("Error. Seleccione una de las 2 opciones de cuenta: ");
        }
        return cuenta;
    }
}
