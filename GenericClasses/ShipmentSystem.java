import java.util.List;

public interface ShipmentSystem<T extends Product>{
  public void createShipment (List<T> products, String destination);
  public void updateShipmentStatus ();
  public String trackShipment();
}
