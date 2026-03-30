public class MockShipmentService implements ShipmentSystem {
  int i = 0;
  HashMap<String, String> status = new HashMap();

  public void CreateShipment(){
    i = i + 1;
    String id = "SHIP" + "<i>";
    status.add(id, "CREATED");
  }

  public void updateShipmentStatus(String id, String newStatus){
    if(status.contains(id)) status.update(id, newStatus);
    
  }

  public String TrackShipment(String id){
    if(status.contains(id)) return status.get(id);
    return 'Not found';
  }
  
}
