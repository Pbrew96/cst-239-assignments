package app;

/**
 * This class represents the store front and connects the inventory,
 * shopping cart, and background administration service.
 */
public class StoreFront
{
    private InventoryManager inventoryManager;
    private ShoppingCart shoppingCart;
    private AdminServerThread adminServerThread;

    /**
     * Constructor for StoreFront.
     */
    public StoreFront()
    {
        inventoryManager = new InventoryManager();
        shoppingCart = new ShoppingCart();
    }

    /**
     * Initializes the store inventory.
     */
    public void initializeStore()
    {
        inventoryManager.initializeInventoryFromFile("inventory.json");
    }

    /**
     * Starts the administration service in the background.
     *
     * @param port The port number
     */
    public void startAdministrationService(int port)
    {
        FileService fileService = new FileService();
        AdministrationService administrationService = new AdministrationService(inventoryManager, fileService);
        adminServerThread = new AdminServerThread(port, administrationService);
        adminServerThread.start();
    }

    /**
     * Displays the inventory.
     */
    public void displayStore()
    {
        inventoryManager.displayInventory();
    }

    /**
     * Purchases a product and adds it to the cart.
     *
     * @param name The product name
     * @param qty The quantity
     * @return true if successful
     */
    public boolean purchaseProduct(String name, int qty)
    {
        SalableProduct product = inventoryManager.findProduct(name);

        if(product != null && inventoryManager.purchaseProduct(name, qty))
        {
            SalableProduct cartProduct = new SalableProduct(product.getName(), product.getDescription(), product.getPrice(), qty);
            shoppingCart.addToCart(cartProduct);
            return true;
        }

        return false;
    }

    /**
     * Cancels a purchase and returns product quantity back to inventory.
     *
     * @param name The product name
     * @return true if successful
     */
    public boolean cancelPurchase(String name)
    {
        for(SalableProduct item : shoppingCart.getCartItems())
        {
            if(item.getName().equalsIgnoreCase(name))
            {
                int qty = item.getQuantity();
                shoppingCart.removeFromCart(name);
                return inventoryManager.cancelProduct(name, qty);
            }
        }

        return false;
    }

    /**
     * Displays the shopping cart.
     */
    public void displayCart()
    {
        shoppingCart.displayCart();
    }

    /**
     * Sorts inventory by name ascending.
     */
    public void sortByNameAscending()
    {
        inventoryManager.sortByNameAscending();
    }

    /**
     * Sorts inventory by name descending.
     */
    public void sortByNameDescending()
    {
        inventoryManager.sortByNameDescending();
    }

    /**
     * Sorts inventory by price ascending.
     */
    public void sortByPriceAscending()
    {
        inventoryManager.sortByPriceAscending();
    }

    /**
     * Sorts inventory by price descending.
     */
    public void sortByPriceDescending()
    {
        inventoryManager.sortByPriceDescending();
    }
}