package app;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class manages the store inventory.
 * It stores a list of products and allows the program
 * to search and display them.
 */
public class InventoryManager
{
    private ArrayList<SalableProduct> products;

    /**
     * Constructor that creates the inventory list.
     */
    public InventoryManager()
    {
        products = new ArrayList<SalableProduct>();
    }

    /**
     * Initializes inventory from a JSON file using the FileService.
     *
     * @param fileName The JSON file name
     */
    public void initializeInventoryFromFile(String fileName)
    {
        FileService fileService = new FileService();

        try
        {
            products = fileService.readProductsFromJson(fileName);
            System.out.println("Inventory successfully loaded from JSON.");
        }
        catch(IOException e)
        {
            System.out.println("Error reading inventory file: " + e.getMessage());
        }
        catch(Exception e)
        {
            System.out.println("Error loading inventory data: " + e.getMessage());
        }
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product The product to add
     */
    public void addProduct(SalableProduct product)
    {
        products.add(product);
    }

    /**
     * Returns the list of products.
     *
     * @return The product list
     */
    public ArrayList<SalableProduct> getProducts()
    {
        return products;
    }

    /**
     * Displays all products in the inventory.
     */
    public void displayInventory()
    {
        for(SalableProduct product : products)
        {
            System.out.println(product);
        }
    }

    /**
     * Finds a product by name.
     *
     * @param name The product name
     * @return The product if found, otherwise null
     */
    public SalableProduct findProduct(String name)
    {
        for(SalableProduct product : products)
        {
            if(product.getName().equalsIgnoreCase(name))
            {
                return product;
            }
        }
        return null;
    }

    /**
     * Reduces the inventory quantity when a product is purchased.
     *
     * @param name The product name
     * @param amount The amount to reduce
     * @return true if successful, otherwise false
     */
    public boolean purchaseProduct(String name, int amount)
    {
        SalableProduct product = findProduct(name);

        if(product != null && product.getQuantity() >= amount)
        {
            product.decreaseQuantity(amount);
            return true;
        }

        return false;
    }

    /**
     * Adds quantity back to inventory when a purchase is canceled.
     *
     * @param name The product name
     * @param amount The amount to add back
     * @return true if successful, otherwise false
     */
    public boolean cancelProduct(String name, int amount)
    {
        SalableProduct product = findProduct(name);

        if(product != null)
        {
            product.increaseQuantity(amount);
            return true;
        }

        return false;
    }
}