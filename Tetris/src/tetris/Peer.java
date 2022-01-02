/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

import java.net.SocketException;

/**
 *
 * @author iania_daniele
 */
public class Peer {
    Buffer buffer;
    Server server;
    Client client;
    Elabora elabora;
    
    public Peer(Buffer buffer) throws SocketException{
        this.buffer = buffer;
        server = new Server(buffer);
        client = new Client(buffer);
        elabora = new Elabora(buffer);
    }
    
    public void startPeer(){
        server.start();
        client.start();
        elabora.start();
    }
}
