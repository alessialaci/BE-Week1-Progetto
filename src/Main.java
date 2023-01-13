import java.util.Scanner;

public class Main {
	
	private static ElementoMultimediale[] elementi = new ElementoMultimediale[5];
	private static int counter = 0;

	public static void main(String[] args) {
		
		lettore();
		
	}
	
	public static void lettore() {
		
		Scanner scan1 = new Scanner(System.in);
		
		System.out.println("Salva qui tutti i tuoi elementi multimediali");
			
		do {
			System.out.println("Inserisci il tipo. Premi 1 per Video, 2 per Audio o 3 per Immagine");
			int tipo = scan1.nextInt();
			
			if(tipo == 1) {
				Scanner scan2 = new Scanner(System.in);
				System.out.println("Inserisci il titolo");
				String titolo = scan2.nextLine();
				System.out.println("Inserisci la durata");
				int durata = scan2.nextInt();
				System.out.println(titolo + durata);
				elementi[counter] = new Video(titolo, durata);
			    counter++;
			} else if(tipo == 2) {
				Scanner scan3 = new Scanner(System.in);
				System.out.println("Inserisci il titolo");
				String titolo = scan3.nextLine();
				System.out.println("Inserisci la durata");
				int durata = scan3.nextInt();
				System.out.println(titolo + durata);
				elementi[counter] = new Audio(titolo, durata);
			    counter++;
			} else if(tipo == 3) {
				Scanner scan4 = new Scanner(System.in);
				System.out.println("Inserisci il titolo");
				String titolo = scan4.nextLine();
				System.out.println(titolo);
				elementi[counter] = new Immagine(titolo);
			    counter++;
			} else {
				System.out.println("Valore errato.");
			}
		} while ( counter < 5 );
		
		int x = 0;
		for(int i = 0; i < counter; i++) {
			x++;
		    System.out.println(x + " - " + elementi[i]);
		}
		
		scan1.close();
		sceltaElemento();
		
	}
	
	public static void sceltaElemento() {
		Scanner scan6 = new Scanner(System.in);
		System.out.println("Scegli un elemento da mostrare/riprodurre");
		int sceltaMedia = scan6.nextInt();
		switch(sceltaMedia) {
			case(0):
				lettore();
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
            	lettore();
		}
	}
	
	public static void controlloTipo(ElementoMultimediale array) {
		if(array instanceof Video) {
			((Video) array).play();
		} else if (array instanceof Audio) {
			((Audio) array).play();
		} else {
			((Immagine) array).show();
		}
	}

}
