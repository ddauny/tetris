/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author giuli
 */
public class movement {

    JPanel[][] board;
    Blocco block;
    boolean touched;

    public movement(Blocco block, JPanel[][] tmp) {
        touched = true;
        board = tmp;
        this.block = block;
    }
    
    public void muoviBasso() {
        int x1 = block.getX();
        int y1 = block.getY();
        if (x1 < x1 + 4 && !touched && y1 < y1 + 3) {
            for (int y2 = 0; y2 < 4 && !touched; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {
                    board[x1 + x2][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    checkBottomCollision(y1 + y2);
                }
                //  System.out.println(board[x1][y1 + y2 + 1].getBackground());
            }
        }
        // altrimenti darebbe errore per il primo, dato che cercherebe di colorare un blocco in y=-1
        if (y1 > 0 && !touched) {
            board[x1][y1 - 1].setBackground(Color.gray);
        }
        block.setY(block.getY() + 1);
    }

    public void muoviDestra() {
        boolean fatto = false;
        
        int x1 = block.getX();
        int y1 = block.getY();
        
        //System.out.println("x1,y1: " + x1 + "," + y1);
        
        for (int y2 = 0; y2 < 4; y2++) {
            for (int x2 = 0; x2 < 4; x2++) {
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
        if (block.getX() + 1 <= 10) {
            block.setX(block.getX() + 1);
        }
    }

    public void muoviSinistra() {  
        boolean fatto = false;
        
        if(block.getX() > 0){   // se è sulla parete sinistra non può andare oltre
            int x1 = block.getX();
            int y1 = block.getY();
            for (int y2 = 0; y2 < 4; y2++) {
                for (int x2 = 0; x2 < 4; x2++) {
                    board[x1 + x2 - 1][y1 + y2].setBackground(block.getPanel(x2, y2).getBackground());
                    if (!fatto && x1 > 0 ){//&& x1 + x2 + 4 <= 10) {
                        if(y1>0)
                            board[x1 + x2][y1-1].setBackground(Color.gray);

                        board[x1 + x2 + 4][y1].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 1].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 2].setBackground(Color.gray);
                        board[x1 + x2 + 4][y1 + 3].setBackground(Color.gray);
                        fatto = true;
                    }
                }
            }
            if (block.getX() - 1 >= 0) {
                block.setX(block.getX() - 1);
            }
        }
    }

    public void checkDestraSinistra(int boardX, int boardY) {
        
        // c'è da controllare che gli spazi grigi della matrice del blocco di modo che possono andare oltre    
        if (boardX >= 9 || boardX < 0) {
            touched = true;
        }
    }

    private void checkBottomCollision(int boardY) {
        if (boardY >= 19) {
            touched = true;
        }
    }

    public boolean getTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
}
