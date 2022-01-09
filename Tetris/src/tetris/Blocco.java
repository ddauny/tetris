/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *  Riceve il blocco generato dal Thread
 * @author iania_daniele
 */
public class Blocco {

    int x = 0; 
    int y = 0; 
    JPanel[][] block = new JPanel[4][4];
    
    boolean sent = false; 
    
    String test = "";    
    public Blocco() {
        for(int i = 0; i< 4; i++)
            for(int j = 0; j< 4;j++){
                block[i][j] = new JPanel(); 
                block[i][j].setSize(30,30);
                block[i][j].setBackground(Color.gray);
            }

    }
    
    public void setBlock(int x, int y, JPanel panel){
        block[this.x][this.y].setBackground(panel.getBackground()); 
    }
    
    public void setBlocco(JPanel[][] blocco){
        block = blocco; 
    }
    
    public JPanel getPanel(int x, int y){
        return block[x][y];
    }
    
    public void setY(int y){
        this.y = y; 
    }
    
    public void setX(int x){
        this.x = x; 
    }
    
    public int getY(){
        return y; 
    }
    public int getX(){
        return x; 
    }
}
