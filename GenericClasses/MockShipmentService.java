import java.util.HashMap;

public class MockShipmentService implements ShipmentSystem{
  private int i = 0;
  HashMap<String, String> status = new HashMap<>(); //Shipment ID to status mapping

  public void createShipment(String orderId, String destination){
    i = i + 1;
    String id = "SHIP" + i;
    status.put(id, "CREATED");

  }

  public void updateShipmentStatus(String id, String newStatus){
    if(status.get(id) != null){
        status.put(id, newStatus);
        System.out.println("Shipment ID: " + id + " assigned - " + newStatus);
        return;
    }

    System.out.println("Shipment ID not found");
  }

  public String trackShipment(String id){
    if(status.get(id) != null){
        return ("Status: " + status.get(id));
    }
    return "Not found";
  }
  
}