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
public class reverseLpiece {
    
    JPanel[][] pieceRL = new JPanel[4][4];
    
    public reverseLpiece(){
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceRL[j][i] = new JPanel();
                pieceRL[j][i].setSize(30,30);
                pieceRL[j][i].setBackground(Color.gray);
            }
        }
    
    }
    
    public JPanel[][] restituisciPezzo(){
    
        return pieceRL;
    }
    
}
