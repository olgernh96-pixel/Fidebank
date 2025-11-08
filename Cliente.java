/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;

/**
 *
 * @author olger
 */
public class Cliente {
    private int id;
    private String nombre;
    private String pin;
    private int numeroCuenta;

    public Cliente(int id, String nombre, String pin, int numeroCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.pin = pin;
        this.numeroCuenta = numeroCuenta;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPin() {
        return pin;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }
}
