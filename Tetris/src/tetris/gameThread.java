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
    // Varie classi della gestione del gioco 
    createPiece cp; // genera il nuovo pezzo
    movement mvt; // muove il pezzo

    public gameThread(JPanel[][] board, Board b) {
        this.b = b;
        this.tmp = board;
    }

    @Override
    public void run() {
        //System.out.println("run di gamethread");
        cp = new createPiece(tmp, b, block);
        mvt = new movement(block, tmp);

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
            //mvt.run();

            switch (direzione) {
                case 0://scende
                    mvt.muoviBasso();
                    break;
                case 1:// 1 a destra
                    mvt.muoviDestra();
                    break;
                case 2://2 a sinistra
                    mvt.muoviSinistra();
                    break;
            }
            b.direzione = 0;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(gameThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
