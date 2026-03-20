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
        inventoryManager.addProduct(new SalableProduct("Laptop", "15 inch Macbook laptop", 899.99, 5));
        inventoryManager.addProduct(new SalableProduct("Mouse", "Wireless SteelSeries Aerox 9 mouse", 25.99, 10));
        inventoryManager.addProduct(new SalableProduct("Keyboard", " SteelSeries Apex Pro Mechanical keyboard", 79.99, 7));
        inventoryManager.addProduct(new SalableProduct("Charger", "USB-C Cable", 19.99, 10));

        
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
        if(inventoryManager.reduceInventory(name, amount))
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
        for(SalableProduct product : shoppingCart.getCartItems())
        {
            if(product.getName().equalsIgnoreCase(name))
            {
                inventoryManager.restockInventory(name, product.getQuantity());
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