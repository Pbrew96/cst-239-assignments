package app;

/**
 * This class represents the store front.
 * It connects the inventory and the shopping cart
 * and controls purchases and cancellations.
 */
public class StoreFront
{
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;

    /**
     * Constructor that creates the inventory and cart.
     */
    public StoreFront()
    {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Initializes the store with some products.
     */
    public void initializeStore()
    {
        inventoryManager.addProduct(new Weapon("Sword", "Basic iron sword", 50.00, 10, 15, "Melee"));
        inventoryManager.addProduct(new Weapon("Bow", "Long range bow", 75.00, 5, 20, "Ranged"));
        inventoryManager.addProduct(new Armor("Helmet", "Iron helmet", 30.00, 8, 10, "Light"));
        inventoryManager.addProduct(new Armor("Chestplate", "Steel chestplate", 100.00, 3, 25, "Heavy"));
        inventoryManager.addProduct(new Health("Small Potion", "Restores a small amount of health", 20.00, 15, 25, "Small"));
        inventoryManager.addProduct(new Health("Large Potion", "Restores a large amount of health", 40.00, 8, 50, "Large"));

        
    }

    /**
     * Allows a user to purchase a product.
     * 
     * @param name The product name
     * @param amount The quantity
     * @return true if purchase succeeds
     */
    public boolean purchaseProduct(String name, int amount)
    {
    	if(inventoryManager.purchaseProduct(name, amount))
        {
            SalableProduct product = inventoryManager.findProduct(name);
            shoppingCart.addToCart(product, amount);
            return true;
        }

        return false;
    }

    /**
     * Cancels a purchase and restores inventory.
     * 
     * @param name The product name
     * @return true if successful
     */
    public boolean cancelPurchase(String name)
    {
    	for(int i = 0; i < shoppingCart.getCartItems().size(); i++)
    	{
    	    SalableProduct product = shoppingCart.getCartItems().get(i);

    	    if(product.getName().equalsIgnoreCase(name))
    	    {
    	        inventoryManager.cancelProduct(name, product.getQuantity());
    	        shoppingCart.removeFromCart(name);
    	        return true;
    	    }
    	}

        return false;
    }

    /**
     * Displays the store inventory.
     */
    public void displayStore()
    {
        inventoryManager.displayInventory();
    }

    /**
     * Displays the shopping cart.
     */
    public void displayCart()
    {
        shoppingCart.displayCart();
    }
}