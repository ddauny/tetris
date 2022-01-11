package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino SR e le sue posizioni 
 * 
 * 0 0 0 0
 * 0 0 0 0
 * 0 1 1 0
 * 1 1 0 0
 * 
 */
public class reverseSpiece {
        
    // Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceSR = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    public reverseSpiece(){
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
                pieceSR[x][y] = new JPanel();
                pieceSR[x][y].setSize(30,30);
                pieceSR[x][y].setBackground(Color.gray);
            }
        }
        
        pieceSR[0][3].setBackground(Color.orange); 
        pieceSR[1][3].setBackground(Color.orange); 
        pieceSR[1][2].setBackground(Color.orange); 
        pieceSR[2][2].setBackground(Color.orange); 

    }
    
    public JPanel restituisciPezzo(int x, int y){       
        return pieceSR[x][y]; 
    }
    
    /***
     * @BRIEF varie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n){      
        switch(n){
            case 0, 2: 
                nextPos[0][1].setBackground(Color.orange); 
                nextPos[0][2].setBackground(Color.orange); 
                nextPos[1][2].setBackground(Color.orange); 
                nextPos[1][3].setBackground(Color.orange); 
            break; 
            case 1, 3: 
                nextPos[0][3].setBackground(Color.orange); 
                nextPos[1][3].setBackground(Color.orange); 
                nextPos[1][2].setBackground(Color.orange); 
                nextPos[2][2].setBackground(Color.orange);
            break;           
        }
        return nextPos;
    }
}
