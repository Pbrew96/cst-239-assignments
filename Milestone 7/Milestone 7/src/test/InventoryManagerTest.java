package test;

import app.InventoryManager;
import app.SalableProduct;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests the InventoryManager class.
 * Verifies product management, searching, sorting, and purchase logic.
 */
public class InventoryManagerTest {

    /**
     * Tests adding a product to inventory.
     */
    @Test
    public void testAddProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 5);

        manager.addProduct(product);

        assertEquals(1, manager.getProducts().size());
        assertEquals("Sword", manager.getProducts().get(0).getName());
    }

    /**
     * Tests finding a product.
     */
    @Test
    public void testFindProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new SalableProduct("Potion", "Heals", 5.0, 10);

        manager.addProduct(product);

        SalableProduct found = manager.findProduct("Potion");

        assertNotNull(found);
        assertEquals("Potion", found.getName());
    }

    /**
     * Tests finding a product that does not exist.
     */
    @Test
    public void testFindProductNotFound() {
        InventoryManager manager = new InventoryManager();

        SalableProduct found = manager.findProduct("Bow");

        assertNull(found);
    }

    /**
     * Tests successful product purchase.
     */
    @Test
    public void testPurchaseProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 5);

        manager.addProduct(product);

        boolean result = manager.purchaseProduct("Sword", 2);

        assertTrue(result);
        assertEquals(3, product.getQuantity());
    }

    /**
     * Tests purchase when not enough quantity.
     */
    @Test
    public void testPurchaseProductNotEnough() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 1);

        manager.addProduct(product);

        boolean result = manager.purchaseProduct("Sword", 5);

        assertFalse(result);
        assertEquals(1, product.getQuantity());
    }

    /**
     * Tests canceling a purchase.
     */
    @Test
    public void testCancelProduct() {
        InventoryManager manager = new InventoryManager();
        SalableProduct product = new SalableProduct("Sword", "Sharp blade", 10.0, 3);

        manager.addProduct(product);

        boolean result = manager.cancelProduct("Sword", 2);

        assertTrue(result);
        assertEquals(5, product.getQuantity());
    }

    /**
     * Tests sorting by name ascending.
     */
    @Test
    public void testSortByNameAscending() {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new SalableProduct("Sword", "Sharp", 10.0, 5));
        manager.addProduct(new SalableProduct("Bow", "Ranged", 8.0, 3));

        manager.sortByNameAscending();

        assertEquals("Bow", manager.getProducts().get(0).getName());
        assertEquals("Sword", manager.getProducts().get(1).getName());
    }

    /**
     * Tests sorting by price ascending.
     */
    @Test
    public void testSortByPriceAscending() {
        InventoryManager manager = new InventoryManager();

        manager.addProduct(new SalableProduct("Sword", "Sharp", 10.0, 5));
        manager.addProduct(new SalableProduct("Potion", "Heals", 5.0, 10));

        manager.sortByPriceAscending();

        assertEquals("Potion", manager.getProducts().get(0).getName());
        assertEquals("Sword", manager.getProducts().get(1).getName());
    }
}