/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * 
 * @author giuli
 * 
 * Matrice di gioco, quella base che va a posizionare gli spazi vuoti
 * per i successivi tetramini
 */
public class Matrix extends JPanel {
    
    Board b; 
    
    public Matrix(JPanel[][] tmp, Board b){
       
        this.b = b; 
        int x = 250;
        int y = 250;
        
        
        for(int j = 0; j< 20;j++){ // Y della matrice
            x = 250; 
            for(int i =0; i< 10;i++){
                        
                tmp[i][j] = new JPanel(); 
                tmp[i][j].setSize(30,30);
                tmp[i][j].setLocation(x, y);
                tmp[i][j].setBackground(Color.gray);
                b.add(tmp[i][j]);
                x += 32;
            }
            y+= 32;
        }        
    }
    
    public Board createTable(){
    
        return b; 
    }
       
    
    
}
