import java.util.List;

public interface ShipmentSystem{
  public void createShipment (List<Product> products, String destination);
  public void updateShipmentStatus ();
  public String trackShipment();
}