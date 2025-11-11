/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.appatm;
// se utiliza esta libreria para poder visualizar en cuadros de dialogo.
import javax.swing.*;
/**
 *
 * @author olger
 */
public class AppATM {
    public static Banco banco=new Banco();

    public static void main(String[] args) {
        VentanaInicio vNuevaVentana=new VentanaInicio();
        vNuevaVentana.setVisible(true);
       // Banco banco = new Banco();

        //primeros clientes creaddos 
        //banco.abrirCuentaCliente("Ana Gómez", "1234", 150000);
       // banco.abrirCuentaCliente("Luis Mora", "5678", 50000);
        
        //ciclo while para menu principal
//        while (true) {
//            String[] ops = {"1) Abrir cuenta", "2) Iniciar sesión", "3) Salir"};
//            int op = menu("FideBank - Sistema de Cajeros\nSeleccione una opción:", ops);
//
//            if (op == 0) abrirCuenta(banco);
//            else if (op == 1) login(banco);
//            else {
//                info("¡Gracias por usar FideBank!");
//                System.exit(0);
//            }
//        }
    
    //Metodo para abrir cuenta a cliente llamado desde elmenu
//    public static void abrirCuenta(Banco banco) {
//        //solicita nombre del cliente
//        String nombre = texto("Nombre del cliente:");
//        if (nombre == null) return;
//        String pin = texto("Cree un PIN (4 dígitos):");
//        //se utiliza pin.matches para verificar que el pin cumpla con las condiciones si no pasar al error
//        if (pin == null || !pin.matches("\\d{4}")) {
//            error("El PIN debe tener 4 dígitos.");
//            return;
//        }
//        //solicita monto inicial
//        double saldo = pedirMonto("Saldo inicial (₡):");
//        if (saldo < 0) return;
//        //creamos un cliente con los datos de la cuenta
//        Cliente cli = banco.abrirCuentaCliente(nombre, pin, saldo);
//        if (cli == null) {
//            error("No se pudo abrir la cuenta.");
//            return;
//        }
//        info("Cuenta creada:\nCliente: " + cli.getNombre() + "\nCuenta: " + cli.getNumeroCuenta());
    }
   //metodo llamado desde el menu para iniciar seccion
    

    // Métodos para utilizar JOptionPane se le dan los argumentos a utilizar
    private static int menu(String msg, String[] ops) {
        return JOptionPane.showOptionDialog(null, msg, "FideBank", JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, ops, ops[0]);
    }

    private static void info(String msg) {
        JOptionPane.showMessageDialog(null, msg, "FideBank", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void error(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private static String texto(String msg) {
        return JOptionPane.showInputDialog(null, msg, "FideBank", JOptionPane.QUESTION_MESSAGE);
    }

    private static double pedirMonto(String msg) {
        String s = texto(msg);
        if (s == null) return -1;
        try {
            double v = Double.parseDouble(s);
            if (v <= 0) {
                error("Debe ser mayor a 0.");
                return -1;
            }
            return v;
        } catch (NumberFormatException e) {
            error("Número inválido.");
            return -1;
        }
    }

    private static int pedirEntero(String msg) {
        String s = texto(msg);
        if (s == null) return -1;
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            error("Número inválido.");
            return -1;
        }
    }     
}
