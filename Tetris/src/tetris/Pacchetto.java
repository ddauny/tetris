/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author iania_daniele
 */
public class Pacchetto {

    int stato, righe, malus;
    String nome, tipo;
    static char tipoConnessione;

    public Pacchetto(String p) {
        String[] v = p.split(";");
        if (v[0].equals("g")) { //pacchetto game       
            stato = Integer.parseInt(v[1]);
            righe = Integer.parseInt(v[2]);
            malus = Integer.parseInt(v[3]);
            tipo = "g";
        } else {
            nome = v[1];
            tipoConnessione = v[0].charAt(0);
        }
    }

    public String toString(Pacchetto p) {
        return "g" + p.stato + ";" + p.righe + ";" + p.malus;
    }
}
