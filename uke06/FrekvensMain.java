public class FrekvensMain{
	public static void main(String[] args){
		String[] objekter = {"Anne", "Anne", "Anne", "Ole", "Rita", "Rita", "Rita", "Rita"};
		Frekvens<String> ordBeh = new Frekvens<String>(objekter);

		ordBeh.printListe();
		ordBeh.likeSammen();
		System.out.println("------------------");
		ordBeh.printListe();
		System.out.println("Maksobjekt:" + ordBeh.hentFlestObjektet());
	}

}
