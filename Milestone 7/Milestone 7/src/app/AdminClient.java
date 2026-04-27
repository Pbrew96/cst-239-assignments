package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class sends admin commands to the store front application.
 */
public class AdminClient
{
    private String host;
    private int port;

    /**
     * Constructor for AdminClient.
     *
     * @param host The host name
     * @param port The port number
     */
    public AdminClient(String host, int port)
    {
        this.host = host;
        this.port = port;
    }

    /**
     * Sends a command to the admin service.
     *
     * @param command The admin command
     * @return The response
     */
    public String sendCommand(AdminCommand command)
    {
        try
        {
            Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            out.println(command.getCommandType());

            if(command.getPayload() != null && !command.getPayload().isEmpty())
            {
                out.println(command.getPayload());
            }

            socket.shutdownOutput();

            StringBuilder response = new StringBuilder();
            String line;

            while((line = in.readLine()) != null)
            {
                response.append(line).append("\n");
            }

            in.close();
            out.close();
            socket.close();

            return response.toString();
        }
        catch(Exception e)
        {
            return "ERROR: " + e.getMessage();
        }
    }
}