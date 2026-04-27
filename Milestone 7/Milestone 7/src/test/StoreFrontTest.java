package test;

import app.StoreFront;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This class tests the StoreFront class.
 */
public class StoreFrontTest {

    @Test
    public void testStoreFrontConstructor() {
        StoreFront store = new StoreFront();

        assertNotNull(store);
    }

    @Test
    public void testPurchaseProductNotFound() {
        StoreFront store = new StoreFront();

        boolean result = store.purchaseProduct("FakeItem", 1);

        assertFalse(result);
    }

    @Test
    public void testCancelPurchaseNotFound() {
        StoreFront store = new StoreFront();

        boolean result = store.cancelPurchase("FakeItem");

        assertFalse(result);
    }

    @Test
    public void testSortMethodsDoNotCrash() {
        StoreFront store = new StoreFront();

        store.sortByNameAscending();
        store.sortByNameDescending();
        store.sortByPriceAscending();
        store.sortByPriceDescending();

        assertNotNull(store);
    }

    @Test
    public void testDisplayMethodsDoNotCrash() {
        StoreFront store = new StoreFront();

        store.displayStore();
        store.displayCart();

        assertNotNull(store);
    }
}