package comunicazione;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import classifica.Classifica;
import rmiClient.ClientRmi;
import rmiServer.RmiServer;
import rmiServer.RmiTaskControl;
import rubamazzo.Mossa;
import rubamazzo.SituazioneRubamazzo;
import slot.Rollata;
import tombola.SituazioneTombola;
import userModel.Utente;
import eccezioni.EccezioneUtente;
import encodec.Encoder;

public class Comunicazione {
	private PrintWriter writer = null;
	private BufferedReader reader = null;
	private boolean tipoCom;
	private RmiTaskControl server;
	private RmiServer serverLog;
	private ClientRmi client;
	
	
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
		writer.print(Encoder.mossaRubamazzo(m));
	}
	
	public void vintoTombolaSocket(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga){
		writer.print(Encoder.vintoTombola(numPartita,tipoVittoria,indiceCartella,indiceRiga));
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
	
	public Rollata riceviRollaSocket(){
		String s = reader.readLine();
		Rollata r = Decoder.clientRollata(s);
		return r;
	}
	
	public Utente riceviLoginSocket() throws IOException{
		String s = reader.readLine();
		Utente u = Decoder.clientLogin(s);
		return u;
	}
	
	public Utente riceviRegistraSocket(){
		String s = reader.readLine();
		Utente u = Decoder.clientRegistra(s);
		return u;
	}
	
	public ArrayList<String> riceviClassificaGlobaleSocket(){
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGlobale(s);
		return c;
	}
	
	public ArrayList<String> riceviClassificaGiornalieraSocket(){
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGiornaliera(s);
		return c;
	}
	
	
	
	public boolean giocoTombolaRmi(int numCartelle) throws EccezioneUtente{
		return server.giocoTombola(numCartelle);
	}
	
	public boolean giocoRubamazzoRmi() throws EccezioneUtente{
		return server.giocoRubamazzo();
	}
	
	public RmiTaskControl loginRmi(String username,String password){
		serverLog.login(client, username, password);
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
		writer.print(Encoder.mossaRubamazzo(m));
	}
	
	public void vintoTombolaSocket(int numPartita,int tipoVittoria,int indiceCartella, int indiceRiga){
		writer.print(Encoder.vintoTombola(numPartita,tipoVittoria,indiceCartella,indiceRiga));
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
	
	public Rollata riceviRollaSocket(){
		String s = reader.readLine();
		Rollata r = Decoder.clientRollata(s);
		return r;
	}
	
	public Utente riceviLoginSocket() throws IOException{
		String s = reader.readLine();
		Utente u = Decoder.clientLogin(s);
		return u;
	}
	
	public Utente riceviRegistraSocket(){
		String s = reader.readLine();
		Utente u = Decoder.clientRegistra(s);
		return u;
	}
	
	public ArrayList<String> riceviClassificaGlobaleSocket(){
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGlobale(s);
		return c;
	}
	
	public ArrayList<String> riceviClassificaGiornalieraSocket(){
		String s = reader.readLine();
		ArrayList<String> c = Decoder.clientClassificaGiornaliera(s);
		return c;
	}
	
	
	

}
