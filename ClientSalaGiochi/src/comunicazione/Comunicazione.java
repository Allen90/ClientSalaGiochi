package comunicazione;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.RemoteException;
import java.text.ParseException;
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
		writer.flush();
		System.out.println("creo reader e writer");
	}
	
	public Comunicazione(){
		tipoCom = false;
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
		writer.println(Encoder.clientGiocoTombola(numCartelle));
		writer.flush();
	}
	
	public void giocoRubamazzoSocket(){
		writer.println(Encoder.clientGiocoRumbamazzo);
	}
	
	public void loginSocket(String username,String password){
		writer.println(Encoder.clientLogin(username, password));
	}
	
	public void registraSocket(String username, String password, String confPassword, String nome, String cognome){
		writer.println(Encoder.clientRegistra(username, password, confPassword, nome, cognome));
	}
	
	public void aggTombolaSocket(){
		writer.println(Encoder.clientAggiornaTombola);
	}
	
	public void aggRubamazzoSocket(){
		writer.println(Encoder.clientAggiornaRubamazzo);
	}
	
	public void aggClassSocket(){
		writer.println(Encoder.clientAggiornaClassifica);
	}
	
	public void mossaRubamazzoSocket(Mossa m, int numPartita){
		writer.println(Encoder.clientMossaRubamazzo(m,numPartita));
	}
	
	public void vintoTombolaSocket(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga){
		writer.println(Encoder.clientVintoTombola(numPartita,tipoVittoria,indiceCartella,indiceRiga));
	}
	
	public void rollaSocket(){
		writer.println(Encoder.clientRolla);
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
	
	public InfoHome riceviLoginSocket() throws IOException, ParseException{
		String s = reader.readLine();
		InfoHome ih = Decoder.clientAccesso(s);
		return ih;
	}
	
	public InfoHome riceviRegistraSocket() throws IOException, ParseException{
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
	
	public InfoHome getInfoHome() throws EccezioneUtente, RemoteException{
		return server.getInfoHome();
	}
	
	public boolean giocoTombolaRmi(int numCartelle) throws EccezioneUtente, RemoteException{
		return server.giocoTombola(numCartelle);
	}
	
	public boolean giocoRubamazzoRmi() throws EccezioneUtente, RemoteException{
		return server.giocoRubamazzo();
	}
	
	public RmiTaskControl loginRmi(String username,String password) throws RemoteException, EccezioneUtente{
		return serverLog.login(username, password);
	}
	

	public RmiTaskControl registraRmi(String username, String password, String confPassword, String nome, String cognome) throws RemoteException, EccezioneUtente, ParseException{
		return serverLog.registra(username,password,confPassword, nome, cognome);
	}
	
	public SituazioneTombola aggTombolarmi() throws RemoteException{
		return server.aggTombola();
	}
	
	public SituazioneRubamazzo aggRubamazzoRmi() throws RemoteException{
		return server.aggRubaMazzo();
	}
	
	public ArrayList<EntryClassifica> aggClassGlobaleRmi() throws EccezioneClassificaVuota, RemoteException{
		return server.aggClass();
	}
	
	public ArrayList<EntryClassifica> aggClassGiornRmi() throws EccezioneClassificaVuota, RemoteException{
		return server.aggClassGiorn();
	}
	
	public boolean mossaRubamazzoRmi(Mossa m, int numPartita) throws RemoteException{
		return server.mossaRubamazzo(m, numPartita);
	}
	
	public boolean vintoTombolaRmi(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga) throws EccezioneUtente, RemoteException{
		return server.vintoTombola(numPartita, tipoVittoria, indiceCartella, indiceRiga);
	}
	
	public Rollata rollaRmi() throws RemoteException, EccezioneUtente{
		return server.rolla();
	}
	
	public boolean riceviVintoTombola() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseVintoTombola(s);
	}
	
	public boolean riceviGiocoTombola() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseGiocoTombola(s);
		
	}
	
	public boolean riceviGiocoRubamazzo() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseGiocoRubamazzo(s);
	}
	
	public boolean riceviMossaRubamazzo() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseMossaRubamazzo(s);
	}
	
	public void logoutSocket(){
		writer.println(Encoder.clientLogout);
	}
	
	public boolean riceviLogoutSocket() throws IOException{
		String s = reader.readLine();
		return Decoder.clientResponseLogout(s);
	}
	
	public boolean logoutRmi() throws RemoteException, EccezioneUtente{
		return server.logout();
	}

}
