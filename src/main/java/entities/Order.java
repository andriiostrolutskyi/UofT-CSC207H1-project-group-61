package entities;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

public class Order {
    // Creates the markers for the status of the order
    public static final int CREATED = 0;
    public static final int FULFILLED = 1;
    public static final int DELAYED = 2;

    // Stores the order id number.
    private final UUID id;

    // Variables to store the ID of the warehouse fulfilling the order and the store receiving it
    final private UUID warehouseID;
    final private UUID storeID;

    // Stores the username of the user that created the Order
    final private String username;
    // Stores the current status of the Order, uses the static public markers above
    private int currentStatus;

    // Stores the items in the order as a HashMap where the first int is
    // the UPC code of the product and second int is the quantity of it
    final private HashMap<Integer, Integer> orderQuantities;

    // Stores the important timestamps of the order object:
    // the creation date, fulfillment date when it does happen
    private HashMap<Integer, Date> timestamps = new HashMap<>();

    public Order(UUID warehouseID, UUID storeID, String username, HashMap<Integer, Integer> orderQuantites, Date dateCreated){
        this.warehouseID = warehouseID;
        this.storeID = storeID;

        this.username = username;

        currentStatus = CREATED;

        this.orderQuantities = orderQuantites;
        timestamps.put(CREATED, dateCreated);
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public UUID getWarehouseID() {
        return warehouseID;
    }

    public UUID getStoreID() {
        return storeID;
    }

    public int getStatus() {
        return currentStatus;
    }

    public String getOrderingUser() {
        return username;
    }

    public HashMap<Integer, Integer> getOrderQuantities() {
        return orderQuantities;
    }

    public HashMap<Integer, Date> getTimestamps() {
        return timestamps;
    }

    public void setStatus(int currentStatus) {
        this.currentStatus = currentStatus;
    }

    public void fulfillOrder(Date dateFulfilled){
        /*
        Marks the order as fulfilled in the timestamps
        It also sets its own new status
         */
        timestamps.put(FULFILLED, dateFulfilled);
        setStatus(FULFILLED);
    }
}
