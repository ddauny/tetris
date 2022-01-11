package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino O e le sue posizioni(anche se ne ha 1 .-.)
 * 
 * 0 0 0 0
 * 0 0 0 0
 * 1 1 0 0
 * 1 1 0 0
 * 
 */
public class Opiece {
    
    // Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceO = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    public Opiece(){
        // Inizializzazione
        for(int x = 0; x<4;x++){ // x
            for(int y =0; y<4;y++){ //Y
                nextPos[x][y] = new JPanel();
                nextPos[x][y].setSize(30,30);
                nextPos[x][y].setBackground(Color.gray);
            }
        }
        
        for(int x = 0; x<4;x++){ // x
            for(int y =0; y<4;y++){ //Y
                pieceO[x][y] = new JPanel();
                pieceO[x][y].setSize(30,30);
                pieceO[x][y].setBackground(Color.gray);
            }
        }
        
        pieceO[0][2].setBackground(Color.yellow);
        pieceO[0][3].setBackground(Color.yellow);
        pieceO[1][2].setBackground(Color.yellow);
        pieceO[1][3].setBackground(Color.yellow);
    }
    
    public JPanel restituisciPezzo(int x, int y){    
        return pieceO[x][y]; 
    }
    
    /***
     * @BRIEF varie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n){ 
    
        switch(n){
            case 0, 1, 2, 3: 
                nextPos[0][2].setBackground(Color.yellow);
                nextPos[0][3].setBackground(Color.yellow);
                nextPos[1][2].setBackground(Color.yellow);
                nextPos[1][3].setBackground(Color.yellow);    
                
                break;  
        }  
        return nextPos;
    }
}
