package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  // declaring fields
  String dateInput = "";
  ArrayList<String> Venues = new ArrayList<String>();

  public VenueHireSystem() {}

  public void printVenues() {
    // TODO implement this method
    String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};
    if (Venues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    } else if (Venues.size() == 4) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", "");
      MessageCli.VENUE_ENTRY.printMessage(
          Venues.get(0), Venues.get(1), Venues.get(2), Venues.get(3), "");
    } else if (Venues.size() < 40) {

      MessageCli.NUMBER_VENUES.printMessage("are", numbers[(Venues.size() / 4) - 2], "s");
      for (int i = 0; i < Venues.size(); i += 4) {
        MessageCli.VENUE_ENTRY.printMessage(
            Venues.get(i), Venues.get(i + 1), Venues.get(i + 2), Venues.get(i + 3), "");
      }
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(Venues.size() / 4), "s");
      for (int i = 0; i < Venues.size(); i += 4) {
        System.out.println(i);
        MessageCli.VENUE_ENTRY.printMessage(
            Venues.get(i), Venues.get(i + 1), Venues.get(i + 2), Venues.get(i + 3), "");
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    // TODO implement this method

    // Ensuring venueName is not an empty/white space only string.
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // Ensuring venueCode doesn't already exist
    if (!Venues.isEmpty()) {
      for (int i = 1; i <= Venues.size(); i += 4) {
        if (Venues.get(i).equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(Venues.get(i), Venues.get(i - 1));
          return;
        }
      }
    }

    // Ensuring capacityInput is postive and whole integer
    try {
      Integer.parseInt(capacityInput);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", "");
      return;
    }
    if (Integer.valueOf(capacityInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("capacity", " positive");
      return;
    }

    // Ensuring hireFeeInput is postive and whole integer

    try {
      Integer.parseInt(hireFeeInput);
    } catch (NumberFormatException e) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", "");
      return;
    }
    if (Integer.valueOf(hireFeeInput) < 0) {
      MessageCli.VENUE_NOT_CREATED_INVALID_NUMBER.printMessage("hire fee", " positive");
      return;
    }

    Venues.add(venueName);
    Venues.add(venueCode);
    Venues.add(capacityInput);
    Venues.add(hireFeeInput);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  public void setSystemDate(String dateInput) {
    // TODO implement this method
    MessageCli.DATE_SET.printMessage(dateInput);
  }

  public void printSystemDate() {
    // TODO implement this method
    if (dateInput.isEmpty()) {
      System.out.println("Current system date is not set.");
    } else {
      MessageCli.CURRENT_DATE.printMessage(dateInput);
    }
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
