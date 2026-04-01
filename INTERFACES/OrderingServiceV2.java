import java.util.HashMap;

public interface OrderingServiceV2<T>{
  public int placeOrder(HashMap<String, Integer> order);
  public boolean cancelOrder(Integer Id);
  public HashMap<String, Integer> retrieveDetails(Integer Id);
  public String orderStatus(Integer id);
}