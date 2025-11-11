/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.io.ObjectOutputStream;


/**
 *
 * @author olger
 */
public class GuardarArchivo{
    
    public static void Guardar(Cliente cli){
        try {
            File archivo = new File("Usuarios.contact");
            boolean exis = archivo.exists()&& archivo.length()>0;
            
            FileOutputStream miArchivo = new FileOutputStream(archivo,true);
            ObjectOutputStream Output;
            
            if(exis){
                Output= new MiObjectOutputStream(miArchivo);   
            }else{
                Output= new ObjectOutputStream(miArchivo);
            }
            Output.writeObject(cli);
            Output.close();
            miArchivo.close();
            System.out.print("Cliente resgistardo correctamente");
        } catch (IOException ex) {
            System.out.println("Error al guardar" + ex.getMessage());
        }   
    }
}
