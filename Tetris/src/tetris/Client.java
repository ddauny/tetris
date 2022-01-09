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
    static public int portaDestinatario;
    static public InetAddress IPAddress;
    private DatagramSocket client;

    public Client(Buffer buffer) throws SocketException {
        this.buffer = buffer;
        client = new DatagramSocket();
    }

    public void send() throws IOException {
        if (buffer.getSizeMandare() > 0) {//se ci sono pacchetti da mandare mando 
            //System.out.println("sono entrato nel send");
            Pacchetto p = buffer.getNextPacchettoDaMandare();
            String s = p.toString(p);
            System.out.println("STO MANDANDO STO PACCHETTO: " + s);
            send(s);
        }
    }

    public void send(String s) throws UnknownHostException, IOException {
   
        byte[] data = s.getBytes();
        risposta = new DatagramPacket(data, data.length);
        IPAddress = InetAddress.getByName("localhost");//da cambiare in caso non sia in locale
        risposta.setAddress(IPAddress);
        //System.out.println("sto mandando sulla porta" + portaDestinatario);
        risposta.setPort(portaDestinatario);//porta dove mandare
        client.send(risposta);
    }

    @Override
    public void run() {
        while (Pacchetto.tipoConnessione != 'c' ) {
            try {
                send();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
