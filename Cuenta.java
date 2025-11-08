/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;

/**
 *
 * @author olger
 */
public class Cuenta {
     private int numero;
    private int idCliente;
    private double saldo;

    public Cuenta(int numero, int idCliente, double saldoInicial) {
        this.numero = numero;
        this.idCliente = idCliente;
        this.saldo = saldoInicial;
    }

    public int getNumero() {
        return numero;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
