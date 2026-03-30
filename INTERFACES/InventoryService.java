public interface InventoryService<T> {
  public T add (T item);
  public T[] update();
  public bool avail(T item);
  public void history();
}
