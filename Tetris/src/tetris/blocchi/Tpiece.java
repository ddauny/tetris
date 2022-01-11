package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino T e le sue posizioni 
 * 
 * 0 0 0 0
 * 0 0 0 0
 * 0 1 0 0
 * 1 1 1 0
 * 
 */
public class Tpiece extends Blocco {

    // Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceT = new JPanel[4][4]; 
    JPanel[][] nextPos = new JPanel[4][4];        
    
    public Tpiece() {
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
                pieceT[x][y] = new JPanel();
                pieceT[x][y].setSize(30,30);
                pieceT[x][y].setBackground(Color.gray);
            }
        }
        
        pieceT[0][3].setBackground(Color.pink);
        pieceT[1][3].setBackground(Color.pink); 
        pieceT[1][2].setBackground(Color.pink); 
        pieceT[2][3].setBackground(Color.pink); 
    }
    
    public JPanel restituisciPezzo(int x, int y){     
        return pieceT[x][y]; 
    }
    
    /***
     * @BRIEFvarie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n){ 
        
        switch(n){
            case 0:
                nextPos[0][3].setBackground(Color.pink);
                nextPos[0][2].setBackground(Color.pink); 
                nextPos[0][1].setBackground(Color.pink); 
                nextPos[1][2].setBackground(Color.pink); 
                break; 
            case 1:
                nextPos[0][2].setBackground(Color.pink);
                nextPos[1][2].setBackground(Color.pink); 
                nextPos[1][3].setBackground(Color.pink); 
                nextPos[2][2].setBackground(Color.pink); 
                break; 
            case 2: 
                nextPos[0][2].setBackground(Color.pink);
                nextPos[1][1].setBackground(Color.pink); 
                nextPos[1][2].setBackground(Color.pink); 
                nextPos[1][3].setBackground(Color.pink); 
                break; 
            case 3: 
                nextPos[0][3].setBackground(Color.pink);
                nextPos[1][3].setBackground(Color.pink); 
                nextPos[1][2].setBackground(Color.pink); 
                nextPos[2][3].setBackground(Color.pink); 
            break; 
        }
        
        
        return nextPos;
    }

}
