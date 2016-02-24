public class ListeMain{
    public static void main(String[] args){
        LenketListe<String> ordListe = new LenketListe<String>();
        /*
        ordListe.settInn("B");
        ordListe.settInn("A");
        ordListe.printListe();
        ordListe.settInn("C");
        ordListe.settInn("E");
        System.out.println("-------------------");
        ordListe.printListe();
        ordListe.settInn("D");
        System.out.println("-------------------");
        ordListe.printListe();
        System.out.println("-------------------");
        System.out.println("Storste element: " + ordListe.hentStorste());
        */

        LenketListe<Person> persListe = new LenketListe<Person>();
        persListe.settInn(new Person("Ola", 20));
        persListe.settInn(new Person("Sofie", 8));
        persListe.settInn(new Person("Malin", 23));
        persListe.settInn(new Person("Henrik", 23));
        persListe.settInn(new Person("Erlend", 26));
        persListe.printListe();
        System.out.println("-------------------");
        System.out.println("Storste person i lista: " + persListe.hentStorste());
        

    }

}