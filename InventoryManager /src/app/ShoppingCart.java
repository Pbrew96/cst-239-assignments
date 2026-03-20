package app;

import java.util.ArrayList;

/**
 * This class represents the user's shopping cart.
 * It stores products the user has selected to purchase.
 */
public class ShoppingCart
{
    private ArrayList<SalableProduct> cartItems;

    /**
     * Constructor that creates the shopping cart list.
     */
    public ShoppingCart()
    {
        cartItems = new ArrayList<SalableProduct>();
    }

    /**
     * Adds a product to the cart.
     * 
     * @param product The product to add
     * @param amount The quantity
     */
    public void addToCart(SalableProduct product, int amount)
    {
        SalableProduct item = new SalableProduct(
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                amount);

        cartItems.add(item);
    }

    /**
     * Removes a product from the cart.
     * 
     * @param name The product name
     * @return true if removed
     */
    public boolean removeFromCart(String name)
    {
        for(SalableProduct product : cartItems)
        {
            if(product.getName().equalsIgnoreCase(name))
            {
                cartItems.remove(product);
                return true;
            }
        }

        return false;
    }

    /**
     * Returns the cart items.
     * 
     * @return list of items
     */
    public ArrayList<SalableProduct> getCartItems()
    {
        return cartItems;
    }

    /**
     * Displays the cart contents.
     */
    public void displayCart()
    {
        if(cartItems.size() == 0)
        {
            System.out.println("Cart is empty.");
            return;
        }

        for(SalableProduct product : cartItems)
        {
            System.out.println(product);
        }

        System.out.println("Total: $" + getTotal());
    }

    /**
     * Calculates the cart total.
     * 
     * @return total price
     */
    public double getTotal()
    {
        double total = 0;

        for(SalableProduct product : cartItems)
        {
            total += product.getPrice() * product.getQuantity();
        }

        return total;
    }

    /**
     * Clears the cart.
     */
    public void clearCart()
    {
        cartItems.clear();
    }
}