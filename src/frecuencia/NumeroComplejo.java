/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frecuencia;

/**
 *
 * @author fran_
 */
public class NumeroComplejo {
    private double real;
    private double imaginario;
    
    public NumeroComplejo(double real, double imaginario){
        this.real = real;
        this.imaginario = imaginario;
    }
    public NumeroComplejo(NumeroComplejo complejo){
        this(complejo.getParteReal(),complejo.getParteImaginario());
    }

    public double getParteReal() {
        return real;
    }

    public double getParteImaginario() {
        return imaginario;
    }
    public NumeroComplejo sumar(NumeroComplejo segundo){
        //optine la referencia del complejo
        NumeroComplejo primero = this;
        double real = primero.real + segundo.real;
        double imag = primero.imaginario + segundo.imaginario;
        return new NumeroComplejo(real,imag);
    }
    public NumeroComplejo product(double multiplicador){
        return new NumeroComplejo(real * multiplicador, imaginario * multiplicador);
    }
}
