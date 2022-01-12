/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.blocchi.Ipiece;
import tetris.blocchi.Lpiece;
import tetris.blocchi.Opiece;
import tetris.blocchi.Spiece;
import tetris.blocchi.Tpiece;
import tetris.blocchi.reverseLpiece;
import tetris.blocchi.reverseSpiece;

/**
 *  Riceve il blocco generato dal Thread
 * @author iania_daniele
 */
public class Blocco {

    // Magari una info sullo stato di posizione del blocco e di che classe s i tratta
    int x = 0; 
    int y = 0; 
    JPanel[][] block = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];
    
    String pezzo = ""; 
    int posizione; 
   
    
    public Blocco() {
        // Inizializza i pannelli nel blocco
        for(int i = 0; i< 4; i++){
            for(int j = 0; j< 4;j++){
                block[i][j] = new JPanel(); 
                block[i][j].setSize(30,30);
                block[i][j].setBackground(Color.gray);
            }
        }
        
        posizione = 0; 
    }
            
            
    public void setBlock(int x, int y, JPanel panel){
        block[this.x][this.y].setBackground(panel.getBackground()); 
    }
    
    
    public void ruotaBlocco(){    
        
        capisciClasse(); 
        
        switch(posizione){
            case 0:    
                block = nextPos;                          
                posizione++;
                break; 
            case 1:
                block = nextPos;                          
                posizione++;
                break; 
            case 2:
                block = nextPos;
                posizione++;
                break; 
            case 3:
                block = nextPos;
                posizione = 0; 
                break; 
            
        }
    }   
    private void capisciClasse(){
        switch(pezzo){
            case "i": // Linea lunga
                Ipiece ip = new Ipiece(); 
                nextPos= ip.prossimaPosizione(posizione);     
            break; 
            
            case "l":
                Lpiece lp = new Lpiece(); 
                nextPos= lp.prossimaPosizione(posizione); 
            break; 
            
            case "o":
                Opiece op = new Opiece(); 
                nextPos= op.prossimaPosizione(posizione); 
                break; 
                
            case "s": 
                Spiece sp = new Spiece(); 
                nextPos= sp.prossimaPosizione(posizione); 
                break; 
                
            case "t": 
                Tpiece tp = new Tpiece(); 
                nextPos= tp.prossimaPosizione(posizione); 
                break; 
            case "rl":
                reverseLpiece rlp = new reverseLpiece(); 
                nextPos= rlp.prossimaPosizione(posizione); 
                break; 
            case "rZ":
                reverseSpiece rsp = new reverseSpiece(); 
                nextPos= rsp.prossimaPosizione(posizione); 
                break;                
        }
    
    }   
    
    
    public void setBlocco(JPanel[][] blocco){
        block = blocco; 
    }
    
    public void setY(int y){
        this.y = y; 
    }
    
    public void setX(int x){
        this.x = x; 
    }
    public void setPezzo(String pezzo){
        this.pezzo = pezzo; 
    }
    public void setPosizione(int pos){
        posizione = pos; 
    }
    
    
    public JPanel getPanel(int x, int y){
        return block[x][y];
    }
    
    public int getY(){
        return y; 
    }
    public int getX(){
        return x; 
    }
}
