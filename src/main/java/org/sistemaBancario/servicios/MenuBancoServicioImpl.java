package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.*;

import java.util.Scanner;

public class MenuBancoServicioImpl implements MenuBancoServicio {
    public Cliente lecturaClienteNuevo(Banco banco, BancoServicioImpl bancoServicio) {
        Scanner datos = new Scanner(System.in);
        System.out.println("### CREAR CUENTA BANCARIA ###");
        System.out.println("Ingrese nombre:");
        String nombre = datos.nextLine();
        System.out.println("Ingrese dirección:");
        String direccion = datos.nextLine();
        Cliente cliente = new Cliente(bancoServicio.proximoClienteId(banco), nombre, direccion);
        return cliente;
    }

}
