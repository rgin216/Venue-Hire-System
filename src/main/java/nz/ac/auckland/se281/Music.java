package nz.ac.auckland.se281;


public class Music extends Service {
  private int cost = 0;

  public Music(String bookingReference) {
      super(bookingReference);
  }

  @Override
  public void addService() {
      this.cost = 500;
  }

  public int getCost() {
      return cost;
  }
}
