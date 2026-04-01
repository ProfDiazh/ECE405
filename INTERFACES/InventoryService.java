public interface InventoryService<T> {
  public T add (T item); //number of items?
  public T[] update(); //which item? ID, item
  public bool avail(T item); // 
  public void history(); //?
}
