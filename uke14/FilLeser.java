/**
 * Denne klassen er en eksempelklasse for aa vise hvordan
 * vi kan kombinere eksisterende klasser med JavaFX. Klassen
 * i seg selv var ikke tema i plenumstimen.
 */

import java.util.*;
import java.io.*;

public class FilLeser {
    /**
     * @Param  filnavn som skal leses inn. Må ha ordet "plenumfil" på første linje.
     *
     * @Return En ArrayList der hver linje i inn-filen er et heltall
     */
    public ArrayList<Integer> lesFil(String filnavn) throws FileNotFoundException, FeilFormatUnntak {
        ArrayList<Integer> listen = new ArrayList<Integer>();

        Scanner scanner = new Scanner(new File(filnavn));

        if (!scanner.nextLine().equals("plenumfil")) {
            throw new FeilFormatUnntak("Feil headerord i input-filen");
        }

        while (scanner.hasNextLine()) {
            try {
                int tall = Integer.parseInt(scanner.nextLine());
                listen.add(tall);
            }
            catch(NumberFormatException e) {
                throw new FeilFormatUnntak("En av linjene inneholdt noe annet enn tall");
            }
        }
        return listen;
    }
}

class FeilFormatUnntak extends Exception {
    public FeilFormatUnntak() {}
    public FeilFormatUnntak(String s) {
        super(s);
    }
}

