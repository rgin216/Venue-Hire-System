package nz.ac.auckland.se281;

import java.util.ArrayList;

public class BookingSystem {
  private String venueCode;
  private String venueName;
  private String systemDate;
  private String requestedDate;
  private String bookingReference;
  private String customerEmail;
  private int numAttendees;
  private int venueFee;
  private ArrayList<Service> services = new ArrayList<Service>();

  BookingSystem(String vCode, String reqDate, String cuEmail, int numPpl, String bookingRef, 
      String systemDate, String venueName, int venueFee) {
    this.venueCode = vCode;
    this.requestedDate = reqDate;
    this.customerEmail = cuEmail;
    this.numAttendees = numPpl;
    this.bookingReference = bookingRef;
    this.systemDate = systemDate;
    this.venueName = venueName;
    this.venueFee = venueFee;
  }

  public String getBookingVenueCode() {
    return venueCode;
  }

  public String getRequestedDate() {
    return requestedDate;
  }

  public String getBookingReference() {
    return bookingReference;
  }

  public String getEmail() {
    return customerEmail;
  }

  public String getSystemDate() {
    return systemDate;
  }

  public int getNumAttendees() {
    return numAttendees;
  }

  public String getVenueName() {
    return venueName;
  }

  public void addService(Catering catering) {
    catering.addService();
    services.add(catering);
    catering.addNum(numAttendees);
  }

  public void addService(Floral floral) {
    floral.addService();
    services.add(floral);
  }

  public void addService(Music music) {
    music.addService();
    services.add(music);
  }

  public void printInvoice() {
    //This method prints the whole invoice (top half, venue services, bottom half)
    String ref = getBookingReference();
    String email = getEmail();
    String date = getSystemDate();
    String ptDate = getRequestedDate();
    int num = getNumAttendees();
    String name = getVenueName();
    int totalCost = venueFee;
    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(ref, email, date, ptDate, String.valueOf(num), name);

    MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(String.valueOf(venueFee));

    for (Service service : services) {
      service.printServices(service);
      totalCost += service.getTotalCost();
    }

    MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(String.valueOf(totalCost));
  }

}
