/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class gameThread extends Thread {

    JPanel[][] tmp;
    Board b;
    Blocco block = new Blocco();
    int direzione = 0;
    Buffer buffer;
    // Varie classi della gestione del gioco 
    createPiece cp; // genera il nuovo pezzo
    movement mvt; // muove il pezzo

    public gameThread(JPanel[][] board, Board b, Buffer buffer) {
        this.b = b;
        this.tmp = board;
        this.buffer = buffer;
    }

    // C'è qualquadra che non cosa: 
    // Migliorare il muro a destra
    @Override
    public void run() {
        //System.out.println("run di gamethread");
        cp = new createPiece(tmp, b, block);
        mvt = new movement(block, tmp, buffer);

        while (true) {
            //System.out.println("direzionee");
            direzione = b.direzione;
            //System.out.println("direzione: " + direzione);

            if (mvt.getTouched()) {
                block = new Blocco();
                cp.run();
                block = cp.getBlocco();
                mvt.setTouched(false);
            }
            switch (b.direzione) {  // get della direzione ascoltata da Board
                case 0:// SCENDE NORMALE
                    mvt.muoviBasso();
                    break;
                case 1:// DESTRA
                  //  System.out.println("entra");
                    mvt.muoviDestra();
                    mvt.muoviBasso();
                    break;
                case 2:// SINISTRA
                //    System.out.println("muovi sinistra");
                    mvt.muoviSinistra();
                    mvt.muoviBasso();
                    break;
                case 3: // HARD DROP
                    mvt.hardDrop();
                    break;
                case 4: // SOFT DROP
                    mvt.muoviBasso();
                    mvt.muoviBasso();
                    break;
                case 5: // Rotazione(X)
                    block.ruotaBlocco();
                    break;

            }
            mvt.chkRigheRisolte();
            b.direzione = 0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(gameThread.class.getName()).log(Level.SEVERE, null, ex);
            }

            //!!CONTROLLO DELLE RIGHE!!//
        }
    }
}

