/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author iania_daniele
 */
public class Blocco {
    int[][] m = new int[4][4];
    int c;//colore

    public Blocco(int c) {
        this.c = c;
    }

    public boolean checkCollisione(){
        boolean t = false;//indica se un pezzo ha toccato o meno 
        
        return t;
    }
    
    public void scendi(){//fa scendere il blocco di uno 
        
    }
    
    
}
