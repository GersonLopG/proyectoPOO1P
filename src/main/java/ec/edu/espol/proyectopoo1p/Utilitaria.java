/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author andre
 */
public class Utilitaria {
    public static ArrayList<Ficha> crearManoJugador() {
        ArrayList<Ficha> mano = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int lado1 = generarNumeroAleatorio();
            int lado2 = generarNumeroAleatorio();
            Ficha ficha = new Ficha(lado1, lado2);
            mano.add(ficha);
        }

        FichaComodin fichaComodin = new FichaComodin();
        mano.add(fichaComodin);

        return mano;
    }


    public static int generarNumeroAleatorio() {
        Random rand = new Random();
        return rand.nextInt(6) +1;
    }
}
