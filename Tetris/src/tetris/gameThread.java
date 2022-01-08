/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class gameThread extends Thread{
    
    JPanel[][] tmp; 
    Board b; 
    Blocco block = new Blocco(); 
    
    // Varie classi della gestione del gioco 
    createPiece cp; // genera il nuovo pezzo
    movement mvt; // muove il pezzo
    
    
    public gameThread(JPanel[][] board, Board b){
        this.b = b;
        this.tmp = board; 
    }
    
    @Override
    public void run(){
        cp = new createPiece(tmp, b, block);    
        mvt = new movement(block, tmp); 

        while(true){
            if(mvt.getTouched()){
                block = new Blocco(); 
                cp.run();
                block = cp.getBlocco();
                mvt.setTouched(false); 
            }
            
            mvt.run();
        }
        
    }
    
}
