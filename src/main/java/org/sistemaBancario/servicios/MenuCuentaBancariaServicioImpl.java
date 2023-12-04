package org.sistemaBancario.servicios;

import org.sistemaBancario.domain.Cliente;
import org.sistemaBancario.domain.CuentaBancaria;
import org.sistemaBancario.domain.CuentaCorriente;
import org.sistemaBancario.domain.CuentaDeAhorro;

import java.util.Scanner;

public class MenuCuentaBancariaServicioImpl implements MenuCuentaBancariaServicio {
    @Override
    public double lecturaMontoParaDepositar(){
        double montoADepositar = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el monto (usd) a depositar: ");
        double deposito = datos.nextDouble();
        montoADepositar = deposito;
        return montoADepositar;
    }
    public double lecturaMontoParaRetirar(){
        double montoARetirar = 0;
        Scanner datos = new Scanner(System.in);
        System.out.println("ingrese el monto (usd) a retirar: ");
        double retiro = datos.nextDouble();
        montoARetirar = retiro;
        return montoARetirar;
    }

    /*@Override
    public double lecturaSaldoParaRetirar(Cliente cliente){
        System.out.println("### RETIRAR SALDO EN CUENTA ###" );
        Scanner datos = new Scanner(System.in);
        verSaldo(cliente);
        System.out.println("seleccione el ID de la cuenta para el retiro: ");
        int idCuenta = datos.nextInt();
        CuentaBancaria cuentaParaRetirar = null;
        for (CuentaBancaria cuenta: cliente.getCuentasBancarias()) {
            if(idCuenta == cuenta.getCuentaID()){
                cuentaParaRetirar = cuenta;
            }
        }
        if (cuentaParaRetirar != null) {
            System.out.println("ingrese el monto a retirar: ");
            double retiro = datos.nextDouble();
            double nuevoSaldo = cuentaParaRetirar.getSaldo() - retiro;
            if(cuentaParaRetirar instanceof CuentaCorriente &&
                    nuevoSaldo < (((CuentaCorriente) cuentaParaRetirar).getLimiteSobregiro() * -1)){
                System.out.println("------------------------------------------------------------------");
                System.out.println("Retiro cancelado - El retiro excede el saldo disponible: " + cuentaParaRetirar.getSaldo()
                        + " usd" + "\n + el límite de sobregiro: " + ((CuentaCorriente) cuentaParaRetirar).getLimiteSobregiro()
                        + " usd");
                System.out.println("------------------------------------------------------------------");
            } else if (cuentaParaRetirar instanceof CuentaDeAhorro && retiro > cuentaParaRetirar.getSaldo()) {
                System.out.println("------------------------------------------------------------------");
                System.out.println("Retiro cancelado - El retiro excede el saldo disponible: " + cuentaParaRetirar.getSaldo()
                        + " usd");
                System.out.println("------------------------------------------------------------------");
            } else {
                cuentaParaRetirar.setSaldo(cuentaParaRetirar.getSaldo()-retiro);
                System.out.println("---------------------------------------------");
                System.out.println("### Saldo retirado con éxito ### ");
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("---------------------------------------------");
            System.out.println("### No existe cuenta elegida ###");
            System.out.println("---------------------------------------------");
        }
    }*/
}
