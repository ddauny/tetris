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
public class Server {
    private Buffer buffer;
    static DatagramPacket pacchetto;
    static InetAddress IPAddress;
    static DatagramSocket server;
    static byte[] data = new byte[1024];
    static DatagramPacket p;
    static String s = "";
    static String[] v;
    
    
    public Server(Buffer buffer) throws SocketException{
        this.buffer = buffer;
        server = new DatagramSocket(12346);
    }        
            
    private static String[] receive() throws SocketException {
        String[] v = {};
        try {
            p = new DatagramPacket(data, data.length);
            server.receive(p);
            s = new String(p.getData());
            v = s.split(";");
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }
}
