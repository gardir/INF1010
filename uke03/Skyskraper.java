public class Skyskraper extends Bygning{
    private int antallEtasjer;
    public Skyskraper(double brA, int antEtasjer){
        super(brA);
        antallEtasjer = antEtasjer;
    }

    public String toString() {
	    /* forklaring av formaterte strenger
	     * % angir at det skal skje en 'formatering'
	     * .3 betyr at det er ingen lengdekrav før punktum '.' i flyttall, men maks 3 siffer etter
	     * f betyr at det skal komme et flyttall
	     * d betyr at det kommer et heltall/desimaltall.
	     * s betyr at det kommer en String (er ikke med i eksempelet under)
	     */
        return String.format("Skyskraper med %.3f areal og %d etasjer", bruttoAreal, antallEtasjer);
    }


}
