import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class MockOrderService<T extends Product> implements OrderingServiceV2<T> {

    HashMap<Integer, ArrayList<Object>> orders = new HashMap<>();

    /*
     * Print out the complete orders architecture
     */
    public String toString() {
        String res = "";
        for (Integer key : orders.keySet()) {
            res += "Order " + key + "\n";
            res += "Status: " + orders.get(key).get(0) + "\n";
            res += "Details: " + orders.get(key).get(1) + "\n\n";
        }
        return res;
    }

    /*
     * Randomly generate a new order integer ID that is not already in orders map
     * 
     * @param: n/a
     * 
     * @ret: int Id
     */
    public int generateID() {
        // generate random int
        Random rand = new Random();
        int randInt = rand.nextInt(1000);

        // if new new id already exists, generate new
        while (orders.containsKey(randInt)) {
            randInt = rand.nextInt(1000);
        }

        return randInt;
    }

    /*
     * Given an order hashmap (item: quantity), create a new order and add to the
     * orders hashmap
     * 
     * @param: HashMap<String, Integer> order
     * 
     * @return: int id (order id)
     */
    @Override
    public int placeOrder(HashMap<T, Integer> order) {
        int id = generateID();

        // arraylist to hold order status and details
        ArrayList<Object> temp = new ArrayList<>();
        temp.add("PLACED");
        temp.add(order);

        orders.put(id, temp);

        return id;
    }

    /*
     * Given the order id, cancel the order. Return true if canceled, else false.
     * 
     * @param: int id
     * 
     * @return: boolean
     */
    @Override
    public boolean cancelOrder(Integer Id) {
        if (orders.containsKey(Id)) {
            orders.get(Id).set(0, "CANCELLED");
            return true;
        }
        return false;
    }

    /*
     * Return the order status (Placed/Canceled)
     * 
     * @param: Integer Id (order id)
     * 
     * @return: String
     */
    @Override
    public String orderStatus(Integer Id) {
        if (orders.containsKey(Id)) {
            return (String) orders.get(Id).get(0); // have to cast as a String, or else it is type Object
        }
        return null;
    }

    /*
     * Retrieve the order details (hashmap containing the order)
     * 
     * @param: Integer id
     * 
     * @return: HashMap<String, Integer>
     */
    @Override
    public HashMap<T, Integer> retrieveDetails(Integer Id) {
        if (orders.containsKey(Id)) {
            return (HashMap<T, Integer>) orders.get(Id).get(1); // have to cast as a HashMap, or else it is type Object
        }
        return null;
    }
}
