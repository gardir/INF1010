public class Kunde extends Thread {
  private String navn;
  private Postkontor kontor;

  public Kunde(String navn, Postkontor kontor) {
    super("Kunde: " + navn);

    this.navn = navn;
    this.kontor = kontor;
  }

  @Override
  public void run() {
    while (true) {
      Post post = kontor.hentPost(navn);
      System.out.println(navn + " " + post.getBeskrivelse());
    }
  }
}
