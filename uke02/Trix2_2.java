public class Trix2_2 {

    public static void oppgA() {
        String[] strenger = {
            "Dette er en string",
            "Dette er en annen string",
            "Vi er glade i strenger",
            "Dette ble litt for mye"
        };
        String stoerste = strenger[0];
        String minste = strenger[0];

        for (String s: strenger) {
            if (s.compareTo(stoerste) >= 0) {
                stoerste  = s;
            }
            else if (s.compareTo(minste) <= 0) {
                minste = s;
            }
        }
        System.out.println(stoerste + " er stoerst");
        System.out.println(minste + " er minst");
        
    }

    public static void oppgB(Person[] personer) {

        Person eldst = personer[0];
        Person yngst = personer[0];
        
        for (Person p: personer) {
            if (p.compareTo(eldst) >= 0) {
                eldst = p;
            }
            else if (p.compareTo(yngst) <= 0) {
                yngst = p;
            }
        }
        System.out.println(yngst.hentNavn() + " er yngst med " + yngst.hentAlder() + " aar");
        System.out.println(eldst.hentNavn() + " er eldst med " + eldst.hentAlder() + " aar");
    }

    public static void oppgC(Person[] personer) {
        Person alfa = personer[0];
        Person zulu = personer[0];
        
        for (Person p: personer) {
            if (p.compareTo(alfa) <= 0) {
                alfa = p;
            }
            else if (p.compareTo(zulu) >= 0) {
                zulu = p;
            }
        }
        System.out.println(alfa.hentNavn() + " er alfabetisk foerst");
        System.out.println(zulu.hentNavn() + " er alfabetisk sist");
    }

    public static void oppgDTest() {
        MinMaxBeholder<String> testBeholder = new MinMaxBeholder<String>();
        System.out.print("Tester om beholder er tom: ");
        testBool(true, testBeholder.erTom());       

        String medium = "medium";
        testBeholder.leggTil(medium);
        System.out.println("Tester om " + medium + "kom på minste()");
        testString(medium, testBeholder.hentMinste());

        String liten = "liten";
        testBeholder.leggTil(liten);
        System.out.print("Tester om " + liten + " kom på minste()");
        testString(liten, testBeholder.hentMinste());
        System.out.print("Tester om " + medium + " kom på minste()");
        testString(medium, testBeholder.hentStoerste());

        String stor = "stor";
        testBeholder.leggTil(stor);
        System.out.print("Tester om " + liten + " fortsatt er på minste()");
        testString(liten, testBeholder.hentMinste());
        System.out.print("Tester om " + stor + " forstatt er på stoerste()");
        testString(stor, testBeholder.hentStoerste());
        
    }
    

    public static void testString(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("Passerte");
        }
        else {
            System.out.println("Feilet");
        }
    }

    public static void oppgD(Person[] personer) {
        MinMaxBeholder<Person> bh = new MinMaxBeholder<Person>();

        for (Person p: personer) {
            bh.leggTil(p);
        }
        System.out.println("Person " + bh.hentMinste().hentNavn() + " er alfa foerst");
        System.out.println("Person " + bh.hentStoerste().hentNavn() + " er alfa sist");

    }

    public static void testBool(boolean expected, boolean actual) {
        if (expected == actual) {
            System.out.println("Passerte");
        }
        else {
            System.out.println("Feilet");
        }
    }

    public static void main(String[] args) {

        
        Person[] personer = {
            new Person("Ole", 22),
            new Person("Vetle", 23),
            new Person("Trise", 33),
            new Person("Hilde", 12),
            new Person("Harald", 26)
        };

        // Trix 2.2b)
        //oppgB(personer);
        // c)
        //oppgC(personer);

        // d)
        //oppgDTest();

        oppgD(personer);
    }
}
