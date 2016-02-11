import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class BygningFilMain{

	private static Bygning lagNyBygning(String[] arg) {
		//System.out.println("Vil lage ny bygning med " + arg[1] + "areal");
		double grunnAreal = Double.parseDouble(arg[1]); // for tydeligere kode
		return new Bygning(grunnAreal);
	}

	private static Skyskraper lagNySkyskraper(String[] arg) {
		//System.out.println("Vil lage ny skyskraper med " + arg[1] + "areal og " + arg[2] + " etasjer");
		double grunnAreal = Double.parseDouble(arg[1]); // for tydeligere kode
		int etasjer = Integer.parseInt(arg[2]);
		return new Skyskraper(grunnAreal, etasjer);
	}

	public static void main(String[] args)
		throws FileNotFoundException {             


		Scanner infile = new Scanner(new File("bygning.txt"));
		String antall = infile.nextLine();
		int n = Integer.parseInt(antall);
		Bygning[] bygninger = new Bygning[n];
		int teller = 0;
        
		while (infile.hasNextLine()) {
			/*
			 * Split deler iforhold til det som sendes inn som argument
			 * Det er noe som heter REGEX som definerer hvordan argumentet
			 * tolkes, men vanlig space er det som er noedvendig å benytte
			 * i inf1010
			 */
			String[] argumenter = infile.nextLine().split(" ");
			if (argumenter[0].equals("SKYSKRAPER")) {
				bygninger[teller++] = lagNySkyskraper(argumenter);
			}
			else if (argumenter[0].equals("BYGNING")) {
				bygninger[teller++] = lagNyBygning(argumenter);
			}
			else {
				// lagt til etter plenum, bør gi beskjed til bruker at det var en feil i fila
				System.out.println("Feil i filens innhold: " + argumenter[0]);
			}
		}
		for (Bygning b: bygninger) {
			System.out.println(b);
		}
	}
}
