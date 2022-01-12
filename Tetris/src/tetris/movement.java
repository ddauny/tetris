package tetris;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 * @author galliFrancesco
 * @bried Classe per gestire il movimento il pezzo(giù, dx, sx)
 */
public class movement {

    JPanel[][] board;
    JPanel[][] placed = new JPanel[10][20]; //tiene traccia dei blocchi piazzati
    Blocco block;
    boolean touched;

    public movement(Blocco block, JPanel[][] tmp) {
        touched = true;
        board = tmp;
        this.block = block;
        
        //Inizializzo la matrice che tiene conto dei pezzi fermi
        for(int j = 0; j< 20;j++){
            for(int i =0; i< 10;i++){                    
                placed[i][j] = new JPanel(); 
                placed[i][j].setSize(30,30);
                placed[i][j].setBackground(Color.gray);
            }
        }        
    }

    public void muoviDestra() {
        boolean fatto = false;
        int x1 = block.getX();
        int y1 = block.getY();
        System.out.println("x1,y1: " + x1 + "," + y1);
        //if(chkSideCol(x1 + ))
        for (int y2 = 0; y2 < 4; y2++) {
            for (int x2 = 0; x2 < 4; x2++) {
                board[x1 + x2 + 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                if (!fatto && x1 >= 0) {//&& x1 + x2 + 4 <= 10) {
                    if (y1 - 1 > 0) {
                            board[x1 + x2][y1 - 1].setBackground(Color.gray);
                    }
                    board[x1 + x2][y1].setBackground(Color.gray);
                    board[x1 + x2][y1 + 1].setBackground(Color.gray);
                    board[x1 + x2][y1 + 2].setBackground(Color.gray);
                    board[x1 + x2][y1 + 3].setBackground(Color.gray);
                    fatto = true;
                }
            }
        }
        if (block.getX() + 1 <= 10) {
            block.setX(block.getX() + 1);
        }
    }

    public void muoviSinistra() {
        boolean fatto = false;
        int x1 = block.getX();
        int y1 = block.getY();
        if (chkSideCol(x1 - 1)) {
            for (int y2 = 0; y2 < 4; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {
                    board[x1 + x2 - 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    if (!fatto && x1 > 0) {//&& x1 + x2 + 4 <= 10) {
                        if (y1 - 1 > 0) {
                            board[x1 + x2][y1 - 1].setBackground(Color.gray);
                        }
                        board[x1 + x2 + 4][y1].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 1].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 2].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 3].setBackground(Color.gray);
    
    public void muoviBasso() {
        
        // X e Y del pezzo
        int x1 = block.getX();
        int y1 = block.getY();
        
        // Se il pezzo non ha toccato 
        if (x1 < x1 + 4 && !touched && y1 < y1 + 3) {
            //Il for va a spostare il pezzo nella posizione più in basso
            for (int y2 = 0; y2 < 4 && !touched; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {
                    redraw();
                    board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    checkBottomCollision();
                    checkBottomCollision(y1 + y2);
                     
                }
            }
        }
        // altrimenti darebbe errore per il primo tetramino, dato che cercherebe di colorare un blocco in y=-1
        if (y1 > 0 && !touched) { 
            board[x1][y1 - 1].setBackground(Color.gray);
        }
               
        // Ovviamente aggiunge uno alla Y del bloco
        if(!touched)
            block.setY(block.getY() + 1);
    }

    public void muoviDestra() {
        
        // X e Y del blocco
        int x1 = block.getX();
        int y1 = block.getY(); 
        
        // Azione completata
        boolean fatto = false;
       
        // For per spostare il pezzo a DESTRA
        for (int y2 = 0; y2 < 4; y2++) {
            for (int x2 = 0; x2 < 4; x2++) {
                    
                redraw();
                    
                if(x1+x2+1 < 10) // altrimenti mette pezzzi grigi fuori
                    board[x1 + x2 + 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());

                if (!fatto && x1 >= 0 ){//&& x1 + x2 + 4 <= 10) {                   
                    if(y1>0)    // altrimenti la linea lunga lascia pezzi di blu sul tragitto
                        board[x1 + x2][y1-1].setBackground(Color.gray);
                        
                        board[x1 + x2][y1].setBackground(Color.gray);
                        board[x1 + x2][y1 + 1].setBackground(Color.gray);   
                        board[x1 + x2][y1 + 2].setBackground(Color.gray);  
                        board[x1 + x2][y1 + 3].setBackground(Color.gray);

                        fatto = true;
                    }
                }
            }
        
        if (block.getX() - 1 >= 0) {
            block.setX(block.getX() - 1);
        }
    }

    public boolean chkSideCol(int x) {
        if (x >= 0 && x <= 10) {
            return true;
        } else {
            return false;
        }
    }
    public void muoviSinistra() {  
        boolean fatto = false;    
        // Se il pezzo è sulla parete sinistra non può andare oltre
        // quindi questo IF Non permette di andarci
        if(block.getX() > 0){   
            int x1 = block.getX();
            int y1 = block.getY();
            for (int y2 = 0; y2 < 4; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {                 
                    redraw(); 

                    if(x1+x2+1 < 10)
                        board[x1 + x2 - 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    
                    if (!fatto && x1 > 0 ){//&& x1 + x2 + 4 <= 10) {
                        if(y1>0)  // altrimenti la linea lunga lascia pezzi di blu sul tragitto
                            board[x1 + x2][y1-1].setBackground(Color.gray);
                    }
                }
            }
        }
    }

    public void muoviBasso() {
        int x1 = block.getX();
        int y1 = block.getY();
        if (x1 < x1 + 4 && !touched && y1 < y1 + 3) {
            for (int y2 = 0; y2 < 4 && !touched; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {
                    board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    checkBottomCollision(x2, y1 + y2);
                }
                //  System.out.println(board[x1][y1 + y2 + 1].getBackground());
            }
        }
        // altrimenti darebbe errore per il primo, dato che cercherebe di colorare un blocco in y=-1
        if (y1 > 0 && !touched) {
            board[x1][y1 - 1].setBackground(Color.gray);
            }
            
            if (block.getX() - 1 >= 0) {
                block.setX(block.getX() - 1);
            }
        }
    }

    public void hardDrop(){
        
        int x1 = block.getX(); // x iniziale
        int y1 = block.getY(); 
        
        for(int x2 = 0; x2 < 4; x2++)
            for(int y2 = 0; y2 < 4; y2++){
                
                if(y1>0)  // altrimenti la linea lunga lascia pezzi di blu sul tragitto
                    board[x1 + x2][y1-1].setBackground(Color.gray);
                
                board[x1+x2][y1+y2].setBackground(Color.gray); 
            }
        
        y1 = 20-4; // y finale
        
        for(int x2 = 0; x2 < 4; x2++)
            for(int y2 = 0; y2 < 4; y2++)
                board[x1+x2][y1+y2].setBackground(block.getPanel(x2, y2).getBackground()); 
                
        
        block.setX(x1);
        block.setY(20-4);
        
        checkBottomCollision();
        checkBottomCollision(19);        
    }
    
    /**
     * @return TRUE se il blocco può andare ancora a destra(visto che non ha altri grigi)
     * @return FALSE se non ci può andare
     */
    public boolean checkDestra(int blockX) {  
        // c'è da controllare che gli spazi grigi della matrice del blocco di modo che possono andare oltre(Dx)  
        boolean sent = false;      
        
        for(int y1 = 0; y1 < 4; y1++){
            if(block.getPanel(blockX, y1).getBackground() == Color.gray)
                sent = true; 
        }
        block.setY(block.getY() + 1);
    }

    private void checkBottomCollision(int boardX, int boardY) {
        if (boardY >= 19) {
            touched = true;
            touched = true;    
            
            addToPlaced(); 
            redraw(); 
            
            block.setX(0); // impostare a 0 x e y del blocco
            block.setY(0);     
        }
    }   
    
    /***
     * @brief Per tenere traccia dei blocchi piazzati, ho fatto questa matrice che 
     *  memorizza la posizione dei blocchi senza intralci di Pannelli Grigi:
     * 
     *  Questo servirà per le collisioni 
     * 
     */
    private void addToPlaced(){
        
        int x2 = block.getX();
        int y2 = block.getY(); 
        
        for(int x1 = 0; x1 < 4; x1++){
            for(int y1 = 0; y1 < 4; y1++){
                JPanel pannello = block.getPanel(x1, y1);
                
                if(pannello.getBackground() != Color.gray)
                    placed[x2+x1][y2+y1].setBackground(pannello.getBackground());
                       
            }
        } 
    }   
    private void redraw(){
        // prende le cose da //JPanel[][] placed// e le mette in JPanel[][] board
        
        for(int x1 = 0; x1 < 10; x1++){
            for(int y1 = 0; y1<20; y1++){           
                if(placed[x1][y1].getBackground() != Color.gray)
                    board[x1][y1].setBackground(placed[x1][y1].getBackground());
            }
        }
        // se sotto non è grigio
    }

    
    public boolean getTouched() {
        return touched;
    }
    public void setTouched(boolean touched) {
        this.touched = touched;
    }
    
    
    
    /***
     * @return TRUE se si è scontrato
     * @return FALSE se non si è scontrato
     */
    private void checkBottomCollision(){
    
        //X e Y del blocco
        int x = block.getX(); 
        int y = block.getY();
        
        boolean sent = false; 
        // per ogni quadrato colorato, controllo la collisione sotto
        
        int y1 = y+4; // parte sotto del blocco
        
        System.out.println(placed[x][y1].getBackground());
        
            for(int y2 = 0; y2< 4; y2++){
                if(y1<19){
                    if(placed[x][y1].getBackground().equals(Color.gray)){
                        // sotto è vuoto
                        touched = false;  
                    } else
                        touched = true; 
                }
                }
    
    }
}
