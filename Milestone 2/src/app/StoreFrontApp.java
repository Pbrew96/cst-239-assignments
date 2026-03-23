package app;

import java.util.Scanner;

/**
 * Main application that runs the Store Front program.
 */
public class StoreFrontApp
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        StoreFront store = new StoreFront();
        System.out.println("Patrick's Game Store");
        System.out.println("Welcome to the Store Front!");

        store.initializeStore();

        int choice = 0;

        while(choice != 5)
        {
            System.out.println("\nSTORE MENU");
            System.out.println("1 - View Inventory");
            System.out.println("2 - Purchase Product");
            System.out.println("3 - Cancel Purchase");
            System.out.println("4 - View Cart");
            System.out.println("5 - Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            if(choice == 1)
            {
                store.displayStore();
            }

            else if(choice == 2)
            {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                System.out.print("Enter quantity: ");
                int qty = scanner.nextInt();
                scanner.nextLine();
                if(qty <= 0)
                {
                    System.out.println("Error: Quantity must be greater than 0.");
                    continue;
                }

                if(store.purchaseProduct(name, qty))
                {
                    System.out.println("Purchase successful.");
                }
                else
                {
                	System.out.println("Error: Product not found or not enough quantity in inventory.");
                }
            }

            else if(choice == 3)
            {
                System.out.print("Enter product name to cancel: ");
                String name = scanner.nextLine();

                if(store.cancelPurchase(name))
                {
                	System.out.println("Cancel successful. Product returned to inventory.");
                }
                else
                {
                	System.out.println("Error: Item not found in cart.");
                }
            }

            else if(choice == 4)
            {
                store.displayCart();
            }

            else if(choice == 5)
            {
                System.out.println("Exiting program.");
            }

            else
            {
            	System.out.println("Error: Invalid menu choice. Please enter 1 through 5.");
            }
        }

        scanner.close();
    }
}