import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int g,m,a;
		LocalDate d=null;
		boolean esito;
	
		do {
			System.out.println("Inserisci la tua data di nascita: ");		
			
			try {			//provo ad eseguire questo codice
				System.out.println("Giorno: ");
				g=Integer.parseInt(sc.nextLine());	//metodo statico			
				System.out.println("Mese: ");
				m=Integer.parseInt(sc.nextLine());	//metodo statico
				System.out.println("Anno: ");
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
		
		System.out.println("La data inserita è: "+d.toString());
		sc.close();
	}

}
