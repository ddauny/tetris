package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * Classe del tetramino Ipiece, dà la posizione inziale e le varie posizioni che può qavere quando gira
 
   Restituisce un JPanel[][] 
 * 
 * @author iania_daniele
 */
public class Ipiece extends Blocco {
    /** Azzurro
     * 1 0 0 0
     * 1 0 0 0
     * 1 0 0 0
     * 1 0 0 0
     */
    
    JPanel[][] pieceI = new JPanel[4][4];
    
    public Ipiece() {
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceI[j][i] = new JPanel();
                pieceI[j][i].setSize(30,30);
                pieceI[j][i].setBackground(Color.gray);
            }
        }
        
        for(int i =0; i<4;i++){ //Y
            pieceI[0][i] = new JPanel(); 
            pieceI[0][i].setBackground(Color.blue);
        }
    }
    
    public JPanel restituisciPezzo(int x, int y){       
        return pieceI[x][y]; 
    }
    
    // poi qui ci saranno anche le varie posizioni del pezzo se viene girato
    
}
