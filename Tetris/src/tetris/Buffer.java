/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.List;
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
    
    public void addPacchettoRicevuto(Pacchetto p){
        ricevuti.add(p);
    }
    
    public Pacchetto getNextPacchettoRicevuto(){
        if(ricevuti.size() > 0){
            Pacchetto p = ricevuti.get(0);
            ricevuti.remove(0);   
            return p;
        } else {
            return new Pacchetto();
        }
    }
    
    public void addPacchettoDaMandare(Pacchetto p){
        daMandare.add(p);
    }
    
    public Pacchetto getNextPacchettoDaMandare(){
        if(daMandare.size() > 0){
            Pacchetto p = daMandare.get(0);
            daMandare.remove(0);   
            return p;
        } else {
            return new Pacchetto();
        }
    }
    
}
