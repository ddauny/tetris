/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.ArrayList;

/**
 *
 * @author iania_daniele
 */
public class Buffer {

    private ArrayList<Pacchetto> ricevuti;
    private ArrayList<Pacchetto> daMandare;

    public Buffer() {
        ricevuti = new ArrayList<Pacchetto>();
        daMandare = new ArrayList<Pacchetto>();
    }

    public int getSizeRicevuti() {
        return ricevuti.size();
    }

    public int getSizeMandare() {
        return daMandare.size();
    }

    public void addPacchettoRicevuto(Pacchetto p) {
        ricevuti.add(p);
    }

    public Pacchetto getNextPacchettoRicevuto() {
        Pacchetto p = ricevuti.get(0);
        System.out.println("PACCHETTO IN POS 0 = " + p.toString(p));
        ricevuti.remove(0);
        return p;
    }

    public void addPacchettoDaMandare(Pacchetto p) {
        daMandare.add(p);
    }

    public Pacchetto getNextPacchettoDaMandare() {
        Pacchetto p = daMandare.get(0);
        daMandare.remove(0);
        return p;
    }

}
