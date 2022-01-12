package tetris.blocchi;

import java.awt.Color;
import javax.swing.JPanel;
import tetris.Blocco;

/**
 * @brief Classe del tetramino Ipiece, dà la posizione inziale e le varie
 * posizioni che può qavere quando gira
 *
 *
 * @author iania_daniele
 */
public class Ipiece extends Blocco {

    JPanel[][] pieceI = new JPanel[4][4];
    JPanel[][] nextPos = new JPanel[4][4];

    public Ipiece() {
        for (int j = 0; j < 4; j++) { // x
            for (int i = 0; i < 4; i++) { //Y
                pieceI[j][i] = new JPanel();
                pieceI[j][i].setSize(30, 30);
                pieceI[j][i].setBackground(Color.gray);
            }
        }

        for (int i = 0; i < 4; i++) { //Y
            pieceI[0][i] = new JPanel();
            pieceI[0][i].setBackground(Color.blue);
            // Inizializzazione
            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    nextPos[x][y] = new JPanel();
                    nextPos[x][y].setSize(30, 30);
                    nextPos[x][y].setBackground(Color.gray);
                }
            }

            for (int x = 0; x < 4; x++) {
                for (int y = 0; y < 4; y++) {
                    pieceI[x][y] = new JPanel();
                    pieceI[x][y].setSize(30, 30);
                    pieceI[x][y].setBackground(Color.gray);
                }
            }

            for (int y = 0; y < 4; y++) { // riempio con un for, tanto è una riga dritta
                pieceI[0][y].setBackground(Color.blue);
            }
        }
    }

    public JPanel restituisciPezzo(int x, int y) {
        return pieceI[x][y];
    }

    /**
     * *
     * @BRIEF varie posizioni del pezzo se viene girato
     * @param n(Attuale posizione del pezzo)
     * @return Il pezzo in posizione girata
     */
    public JPanel[][] prossimaPosizione(int n) {

        switch (n) {
            case 0, 2:
                // Orizzontale
                for (int i = 0; i < 4; i++) { //X                 
                    nextPos[i][0] = new JPanel();
                    nextPos[i][0].setBackground(Color.blue);
                }

                break;
            case 1, 3:
                for (int i = 0; i < 4; i++) { //Y
                    nextPos[3][i] = new JPanel();
                    nextPos[3][i].setBackground(Color.blue);
                }
                break;
        }

        return nextPos;
    }
}
