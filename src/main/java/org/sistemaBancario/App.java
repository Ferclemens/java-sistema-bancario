package org.sistemaBancario;

import org.sistemaBancario.servicios.*;

public class App
{
    public static void main( String[] args ) {
        MenuServicioImpl menu = new MenuServicioImpl();
        menu.desplegarMenu();

        //WIP:
        //  (x)  Elaborar el README
        //  (x)  que sea editable intereses y sobregiro
        //  (x)  aplicar intereses
        //  (x)  funcion exportar CSV
        //  (x)  aplicar interfaces
        //  (x)  BUG: IDs de cuentas se pisa al eliminar un cliente.
        //  (x)  BUG: se dispara el else en varios if de selección.
        //  (x)  REFACTORIZAR.
        //  (x)  Hacer editable el destino del exportable (CSV).
    }
}
