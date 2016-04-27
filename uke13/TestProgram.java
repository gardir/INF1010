class TestProgram {
    public static void main(String[] args) {
        Object[] objekter = new Object[] {
            new Person("Bob"),
            new Person("Kari"),
            new Student("Gosnar", 123),
            new Student("Ragnhild", 321),
            new Student("Gosnar", 123),
            new Eple(),
            new Eple(),
            new Kiwi(),
            new Kiwi(),
            new Banan()
        };

        Beholder b = new Beholder();

        for (Object o : objekter) {
            b.settInn(o);
        }

        while (true) {
            Object o = b.hent();
            if (o == null) {
                break;
            }
            b.fjern(o);

            if (o instanceof Student) {
                Student s = (Student) o;
                System.out.println("Student: " + s.id() + " " + s.hentStudentnr());
            } else if (o instanceof Person) {
                Person p = (Person) o;
                System.out.println("Person: " + p.id());
            }
            if (o instanceof Frukt) {
                Frukt f = (Frukt) o;
                System.out.println(f.id());
            }
        }
    }
}