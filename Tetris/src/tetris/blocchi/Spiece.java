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
 *
 * @author giuli
 */
public class Spiece {
    /**
     * Rosso
     * 0 0 0 0
     * 0 0 0 0
     * 1 1 0 0
     * 0 1 1 0
     */
    JPanel[][] pieceS = new JPanel[4][4];
    
    public Spiece(){
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceS[j][i] = new JPanel();
                pieceS[j][i].setSize(30,30);
                pieceS[j][i].setBackground(Color.gray);
            }
        }
    
        pieceS[0][2].setBackground(Color.red); 
        pieceS[1][2].setBackground(Color.red); 
        pieceS[1][3].setBackground(Color.red); 
        pieceS[2][3].setBackground(Color.red); 
        
    }
    
    public JPanel[][] restituisciPezzo(){
        
        return pieceS; 
    }
    
}
