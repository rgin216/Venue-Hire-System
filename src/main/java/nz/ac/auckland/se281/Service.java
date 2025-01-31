package nz.ac.auckland.se281;


public abstract class Service {
  private String bookingReference;
  protected int totalCost;

  public Service(String bookingReference) {
    this.bookingReference = bookingReference;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public abstract void addService();

  public abstract void printServices(Service service);

  public int getTotalCost() {
    return totalCost;
  }

}
