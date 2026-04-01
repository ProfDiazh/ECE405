import java.util.List;

public interface ShipmentSystem<T extends Product>{
  public void createShipment (List<Product> products, String destination);
  public void updateShipmentStatus ();
  public String trackShipment();
}
