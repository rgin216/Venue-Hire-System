package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Music extends Service {
  private int cost = 0;

  public Music(String bookingReference) {
    super(bookingReference);
  }

  @Override
  public void addService() {
    this.cost = 500;
  }

  @Override
  public void printServices(ArrayList<Service> services) {
    if (services.contains(this)) {
      MessageCli.INVOICE_CONTENT_MUSIC_ENTRY.printMessage(String.valueOf(cost));
      totalCost += cost;
    }
  }

  public int getCost() {
    return cost;
  }

}
