package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.FloralType;

public class Floral extends Service {
  private FloralType floralType;
  private int cost;
  private String name;

  public Floral(String bookingReference, FloralType floralType) {
    super(bookingReference);
    this.floralType = floralType;
  }

  @Override
  public void addService() {
    this.cost = floralType.getCost();
    this.name = floralType.getName();
  }

  public int getCost() {
    return cost;
  }

  public String getName() {
    return name;
  }
}