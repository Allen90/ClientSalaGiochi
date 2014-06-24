package comunicazione;

import java.io.IOException;

import rubamazzo.Mossa;

import eccezioni.EccezioneUtente;

public class InvioMosseRubamazzo implements Runnable{
	
	boolean finito;
	private Comunicazione comunicazione;

	public InvioMosseRubamazzo(Comunicazione comunicazione){
		this.comunicazione = comunicazione;
		finito = false;
	}


	public boolean invio(Mossa m, int numPartita) throws IOException, EccezioneUtente{
		boolean ok;
		if(comunicazione.getTipoCom())
		{
			System.out.println("sto per mandare la mossa socket");
			comunicazione.mossaRubamazzoSocket(m, numPartita);
			System.out.println("mossa socket inviata");
			ok = comunicazione.riceviMossaRubamazzo();
			System.out.println("ricevuto response dal server: "+ok);
		}
		else {
			ok = comunicazione.mossaRubamazzoRmi(m, numPartita);
		}
		return ok;
	}
	
	public void setFinito(){
		finito = true;
	}

	public void run(){
		while(finito == false){

		}
	}
}
