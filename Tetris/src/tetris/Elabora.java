/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iania_daniele
 */
public class Elabora extends Thread {

    //elaboro dati e aggiorno
    private Buffer buffer;
    Pacchetto p;

    public Elabora(){
        
    }
    public Elabora(Buffer buffer) {
        this.buffer = buffer;
    }

    public void esamina() {
        while (Pacchetto.tipoConnessione != 'c') {
            //System.out.println("sono in elabora");
            if (buffer.getSizeRicevuti() > 0) {
                System.out.println("ELABORA: pacchetto ricevuto");
                p = buffer.getNextPacchettoRicevuto();
                if (!p.tipo.equals("g")) {//se non è un pacchetto game
                    char c = Pacchetto.tipoConnessione;
                    switch (c) {
                        case 'a'://richiesta connessione
                            Window.richiestaConnessione(p.nome);
                            break;
                        case 'y'://ricevo conferma connessione                      
                            Window.initGame();
                            break;
                        case 'n'://ricevo rifiuto connessione
                            Window.rifiutoConnessione();
                            break;
                    }
                } else {//è arrivato un pacchetto di tipo game
                    switch(p.malus){
                        case 1:
                            movement.mVelocita();
                            break;
                        case 2:
                            movement.mRiduzione();
                            break;
                    }
                    if(p.righe > 0)
                        movement.addRighe(p.righe);
                    if(p.stato == 1)
                        Window.gameOver();
                }
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Elabora.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void run() {
        esamina();
    }
}
