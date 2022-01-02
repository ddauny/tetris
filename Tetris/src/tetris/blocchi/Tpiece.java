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
 * @author iania_daniele
 */
public class Tpiece extends Blocco {

    /** ROSA
     * 
     * 0 0 0 0
     * 0 0 0 0
     * 0 1 0 0
     * 1 1 1 0
     */
    JPanel[][] pieceT = new JPanel[4][4]; 
            
    public Tpiece() {
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceT[j][i] = new JPanel();
                pieceT[j][i].setSize(30,30);
                pieceT[j][i].setBackground(Color.gray);
            }
        }
        
        pieceT[0][3].setBackground(Color.pink);
        pieceT[1][3].setBackground(Color.pink); 
        pieceT[1][2].setBackground(Color.pink); 
        pieceT[2][3].setBackground(Color.pink); 
    }
    
    public JPanel[][] restituisciPezzo(){     
        return pieceT; 
    }

}
