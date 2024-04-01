package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class BookingSystem {
  private String venueCode;
  private String venueName;
  private String systemDate;
  private String requestedDate;
  private String bookingReference;
  private String customerEmail;
  private int numAttendees;
  private ArrayList<CateringType> caterings = new ArrayList<CateringType>();
  private ArrayList<FloralType> florals = new ArrayList<FloralType>();
  private boolean music = false;

  BookingSystem(String vCode, String reqDate, String cEmail, int numPpl, String bookingRef, String systemDate, String venueName) {
    this.venueCode = vCode;
    this.requestedDate = reqDate;
    this.customerEmail = cEmail;
    this.numAttendees = numPpl;
    bookingReference = bookingRef;
    this.systemDate = systemDate;
    this.venueName = venueName;
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
  }

  public void addService(Floral floral) {
    floral.addService();
  }

  public void addService(Music music) {
    music.addService();
  }

  public void printInvoice() {
    String ref = getBookingReference();
    String email = getEmail();
    String date = getSystemDate();
    String pDate =  getRequestedDate();
    String num = String.valueOf(getNumAttendees());
    String name = getVenueName();
    // System.out.println(ref + email + date + pDate + num + name);
    MessageCli.INVOICE_CONTENT_TOP_HALF.printMessage(ref, email, date, pDate, num, name);
  }

  

}
