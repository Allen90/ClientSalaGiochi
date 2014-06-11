package comunicazione;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;
import java.util.ArrayList;

import rmiClient.ClientRmi;
import rmiServer.RmiServer;
import rmiServer.RmiTaskControl;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.InfoHome;
import userModel.Utente;
import eccezioni.EccezioneClassificaVuota;
import eccezioni.EccezioneUtente;
import encodec.Decoder;
import encodec.Encoder;

public class Comunicazione {
	
	private BufferedReader reader = null;
	private boolean tipoCom;
	private RmiTaskControl server;
	private RmiServer serverLog;
	private ClientRmi client;
	private PrintWriter writer = null;
	// modficare login, registrazione rmi
	
	
	public Comunicazione(Socket client) throws IOException{
		this.tipoCom = true;
		reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		writer = new PrintWriter(client.getOutputStream(), true);
	}
	
	public Comunicazione(RmiTaskControl server){
		this.server = server;
		tipoCom = false;
	}
	
	public Comunicazione(RmiServer serverLog, ClientRmi c){
		this.serverLog  = serverLog;
		this.client = client;
	}
	
	public boolean getTipoCom(){
		return tipoCom;
	}
	
	
	
	public void giocoTombolaSocket(int numCartelle){
		writer.print(Encoder.clientGiocoTombola(numCartelle));
	}
	
	public void giocoRubamazzoSocket(){
		writer.print(Encoder.clientGiocoRumbamazzo);
	}
	
	public void loginSocket(String username,String password){
		writer.print(Encoder.clientLogin(username, password));
	}
	
	public void registraSocket(String username, String password, String confPassword, String nome, String cognome){
		writer.print(Encoder.clientRegistra(username, password, confPassword, nome, cognome));
	}
	
	public void aggTombolaSocket(){
		writer.print(Encoder.clientAggiornaTombola);
	}
	
	public void aggRubamazzoSocket(){
		writer.print(Encoder.clientAggiornaRubamazzo);
	}
	
	public void aggClassSocket(){
		writer.print(Encoder.clientAggiornaClassifica);
	}
	
	public void mossaRubamazzoSocket(Mossa m, int numPartita){
		writer.print(Encoder.clientMossaRubamazzo(m));
	}
	
	public void vintoTombolaSocket(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga){
		writer.print(Encoder.clientVintoTombola(numPartita,tipoVittoria,indiceCartella,indiceRiga));
	}
	
	public void rollaSocket(){
		writer.print(Encoder.clientRolla);
	}
	
	public SituazioneTombola riceviAggTombolaSocket() throws IOException{
		String s = reader.readLine();
		SituazioneTombola sit = Decoder.clientAggTombola(s);
		return sit;
	}
	
	public SituazioneRubamazzo riceviAggRubamazzoSocket() throws IOException{
		String s = reader.readLine();
		SituazioneRubamazzo sit = Decoder.clientAggRubamazzo(s); 
		return sit;
	}
	
	public Rollata riceviRollaSocket() throws IOException{
		String s = reader.readLine();
		Rollata r = Decoder.clientRollata(s);
		return r;
	}
	
	public InfoHome riceviLoginSocket() throws IOException{
		String s = reader.readLine();
		InfoHome ih = Decoder.clientAccesso(s);
		return ih;
	}
	
	public InfoHome riceviRegistraSocket() throws IOException{
		String s = reader.readLine();
		InfoHome ih = Decoder.clientAccesso(s);
		return ih;
	}
	
	public ArrayList<String> riceviClassificaGlobaleSocket() throws IOException{
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGlobale(s);
		return c;
	}
	
	public ArrayList<String> riceviClassificaGiornalieraSocket() throws IOException{
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGiornaliera(s);
		return c;
	}
	
	public InfoHome getInfoHome() throws EccezioneUtente{
		return server.getInfoHome();
	}
	
	public boolean giocoTombolaRmi(int numCartelle) throws EccezioneUtente{
		return server.giocoTombola(numCartelle);
	}
	
	public boolean giocoRubamazzoRmi() throws EccezioneUtente{
		return server.giocoRubamazzo();
	}
	
	public RmiTaskControl loginRmi(String username,String password) throws RemoteException, EccezioneUtente{
		return serverLog.login(client, username, password);
	}
	

	public RmiTaskControl registrarmi(String username, String password, String confPassword, String nome, String cognome) throws RemoteException, EccezioneUtente{
		return serverLog.registra(client, username,password,confPassword, nome, cognome);
	}
	
	public SituazioneTombola aggTombolarmi(){
		return server.aggTombola();
	}
	
	public SituazioneRubamazzo aggRubamazzoRmi(){
		return server.aggRubaMazzo();
	}
	
	public ArrayList<Utente> aggClassGlobaleRmi() throws EccezioneClassificaVuota{
		return server.aggClass();
	}
	
	public ArrayList<Utente> aggClassGiornRmi() throws EccezioneClassificaVuota{
		return server.aggClassGiorn();
	}
	
	public boolean mossaRubamazzoRmi(Mossa m, int numPartita){
		return server.mossaRubamazzo(m, numPartita);
	}
	
	public boolean vintoTombolaRmi(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga){
		return server.vintoTombola(numPartita, tipoVittoria, indiceCartella, indiceRiga);
	}
	
	public Rollata rollaRmi(){
		return server.rolla();
	}

	
	
	

}
