import java.util.Scanner;

public class Main {
	
	private static ElementoMultimediale[] elementi = new ElementoMultimediale[5];
	private static int counter = 0;

	public static void main(String[] args) {
		System.out.println("PLAYER MULTIMEDIALE");
		System.out.println("Salva qui i tuoi file multimediali (fino a 5 elementi)");
		lettore();
	}
	
	public static void lettore() {
		
		Scanner scan1 = new Scanner(System.in);
			
		do {
			System.out.println("Inserisci il tipo. Premi 1 per Video, 2 per Audio o 3 per Immagine");
			int tipo = scan1.nextInt();
			
			if(tipo == 1) {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Inserisci il titolo:");
				String titolo = scan2.nextLine();
				System.out.println("Inserisci la durata:");
				int durata = scan2.nextInt();
				System.out.println("Elemento " + titolo + " durata " + durata + " minuti inserito!");
				elementi[counter] = new Video(titolo, durata);
			    counter++;
			} else if(tipo == 2) {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Inserisci il titolo:");
				String titolo = scan3.nextLine();
				System.out.println("Inserisci la durata:");
				int durata = scan3.nextInt();
				System.out.println("Elemento " + titolo + " durata " + durata + " minuti inserito!");
				elementi[counter] = new Audio(titolo, durata);
			    counter++;
			} else if(tipo == 3) {
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Inserisci il titolo:");
				String titolo = scan4.nextLine();
				System.out.println("Elemento " + titolo + " inserito!");
				elementi[counter] = new Immagine(titolo);
			    counter++;
			} else {
				System.out.println("Valore errato.");
			}
		} while ( counter < 5 );
		
		int x = 0;
		System.out.println("Ecco la lista dei tuoi elementi:");
		for(int i = 0; i < counter; i++) {
			x++;
		    System.out.println(x + " - " + elementi[i]);
		}

		sceltaElemento();
		scan1.close();
		
	}
	
	public static void sceltaElemento() {
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Scegli un elemento (o premi 0 per uscire):");
		int sceltaMedia = scan6.nextInt();
		switch(sceltaMedia) {
			case(0):
				System.out.println("Non stai riproducendo/mostrando nessun file multimediale");
				break;
        	case(1):
        		controlloTipo(elementi[0]);
        		break;
        	case(2):
        		controlloTipo(elementi[1]);
            	break;
        	case(3):
        		controlloTipo(elementi[2]);
            	break;
        	case(4):
        		controlloTipo(elementi[3]);
            	break;
        	case(5):
        		controlloTipo(elementi[4]);
            	break;
            default:
            	System.out.println("Valore errato, scegli tra quelli mostrati");
            	sceltaElemento();
		}
		scan6.close();
	}
	
	public static void controlloTipo(ElementoMultimediale array) {
		if(array instanceof Video) {
			Scanner scan7 = new Scanner(System.in);
			System.out.println("Premi il numero corrispondente all'azione desiderata:");
			System.out.println("1 - Riproduci");
			System.out.println("2 - Aumenta Volume");
			System.out.println("3 - Abbassa Volume");
			System.out.println("4 - Aumenta Luminosità");
			System.out.println("5 - Abbassa Luminosità");
			
			int select = scan7.nextInt();
			
			switch(select) {
				case(1):
					((Video) array).play();
					sceltaElemento();
					break;
				case(2):
					((Video) array).alzaVolume();
					System.out.println("Volume aumentato!");
					controlloTipo(array);
					break;
				case(3):
					((Video) array).abbassaVolume();
					System.out.println("Volume abbassato!");
					controlloTipo(array);
					break;
				case(4):
					((Video) array).aumentaLuminosita();
					System.out.println("Luminosità aumentata!");
					controlloTipo(array);
					break;
				case(5):
					((Video) array).diminuisciLuminosita();
					System.out.println("Luminosità abbassata!");
					controlloTipo(array);
					break;
				default:
					System.out.println("Valore errato");
					controlloTipo(array);
					break;
			}
			scan7.close();
		} else if (array instanceof Audio) {
			Scanner scan8 = new Scanner(System.in);
			System.out.println("Premi il numero corrispondente all'azione desiderata:");
			System.out.println("1 - Riproduci");
			System.out.println("2 - Aumenta Volume");
			System.out.println("3 - Abbassa Volume");
			int select = scan8.nextInt();
			
			switch(select) {
				case(1):
					((Audio) array).play();
					sceltaElemento();
					break;
				case(2):
					((Audio) array).alzaVolume();
					System.out.println("Volume aumentato!");
					controlloTipo(array);
					break;
				case(3):
					((Audio) array).abbassaVolume();
					System.out.println("Volume abbassato!");
					controlloTipo(array);
					break;
				default:
					System.out.println("Valore errato");
					controlloTipo(array);
					break;
			}
			scan8.close();
		} else {
			Scanner scan9 = new Scanner(System.in);
			System.out.println("Premi il numero corrispondente all'azione desiderata:");
			System.out.println("1 - Riproduci");
			System.out.println("2 - Aumenta Luminosità");
			System.out.println("3 - Abbassa Luminosità");
			int select = scan9.nextInt();
			
			switch(select) {
				case(1):
					((Immagine) array).show();
					sceltaElemento();
					break;
				case(2):
					((Immagine) array).aumentaLuminosita();
					System.out.println("Luminosità aumentata!");
					controlloTipo(array);
					break;
				case(3):
					((Immagine) array).diminuisciLuminosita();
					System.out.println("Luminosità abbassata!");
					controlloTipo(array);
					break;
				default:
					System.out.println("Valore errato");
					controlloTipo(array);
					break;
			}
			scan9.close();
		}
	}

}