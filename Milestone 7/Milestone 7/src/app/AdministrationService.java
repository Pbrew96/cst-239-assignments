package app;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class processes admin commands for updating and retrieving inventory.
 */
public class AdministrationService
{
    private InventoryManager inventoryManager;
    private FileService fileService;

    /**
     * Constructor for AdministrationService.
     *
     * @param inventoryManager The inventory manager
     * @param fileService The file service
     */
    public AdministrationService(InventoryManager inventoryManager, FileService fileService)
    {
        this.inventoryManager = inventoryManager;
        this.fileService = fileService;
    }

    /**
     * Processes an admin command.
     *
     * @param command The admin command
     * @return Response message
     */
    public String processCommand(AdminCommand command)
    {
        if(command.getCommandType().equalsIgnoreCase("U"))
        {
            return handleUpdate(command.getPayload());
        }
        else if(command.getCommandType().equalsIgnoreCase("R"))
        {
            return handleRetrieve();
        }

        return "ERROR: Invalid command";
    }

    /**
     * Handles the inventory update command.
     *
     * @param payload JSON payload
     * @return Response message
     */
    public String handleUpdate(String payload)
    {
        try
        {
            ArrayList<SalableProduct> newProducts = fileService.jsonToProducts(payload);
            inventoryManager.updateInventory(newProducts);
            return "SUCCESS: Inventory updated";
        }
        catch(IOException e)
        {
            return "ERROR: Could not update inventory - " + e.getMessage();
        }
    }

    /**
     * Handles the inventory retrieve command.
     *
     * @return Inventory in JSON format
     */
    public String handleRetrieve()
    {
        try
        {
            return fileService.productsToJson(inventoryManager.getProducts());
        }
        catch(IOException e)
        {
            return "ERROR: Could not retrieve inventory - " + e.getMessage();
        }
    }
}