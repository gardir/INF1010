import java.util.*;

public class Main {
  public static void main(String[] args) {
    List<String> kundenavn = Arrays.asList("Arne", "Bjarne", "Charlie", "Dora");

    Postkontor postkontor = new Postkontor();

    Postmann postmann = new Postmann(postkontor, kundenavn);
    postmann.start();

    for (String navn : kundenavn) {
      Kunde kunde = new Kunde(navn, postkontor);
      kunde.start();
    }
  }
}
