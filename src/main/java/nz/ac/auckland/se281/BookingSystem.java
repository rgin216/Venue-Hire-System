package nz.ac.auckland.se281;

public class BookingSystem {
  private String venueCode;
  private String requestedDate;
  private String customerEmail;
  private int numAttendees;
  
  BookingSystem(String venueCode, String requestedDate, String customerEmail, int numAttendees){
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.customerEmail = customerEmail;
    this.numAttendees = numAttendees;
  }
  public String getBookingVenueCode(){
    return venueCode;
  }

  public String getRequestedDate(){
    return requestedDate;
  }
}

