package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This class manages the store inventory.
 * It stores a list of products and allows the program
 * to search and display them.
 */
public class InventoryManager
{
    private ArrayList<SalableProduct> products;
    private FileService fileService;
    private String inventoryFileName;

    /**
     * Constructor that creates the inventory list.
     */
    public InventoryManager()
    {
        products = new ArrayList<SalableProduct>();
        fileService = new FileService();
        inventoryFileName = "inventory.json";
    }

    /**
     * Initializes inventory from a JSON file using the FileService.
     *
     * @param fileName The JSON file name
     */
    public void initializeInventoryFromFile(String fileName)
    {
        inventoryFileName = fileName;

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
     * Saves inventory to the current JSON file.
     */
    public void saveInventoryToFile()
    {
        try
        {
            fileService.writeProductsToJson(inventoryFileName, products);
        }
        catch(IOException e)
        {
            System.out.println("Error saving inventory file: " + e.getMessage());
        }
    }

    /**
     * Replaces the inventory with a new list of products.
     *
     * @param newProducts The new product list
     */
    public synchronized void updateInventory(ArrayList<SalableProduct> newProducts)
    {
        products = newProducts;
        saveInventoryToFile();
    }

    /**
     * Returns all products in the inventory.
     *
     * @return The product list
     */
    public synchronized ArrayList<SalableProduct> getProducts()
    {
        return products;
    }

    /**
     * Adds a product to the inventory.
     *
     * @param product The product to add
     */
    public synchronized void addProduct(SalableProduct product)
    {
        products.add(product);
        saveInventoryToFile();
    }

    /**
     * Displays all products in the inventory.
     */
    public synchronized void displayInventory()
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
    public synchronized SalableProduct findProduct(String name)
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
     * Sorts products by name in ascending order.
     */
    public synchronized void sortByNameAscending()
    {
        Collections.sort(products, Comparator.comparing(SalableProduct::getName));
    }

    /**
     * Sorts products by name in descending order.
     */
    public synchronized void sortByNameDescending()
    {
        Collections.sort(products, Comparator.comparing(SalableProduct::getName).reversed());
    }

    /**
     * Sorts products by price in ascending order.
     */
    public synchronized void sortByPriceAscending()
    {
        Collections.sort(products, Comparator.comparingDouble(SalableProduct::getPrice));
    }

    /**
     * Sorts products by price in descending order.
     */
    public synchronized void sortByPriceDescending()
    {
        Collections.sort(products, Comparator.comparingDouble(SalableProduct::getPrice).reversed());
    }

    /**
     * Reduces the inventory quantity when a product is purchased.
     *
     * @param name The product name
     * @param amount The amount to reduce
     * @return true if successful, otherwise false
     */
    public synchronized boolean purchaseProduct(String name, int amount)
    {
        SalableProduct product = findProduct(name);

        if(product != null && product.getQuantity() >= amount)
        {
            product.decreaseQuantity(amount);
            saveInventoryToFile();
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
    public synchronized boolean cancelProduct(String name, int amount)
    {
        SalableProduct product = findProduct(name);

        if(product != null)
        {
            product.increaseQuantity(amount);
            saveInventoryToFile();
            return true;
        }

        return false;
    }
}