package nz.ac.auckland.se281;

public abstract class Service {
  private String bookingReference;

  public Service(String bookingReference) {
      this.bookingReference = bookingReference;
  }

  public int getNumAttendees() {
      for (int i = 0; i < bookings.size; i++) {
          System.out.println("Hello");
      }
  }

  public abstract void addService();
}
