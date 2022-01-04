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
    
    /**
     * 0 0 0 0
     * 0 0 0 0
     * 0 1 1 0
     * 1 1 0 0
     */
    
    JPanel[][] pieceSR = new JPanel[4][4];
    
    public reverseSpiece(){
    
        for(int j = 0; j<4;j++){ // x
            for(int i =0; i<4;i++){ //Y
                pieceSR[j][i] = new JPanel();
                pieceSR[j][i].setSize(30,30);
                pieceSR[j][i].setBackground(Color.gray);
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
}
