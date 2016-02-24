public class Person implements Comparable<Person>{
	private String navn;
	private int alder;

	public Person(String n, int a){
		alder = a;
		navn = n;
	}

	public String hentNavn(){
		return navn;
	}

	public int hentAlder(){
		return alder;
	}

	public int compareTo(Person p){
		return alder - p.hentAlder();
	}

	public String toString(){
		return "Navn: " + navn + ", Alder: " + alder;
	}

}
