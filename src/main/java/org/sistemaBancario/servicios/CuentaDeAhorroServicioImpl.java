package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.lang.reflect.Field;
import java.util.Scanner;

public class CuentaDeAhorroServicioImpl implements CuentaDeAhorroServicio {
    @Override
    public CuentaDeAhorro editarIntereses(CuentaBancaria cuenta){
        CuentaDeAhorro cuentaEditada = new CuentaDeAhorro();
        cuentaEditada.setCuentaID(cuenta.getCuentaID());
        cuentaEditada.setTipo(cuenta.getTipo());
        cuentaEditada.setSaldo(cuenta.getSaldo());
        cuentaEditada.setTitular(cuenta.getTitular());
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el nuevo porcentaje de intereses: ");
        double intereses = datos.nextDouble();
        cuentaEditada.setIntereses(intereses);
        System.out.println("--------------------------------------------------");
        System.out.println("### porcentaje de intereses cambiado con éxito ###");
        System.out.println("--------------------------------------------------");
        return cuentaEditada;
    }
    @Override
    public CuentaDeAhorro SumarInteresesACuenta(CuentaBancaria cuenta){
        //se utiliza reflexion (java.lang.reflect) para saber si cuenta tiene el
        //atributo "intereses" correspondiente a una clase hija (CuentaDeAhorro)
        //si es asi, se da accesibilidad a ese atributo (private) y lo guardo
        //en una variable para su posterior uso.
        double interesesDeCuenta = 0;
        try {
            //obtenemos el campo "intereses" en cuenta
            Field campo = cuenta.getClass().getDeclaredField("intereses");
            //lo hacemos accesible (campo tipo private)
            campo.setAccessible(true);
            //guardamos ese campo (tipo oBject) en una variable
            Object valor = campo.get(cuenta);
            //preguntamos si ese campo es instancia de Double, si es correcto
            //lo guardamos en la variable interesesDeCuenta para usarlo.
            if(valor instanceof Double){
                interesesDeCuenta = (Double) valor;
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
        CuentaDeAhorro cuentaEditada = new CuentaDeAhorro();
        cuentaEditada.setCuentaID(cuenta.getCuentaID());
        cuentaEditada.setTipo(cuenta.getTipo());
        cuentaEditada.setIntereses(interesesDeCuenta);
        double saldoConIntereses = cuenta.getSaldo() * (1 + interesesDeCuenta /100);
        cuentaEditada.setSaldo(saldoConIntereses);
        cuentaEditada.setTitular(cuenta.getTitular());
        System.out.println("---------------------------------------------");
        System.out.println("### Intereses sumados al saldo con éxito ###");
        System.out.println("---------------------------------------------");
        return cuentaEditada;
    }
}
