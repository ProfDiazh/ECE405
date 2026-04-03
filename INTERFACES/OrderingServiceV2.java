import java.util.HashMap;

public interface OrderingServiceV2<T  extends Product> {
  public int placeOrder(HashMap<T, Integer> order);

  

  public boolean cancelOrder(Integer Id);

  
  public HashMap<T, Integer> retrieveDetails(Integer Id);

  public String orderStatus(Integer id);
}