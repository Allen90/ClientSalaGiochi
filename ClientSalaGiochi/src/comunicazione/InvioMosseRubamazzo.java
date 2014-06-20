package comunicazione;

import java.io.IOException;

import eccezioni.EccezioneUtente;

public class InvioMosseRubamazzo implements Runnabale{
	
	boolean finito;
	private Comunicazione comunicazione;

	public InvioMosseRubamazzo(Comunicazione comunicazione){
		this.comunicazione = comunicazione;
		finito = false;
	}


	public boolean invio() throws IOException, EccezioneUtente{
		boolean ok;
		if(comunicazione.getTipoCom())
		{
			comunicazione.mossaRubamazzoSocket(m, numPartita);
			ok = comunicazione.riceviMossaRubamazzo();
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
