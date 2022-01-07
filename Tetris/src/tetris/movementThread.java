/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class movementThread extends Thread {
    // decrementa la Y
    
    Blocco block; 
    JPanel[][] tmp; 
    
    
    public movementThread(){
    
    }
    
    public movementThread(JPanel[][] tmp, Board b, Blocco block){
        this.tmp = tmp; 
        this.block = block; // contiene il blocco
    }
    
    @Override
    public void run(){
    
        for(int x1 = 0; x1< 4; x1++){
            x1++;
        }
        
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(movementThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
