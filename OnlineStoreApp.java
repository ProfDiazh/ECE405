public class OnlineStoreApp { 
    public static void main(String[] args) { 
 
        InventoryService inventory = new MockInventoryService(); 
        OrderService orderService = new MockOrderService(); 
        ShipmentService shipmentService = new MockShipmentService(); 
 
        // Step 1: Add product 
        inventory.addProduct(new Toy(“hot wheels”), 10); 
 
        // Step 2: Check stock 
        System.out.println("Stock: " + inventory.checkStock(new Toy(“hot wheels”))); 
 
        // Step 3: Place order 
        String orderId = orderService.placeOrder(new Toy(“hot wheels”), 1, "CUST1"); 
        System.out.println("Order ID: " + orderId); 
 
        // Step 4: Update inventory 
        inventory.updateStock(new Toy(“hot wheels”), -1); 
 
        // Step 5: Create shipment 
        String shipmentId = shipmentService.createShipment(orderId, "123 Main St"); 
 
        // Step 6: Track statuses 
        System.out.println("Order Status: " + orderService.getOrderStatus(orderId)); 
        System.out.println("Shipment Status: " + shipmentService.trackShipment(shipmentId)); 
    } 
} 
