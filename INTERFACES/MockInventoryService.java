import java.util.*;

/**
 * Mock inventory service for testing.
 */
public class MockInventoryService<T> implements InventoryService<T> {

    // orderId -> items in that order
    private final Map<String, List<T>> orders = new HashMap<>();

    // current stock
    private final List<T> stock = new ArrayList<>();

    // inventory history snapshots
    private final List<List<T>> inventoryHistory = new ArrayList<>();

    @Override
    public String generateFakeId() {
        return "ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Override
    public List<String> simulateStatus(String orderId) {
        if (!orders.containsKey(orderId)) {
            return List.of("NOT_FOUND");
        }
        return List.of("PLACED", "IN_TRANSIT");
    }

    @Override
    public T add(T item) {
        stock.add(item);
        return item;
    }

    @Override
    public String createOrder(List<T> items) {
        String orderId = generateFakeId();

        for (T item : items) {
            if (!stock.contains(item)) {
                throw new IllegalArgumentException("Item not available in stock: " + item);
            }
        }

        orders.put(orderId, new ArrayList<>(items));
        return orderId;
    }

    @Override
    public List<T> update(String orderId) {
        List<T> orderItems = orders.remove(orderId);

        if (orderItems == null) {
            return Collections.emptyList();
        }

        stock.removeAll(orderItems);
        inventoryHistory.add(new ArrayList<>(stock));

        return orderItems;
    }

    @Override
    public boolean available(T item) {
        return stock.contains(item);
    }

    @Override
    public List<List<T>> history() {
        return new ArrayList<>(inventoryHistory);
    }

    @Override
    public List<T> getStock() {
        return new ArrayList<>(stock);
    }
}
