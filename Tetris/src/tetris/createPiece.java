package tetris;

import java.awt.Color;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import tetris.blocchi.Ipiece;
import tetris.blocchi.Lpiece;
import tetris.blocchi.Opiece;
import tetris.blocchi.Spiece;
import tetris.blocchi.Tpiece;
import tetris.blocchi.reverseLpiece;
import tetris.blocchi.reverseSpiece;


/**
 * @author galliFrancesco
 * @brief Questo Thread prende un numero casuale e genera un blocco da una classe
 * @return Blocco block
 */
public class createPiece{
    Board b;
    JPanel[][] board; // Matrice della Board
    JPanel[][] blocco; // Matrice del blocco che va poi 
    Blocco block ; 
    
    public createPiece(JPanel[][] tmp, Board b, Blocco block){
        //gli passo la matrice
        this.b = b; 
        this.board = tmp; 
        blocco = new JPanel[4][4];       
        this.block = block;      
        
        for(int i = 0; i<4; i++)
            for(int j = 0; j<4; j++){
                blocco[j][i] = new JPanel();
                blocco[j][i].setSize(30,30);
                blocco[j][i].setBackground(Color.gray);
            }  
    }
    
    public void run(){        
        synchronized(this){     
            // posiziona e pittura il pezzo
            generatePiece();
            paintPiece();         
        }     
        
        b.repaint();          
        try { 
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(createPiece.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void generatePiece(){
            Random r = new Random(); 
            int scelta = r.nextInt(7);                 
            
            switch (scelta) {
                case 0:
                    // Ipiece -> Linea
                    Ipiece i = new Ipiece();
                    System.out.println("Linea");
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(i.restituisciPezzo(x1, y1).getBackground());
                           //block.setBlock(x1, y1, blocco[x1][y1]); 
                        }
                    block.setBlocco(blocco);
                    block.setPezzo("i"); 
                    block.setPosizione(0);

                    break;
                case 1:
                    // Lpiece -> pezzo L
                    Lpiece l = new Lpiece();
                    System.out.println("L");
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(l.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);
                    block.setPezzo("l"); 
                    block.setPosizione(0);
                    
                    break;
                case 2:
                    // Opiece -> pezzo Quadrato
                    Opiece o = new Opiece();
                    System.out.println("O"); 
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(o.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);  
                    block.setPezzo("o"); 
                    block.setPosizione(0);
                    
                    break;
                case 3:
                    // Spiece -> pezzo S
                    Spiece s = new Spiece();
                    System.out.println("S"); 
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(s.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);
                    block.setPezzo("s"); 
                    block.setPosizione(0);

                    break;
                case 4:
                    // Tpiece -> pezzo T
                    Tpiece t = new Tpiece();
                    System.out.println("T"); 
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(t.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);
                    block.setPezzo("t"); 
                    block.setPosizione(0);

                    break;
                case 5:
                    // reverseLPiece -> pezzo L reverse
                    reverseLpiece rl = new reverseLpiece();
                    System.out.println("RL"); 
                    
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(rl.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);
                    block.setPezzo("rl"); 
                    block.setPosizione(0);

                    break;
                case 6:
                    // reverseSPiece -> pezzo S reverse
                    reverseSpiece rs = new reverseSpiece();
                    System.out.println("Z"); 
                  
                    for(int x1 = 0; x1 < 4; x1++)
                        for(int y1 = 0; y1< 4; y1++){
                            blocco[x1][y1].setBackground(rs.restituisciPezzo(x1, y1).getBackground());
                            //block.setBlock(x1, y1, blocco[x1][y1]);
                        }
                    block.setBlocco(blocco);  
                    block.setPezzo("rZ"); 
                    block.setPosizione(0);
               
                    break;     
            }
    }
    
    
    private void paintPiece(){   
        // posiziona il pezzo in alto a sinistra
        for(int x1 = 0; x1 < 4; x1++){            
            for(int y1 = 0; y1< 4; y1++){
                board[x1][y1].setBackground(blocco[x1][y1].getBackground());
            }
        }
        
        b.repaint();     
    }
    
    public Blocco getBlocco(){    
        return block; 
    }
}
