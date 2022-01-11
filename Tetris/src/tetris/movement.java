/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                        fatto = true;
                    }
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
        block.setY(block.getY() + 1);
    }

    private void checkBottomCollision(int boardX, int boardY) {
        if (boardY >= 19) {
            touched = true;
        }
        // se sotto non è grigio
    }

    public boolean getTouched() {
        return touched;
    }

    public void setTouched(boolean touched) {
        this.touched = touched;
    }
}
