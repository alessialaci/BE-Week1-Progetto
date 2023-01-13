import interfacce.Luminosita;
import interfacce.Volume;

public class Video extends ElementoMultimediale implements Volume, Luminosita {
	
	public Video(String titolo, int durata) {
		super(titolo, durata);
	}

	@Override
	public int abbassaVolume() {
		if(volume <= 0) {
			return volume = 0;
		}
		return volume--;
	}

	@Override
	public int alzaVolume() {
		if(volume >= 10) {
			return volume = 10;
		}
		return volume++;
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
	
	public void play() {
		System.out.print("Riproduzione di...");
		
		for(int i = this.durata; i > 0; i--) {
			
			String volume = "";
			String luminosita = "";
			
			System.out.printf("%n%s volume: %s luminosità: %s", this.titolo, volume, luminosita);
			
			for(int v = this.volume; v > 0; v--) {
				volume += "!";
			}
			
			for(int l = this.luminosita; l > 0; l--) {
				luminosita += "*";;
			}
		}

		System.out.printf("%nFine riproduzione%n%n");
	}
	
	@Override
    public String toString() {
        return "Elemento Video: " + this.titolo + " durata: " + this.durata;
    }


}
