/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;

/**
 *
 * @author olger
 */
public class Banco {
    //con los atributos con private solo se puede usar dentro de la clase banco
    //con static hacemos que la variable pertenezca a la clase y no al objeto compartida con todos los objetos
    //con final hacemos que la variable se convierta en una constante y no puede ser modidificado
    private static final int MAX_CLIENTES = 100;
    private static final int MAX_CUENTAS = 100;
    private static final int MAX_TRANSACCIONES = 1000;

    private Cliente[] clientes = new Cliente[MAX_CLIENTES];
    private Cuenta[] cuentas = new Cuenta[MAX_CUENTAS];
    private Transaccion[] trans = new Transaccion[MAX_TRANSACCIONES];

    private int clientesUsados = 0;
    private int cuentasUsadas = 0;
    private int transUsadas = 0;

    private int secCliente = 1;
    private int secCuenta = 1001;

    // Creamos cliente y su cuenta 
    public Cliente abrirCuentaCliente(String nombre, String pin, double saldoInicial) {
        if (clientesUsados >= MAX_CLIENTES || cuentasUsadas >= MAX_CUENTAS) return null;

        int id = secCliente++;
        int numeroCuenta = secCuenta++;

        Cuenta c = new Cuenta(numeroCuenta, id, saldoInicial);
        cuentas[cuentasUsadas++] = c;

        Cliente cli = new Cliente(id, nombre, pin, numeroCuenta);
        clientes[clientesUsados++] = cli;

        registrar(new Transaccion("APERTURA", 0, numeroCuenta, saldoInicial, "Apertura de cuenta"));
        return cli;
    }

    // metod para buscar cliente por PIN
    public Cliente autenticarPorPin(String pin) {
        for (int i = 0; i < clientesUsados; i++) {
            if (clientes[i].getPin().equals(pin)) return clientes[i];
        }
        return null;
    }

    // metodo para buscar cuenta por número
    public Cuenta buscarCuentaPorNumero(int numero) {
        for (int i = 0; i < cuentasUsadas; i++) {
            if (cuentas[i].getNumero() == numero) return cuentas[i];
        }
        return null;
    }

    // metodos para transacciones 
    public boolean depositar(int numeroCuenta, double monto) {
        Cuenta c = buscarCuentaPorNumero(numeroCuenta);
        if (c == null || monto <= 0) return false;
        c.setSaldo(c.getSaldo() + monto);
        registrar(new Transaccion("DEPOSITO", 0, numeroCuenta, monto, "Depósito en efectivo"));
        return true;
    }

    public boolean retirar(int numeroCuenta, double monto) {
        Cuenta c = buscarCuentaPorNumero(numeroCuenta);
        if (c == null || monto <= 0) return false;
        if (c.getSaldo() < monto) return false;
        c.setSaldo(c.getSaldo() - monto);
        registrar(new Transaccion("RETIRO", numeroCuenta, 0, monto, "Retiro en cajero"));
        return true;
    }

    public boolean transferir(int origen, int destino, double monto) {
        if (origen == destino) return false;
        Cuenta cOri = buscarCuentaPorNumero(origen);
        Cuenta cDes = buscarCuentaPorNumero(destino);
        if (cOri == null || cDes == null || monto <= 0) return false;
        if (cOri.getSaldo() < monto) return false;

        cOri.setSaldo(cOri.getSaldo() - monto);
        cDes.setSaldo(cDes.getSaldo() + monto);
        registrar(new Transaccion("TRANSFERENCIA", origen, destino, monto, "Transferencia entre cuentas"));
        return true;
    }

    // Registro de transacciones
    private void registrar(Transaccion t) {
        if (transUsadas < MAX_TRANSACCIONES) trans[transUsadas++] = t;
    }

    // Últimos movimientos
    public String ultimasTransCuenta(int numeroCuenta, int limite) {
        StringBuilder sb = new StringBuilder();
        int cont = 0;
        for (int i = transUsadas - 1; i >= 0 && cont < limite; i--) {
            Transaccion t = trans[i];
            if (t == null) continue;
            if (t.corto().contains(String.valueOf(numeroCuenta))) {
                sb.append(t.corto()).append("\n");
                cont++;
            }
        }
        if (cont == 0) sb.append("(Sin transacciones)\n");
        return sb.toString();
    }
}
