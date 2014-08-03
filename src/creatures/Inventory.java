package creatures;

import java.util.ArrayList;

public class Inventory {

    // How many items can the inventory store.
    private int size;
    
    /** Current weight. */
    private int curWeight = 0;
    /** Maximum total weight. */
    private int maxWeight;
    
    /** The array of items. */
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Inventory(int size, int weight) {
        this.size = size;
        this.maxWeight = weight;
    }
    
    /**
     * Adds an item to the inventory.
     * @return true if the item was added.
     *         false otherwise.
     */
    public boolean add(Item item) {
        if (this.inventory.size() < this.size && this.curWeight + item.getWeight() <= this.maxWeight) {
            this.inventory.add(item);
            return true;
        } else {
            return false;
        }
    }

}
