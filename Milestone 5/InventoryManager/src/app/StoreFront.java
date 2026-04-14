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
     * Initializes the store from an external JSON file.
     */
    public void initializeStore()
    {
        inventoryManager.initializeInventoryFromFile("inventory.json");
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
        SalableProduct product = inventoryManager.findProduct(name);

        if(product != null && inventoryManager.purchaseProduct(name, amount))
        {
            SalableProduct cartProduct = new SalableProduct(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                amount
            );

            shoppingCart.addToCart(cartProduct);
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
    public void sortByNameAscending()
    {
        inventoryManager.sortByNameAscending();
    }

    public void sortByNameDescending()
    {
        inventoryManager.sortByNameDescending();
    }
}