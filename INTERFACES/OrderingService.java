public interface OrderinService{
  public int placeOrder(T item);
  public boolean cancelOrder();
  public T[] retreieveDetails();
  public String orderStatus();
}
