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
public class reverseSpiece {
    
    JPanel[][] pieceSR = new JPanel[4][4];
    
    public reverseSpiece(){
    
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceSR[j][i] = new JPanel();
                pieceSR[j][i].setSize(30,30);
                pieceSR[j][i].setBackground(Color.gray);
            }
        }
    }
    
    public JPanel[][] restituisciPezzo(){
        
        return pieceSR; 
    }
}
