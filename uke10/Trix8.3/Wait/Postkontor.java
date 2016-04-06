public class Postkontor {
  private final int maksPost = 10;
  private Post[] postHylle = new Post[maksPost];
  private int antallPost = 0;

  public synchronized void leverPost(Post post) {
    while (antallPost >= maksPost) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i < maksPost; i++) {
      if (postHylle[i] == null) {
        postHylle[i] = post;
        antallPost++;
        notifyAll();
        return;
      }
    }
    throw new IllegalStateException("Ikke plass selv om vi trodde det var plass");
  }

  public synchronized Post hentPost(String mottaker) {
    while (antallPost <= 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    for (int i = 0; i < maksPost; i++) {
      if (postHylle[i] != null) {
        Post ret = postHylle[i];
        postHylle[i] = null;
        antallPost--;
        notifyAll();
        return ret;
      }
    }
    throw new IllegalStateException("Ikke post selv om vi trodde det!");
  }
}
