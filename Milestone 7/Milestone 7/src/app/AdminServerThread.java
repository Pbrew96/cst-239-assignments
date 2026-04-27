package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class runs the administration server in the background.
 */
public class AdminServerThread extends Thread
{
    private int port;
    private AdministrationService administrationService;

    /**
     * Constructor for AdminServerThread.
     *
     * @param port The port number
     * @param administrationService The administration service
     */
    public AdminServerThread(int port, AdministrationService administrationService)
    {
        this.port = port;
        this.administrationService = administrationService;
    }

    /**
     * Runs the server thread.
     */
    @Override
    public void run()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Administration Service started on port " + port);

            while(true)
            {
                Socket clientSocket = serverSocket.accept();

                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String commandType = in.readLine();
                StringBuilder payloadBuilder = new StringBuilder();
                String line;

                while((line = in.readLine()) != null)
                {
                    payloadBuilder.append(line);
                }

                AdminCommand command = new AdminCommand(commandType, payloadBuilder.toString());
                String response = administrationService.processCommand(command);
                out.println(response);

                in.close();
                out.close();
                clientSocket.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Admin server error: " + e.getMessage());
        }
    }
}