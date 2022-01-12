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
        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < 10; i++) {
                placed[i][j] = new JPanel();
                placed[i][j].setSize(30, 30);
                placed[i][j].setBackground(Color.gray);
            }
        }
    }

    int lastX;

    public void muoviDestra() {
        int x1 = block.getX();
        int y1 = block.getY();
        // System.out.println("x1,y1: " + x1 + "," + y1);
        if (chkDestra(block)) {
            //   System.out.println("entrato");
            for (int y2 = 0; y2 < 4; y2++) {
                for (int x2 = 0; x2 < lastX - x1 + 1; x2++) {
                    //System.out.println("x1+x2+1. " + (x1 + x2));
                    board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());

                    if (x1 >= 0) {//&& x1 + x2 + 4 <= 10) {
                        if (y1 - 1 > 0) {
                            board[x1 + x2][y1 - 1].setBackground(Color.gray);
                        }
                        board[x1 + x2][y1].setBackground(Color.gray);
                        board[x1 + x2][y1 + 1].setBackground(Color.gray);
                        board[x1 + x2][y1 + 2].setBackground(Color.gray);
                        board[x1 + x2][y1 + 3].setBackground(Color.gray);

                    }
                }
            }
            // System.out.println("x1 " + x1);
            if (block.getX() + 1 < 10) {
                block.setX(block.getX() + 1);
                // System.out.println("blocco x " + block.getX());
            }
        }
    }

    public void muoviSinistra() {
        int x1 = block.getX();
        int y1 = block.getY();
        if (chkSideCol(x1 - 1)) {
            for (int y2 = 0; y2 < 4; y2++) {
                for (int x2 = 0; x2 < lastX - x1 - 1; x2++) {
                    board[x1 + x2 - 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    //System.out.println("messo blocco in pos " + (x1 + x2 - 1));
                    if (x1 > 0) {//&& x1 + x2 + 4 <= 10) {
                        if (y1 - 1 > 0 && x1 + x2 < 10) {
                            board[x1 + x2][y1 - 1].setBackground(Color.gray);
                        }
                        int t = ultimaX(block) + x1 + x2;
                        //  System.out.println("t: " + t);
                        board[t][y1].setBackground(Color.gray);
                        board[t][y1 + 1].setBackground(Color.gray);
                        board[t][y1 + 2].setBackground(Color.gray);
                        board[t][y1 + 3].setBackground(Color.gray);
                    }
                }
            }
            if (block.getX() - 1 >= 0) {
                block.setX(block.getX() - 1);
            }
            // System.out.println(block.getX());
        }

    }

    public void muoviBasso() {
        // X e Y del pezzo
        int x1 = block.getX();
        int y1 = block.getY();
        // System.out.println("getx " + x1);

        //  System.out.println("gety " + y1);
        // Se il pezzo non ha toccato 
        if (x1 < x1 + 4 && !touched && y1 < y1 + 3) {
            //Il for va a spostare il pezzo nella posizione più in basso
            for (int y2 = 0; y2 < 4 && !touched; y2++) {
                for (int x2 = 0; x2 < 3; x2++) {
                    //redraw();
                    // System.out.println(x1 + x2);
                    if (x1 + x2 < 10) {
                        board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    }
                }

                checkBottomCollision();
                System.out.println("y1+y2: " + (y1 + y2));
                checkBottomCollision(y1 + y2);
            }
        }
        // altrimenti darebbe errore per il primo tetramino, dato che cercherebe di colorare un blocco in y=-1
        if (y1 > 0 && !touched) {
            board[x1][y1 - 1].setBackground(Color.gray);
        }
        // Ovviamente aggiunge uno alla Y del bloco
        if (!touched) {
            block.setY(block.getY() + 1);
<<<<<<< HEAD
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
=======
>>>>>>> a41f397fb9fd38951e2eab6d6e32c275ce408f4b
        }
    }

    public boolean chkSideCol(int x) {
        if (x >= 0 && x <= 10) {
            return true;
        } else {
            return false;
        }
    }
//    
//    public void hardDrop(){
//        
//        int x1 = block.getX(); // x iniziale
//        int y1 = block.getY(); 
//        
//        for(int x2 = 0; x2 < 4; x2++)
//            for(int y2 = 0; y2 < 4; y2++){
//                
//                if(y1>0)  // altrimenti la linea lunga lascia pezzi di blu sul tragitto
//                    board[x1 + x2][y1-1].setBackground(Color.gray);
//                
//                board[x1+x2][y1+y2].setBackground(Color.gray); 
//            }
//        
//        y1 = 20-4; // y finale
//        
//        for(int x2 = 0; x2 < 4; x2++)
//            for(int y2 = 0; y2 < 4; y2++)
//                board[x1+x2][y1+y2].setBackground(block.getPanel(x2, y2).getBackground()); 
//                
//        
//        block.setX(x1);
//        block.setY(20-4);
//        
//        checkBottomCollision();
//        checkBottomCollision(19);        
//    }

<<<<<<< HEAD
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
=======
    public void hardDrop() {
        int x1 = block.getX(); // x iniziale
>>>>>>> a41f397fb9fd38951e2eab6d6e32c275ce408f4b
        int y1 = block.getY();
        //rende grigio il pezzo
        for (int x2 = 0; x2 < 4; x2++) {
            for (int y2 = 0; y2 < 4; y2++) {
                if (y1 > 0) // altrimenti la linea lunga lascia pezzi di blu sul tragitto
                {
                    board[x1 + x2][y1 - 1].setBackground(Color.gray);
                }
                board[x1 + x2][y1 + y2].setBackground(Color.gray);
            }
        }
        //////////////////////////
        //cerco il fondo
        //[x1][y1 + 3] angolo in basso a sinistra del blocco quindi + 4 è la cella sotto
        //  System.out.println("y1 + 4: " + (y1 + 4));
        // System.out.println("x1: " + x1);
        for (int i = y1 + 4; i < 20; i++) {
            //     System.out.println("i: " + i);
            if (board[x1][i].getBackground().equals(Color.gray) && board[x1 + 1][i].getBackground().equals(Color.gray)
                    && board[x1 + 2][i].getBackground().equals(Color.gray) && board[x1 + 3][i].getBackground().equals(Color.gray) && i < 19) {
                //     System.out.println("sotto è grigio");
            } else {
                //   System.out.println("sono nell'else");
                y1 = i - 3;
                break;
            }
        }

        //disegno il pezzo sul fondo
        for (int x2 = 0; x2 < 4; x2++) {
            for (int y2 = 0; y2 < 4; y2++) {
                board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
            }
        }

        //imposto coordinate del pezzo sul fondo
        block.setX(x1);
        block.setY(y1);

        checkBottomCollision();
        checkBottomCollision(19);
    }

    /**
     * @return TRUE se il blocco può andare ancora a destra(visto che non ha
     * altri grigi)
     * @return FALSE se non ci può andare
     */
    public boolean chkDestra(Blocco b) {
        // c'è da controllare che gli spazi grigi della matrice del blocco di modo che possono andare oltre(Dx)  
        boolean t = false;
        int xb = ultimaX(b);//trovo l'ultima x del blocco colorata
//        System.out.println("xb: " + xb);
//        System.out.println("getx: " + b.getX());
        lastX = b.getX() + xb + 1;
        //System.out.println("last x: " + lastX);
        if (lastX < 10) {//se l'ultima x del blocco e la sua x sono meno di 10, sono ancora nella board
            //  System.out.println("la x è: " + (b.getX() + xb));
            t = true;
        }

        //block.setY(block.getY() + 1);
        return t;
    }

    private int ultimaX(Blocco b) {//torna la x dell'ultimo blocchettino colorato
        boolean sentinel = true;
        int x;
        for (x = b.getX(); x < b.getX() + 4 && sentinel == true; x++) {
            //  System.out.println("x: " + x);
            sentinel = false;
            for (int y = b.getY(); y < 4 + b.getY(); y++) {
                if (x < 10) {
                    if (!board[x][y].getBackground().equals(Color.gray)) {//se almeno un quadratino è colorato
                        sentinel = true;
                        break;
                    }
                }
            }
        }
        // System.out.println("Il blocco è lungo: " + (x - b.getX() - 1));
        return x - b.getX() - 2;
    }

    private void checkBottomCollision(int boardY) {
        if (boardY >= 19) {
            touched = true;
            System.out.println("creo nuovo blocco");
            block.setX(0); // impostare a 0 x e y del blocco
            block.setY(0);
            addToPlaced();
            redraw();
        }
    }

    /**
     * *
     * @brief Per tenere traccia dei blocchi piazzati, ho fatto questa matrice
     * che memorizza la posizione dei blocchi senza intralci di Pannelli Grigi:
     *
     * Questo servirà per le collisioni
     *
     */
    private void addToPlaced() {
        int x2 = block.getX();
        int y2 = block.getY();

        for (int x1 = 0; x1 < 4; x1++) {
            for (int y1 = 0; y1 < 4; y1++) {
                JPanel pannello = block.getPanel(x1, y1);

                if (pannello.getBackground() != Color.gray) {
                    placed[x2 + x1][y2 + y1].setBackground(pannello.getBackground());
                }

            }
        }
    }

    private void redraw() {
        // prende le cose da //JPanel[][] placed// e le mette in JPanel[][] board
        for (int x1 = 0; x1 < 10; x1++) {
            for (int y1 = 0; y1 < 20; y1++) {
                if (placed[x1][y1].getBackground() != Color.gray) {
                    board[x1][y1].setBackground(placed[x1][y1].getBackground());
                }
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

    /**
     * *
     * @return TRUE se si è scontrato
     * @return FALSE se non si è scontrato
     */
//    private void checkBottomCollision() {
//        int x1 = block.getX(); // x iniziale
//        int y1 = block.getY();
//        //cerco il fondo
//        //[x1][y1 + 3] angolo in basso a sinistra del blocco quindi + 4 è la cella sotto
//        //  System.out.println("y1 + 4: " + (y1 + 4));
//        // System.out.println("x1: " + x1);
//
//        touched = false;
//        int i = y1 + 4;
//        System.out.println("x1: " + x1);
//        System.out.println("y1: " + i);
//        if (i <= 19) {
//            if (board[x1][i].getBackground().equals(Color.gray) && board[x1 + 1][i].getBackground().equals(Color.gray)
//                    && board[x1 + 2][i].getBackground().equals(Color.gray) && board[x1 + 3][i].getBackground().equals(Color.gray)) {
//                touched = false;
//            } else {
//                touched = true;
//            }
//        }
//
//    }

    
    private void checkBottomCollision() {
        //X e Y del blocco
        int x = block.getX();
        int y = block.getY();
        //     System.out.println("y blocco: " + y);
        boolean sent = false;
        // per ogni quadrato colorato, controllo la collisione sotto
        int y1 = y + 4; // parte sotto del blocco
        // System.out.println(placed[x][y1].getBackground());
        for (int y2 = 0; y2 < 4; y2++) {
            if (y1 < 19) {
                if (placed[x][y1].getBackground().equals(Color.gray)) {
                    // sotto è vuoto
                    touched = false;
                } else {
                    touched = true;
                }
            }
        }
    }
    
    public void chkRigheRisolte() {
        boolean spazio = false;
        int y = 0;
        for (y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (board[x][y].getBackground().equals(Color.gray)) {
                    spazio = true;
                    break;
                }
            }
        }
        if (!spazio) {//se non è stato trovato uno spazio
            cancellaRiga(y);
            chkRigheRisolte();//perchè potrei aver completato più righe in una volta
        }
    }

    private void cancellaRiga(int i) {
        for (int y = 0; y < i; y++) {
            for (int x = 0; x < 10; x++) {
                board[x][y + 1].setBackground(board[x][y].getBackground());
            }
        }
    }
}
