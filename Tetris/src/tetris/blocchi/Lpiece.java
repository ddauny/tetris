/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * @author galliFrancesco
 * 
 * @brief Classe del Tetramino L e le sue posizioni 
 * 
 * 0 0 0 0
 * 1 0 0 0
 * 1 0 0 0
 * 1 1 0 0
 * 
 */
public class Lpiece  extends Blocco{
    
// Creazione della matrice del pezzo e della possibile rotazione
    JPanel[][] pieceL = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    public Lpiece() {
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
                pieceL[x][y] = new JPanel();
                pieceL[x][y].setSize(30,30);
                pieceL[x][y].setBackground(Color.gray);
            }
        }
        
        pieceL[0][1].setBackground(Color.ORANGE);
        pieceL[0][2].setBackground(Color.ORANGE);
        pieceL[0][3].setBackground(Color.ORANGE);
        pieceL[1][3].setBackground(Color.ORANGE);
        
    }
    
    public JPanel restituisciPezzo(int x, int y){      
        return pieceL[x][y]; 
    }
    
    /***
     * @BRIEFvarie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n){ 
    
        switch(n){
            case 0:    
                nextPos[0][3].setBackground(Color.ORANGE);
                nextPos[1][3].setBackground(Color.ORANGE);
                nextPos[2][3].setBackground(Color.ORANGE);
                nextPos[2][2].setBackground(Color.ORANGE);
                break; 
            case 1:     
                nextPos[0][1].setBackground(Color.ORANGE);
                nextPos[1][1].setBackground(Color.ORANGE);
                nextPos[1][2].setBackground(Color.ORANGE);
                nextPos[1][3].setBackground(Color.ORANGE);
                break;    
            case 2: 
                nextPos[0][3].setBackground(Color.ORANGE);
                nextPos[0][2].setBackground(Color.ORANGE);
                nextPos[1][2].setBackground(Color.ORANGE);
                nextPos[2][2].setBackground(Color.ORANGE);
                break; 
            case 3:
                nextPos[0][1].setBackground(Color.ORANGE);
                nextPos[0][2].setBackground(Color.ORANGE);
                nextPos[0][3].setBackground(Color.ORANGE);
                nextPos[1][3].setBackground(Color.ORANGE);
                break; 
        }    
        return nextPos;
    }
    
}
