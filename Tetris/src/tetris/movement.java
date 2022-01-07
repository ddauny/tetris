/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Sposta i pezzi dato una direzione in input
 * 
 * @author giuli
 */
public class movement {
    
    Board b; 
    JPanel[][] board; 
    JPanel[][] blocco = new JPanel[4][4];
    int x; 
    int y; 
    
    String direction ; 
    
    public movement(){
        x=0;
        y=0; 
        
        for(int x1 = 0; x1<4; x1++)
            for(int y1 = 0; y1<4; y++){
                blocco[x1][y1] = new JPanel();
                blocco[x1][y1].setSize(30,30);
                blocco[x1][y1].setLocation(x, y);
                blocco[x1][y1].setBackground(Color.gray);
            }
                
    }
    
    public movement(Board b){
        this.b = b; 
        
        for(int x1 = 0; x1<4; x1++)
            for(int y1 = 0; y1<4; y++){
                blocco[x1][y1] = new JPanel();
                blocco[x1][y1].setSize(30,30);
                blocco[x1][y1].setLocation(x, y);
                blocco[x1][y1].setBackground(Color.gray);
            }
    }
    
    public void setDirection(String key){
        direction = key; 
    }
    
    public void moveMethod(){
        
        if(direction.equals("RIGHT")){
            // si sposta a sinistra
            x++;
            
            // ridisegna da un certo punto 
            /*
            for(int y1 = 0; y1<4;y1++){                         
                for(int x1 = 0; x1 < 4; x1++){
                    board[x1][y1].setBackground(board[x1-1][y1].getBackground()); 
                }
            }    
            */
        }
    
    } 
    
    
    
    
}
