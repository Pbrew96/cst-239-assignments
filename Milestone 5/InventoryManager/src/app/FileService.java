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
}