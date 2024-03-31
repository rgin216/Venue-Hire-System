package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class BookingSystem {
  private String venueCode;
  private String requestedDate;
  private String bookingReference;
  // private String customerEmail;
  // private int numAttendees;
  private ArrayList<CateringType> caterings = new ArrayList<CateringType>();
  private ArrayList<FloralType> florals = new ArrayList<FloralType>();
  private boolean music = false;

  BookingSystem(String vCode, String reqDate, String cEmail, int numPpl, String bookingRef) {
    this.venueCode = vCode;
    this.requestedDate = reqDate;
    // this.customerEmail = customerEmail;
    // this.numAttendees = numAttendees;
    bookingReference = bookingRef;
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

   public void addService(Catering catering) {
    catering.addService();
  }

  public void addService(Floral floral) {
    floral.addService();
  }

  public void addService(Music music) {
    music.addService();
  }

  

}
