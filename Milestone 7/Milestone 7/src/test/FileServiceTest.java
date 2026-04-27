package test;

import app.FileService;
import app.SalableProduct;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;

/**
 * This class tests the FileService class.
 */
public class FileServiceTest {

    @Test
    public void testProductsToJsonAndBack() throws Exception {
        FileService fileService = new FileService();

        ArrayList<SalableProduct> products = new ArrayList<>();
        products.add(new SalableProduct("Sword", "Sharp blade", 10.0, 5));
        products.add(new SalableProduct("Potion", "Heals", 5.0, 10));

        String json = fileService.productsToJson(products);

        ArrayList<SalableProduct> result = fileService.jsonToProducts(json);

        assertEquals(2, result.size());
        assertEquals("Sword", result.get(0).getName());
        assertEquals("Potion", result.get(1).getName());
    }

    @Test
    public void testWriteAndReadFile() throws Exception {
        FileService fileService = new FileService();

        ArrayList<SalableProduct> products = new ArrayList<>();
        products.add(new SalableProduct("Bow", "Ranged weapon", 8.0, 3));

        String fileName = "test_inventory.json";

        fileService.writeProductsToJson(fileName, products);

        ArrayList<SalableProduct> result = fileService.readProductsFromJson(fileName);

        assertEquals(1, result.size());
        assertEquals("Bow", result.get(0).getName());
    }
}