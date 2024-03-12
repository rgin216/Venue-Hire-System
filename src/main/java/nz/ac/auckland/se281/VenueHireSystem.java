package nz.ac.auckland.se281;

import java.util.ArrayList;

import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  // declaring fields

  ArrayList<String> Venues = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method
    if (Venues.isEmpty()){
      MessageCli.NO_VENUES.printMessage(); 
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    // Ensuring venueName is not an empty/white space only string.
    if (venueName.trim().isEmpty()){
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }
    
    // Ensuring venueCode doesn't already exist
    if (!Venues.isEmpty()){
      for (int i = 1; i <= Venues.size(); i += 4){
        if (Venues.get(i).equals(venueCode)){ 
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(Venues.get(i), Venues.get(i-1));
          return;
        }
      } 
    }

    Venues.add(venueName);
    Venues.add(venueCode);
    Venues.add(capacityInput);
    Venues.add(hireFeeInput);
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
  }

  public void printSystemDate() {
    // TODO implement this method
  }

  public void makeBooking(String[] options) {
    // TODO implement this method
  }

  public void printBookings(String venueCode) {
    // TODO implement this method
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    // TODO implement this method
  }

  public void addServiceMusic(String bookingReference) {
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
