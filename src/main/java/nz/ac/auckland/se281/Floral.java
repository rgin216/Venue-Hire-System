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

  @Override
  public void printServices(Service service) {

    if (service instanceof Floral) {
      Floral floral = (Floral) service;
      totalCost += floral.getCost();
      MessageCli.INVOICE_CONTENT_FLORAL_ENTRY.printMessage(floral.getName(), String.valueOf(floral.getCost()));
    }

  }
}