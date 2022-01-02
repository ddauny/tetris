/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class createPiece extends Thread{
    // crea il pezzo 
    // lo muove
    
    Board b;
    JPanel[][] tmp; 
    
    Blocco block = new Blocco(); 
    
    
    int x = 0; 
    int y = 0; 
    
    boolean test = false; 
    
    
    public createPiece(JPanel[][] tmp, Board b){
        //gli passo la matrice
        this.b = b; 
        this.tmp = tmp; 
    }
    
    @Override
    public void run(){    

        synchronized(this){           
            generatePiece();
        }
                    test = !test;

           
           // b.repaint();
            
            // immagino che ci sarà una classe che mi modifica la posizione in caduta,
            // altrimenti gestirebbe tutto questo Thread
            
            
            // questo sarà poi nel thrad movimento
            //tmp[x][y].setBackground(Color.gray);
            //tmp[x][y+1].setBackground(Color.blue);
            
                try { 
                    Thread.sleep(100000000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(createPiece.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            //y++;
        
    }
    
    private void generatePiece(){
        
                for(int y1 = 0; y1<4; y1++){
                    for(int x1 = 0; x1<4; x1++){
                        tmp[x1][y1].setBackground(block.generatePiece()[x1][y1].getBackground());
                    }
                }

                
        try { 
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(createPiece.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private boolean movePiece(){
        // true se è al limite
        
        
        
        return true; 
    }
    
}
