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
    String nome;
    char tipoConnessione;
    
    public Pacchetto() {
        stato = -100;//uso stato per sapere se il pacchetto è valido o no
        righe = 0;
        malus = 0;
        nome = "";
        tipoConnessione = 0;
    }

    public Pacchetto(int stato, int righe, int malus) {
        this.stato = stato;
        this.righe = righe;
        this.malus = malus;
        nome = "";
        tipoConnessione = 0;
    }
    
    public Pacchetto(String p){
        String[] v = p.split(";");
        stato = Integer.parseInt(v[0]);
        righe = Integer.parseInt(v[1]);
        malus = Integer.parseInt(v[2]);
        nome = "";
        tipoConnessione = 0;
    }
    
    public Pacchetto(String nome, char tipoConnessione){
        this.nome = nome;
        this.tipoConnessione = tipoConnessione;
    }    
    
    public String toString(Pacchetto p){
        return p.stato + ";" + p.righe + ";" + p.malus;
    }
}
