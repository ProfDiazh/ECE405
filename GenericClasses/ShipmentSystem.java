public interface ShipmentSystem{
  public void createShipment (String orderId, String destination);
  public void updateShipmentStatus (String id, String newStatus);
  public String trackShipment(String id);
}
