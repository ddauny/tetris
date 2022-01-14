/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tetris;

import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dani2
 */
public class Window extends javax.swing.JFrame {

    private static Buffer buffer;
    private Peer peer;

    /**
     * Creates new form Window
     */
    public Window() throws SocketException {
        initComponents();
        this.setTitle("CONNESSIONE");
        buffer = new Buffer();
        Client.portaDestinatario = 12345;//da togliere nella versione definitiva
        Server.portaServer = 12345;//da togliere nella versione definitiva
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtPorta = new javax.swing.JTextField();
        btnConnetti = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtIp = new javax.swing.JTextField();
        txtServer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnSkip = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nome:");

        jLabel2.setText("Porta:");

        btnConnetti.setText("Connetti");
        btnConnetti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnettiActionPerformed(evt);
            }
        });

        jLabel4.setText("IP:");

        txtIp.setText("localhost");

        jButton1.setText("set variabili");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnSkip.setText("skip");
        btnSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNome)
                            .addComponent(txtPorta)
                            .addComponent(txtIp, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSkip, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 90, Short.MAX_VALUE)
                                .addComponent(btnConnetti))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConnetti)
                                .addGap(0, 6, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnSkip, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtServer, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void gameOver() {
        JOptionPane.showConfirmDialog(null, "GameOver", "Hai perso!", JOptionPane.OK_CANCEL_OPTION);
    }

    private void btnConnettiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnettiActionPerformed
        String nome = txtNome.getText();
       // String ip = txtIp.getText();//"localhost"
        //String porta = txtPorta.getText();
        if (check(nome)) {
            Pacchetto p = new Pacchetto("a;" + nome);
            buffer.addPacchettoDaMandare(p);
        } else {
            JOptionPane.showConfirmDialog(null, "Nome non valido!", "Errore", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_btnConnettiActionPerformed

    private boolean check(String nome) {
        if (nome != null && !nome.equals("") && !nome.contains(";")) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // BOTTONE PER PROVARE IN LOCALE
        // String nome = txtNome.getText();
        //String ip = txtIp.getText();
//
//        Client.portaDestinatario = Integer.parseInt(txtPorta.getText());
//        //Client.ip = ip;
//        Server.portaServer = Integer.parseInt(txtServer.getText());
//        try {
//            peer = new Peer(buffer);
//        } catch (SocketException ex) {
//            Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        Peer.initPeer();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipActionPerformed
        // TODO add your handling code here:
        //   initGame();

    }//GEN-LAST:event_btnSkipActionPerformed

    public static void richiestaConnessione(String avversario) {
        int r = JOptionPane.showConfirmDialog(null, "Connessione", "Accettare connessione da " + avversario + "?", JOptionPane.OK_CANCEL_OPTION);
        //se ok 0, annulla 1
        if (r == 0) {//se accetto
            String nome = JOptionPane.showInputDialog(null, "Inserisci nome", null);
            buffer.addPacchettoDaMandare(new Pacchetto("y;" + nome));
            initGame();//avvio il gioco vero e proprio 
        } else {
            buffer.addPacchettoDaMandare(new Pacchetto("n; "));
            System.out.println("RIFIUTO CONNESSIONE");
        }
    }

    public static void rifiutoConnessione() {
        JOptionPane.showConfirmDialog(null, "Connessione", "Connessione rifiutata", JOptionPane.OK_CANCEL_OPTION);

    }

    static Board b = new Board(buffer);

    public static void initGame() {
        b.startBoard(buffer);
        // b.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Window().setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnetti;
    private javax.swing.JButton btnSkip;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtIp;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPorta;
    private javax.swing.JTextField txtServer;
    // End of variables declaration//GEN-END:variables

}
