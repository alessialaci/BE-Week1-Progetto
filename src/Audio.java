import interfacce.Volume;

public class Audio extends ElementoMultimediale implements Volume {
	
	public Audio(String titolo, int durata) {
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
	
	public void play() {
		System.out.print("Riproduzione di...");

		for(int i = this.durata; i > 0; i--) {
			String volume = "";
			
			for(int v = this.volume; v > 0; v--) {
				volume += "!";
			}
			
			System.out.printf("%n%s volume: %s", this.titolo, volume);
		}

		System.out.printf("%nFine riproduzione%n%n");
	}
	
	@Override
    public String toString() {
        return "Elemento Audio: " + this.titolo + " durata: " + this.durata;
    }
}
