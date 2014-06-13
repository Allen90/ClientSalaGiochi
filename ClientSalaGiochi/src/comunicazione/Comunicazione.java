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
import userModel.EntryClassifica;
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
	private PrintWriter writer = null;
	// modficare login, registrazione rmi
	
	
	public Comunicazione(Socket client) throws IOException{
		tipoCom = true;
		
		reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
		writer = new PrintWriter(client.getOutputStream(), true);
		System.out.println("creo reader e writer");
	}
	
	public Comunicazione(RmiTaskControl server){
		this.server = server;
		tipoCom = false;
	}
	
	public Comunicazione(RmiServer serverLog){
		this.serverLog  = serverLog;
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
		System.out.println("Stringa da inviare"+Encoder.clientLogin(username, password));
		writer.print(Encoder.clientLogin(username, password));
		System.out.println("stringa inviata");
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
		writer.print(Encoder.clientMossaRubamazzo(m,numPartita));
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
		System.out.println("qui prima di leggere stringa");
		String s = reader.readLine();
		InfoHome ih = Decoder.clientAccesso(s);
		return ih;
	}
	
	public InfoHome riceviRegistraSocket() throws IOException{
		String s = reader.readLine();
		InfoHome ih = Decoder.clientAccesso(s);
		return ih;
	}
	
	public ArrayList<EntryClassifica> riceviClassificaGlobaleSocket() throws IOException{
		String s = reader.readLine();
		return Decoder.clientClassificaGlobale(s);
	}
	
	public ArrayList<EntryClassifica> riceviClassificaGiornalieraSocket() throws IOException{
		String s = reader.readLine();
		return Decoder.clientClassificaGiornaliera(s);
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
		return serverLog.login(username, password);
	}
	

	public RmiTaskControl registraRmi(String username, String password, String confPassword, String nome, String cognome) throws RemoteException, EccezioneUtente{
		return serverLog.registra(username,password,confPassword, nome, cognome);
	}
	
	public SituazioneTombola aggTombolarmi(){
		return server.aggTombola();
	}
	
	public SituazioneRubamazzo aggRubamazzoRmi(){
		return server.aggRubaMazzo();
	}
	
	public ArrayList<EntryClassifica> aggClassGlobaleRmi() throws EccezioneClassificaVuota{
		return server.aggClass();
	}
	
	public ArrayList<EntryClassifica> aggClassGiornRmi() throws EccezioneClassificaVuota{
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
	
	public boolean riceviVintoTombola() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseVintoTombola(s);
	}
	
	
	

}
