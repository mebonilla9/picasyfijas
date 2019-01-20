/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.appreactor.picasyfijas.negocio;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/**
 *
 * @author Lord_Nightmare
 */
public class Comparador {

    private final String palabraJuego;
    private String palabraComparar;

    public Comparador(String palabraJuego) {
        this.palabraJuego = palabraJuego;
    }

    /**
     * @return the palabraComparar
     */
    public String getPalabraComparar() {
        return palabraComparar;
    }

    /**
     * @param palabraComparar the palabraComparar to set
     */
    public void setPalabraComparar(String palabraComparar) {
        this.palabraComparar = palabraComparar;
    }

    public int obtenerPicas() {
        int contador = 0;
        Iterator<String> letras = new HashSet<>(Arrays.asList(palabraComparar.toLowerCase().split(Pattern.quote("")))).iterator();
        String[] letrasPalabras = palabraJuego.toLowerCase().split(Pattern.quote(""));
        while (letras.hasNext()) {
            String letra = letras.next();
            for (int i = 0; i < letrasPalabras.length; i++) {
                if (letra.equals(letrasPalabras[i])) {
                    contador++;
                    break;
                }
            }
        }
        return contador;
    }

    public int obtenerFijas() {
        int contador = 0;
        String[] letrasJuego = palabraJuego.toLowerCase().split(Pattern.quote(""));
        String[] letrasPalabra = palabraComparar.toLowerCase().split(Pattern.quote(""));
        int limite = letrasJuego.length > letrasPalabra.length ? letrasPalabra.length : letrasJuego.length;
        for (int i = 0; i < limite; i++) {
            if (letrasJuego[i].equals(letrasPalabra[i])) {
                contador++;
            }
        }
        return contador;
    }

}
