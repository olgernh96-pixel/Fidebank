/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.appatm;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;


/**
 *
 * @author olger
 */
public class MiObjectOutputStream extends ObjectOutputStream {
    public MiObjectOutputStream(OutputStream Out)throws IOException{
        super(Out);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }
}
