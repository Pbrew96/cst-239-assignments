package app;

/**
 * This class represents an admin command with a command type and payload.
 */
public class AdminCommand
{
    private String commandType;
    private String payload;

    /**
     * Constructor for AdminCommand.
     *
     * @param commandType The command type
     * @param payload The command payload
     */
    public AdminCommand(String commandType, String payload)
    {
        this.commandType = commandType;
        this.payload = payload;
    }

    /**
     * Returns the command type.
     *
     * @return The command type
     */
    public String getCommandType()
    {
        return commandType;
    }

    /**
     * Returns the payload.
     *
     * @return The payload
     */
    public String getPayload()
    {
        return payload;
    }
}