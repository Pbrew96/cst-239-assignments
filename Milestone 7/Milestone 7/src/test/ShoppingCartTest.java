package test;

import app.ShoppingCart;
import app.SalableProduct;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the ShoppingCart class.
 * Verifies adding, removing, totals, and clearing the cart.
 */
public class ShoppingCartTest {

    /**
     * Tests adding a product to the cart.
     */
    @Test
    public void testAddToCart() {
        ShoppingCart cart = new ShoppingCart();
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 1);

        cart.addToCart(product);

        assertEquals(1, cart.getCartItems().size());
        assertEquals("Sword", cart.getCartItems().get(0).getName());
    }

    /**
     * Tests removing a product from the cart.
     */
    @Test
    public void testRemoveFromCart() {
        ShoppingCart cart = new ShoppingCart();
        SalableProduct product = new SalableProduct("Potion", "Heals", 5.0, 1);

        cart.addToCart(product);

        boolean result = cart.removeFromCart("Potion");

        assertTrue(result);
        assertEquals(0, cart.getCartItems().size());
    }

    /**
     * Tests removing a product that does not exist.
     */
    @Test
    public void testRemoveFromCartNotFound() {
        ShoppingCart cart = new ShoppingCart();

        boolean result = cart.removeFromCart("Sword");

        assertFalse(result);
    }

    /**
     * Tests total calculation.
     */
    @Test
    public void testGetTotal() {
        ShoppingCart cart = new ShoppingCart();

        cart.addToCart(new SalableProduct("Sword", "Sharp", 10.0, 2));
        cart.addToCart(new SalableProduct("Potion", "Heals", 5.0, 3));

        assertEquals(35.0, cart.getTotal(), 0.001);
    }

    /**
     * Tests clearing the cart.
     */
    @Test
    public void testClearCart() {
        ShoppingCart cart = new ShoppingCart();

        cart.addToCart(new SalableProduct("Sword", "Sharp", 10.0, 1));
        cart.clearCart();

        assertEquals(0, cart.getCartItems().size());
    }
}