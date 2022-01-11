package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino S e le sue posizioni 
 * 
 * 0 0 0 0
 * 0 0 0 0
 * 1 1 0 0
 * 0 1 1 0
 * 
 */
public class Spiece {
    
    // Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceS = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    public Spiece(){
        // Inizializzazione
        for(int x = 0; x<4;x++){ 
            for(int y =0; y<4;y++){ 
                nextPos[x][y] = new JPanel();
                nextPos[x][y].setSize(30,30);
                nextPos[x][y].setBackground(Color.gray);
            }
        }
        
        for(int x = 0; x<4;x++){ 
            for(int y =0; y<4;y++){ 
                pieceS[x][y] = new JPanel();
                pieceS[x][y].setSize(30,30);
                pieceS[x][y].setBackground(Color.gray);
            }
        }
    
        pieceS[0][2].setBackground(Color.red); 
        pieceS[1][2].setBackground(Color.red); 
        pieceS[1][3].setBackground(Color.red); 
        pieceS[2][3].setBackground(Color.red); 
        
    }
    
    public JPanel restituisciPezzo(int x, int y){       
        return pieceS[x][y]; 
    }
    
    /***
     * @BRIEFvarie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n){ 
        
        switch(n){
            case 0, 2: 
                nextPos[0][3].setBackground(Color.red); 
                nextPos[0][2].setBackground(Color.red); 
                nextPos[1][2].setBackground(Color.red); 
                nextPos[1][1].setBackground(Color.red); 
                break; 
            case 1, 3: 
                nextPos[0][2].setBackground(Color.red); 
                nextPos[1][2].setBackground(Color.red); 
                nextPos[1][3].setBackground(Color.red); 
                nextPos[2][3].setBackground(Color.red); 
                break;    
        }
        
        
        return nextPos;
    }
    
}
