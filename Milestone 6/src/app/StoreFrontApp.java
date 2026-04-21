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
        store.startAdministrationService(6666);
        
        try
        {
        	Thread.sleep(200);
        }
        catch(InterruptedException e)
        {
        	e.printStackTrace();
        }

        int choice = 0;

        while(choice != 9)
        {
            System.out.println("\nSTORE MENU");
            System.out.println("1 - View Inventory");
            System.out.println("2 - Purchase Product");
            System.out.println("3 - Cancel Purchase");
            System.out.println("4 - View Cart");
            System.out.println("5 - Sort by Name Ascending");
            System.out.println("6 - Sort by Name Descending");
            System.out.println("7 - Sort by Price Ascending");
            System.out.println("8 - Sort by Price Descending");
            System.out.println("9 - Exit");
            System.out.print("Enter choice: ");

            if(scanner.hasNextInt())
            {
                choice = scanner.nextInt();
                scanner.nextLine();
            }
            else
            {
                System.out.println("Error: Please enter a number from 1 through 9.");
                scanner.nextLine();
                continue;
            }

            if(choice == 1)
            {
                store.displayStore();
            }
            else if(choice == 2)
            {
                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                if(name.trim().isEmpty())
                {
                    System.out.println("Error: Product name cannot be blank.");
                    continue;
                }

                System.out.print("Enter quantity: ");

                if(!scanner.hasNextInt())
                {
                    System.out.println("Error: Quantity must be a valid number.");
                    scanner.nextLine();
                    continue;
                }

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

                if(name.trim().isEmpty())
                {
                    System.out.println("Error: Product name cannot be blank.");
                    continue;
                }

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
                store.sortByNameAscending();
                System.out.println("Inventory sorted by name ascending.");
                store.displayStore();
            }
            else if(choice == 6)
            {
                store.sortByNameDescending();
                System.out.println("Inventory sorted by name descending.");
                store.displayStore();
            }
            else if(choice == 7)
            {
                store.sortByPriceAscending();
                System.out.println("Inventory sorted by price ascending.");
                store.displayStore();
            }
            else if(choice == 8)
            {
                store.sortByPriceDescending();
                System.out.println("Inventory sorted by price descending.");
                store.displayStore();
            }
            else if(choice == 9)
            {
                System.out.println("Exiting program.");
            }
            else
            {
                System.out.println("Error: Invalid menu choice. Please enter 1 through 9.");
            }
        }

        scanner.close();
    }
}