package comunicazione;

import java.io.IOException;

import eccezioni.EccezioneUtente;

public class InvioVittorieTombola implements Runnable{

	boolean finito;
	private Comunicazione comunicazione;

	public InvioVittorieTombola(Comunicazione comunicazione){
		this.comunicazione = comunicazione;
		finito = false;
	}


	public boolean invio(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga) throws IOException, EccezioneUtente{
		boolean ok;
		if(comunicazione.getTipoCom())
		{
			comunicazione.vintoTombolaSocket(numPartita, tipoVittoria, indiceCartella, indiceRiga);
			ok = comunicazione.riceviVintoTombola();
		}
		else {
			ok = comunicazione.vintoTombolaRmi(numPartita, tipoVittoria, indiceCartella, indiceRiga);
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
