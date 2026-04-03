public class App {
    public static void main(String[] args) throws Exception {
        ShipmentSystem shipSys = new MockShipmentService();
        
        shipSys.createShipment("ORD123", "Canada");

        System.out.println(shipSys.trackShipment("SHIP1"));

        shipSys.updateShipmentStatus("SHIP1", "SHIPPED");

        System.out.println(shipSys.trackShipment("SHIP1"));

    }
}
