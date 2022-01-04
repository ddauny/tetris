/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.util.Random;
import javax.swing.JPanel;
import tetris.blocchi.Ipiece;
import tetris.blocchi.Lpiece;
import tetris.blocchi.Opiece;
import tetris.blocchi.Spiece;
import tetris.blocchi.Tpiece;
import tetris.blocchi.reverseLpiece;
import tetris.blocchi.reverseSpiece;

/**
 *  Genera un pezzo nuovo e lo passa al Thread che gestisce il movimento 
 * @author iania_daniele
 */
public class Blocco {

    int x = 0; 
    int y = 0; 
    JPanel[][] block = new JPanel[4][4];
    
    boolean sent = false; 
    
    public Blocco() {

    }
/*
    public JPanel[][] generatePiece(){
        
        do{
        Random r = new Random(); 
        int scelta = r.nextInt(7);        

        System.out.println(scelta); 
        
        if(scelta==0){
                // Ipiece -> Linea
                Ipiece i = new Ipiece();
                System.out.println("Linea"); 
                return i.restituisciPezzo();
        } else if(scelta==1){
                // Lpiece -> pezzo L
                Lpiece l = new Lpiece();
                System.out.println("L");  
                return l.restituisciPezzo();
        } else if(scelta==2){
                // Opiece -> pezzo Quadrato
                Opiece o = new Opiece();
                System.out.println("O"); 
                return o.restituisciPezzo();
        } else if(scelta==3){
                // Spiece -> pezzo S
                Spiece s = new Spiece();
                System.out.println("S"); 
                return s.restituisciPezzo();
        } else if(scelta==4){
                // Tpiece -> pezzo T
                Tpiece t = new Tpiece();
                System.out.println("T"); 
                return t.restituisciPezzo();
        } else if(scelta==5){
                // reverseLPiece -> pezzo L reverse
                reverseLpiece rl = new reverseLpiece();
                System.out.println("RL"); 
                return rl.restituisciPezzo();
        } else {
                // reverseSPiece -> pezzo S reverse
                reverseSpiece rs = new reverseSpiece();
                System.out.println("Z"); 
                return rs.restituisciPezzo();
        }
        }while(sent); 
    }*/
}
