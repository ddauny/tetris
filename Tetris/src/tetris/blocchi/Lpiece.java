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
public class Lpiece  extends Blocco{

    /** Arancione
     * 0 0 0 0
     * 1 0 0 0
     * 1 0 0 0
     * 1 1 0 0
     */
    
    JPanel[][] pieceL = new JPanel[4][4];
    
    public Lpiece() {
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceL[j][i] = new JPanel();
                pieceL[j][i].setSize(30,30);
                pieceL[j][i].setBackground(Color.gray);
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
    
}
