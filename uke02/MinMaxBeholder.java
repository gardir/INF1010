public class MinMaxBeholder<T extends Comparable<T>> {
    private T minste;
    private T stoerste;

    public void leggTil(T ny) {
        if (minste == null) {
            // Beholderen er tom
            minste = ny;
        }
        else {
            // beholderen er ikke tom
            if (ny.compareTo(minste) <= 0) {
                // Tar vare på gammel minstepeker
                T gammel = minste;
                minste = ny;
                ny = gammel;
            }
            if (stoerste == null) {
                stoerste = ny;
            }
            else if (ny.compareTo(stoerste) >= 0) {
                stoerste = ny;
            }            
        }
        
    }

    public T hentMinste() {
        return minste;
    }

    public T hentStoerste() {
        return stoerste;
    }
    

    public boolean erTom() {
        return minste == null;
    }
}