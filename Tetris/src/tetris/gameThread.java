package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * @author galliFrancesco
 * @brief Questo Thrad gestisce il gioco, quindi genera il pezzo e lo muove, 
 * !!AGGIUNGERE CONTROLLO RIGHE ALLA FINE DEL WHILE!!
 * 
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

    // C'è qualquadra che non cosa: 
    // Migliorare il muro a destra
    @Override
    public void run() {
        //System.out.println("run di gamethread");
        cp = new createPiece(tmp, b, block);
        mvt = new movement(block, tmp);

        while (true) {
 
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
                    mvt.muoviDestra();
                    mvt.muoviBasso();
                    break;
                case 2:// SINISTRA
                    System.out.println("muovi sinistra");
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
