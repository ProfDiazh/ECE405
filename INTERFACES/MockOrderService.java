import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

public class MockOrderService<T> implements OrderingServiceV2<T> {

    HashMap <Integer, ArrayList<Object>> orders = new HashMap<>();

    public String toString(){
        String res = "";
        for (Integer key : orders.keySet()){
            res += "Order " + key + "\n";
            res += "Status: " + orders.get(key).get(0) + "\n";
            res += "Details: " + orders.get(key).get(1) + "\n\n";
        }
        return res;
    }

    /*
        Randomly generate a new order ID that is not already in orders map
        @param: n/a
        @ret: int Id
    */
    public int generateID(){
        Random rand = new Random();
        int randInt = rand.nextInt(1000);

        while(orders.containsKey(randInt)){
            randInt = rand.nextInt(1000);
        }

        return randInt;
    }

    /*
        Using a 
    */
    @Override
    public int placeOrder(HashMap<String, Integer> order){
        int id = generateID();

        ArrayList<Object> temp = new ArrayList<>();
        temp.add("PLACED");
        temp.add(order);

        orders.put(id, temp);

        return id;
    }

    @Override
    public boolean cancelOrder(Integer Id){
        if (orders.containsKey(Id)){
            orders.get(Id).set(0, "CANCELLED");
            return true;
        }
        return false;
    }

    @Override
    public String orderStatus(Integer Id){
        if (orders.containsKey(Id)){
            return (String) orders.get(Id).get(0);
        }
        return null;
    }

    @Override
    public HashMap<String, Integer> retrieveDetails(Integer Id){
        if (orders.containsKey(Id)){
            return (HashMap<String, Integer>) orders.get(Id).get(1);
        }
        return null;
    }
}