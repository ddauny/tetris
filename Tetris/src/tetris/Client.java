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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iania_daniele
 */
public class Client extends Thread {

    private DatagramPacket risposta;
    private Buffer buffer;
    static public String ip;
    private InetAddress IPAddress;
    private DatagramSocket client;

    public Client(Buffer buffer) throws SocketException {
        this.buffer = buffer;
        client = new DatagramSocket(12344);
    }

    public void send() throws IOException {
        if (buffer.getSizeMandare() > 0) {//se ci sono pacchetti da mandare mando 
            Pacchetto p = buffer.getNextPacchettoDaMandare();
            send(p.toString(p));
        }
    }

    public void send(String s) throws UnknownHostException, IOException {
        byte[] data = s.getBytes();
        risposta = new DatagramPacket(data, data.length);
        IPAddress = InetAddress.getByName(ip);
        risposta.setAddress(IPAddress);
        risposta.setPort(12346);//porta dove mandare
        client.send(risposta);
    }

    @Override
    public void run() {
        while (Pacchetto.tipoConnessione == 'g') {
            try {
                send();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
