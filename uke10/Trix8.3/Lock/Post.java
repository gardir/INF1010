public class Post {
  private String beskrivelse;
  private String mottaker;

  public Post(String beskrivelse, String mottaker) {
    this.beskrivelse = beskrivelse;
    this.mottaker = mottaker;
  }

  public String getBeskrivelse() {
    return beskrivelse;
  }

  public String getMottaker() {
    return mottaker;
  }
}
