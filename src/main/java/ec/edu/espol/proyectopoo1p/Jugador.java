/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
public class Jugador {
    
    private String nombre;
    private ArrayList<Ficha> mano;

    public Jugador(String nombre, ArrayList<Ficha> mano) {
        this.nombre = nombre;
        this.mano = new ArrayList<>(mano);
    }

    public Ficha getFicha(int indice) {
        if (indice >= 0 && indice < mano.size()) {
            return mano.get(indice);
        } else {
            return null;
        }
    }

    public void removerFicha(Ficha ficha) {
        mano.remove(ficha);
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ficha> getMano() {
        return mano;
    }

    
    
    public void imprimirMano() {
        for (Ficha ficha : mano) {
            System.out.print(ficha.toString() + "-");
        }
        System.out.println();  
    }
    
}
