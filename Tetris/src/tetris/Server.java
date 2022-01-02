/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iania_daniele
 */
public class Server extends Thread {

    private Buffer buffer;
    private DatagramSocket server;
    private byte[] data;
    private DatagramPacket p;
    private String s = "";

    public Server(Buffer buffer) throws SocketException {
        this.buffer = buffer;
        server = new DatagramSocket(12346);
        data = new byte[1024];
    }

    private void receive() throws SocketException {
        try {
            p = new DatagramPacket(data, data.length);
            server.receive(p);
            s = new String(p.getData());
            buffer.addPacchettoRicevuto(new Pacchetto(s));
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
        while (Pacchetto.tipoConnessione != 'c') {
            try {
                receive();
            } catch (SocketException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
