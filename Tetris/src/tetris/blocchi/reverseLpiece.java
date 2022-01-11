package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino LR(L Reverse) e le sue posizioni 
 * 
 * 0 0 0 0
 * 0 1 0 0
 * 0 1 0 0
 * 1 1 0 0
 * 
 */
public class reverseLpiece {
    
    // Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceRL = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    public reverseLpiece(){
        // Inizializzazione
        for(int x = 0; x<4;x++){ 
            for(int y =0; y<4; y++){
                nextPos[x][y] = new JPanel();
                nextPos[x][y].setSize(30,30);
                nextPos[x][y].setBackground(Color.gray);
            }
        }
        
        for(int x = 0; x<4;x++){ 
            for(int y =0; y<4;y++){ 
                pieceRL[x][y] = new JPanel();
                pieceRL[x][y].setSize(30,30);
                pieceRL[x][y].setBackground(Color.gray);
            }
        }
        
        pieceRL[0][3].setBackground(Color.blue); 
        pieceRL[1][3].setBackground(Color.blue); 
        pieceRL[1][2].setBackground(Color.blue); 
        pieceRL[1][1].setBackground(Color.blue); 
    
    }
    
    public JPanel restituisciPezzo(int x, int y){  
        return pieceRL[x][y];
    }
    
     public JPanel[][] prossimaPosizione(int n){ 
    
        switch(n){
            case 0: 
                nextPos[0][2].setBackground(Color.blue); 
                nextPos[0][3].setBackground(Color.blue); 
                nextPos[1][3].setBackground(Color.blue); 
                nextPos[2][3].setBackground(Color.blue); 
            break;
            
            case 1:
                nextPos[0][1].setBackground(Color.blue); 
                nextPos[0][2].setBackground(Color.blue); 
                nextPos[0][3].setBackground(Color.blue); 
                nextPos[1][1].setBackground(Color.blue); 
            break;
            
            case 2: 
                nextPos[0][2].setBackground(Color.blue); 
                nextPos[1][2].setBackground(Color.blue); 
                nextPos[2][2].setBackground(Color.blue); 
                nextPos[2][3].setBackground(Color.blue); 
            break;
            
            case 3: 
                nextPos[0][3].setBackground(Color.blue); 
                nextPos[1][3].setBackground(Color.blue); 
                nextPos[1][2].setBackground(Color.blue); 
                nextPos[1][1].setBackground(Color.blue); 
            break;
        }
        
        
        return nextPos;
    }
    
}
