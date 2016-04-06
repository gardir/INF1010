import java.util.concurrent.locks.*;

public class Postkontor {
  private final int maksPost = 10;
  private Post[] postHylle = new Post[maksPost];
  private int antallPost = 0;
  private Lock lock = new ReentrantLock();
  private Condition hylleIkkeFull = lock.newCondition();
  private Condition hylleIkkeTom = lock.newCondition();

  public void leverPost(Post post) {
    lock.lock();
    try {
      while (antallPost >= maksPost) {
        try {
          hylleIkkeFull.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      for (int i = 0; i < maksPost; i++) {
        if (postHylle[i] == null) {
          postHylle[i] = post;
          antallPost++;
          hylleIkkeTom.signalAll();
          return;
        }
      }
      throw new IllegalStateException("Ikke plass selv om vi trodde det var plass");
    } finally {
      lock.unlock();
    }
  }

  public Post hentPost(String mottaker) {
    lock.lock();
    try {
      while (true) {
        while (antallPost <= 0) {
          try {
            hylleIkkeTom.await();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

        for (int i = 0; i < maksPost; i++) {
          if (postHylle[i] != null && postHylle[i].getMottaker().equals(mottaker)) {
            Post ret = postHylle[i];
            postHylle[i] = null;
            antallPost--;
            hylleIkkeFull.signalAll();
            return ret;
          }
        }

        try {
          hylleIkkeTom.await();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    } finally {
      lock.unlock();
    }

  }
}
