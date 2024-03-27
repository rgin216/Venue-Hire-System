package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;

public class BookingSystem {
  private String venueCode;
  private String requestedDate;
  private String bookingReference;
  // private String customerEmail;
  // private int numAttendees;
  private ArrayList<CateringType> Caterings = new ArrayList<CateringType>();


  
  BookingSystem(String venueCode, String requestedDate, String customerEmail, int numAttendees, String bookingReference){
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    // this.customerEmail = customerEmail;
    // this.numAttendees = numAttendees;
    this.bookingReference = bookingReference;
  }
  public String getBookingVenueCode(){
    return venueCode;
  }

  public String getRequestedDate(){
    return requestedDate;
  }


  public String getBookingReference(){
    return bookingReference;
  }

  public void setCateringType(CateringType cateringType){
    Caterings.add(cateringType);

  }
}

