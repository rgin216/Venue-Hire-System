package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;

public class BookingSystem {
  private String venueCode;
  private String requestedDate;
  private String bookingReference;
  // private String customerEmail;
  // private int numAttendees;
  private ArrayList<CateringType> caterings = new ArrayList<CateringType>();

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

  public void setCateringType(CateringType cateringType) {
    caterings.add(cateringType);

  }
}
