package app;

import java.util.Scanner;

/**
 * This class represents the console based administration application.
 */
public class AdministrationApplication
{
    /**
     * Main method for the administration application.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        AdminClient adminClient = new AdminClient("localhost", 6666);

        int choice = 0;

        while(choice != 3)
        {
            System.out.println("\nADMIN MENU");
            System.out.println("1 - Update Inventory");
            System.out.println("2 - Retrieve Inventory");
            System.out.println("3 - Exit");
            System.out.print("Enter choice: ");

            if(scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            else
            {
                System.out.println("Error: Please enter a number from 1 through 3.");
                scanner.nextLine();
                continue;
            }

            if(choice == 1)
            {
                System.out.println("Paste JSON payload for inventory update:");
                String jsonPayload = scanner.nextLine();

                AdminCommand command = new AdminCommand("U", jsonPayload);
                String response = adminClient.sendCommand(command);
                System.out.println(response);
            }
            else if(choice == 2)
            {
                AdminCommand command = new AdminCommand("R", "");
                String response = adminClient.sendCommand(command);
                System.out.println(response);
            }
            else if(choice == 3)
            {
                System.out.println("Exiting admin application.");
            }
            else
            {
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}