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
  private ArrayList<Catering> caterings = new ArrayList<Catering>();
  private ArrayList<Floral> florals = new ArrayList<Floral>();
  private boolean music = false;

  BookingSystem(String vCode, String reqDate, String cEmail, int numPpl, String bookingRef, String systemDate,
      String venueName, int venueFee) {
    this.venueCode = vCode;
    this.requestedDate = reqDate;
    this.customerEmail = cEmail;
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
    caterings.add(catering);
  }

  public void addService(Floral floral) {
    floral.addService();
    florals.add(floral);
  }

  public void addService() {
    this.music = true;
  }

  public void printInvoice() {
    String ref = getBookingReference();
    String email = getEmail();
    String date = getSystemDate();
    String pDate = getRequestedDate();
    int num = getNumAttendees();
    String name = getVenueName();
    int totalCost = venueFee;
    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(ref, email, date, pDate, String.valueOf(num), name);

    MessageCli.INVOICE_CONTENT_VENUE_FEE.printMessage(String.valueOf(venueFee));

    for (Catering catering : caterings) {
      totalCost += catering.getCostPerPerson() * num;
      MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(catering.getName(),
          String.valueOf(num * catering.getCostPerPerson()));
    }
    for (Floral floral : florals) {
      totalCost += floral.getCost();
      MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floral.getName(), String.valueOf(floral.getCost()));
    }
    if (music) {
      totalCost += 500;
      MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(String.valueOf(500));
    }
    MessageCli.INVOICE_CONTENT_BOTTOM_HALF.printMessage(String.valueOf(totalCost));
  }

}
