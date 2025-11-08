/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// usamos estalibreria local datetime para poder utilizar la fecha y hora del momento
//usamos la libreria format dateformatter para poder dar formato a las horas y fechas
/**
 *
 * @author olger
 */
public class Transaccion {
    private LocalDateTime fecha;
    private String tipo;
    private int cuentaOrigen;
    private int cuentaDestino;
    private double monto;
    private String detalle;
    

    public Transaccion(String tipo, int cuentaOrigen, int cuentaDestino, double monto, String detalle) {
        this.fecha = LocalDateTime.now();
        this.tipo = tipo;
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
        this.detalle = detalle;
    }
   // metodo para realizar comprobante
    public String comprobante() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String texto = "===== FideBank - Comprobante =====\n";
        texto += "Fecha: " + fecha.format(f) + "\n";
        texto += "Tipo: " + tipo + "\n";
        if (cuentaOrigen != 0) texto += "Cuenta origen: " + cuentaOrigen + "\n";
        if (cuentaDestino != 0) texto += "Cuenta destino: " + cuentaDestino + "\n";
        texto += String.format("Monto: ₡%.2f\n", monto);
        if (detalle != null && !detalle.isEmpty()) texto += "Detalle: " + detalle + "\n";
        texto += "Gracias por usar FideBank\n";
        texto += "==================================";
        return texto;
    }

    public String corto() {
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("[%s] %s ₡%.2f (ori:%s des:%s)",
                fecha.format(f), tipo, monto,
                (cuentaOrigen == 0 ? "-" : String.valueOf(cuentaOrigen)),
                (cuentaDestino == 0 ? "-" : String.valueOf(cuentaDestino)));
    }
}
