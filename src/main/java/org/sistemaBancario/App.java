package org.sistemaBancario;

import org.sistemaBancario.servicios.serviciosMenu.MenuServicioImpl;

public class App
{
    public static void main( String[] args ) {
        MenuServicioImpl menu = new MenuServicioImpl();
        menu.desplegarMenu();

        //WIP:
        //  (x)  REFACTORIZAR.
    }
}
