package app;

/**
 * This class represents a product that can be sold in the store.
 * A product has a name, description, price, and quantity.
 */
public class SalableProduct 
{
    protected String name;
    protected String description;
    protected double price;
    protected int quantity;

    /**
     * This constructor creates a SalableProduct object.
     * 
     * @param name The product name
     * @param description The product description
     * @param price The product price
     * @param quantity The product quantity
     */
    public SalableProduct(String name, String description, double price, int quantity) 
    {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Gets the product name.
     * 
     * @return The name
     */
    public String getName() 
    {
        return name;
    }

    /**
     * Sets the product name.
     * 
     * @param name The new name
     */
    public void setName(String name) 
    {
        this.name = name;
    }

    /**
     * Gets the product description.
     * 
     * @return The description
     */
    public String getDescription() 
    {
        return description;
    }

    /**
     * Sets the product description.
     * 
     * @param description The new description
     */
    public void setDescription(String description) 
    {
        this.description = description;
    }

    /**
     * Gets the product price.
     * 
     * @return The price
     */
    public double getPrice() 
    {
        return price;
    }

    /**
     * Sets the product price.
     * 
     * @param price The new price
     */
    public void setPrice(double price) 
    {
        this.price = price;
    }

    /**
     * Gets the product quantity.
     * 
     * @return The quantity
     */
    public int getQuantity() 
    {
        return quantity;
    }

    /**
     * Sets the product quantity.
     * 
     * @param quantity The new quantity
     */
    public void setQuantity(int quantity) 
    {
        this.quantity = quantity;
    }

    /**
     * Decreases the quantity by the amount given.
     * 
     * @param amount The amount to subtract
     */
    public void decreaseQuantity(int amount) 
    {
        quantity = quantity - amount;
    }

    /**
     * Increases the quantity by the amount given.
     * 
     * @param amount The amount to add
     */
    public void increaseQuantity(int amount) 
    {
        quantity = quantity + amount;
    }

    /**
     * Returns the product information as a string.
     * 
     * @return Product information
     */
    
    @Override
    public String toString() 
    {
        return name + " | " + description + " | $" + price + " | Qty: " + quantity;
    }
}