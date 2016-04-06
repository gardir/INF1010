import java.util.*;
import java.util.concurrent.*;

class Postmann extends Thread {
  private Postkontor kontor;
  private List<String> kundenavn;

  public Postmann(Postkontor kontor, List<String> kundenavn) {
    super("Postmann");
    this.kontor = kontor;
    this.kundenavn = kundenavn;
  }

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      String navn = kundenavn.get(ThreadLocalRandom.current().nextInt(kundenavn.size()));
      Post post = new Post(i + " Hei " + navn, navn);
      kontor.leverPost(post);
    }
  }
}
