import java.util.*;
package INTERFACES;
import GenericClasses.Product;
/**
 * Mock inventory service for testing.
 */
public class MockInventoryService<T extends product> implements InventoryService<T extends product> {


    // current stock
    private final List<T> stock = new ArrayList<>();

    // inventory history snapshots
    private final List<List<T>> inventoryHistory = new ArrayList<>();

    public String generateFakeId() {
        String random_id
        random_id = "ORD123"
        return random_id
        
    }

    public List<String> simulateStatus(String orderId) {
        if (!orders.containsKey(orderId)) {
            return List.of("NOT_FOUND");
        }
        return List.of("PLACED", "IN_TRANSIT");
    }

    public T addProduct(T item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            stock.add(item);
        }
        return item;
    }
    public List<T> removeProduct(T item, int quantity) {
        List<T> removedItems = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            if (stock.remove(item)) {
                removedItems.add(item);
            } else {
                break; // No more items to remove
            }
        }
        return removedItems;
    }

    public List<T> updateStock(T item , int quantity) {
        if (quantity > 0){
            return List.of(addProduct(item, quantity));
        } else if (quantity < 0) {
            return removeProduct(item, -quantity);
        } else {
            return List.of(); // No change
        }
    }

    public boolean checkStock(T item) {
        return stock.contains(item);
    }

    public List<List<T>> history() {
        return new ArrayList<>(inventoryHistory);
    }

    public List<T> getStock() {
        return new ArrayList<>(stock);
    }
}
