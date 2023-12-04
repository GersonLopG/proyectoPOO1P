/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;

/**
 *
 * @author andre
 */
public class FichaComodin extends Ficha {
    
    public FichaComodin() {
        super(-1, -1);
    }

    @Override
    public void setLado1(int lado1) {
        super.setLado1(lado1);
    }

    
    @Override
    public void setLado2(int lado2) {
        super.setLado2(lado2);
    }

    @Override
    public String toString() {
        return "*" + super.toString() + "*";
    }
}