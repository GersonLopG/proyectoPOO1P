/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.proyectopoo1p;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author andre
 */
public class Juego {
    private ArrayList<Jugador> jugadores;
    private ArrayList<Ficha> lineaJuego;

    public Juego() {
        jugadores = new ArrayList<>();
        lineaJuego = new ArrayList<>();
    }

    public void agregarJugador(String nombre) {
        Jugador nuevoJugador = new Jugador(nombre, Utilitaria.crearManoJugador());
        jugadores.add(nuevoJugador);
    }

    public int obtenerValorInicioLinea() {
            return lineaJuego.get(0).getLado1();
    }

    public int obtenerValorFinLinea() {
            return lineaJuego.get(lineaJuego.size() - 1).getLado2();
    }

    public void mostrarLinea() {
        int totalFichas = lineaJuego.size();

        for (int i = 0; i < totalFichas; i++) {
            System.out.print(lineaJuego.get(i).toString());

            if (i < totalFichas - 1) {
                System.out.print(" - ");
            }
        }

        System.out.println();  
    }
    
    public boolean agregarFichaLinea(Ficha ficha, Jugador jugador) {
        Scanner scanner = new Scanner(System.in);

        if (!(ficha instanceof FichaComodin)) {
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(ficha);
                jugador.removerFicha(ficha); 
                return true;
            } 
            else {
                int inicioLinea = obtenerValorInicioLinea();
                int finLinea = obtenerValorFinLinea();

                if (ficha.getLado2() == inicioLinea) {
                    lineaJuego.add(0, ficha);
                    jugador.removerFicha(ficha); 
                    return true;
                } 
                else if (ficha.getLado1() == finLinea) {
                    lineaJuego.add(ficha);
                    jugador.removerFicha(ficha);
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            if (lineaJuego.isEmpty()) {
                lineaJuego.add(ficha);
                System.out.println("Ingrese el valor del lado1 de la ficha: ");
                int nuevoLado1 = scanner.nextInt();
                ficha.setLado1(nuevoLado1);
                System.out.println("Ingrese el valor del lado2 de la ficha: ");
                int nuevoLado2 = scanner.nextInt();
                ficha.setLado2(nuevoLado2);
                return true;
            } 
            else {
                System.out.println("Posición para agregar la ficha (Inicio o Fin): ");
                String posicion = scanner.nextLine();

                if ("Inicio".equals(posicion)) {
                    lineaJuego.add(0, ficha);
                    System.out.println("Ingrese el valor del lado1 de la ficha: ");
                    int nuevoLado1 = scanner.nextInt();
                    ficha.setLado1(nuevoLado1);
                    return true;
                } 
                else if ("Fin".equals(posicion)) {
                    lineaJuego.add(ficha);
                    System.out.println("Ingrese el valor del lado2 de la ficha: ");
                    int nuevoLado2 = scanner.nextInt();
                    ficha.setLado2(nuevoLado2);
                    return true;
                }
            }
        }

        return false; 
        
    }
    
    private String elegirAleatorioInicioFin() {
        Random random = new Random();
        int aleatorio = random.nextInt(2);
        if (aleatorio == 0) {
            return "Inicio";
        } 
        else {
            return "Fin";
        }
        
    }
    
    public void agregarFichaMaquina(JugadorMaquina maquina, ArrayList<Ficha> lineaJuego){
        ArrayList<Ficha> manoMaquina = maquina.getMano();
        int inicioLinea = obtenerValorInicioLinea();
        int finLinea = obtenerValorFinLinea();
        
        for (Ficha ficha: manoMaquina){    
            if (ficha.getLado2() == inicioLinea) {
                    lineaJuego.add(0, ficha);
                    maquina.removerFicha(ficha);
                    break;
            }
        }
        for (Ficha ficha: manoMaquina){    
            if (ficha.getLado1() == finLinea) {
                    lineaJuego.add( ficha);
                    maquina.removerFicha(ficha);
                    break;
            }
        }
        for (Ficha ficha : manoMaquina) {
            if (ficha instanceof FichaComodin) {
                String posicion = elegirAleatorioInicioFin();
                if ("Inicio".equals(posicion)) {
                lineaJuego.add(0, ficha);
                int nuevoLado1 = Utilitaria.generarNumeroAleatorio();
                    ficha.setLado1(nuevoLado1);
                } 
                else if ("Fin".equals(posicion)) {
                lineaJuego.add(ficha);
                int nuevoLado2 = Utilitaria.generarNumeroAleatorio();
                    ficha.setLado2(nuevoLado2);              
                }
            }
        }
    }
}
    
