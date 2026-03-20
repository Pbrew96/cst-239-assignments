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

                if(store.purchaseProduct(name, qty))
                {
                    System.out.println("Purchase successful.");
                }
                else
                {
                    System.out.println("Purchase failed, product not available.");
                }
            }

            else if(choice == 3)
            {
                System.out.print("Enter product name to cancel: ");
                String name = scanner.nextLine();

                if(store.cancelPurchase(name))
                {
                    System.out.println("Purchase canceled.");
                }
                else
                {
                    System.out.println("Item not found in cart.");
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
                System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}