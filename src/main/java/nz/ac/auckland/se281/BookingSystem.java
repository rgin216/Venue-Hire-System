package nz.ac.auckland.se281;

public class BookingSystem {
  private String venueCode;
  private String requestedDate;
  private String customerEmail;
  private int numAttendees;
  private String bookingReference;
  
  BookingSystem(String venueCode, String requestedDate, String customerEmail, int numAttendees, String bookingReference){
    this.venueCode = venueCode;
    this.requestedDate = requestedDate;
    this.customerEmail = customerEmail;
    this.numAttendees = numAttendees;
    this.bookingReference = bookingReference;
  }
  public String getBookingVenueCode(){
    return venueCode;
  }

  public String getRequestedDate(){
    return requestedDate;
  }
}

