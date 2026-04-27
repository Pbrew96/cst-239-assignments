package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class handles file operations for inventory data.
 */
public class FileService
{
    /**
     * Reads products from a JSON file.
     *
     * @param fileName The name of the JSON file
     * @return A list of products
     * @throws IOException if the file cannot be read
     */
    public ArrayList<SalableProduct> readProductsFromJson(String fileName) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        SalableProduct[] productArray = mapper.readValue(new File(fileName), SalableProduct[].class);
        return new ArrayList<SalableProduct>(Arrays.asList(productArray));
    }

    /**
     * Writes products to a JSON file.
     *
     * @param fileName The name of the JSON file
     * @param products The list of products to write
     * @throws IOException if the file cannot be written
     */
    public void writeProductsToJson(String fileName, ArrayList<SalableProduct> products) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(fileName), products);
    }

    /**
     * Converts a list of products into a JSON string.
     *
     * @param products The product list
     * @return JSON string
     * @throws IOException if conversion fails
     */
    public String productsToJson(ArrayList<SalableProduct> products) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(products);
    }

    /**
     * Converts a JSON string into a list of products.
     *
     * @param json The JSON string
     * @return The list of products
     * @throws IOException if conversion fails
     */
    public ArrayList<SalableProduct> jsonToProducts(String json) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        SalableProduct[] productArray = mapper.readValue(json, SalableProduct[].class);
        return new ArrayList<SalableProduct>(Arrays.asList(productArray));
    }
}