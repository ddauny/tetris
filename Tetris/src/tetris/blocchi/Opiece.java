/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class Opiece {
    
    /** Giallo
     * 
     * 0 0 0 0
     * 0 0 0 0
     * 1 1 0 0
     * 1 1 0 0
     */
    
    JPanel[][] pieceO = new JPanel[4][4];
    
    public Opiece(){

        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceO[j][i] = new JPanel();
                pieceO[j][i].setSize(30,30);
                pieceO[j][i].setBackground(Color.gray);
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
}
