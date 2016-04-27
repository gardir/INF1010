/*
  Denne oppgaven blir sannsynligvis gaat gjennom paa plenum uke14 (4.mai)
 */
class Program {
    public static void main(String[] args) {
        Joiner j = new Joiner();
        j.init();
    }
}

class Joiner {
    Beholder bmb = hentBeholderMedBeholdere();
    int antallAktive = 0;
    int antallIBmb = 0;

    public synchronized void init() {
        gammel = bmb;
        bmb = new Beholder();
        while (true) {
            Beholder a = (Beholder) gammel.hent();
            Beholder b = (Beholder) gammel.hent();
            if (a == null) {
                break;
            }
            if (b == null) {
                bmb.settInn(a);
                antallIBmb++;
                break;
            }
            Arbeider arb = new Arbeider(a, b, this).start();
            antallAktive++;
        }
    }

    public synchronized void lever(Beholder b) {
        antallAktive--;
        bmb.leggTil(b);
        antallIBmb++;
        if (antallIBmb >= 2) {
            Beholder x = bmb.hent();
            bmb.fjern(x);
            Beholder y = bmb.hent();
            bmb.fjern(y);
            antallIBmb -= 2;
            Arbeider arb = new Arbeider(a, b, this).start();
            antallAktive++;
        }
        if (antallAktive == 0) {
            System.out.println("Ferdig!");
        }
    }
}

class Arbeider extends Thread {
    Beholder a;
    Beholder b;
    Joiner j;

    Arbeider(Beholder a, Beholder b, Joiner j) {
        this.a = a;
        this.b = b;
        this.j = j;
    }

    public void run() {
        a.ovfAlleFraBeholder(b);
        j.lever(a);
    }
}
