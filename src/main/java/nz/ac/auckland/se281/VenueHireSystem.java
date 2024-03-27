package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Types.CateringType;
import nz.ac.auckland.se281.Types.FloralType;

public class VenueHireSystem {
  // declaring fields
  private String dateInput = "";
  private ArrayList<VenueHireSystem> Venues = new ArrayList<VenueHireSystem>();
  private boolean dateSet = false;
  private ArrayList<BookingSystem> Bookings = new ArrayList<BookingSystem>();
  private String venueName;
  private String venueCode;
  private String capacityInput;
  private String hireFeeInput;

  VenueHireSystem() {}

  VenueHireSystem(String venueName, String venueCode, String capacityInput, String hireFeeInput) {
    this.venueName = venueName;
    this.venueCode = venueCode;
    this.capacityInput = capacityInput;
    this.hireFeeInput = hireFeeInput;
  }

  public String getVenueName() {
    //returns the name of the venue
    return this.venueName;
  }

  public String getVenueCode() {
    //returns the code of the venue
    return this.venueCode;
  }

  public String getCapacityInput() {
    //returns the capacity of the venue
    return this.capacityInput;
  }

  public String getHireFeeInput() {
    //returns the hire fee of the venue
    return this.hireFeeInput;
  }

  public void printVenues() {
    // array of strings of the words of each number from 2-9
    String[] numbers = {"two", "three", "four", "five", "six", "seven", "eight", "nine"};

    // When theres only one venue
    if (Venues.isEmpty()) {
      MessageCli.NO_VENUES.printMessage();
    } else if (Venues.size() == 1) {
      MessageCli.NUMBER_VENUES.printMessage("is", "one", getNextAvailableDate(Venues.get(0)));
      MessageCli.VENUE_ENTRY.printMessage(
          Venues.get(0).getVenueName(),
          Venues.get(0).getVenueCode(),
          Venues.get(0).getCapacityInput(),
          Venues.get(0).getHireFeeInput(),
          "");
    }

    // When theres 2-9 venues
    else if (Venues.size() < 10) {
      MessageCli.NUMBER_VENUES.printMessage("are", numbers[Venues.size() - 2], "s");
      for (int i = 0; i < Venues.size(); i++) {
        MessageCli.VENUE_ENTRY.printMessage(
            Venues.get(i).getVenueName(),
            Venues.get(i).getVenueCode(),
            Venues.get(i).getCapacityInput(),
            Venues.get(i).getHireFeeInput(),
            getNextAvailableDate(Venues.get(i)));
      }
    } else {
      MessageCli.NUMBER_VENUES.printMessage("are", String.valueOf(Venues.size()), "s");
      for (int i = 0; i < Venues.size(); i++) {
        System.out.println(i);
        MessageCli.VENUE_ENTRY.printMessage(
            Venues.get(i).getVenueName(),
            Venues.get(i).getVenueCode(),
            Venues.get(i).getCapacityInput(),
            Venues.get(i).getHireFeeInput(),
            getNextAvailableDate(Venues.get(i)));
      }
    }
  }

