import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import Exceptions.FutureDateException;
import Exceptions.InvalidHiredDateException;

public class Main {
	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {		
		
		LocalDate dataNascita=null;
		LocalDate dataAssunzione=null;
	
		dataNascita=inserisciData("Inserisci la tua data di nascita:");
		dataAssunzione=inserisciData("Inserisci la tua data di assunzione:");
				
		
		try {
			Dipendente dip=new Dipendente("Mario", "Rossi", dataNascita, dataAssunzione);
			System.out.println("Dipendente inserito correttamente");
		} catch (FutureDateException e) {
			System.out.println("E' stata inserita una data del futuro");
		} catch (InvalidHiredDateException e) {
			System.out.println("La data di assunzione non può essere precedente alla data di nascita");
		}  
		
		catch (Exception e) {
			System.out.println("Dipendente non inserito correttamente");
		}
		
		sc.close();
	}
	
	public static LocalDate inserisciData(String messaggio) {
		int g,m,a;
		
		boolean esito;
		LocalDate d=null;
		do {
			System.out.println(messaggio);		
			
			try {			//provo ad eseguire questo codice
				System.out.print("Giorno: ");
				g=Integer.parseInt(sc.nextLine());	//metodo statico			
				System.out.print("Mese: ");
				m=Integer.parseInt(sc.nextLine());	//metodo statico
				System.out.print("Anno: ");
				a=Integer.parseInt(sc.nextLine());	//metodo statico
				d=LocalDate.of(a, m, g);
				esito=true;
			} catch(NumberFormatException e) {	//se si verifica un'eccezione del tipo NumberFormatException  allora esegui quest'altro codice:
				System.out.println("non hai inserito un numero intero");
				esito=false;
			} catch(DateTimeException e) {	//se si verifica un'eccezione del tipo DateTimeException allora esegui quest'altro codice:
				System.out.println("non hai inserito una data valida");
				esito=false;
			}
			
		} while (esito==false);
		
		return d;
	}

}
