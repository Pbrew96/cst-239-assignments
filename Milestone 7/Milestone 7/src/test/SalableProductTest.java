package test;

import app.SalableProduct;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the SalableProduct class.
 * Verifies constructors, getters, setters, and quantity updates.
 */
public class SalableProductTest {

    /**
     * Tests the constructor and getter methods.
     */
    @Test
    public void testConstructorAndGetters() {
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 5);

        assertEquals("Sword", product.getName());
        assertEquals("Sharp blade", product.getDescription());
        assertEquals(10.0, product.getPrice(), 0.001);
        assertEquals(5, product.getQuantity());
    }

    /**
     * Tests setter methods.
     */
    @Test
    public void testSetters() {
        SalableProduct product = new SalableProduct();

        product.setName("Potion");
        product.setDescription("Heals");
        product.setPrice(5.0);
        product.setQuantity(10);

        assertEquals("Potion", product.getName());
        assertEquals("Heals", product.getDescription());
        assertEquals(5.0, product.getPrice(), 0.001);
        assertEquals(10, product.getQuantity());
    }

    /**
     * Tests decreasing quantity.
     */
    @Test
    public void testDecreaseQuantity() {
        SalableProduct product = new SalableProduct("Item", "Test", 1.0, 10);

        product.decreaseQuantity(3);

        assertEquals(7, product.getQuantity());
    }

    /**
     * Tests increasing quantity.
     */
    @Test
    public void testIncreaseQuantity() {
        SalableProduct product = new SalableProduct("Item", "Test", 1.0, 5);

        product.increaseQuantity(4);

        assertEquals(9, product.getQuantity());
    }
}