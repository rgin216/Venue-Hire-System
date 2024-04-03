package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Types.CateringType;

public class Catering extends Service {
  private CateringType cateringType;
  private int costPerPerson;
  private String name;
  private int num;

  public Catering(String bookingReference, CateringType cateringType) {
    super(bookingReference);
    this.cateringType = cateringType;
  }

  public int getCostPerPerson() {
    return costPerPerson;
  }

  public void addNum(int num) {
    this.num = num;
  }

  public String getName() {
    return name;
  }

  @Override
  public void addService() {
    this.costPerPerson = cateringType.getCostPerPerson();
    this.name = cateringType.getName();
  }

  @Override
  public void printServices(Service service) {
    if (service instanceof Catering) {
      Catering catering = (Catering) service;
      totalCost += catering.getCostPerPerson() * num;
      MessageCli.INVOICE_CONTENT_CATERING_ENTRY.printMessage(catering.getName(),
          String.valueOf(num * catering.getCostPerPerson()));
    }
  }

}