package org.sistemaBancario.servicios.serviciosMenu.menuCuentaCorriente;

import java.util.Scanner;

public class MenuCuentaCorrienteServicioImpl implements MenuCuentaCorrienteServicio {
    @Override
    public double lecturaNuevoSobregiro() {
        double nuevoSobregiro = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el nuevo monto de sobregiro: ");
        double sobregiro = datos.nextDouble();
        nuevoSobregiro = sobregiro;
        return nuevoSobregiro;
    }
}