  public void createVenue(
      String venueName, String venueCode, String capacityInput, String hireFeeInput) {

    // Ensuring venueName is not an empty/white space only string.
    if (venueName.trim().isEmpty()) {
      MessageCli.VENUE_NOT_CREATED_EMPTY_NAME.printMessage();
      return;
    }

    // Ensuring venueCode doesn't already exist
    if (!Venues.isEmpty()) {
      for (int i = 0; i < Venues.size(); i++) {
        if (Venues.get(i).getVenueCode().equals(venueCode)) {
          MessageCli.VENUE_NOT_CREATED_CODE_EXISTS.printMessage(
              Venues.get(i).getVenueCode(), Venues.get(i).getVenueName());
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

    VenueHireSystem venue = new VenueHireSystem(venueName, venueCode, capacityInput, hireFeeInput);
    Venues.add(venue);
    MessageCli.VENUE_SUCCESSFULLY_CREATED.printMessage(venueName, venueCode);
  }

  public void setSystemDate(String dateInput) {
    MessageCli.DATE_SET.printMessage(dateInput);
    this.dateInput = dateInput;
    dateSet = true;
  }

  public void printSystemDate() {
    if (dateInput.isEmpty()) {
      System.out.println("Current system date is not set.");
    } else {
      MessageCli.CURRENT_DATE.printMessage(dateInput);
    }
  }

  public void makeBooking(String[] options) {

    // Checking if there is a set date
    if (!dateSet) {
      MessageCli.BOOKING_NOT_MADE_DATE_NOT_SET.printMessage();
      return;
    }

    // Checking if there is at least one venue in the Hire system
    if (Venues.size() == 0) {
      MessageCli.BOOKING_NOT_MADE_NO_VENUES.printMessage();
      return;
    }

    // Checking if the venue code inputed exists in the venue system.
    int match = -1;
    for (int i = 0; i < Venues.size(); i++) {
      if (Venues.get(i).getVenueCode().equals(options[0])) {
        venueName = Venues.get(i).getVenueName();
        match = i;
      }
    }
    if (match == -1) {
      MessageCli.BOOKING_NOT_MADE_VENUE_NOT_FOUND.printMessage(options[0]);
      return;
    }

    // Checking if the booking date is not earlier than the set date
    String[] setDateParts = dateInput.split("/");

    String setDay = setDateParts[0];
    String setMonth = setDateParts[1];
    String setYear = setDateParts[2];

    String[] bookingDateParts = options[1].split("/");
    String bookingDay = bookingDateParts[0];
    String bookingMonth = bookingDateParts[1];
    String bookingYear = bookingDateParts[2];

    if (Integer.valueOf(setYear) > Integer.valueOf(bookingYear)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], dateInput);
      System.out.println(setYear + bookingYear);
      return;
    } else if (Integer.valueOf(setMonth) > Integer.valueOf(bookingMonth)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], dateInput);
      return;
    } else if (Integer.valueOf(setDay) > Integer.valueOf(bookingDay)) {
      MessageCli.BOOKING_NOT_MADE_PAST_DATE.printMessage(options[1], dateInput);
      return;
    }

    // Check if that venuecode has already dates made on that same day

    ArrayList<Integer> Matches = new ArrayList<Integer>();

    for (int i = 0; i < Bookings.size(); i++) {
      if (options[0].equals(Bookings.get(i).getBookingVenueCode())) {
        Matches.add(i);
      }
    }

    if (Matches.size() > 0) {
      for (int i : Matches) {
        String[] existingDateParts = Bookings.get(i).getRequestedDate().split("/");
        System.out.println(existingDateParts);
        String existingDay = existingDateParts[0];
        String existingMonth = existingDateParts[1];
        String existingYear = existingDateParts[2];
        if (existingDay.equals(bookingDay)
            && existingMonth.equals(bookingMonth)
            && existingYear.equals(bookingYear)) {
          MessageCli.BOOKING_NOT_MADE_VENUE_ALREADY_BOOKED.printMessage(venueName, options[1]);
          return;
        }
      }
    }

