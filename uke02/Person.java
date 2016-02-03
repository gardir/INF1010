public class Person implements Comparable<Person> {
    private String navn;
    private int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    public int hentAlder()  {
        return alder;
    }

    public String hentNavn() {
        return navn;
    }

    public int compareTo(Person p) {
        return navn.compareTo(p.hentNavn());
    }

    public int alderCompareTo(Person p) {
        return alder - p.hentAlder();
        /*
        int pAlder = p.hentAlder();
        if (alder < pAlder) {
            return -1;
        }
        else if (alder > pAlder) {
            return 1;
        }
        else {
            return 0;
        }
        */
    }

}