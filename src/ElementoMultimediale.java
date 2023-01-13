
abstract public class ElementoMultimediale {
	
	String titolo;
	int durata;
	int volume = 5;
	int luminosita = 5;
	
	public ElementoMultimediale(String titolo) {
		this.titolo = titolo;
	}
	
	public ElementoMultimediale(String titolo, int durata) {
		this(titolo);
		this.durata = durata;
	}
	
}
