/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetris;

/**
 *
 * @author iania_daniele
 */
public class Dati {
    //elaboro dati e aggiorno
    private Buffer buffer;
    Pacchetto p;
    
    public Dati(Buffer buffer) {
        this.buffer = buffer;
    }

    public void esamina(){
        while(Pacchetto.tipoConnessione != 'c'){
            if(buffer.getSizeRicevuti() > 0){
                p = buffer.getNextPacchettoRicevuto();
                if(!p.tipo.equals("g")){//se non è un pacchetto game
                    char c = Pacchetto.tipoConnessione;
                    switch(c){
                        case 'a'://richiesta connessione
                            
                            break;
                        case 'y'://ricevo conferma connessione
                            
                            break;
                        case 'n'://ricevo rifiuto connessione
                            
                            break;                            
                    }                                     
                }
            }
        }
    }   
}