    // Altering numAttendees to 25% or 100% of the venue's capacity.
    if (Integer.valueOf(options[3]) < (Integer.valueOf(Venues.get(match).getCapacityInput())) / 4) {
      String newAttendees =
          String.valueOf((Integer.valueOf(Venues.get(match).getCapacityInput())) / 4);
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
          options[3], newAttendees, Venues.get(match).getCapacityInput());
      options[3] = newAttendees;
    } else if (Integer.valueOf(options[3])
        > (Integer.valueOf(Venues.get(match).getCapacityInput()))) {
      String newAttendees = String.valueOf(Integer.valueOf(Venues.get(match).getCapacityInput()));
      MessageCli.BOOKING_ATTENDEES_ADJUSTED.printMessage(
          options[3], newAttendees, Venues.get(match).getCapacityInput());
      options[3] = newAttendees;
    }

    // If no error comes up, a new Booking is created, and added to the list of Bookings.
    String newBookingReference = BookingReferenceGenerator.generateBookingReference();
    BookingSystem Booking = new BookingSystem(
        options[0], options[1], options[2], Integer.valueOf(options[3]), newBookingReference);
    Bookings.add(Booking);
    MessageCli.MAKE_BOOKING_SUCCESSFUL.printMessage(
        newBookingReference, venueName, options[1], options[3]);
  }

  public String getNextAvailableDate(VenueHireSystem Venue) {
    //If date hasnt bean set, return an empty string TEMP
    if (dateInput.isEmpty()) {
      return "";
    }


    // Getting day component of system date
    String[] setDateParts = dateInput.split("/");
    int setDay = Integer.valueOf(setDateParts[0]);
    String[] bookingDateParts;
    // Finding all instances of venuecode's booking day
    ArrayList<Integer> Matches = new ArrayList<Integer>();
    for (int i = 0; i < Bookings.size(); i++) {
      if (Venue.getVenueCode().equals(Bookings.get(i).getBookingVenueCode())) {
        bookingDateParts = Bookings.get(i).getRequestedDate().split("/");
        Matches.add(Integer.valueOf(bookingDateParts[0]));
      }
    }

    // If theres no bookings, return set date
    if (Matches.size() == 0) {
      return dateInput;
    }

    int tempDay = setDay;
    boolean match = false;

    for (int i = 0; i < 32; i++) {
      for (int day : Matches) {
        if (day == tempDay) {
          tempDay++;
          match = true;
        }
      }
    }

    // If there was no match, there is an available booking today
    if (!match) {
      return dateInput;
    }

    // If there was a match, tempDay is the new earliest booking date
    if (tempDay < 10) {
      return ("0" + tempDay + "/" + setDateParts[1] + "/" + setDateParts[2]);
    }
    return (tempDay + "/" + setDateParts[1] + "/" + setDateParts[2]);
  }

  public void printBookings(String venueCode) {
    // Getting the name of the venue
    boolean match = false;
    int matchVenue;
    String venueName = "";
    for (int i = 0; i < Venues.size(); i++) {
      if (Venues.get(i).getVenueCode().equals(venueCode)) {
        venueName = Venues.get(i).getVenueName();
        match = true;
        matchVenue = i;
      }
    }
    // If no match, print no code exists and return
    if (!match) {
      MessageCli.PRINT_BOOKINGS_VENUE_NOT_FOUND.printMessage(venueCode);
      return;
    }

    ArrayList<Integer> MatchIndex = new ArrayList<Integer>();
    for (int i = 0; i < Bookings.size(); i++){
      if (venueCode.equals(Bookings.get(i).getBookingVenueCode())){
        MatchIndex.add(i);
      }
    }
    
    // If there is no matches, there are no bookings for that code
    if (MatchIndex.size() == 0) {
      MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
      MessageCli.PRINT_BOOKINGS_NONE.printMessage(venueName);
      return;
    }

    MessageCli.PRINT_BOOKINGS_HEADER.printMessage(venueName);
    for (int i = 0; i < MatchIndex.size(); i++) {
      MessageCli.PRINT_BOOKINGS_ENTRY.printMessage(
          Bookings.get(MatchIndex.get(i)).getBookingReference(),
          Bookings.get(MatchIndex.get(i)).getRequestedDate());
    }
  }

  public int bookingExists(String bookingReference){
    int matchIndex = -1;
    for (int i = 0; i < Bookings.size(); i++){
      if (bookingReference.equals(Bookings.get(i).getBookingReference())){
        matchIndex = i;
      }
    }
    if (matchIndex == -1){
      MessageCli.SERVICE_NOT_ADDED_BOOKING_NOT_FOUND.printMessage("Catering", bookingReference);
    }
    return matchIndex;
  }

  public void addCateringService(String bookingReference, CateringType cateringType) {
    //Check if the bookingReference exists:
    int matchIndex = bookingExists(bookingReference);
    if (matchIndex == -1){
      return;
    }
    //Add the catering to the list of catering in that booking
    Bookings.get(matchIndex).setCateringType(cateringType);
    MessageCli.ADD_SERVICE_SUCCESSFUL.printMessage("Catering", cateringType.toString());
  }

  public void addServiceMusic(String bookingReference) {
    //Check if the bookingReference exists:
    int matchIndex = bookingExists(bookingReference);
    if (matchIndex == -1){
      return;
    }
    // TODO implement this method
  }

  public void addServiceFloral(String bookingReference, FloralType floralType) {
    //Check if the bookingReference exists:
    int matchIndex = bookingExists(bookingReference);
    if (matchIndex == -1){
      return;
    }
    // TODO implement this method
  }

  public void viewInvoice(String bookingReference) {
    // TODO implement this method
  }
}
