import interfacce.Luminosita;

public class Immagine extends ElementoMultimediale implements Luminosita {

	public Immagine(String titolo) {
		super(titolo);
	}

	@Override
	public int diminuisciLuminosita() {
		if(luminosita <= 0) {
			return luminosita = 0;
		}
		return luminosita--;
	}

	@Override
	public int aumentaLuminosita() {
		if(luminosita >= 10) {
			return luminosita = 10;
		}
		return luminosita++;
	}
	
	public void show() {
		System.out.println("Mostra immagine...");
		
		String luminosita = "";
		
		for(int l = this.luminosita; l > 0; l--) {
			luminosita += "*";
		}
		
		System.out.println(this.titolo + " luminosità: " + luminosita);
		System.out.printf("Fine%n%n");
	}
	
	@Override
    public String toString() {
        return "Elemento Immagine " + this.titolo;
    }

}
