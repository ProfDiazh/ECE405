public interface InventoryService<T> {
  public T add (T item); 
  public T[] update(T item, int id); 
  public T[] avail(T item); 
  public T[] history(); 
}
