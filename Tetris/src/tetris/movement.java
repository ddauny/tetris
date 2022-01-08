/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class movement {
    
    JPanel[][] board; 
    Blocco block ;           
    boolean touched;
    
    public movement(Blocco block, JPanel[][] tmp){
        touched = true;
        
        board = tmp; 
        this.block = block; 
    }
    
    public void run(){
        // ora che ho il blocco posso muoverlo     
        
        // deve interrompersi però se incontra il fondo
        
        // i due for per la board
        for(int x1 = block.getX(); x1 < x1+4 && !touched; x1++){ 
            for(int y1 = block.getY(); y1 < y1+3 && !touched; y1++){         
                // e i due for per il pezzo
                for(int y2 = 0; y2 <4 && !touched ; y2++){ 
                    for(int x2 = 0; x2 <4 ; x2++){
                        board[x1+x2][y1+y2].setBackground(block.getPanel(x2, y2).getBackground()); 
                        
                        checkBottomCollision(x2, y1+y2);                     

                    }
                    System.out.println(board[x1][y1+y2+1].getBackground()); 
                }             
                // altrimenti darebbe errore per il primo, dato che cercherebe di colorare un blocco in y=-1
                if(y1>0 && !touched)
                    board[x1][y1-1].setBackground(Color.gray); 
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(movement.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            block.setY(block.getY()+1);
        }
    }
    
    
    private void checkBottomCollision(int boardX, int boardY){    
        if(boardY>=19)
            touched = true;
        // se sotto non è grigio
            
    }
            

    public boolean getTouched(){    
        return touched; 
    }
         
    public void setTouched(boolean touched){
        this.touched = touched; 
    }
}