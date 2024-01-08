import java.time.LocalDate;

import Exceptions.FutureDateException;
import Exceptions.InvalidHiredDateException;

public class Dipendente {
	private String nome, cognome;
	private LocalDate dataNascita, dataAssunzione;
	
	//il costruttore può generare un'eccezione ("throws") di tipo Exception
	public Dipendente(String nome, String cognome, LocalDate dataNascita, LocalDate dataAssunzione) throws Exception {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		if (this.dataNascita.compareTo(LocalDate.now())>0 || this.dataAssunzione.compareTo(LocalDate.now())>0) 
			throw new FutureDateException();	
		else if (this.dataNascita.compareTo(dataAssunzione)>0)	//la data di nascita è successiva alla data di assunzione
			throw new InvalidHiredDateException();		//Lancio ("throw") un eccezione
		else
			this.dataAssunzione = dataAssunzione;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public LocalDate getDataNascita() {
		return dataNascita;
	}

	public LocalDate getDataAssunzione() {
		return dataAssunzione;
	}
	
	
	

}
