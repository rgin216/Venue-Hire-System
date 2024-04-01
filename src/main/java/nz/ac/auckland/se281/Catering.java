package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private CateringType cateringType;
  private int costPerPerson;
  private String name;

  public Catering(String bookingReference, CateringType cateringType) {
    super(bookingReference);
    this.cateringType = cateringType;
  }

  @Override
  public void addService() {
    this.costPerPerson = cateringType.getCostPerPerson();
    this.name = cateringType.getName();
  }

  public int getCostPerPerson() {
    return costPerPerson;
  }

  public String getName() {
    return name;
  }
}