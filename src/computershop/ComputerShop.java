/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; 

/**
 * The ComputerShop class is the main entry point for the application. It
 * displays a menu to the user, allowing them to perform various actions such as
 * adding products, viewing products, shopping, sorting products, viewing
 * orders, finding the most expensive product, and searching for a product by
 * ID. The user interacts with the ProductManagement class to perform these
 * actions. The menu loop continues until the user chooses to exit the
 * application.
 *
 * @author Group 4 - Assignment
 */
public class ComputerShop {

    /**
     * The main method serves as the entry point for the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of ProductManagement to manage products and orders
        ProductManagement manager = new ProductManagement();
        int choice; // Variable to store the user's menu choice

        // Display the menu and handle user input until they choose to exit
        do {
            // Print the menu
            System.out.println("#################### - COMPUTER SHOP - ####################");
            System.out.println("#                                                         #");
            System.out.println("#     ==================== MENU ====================      #");
            System.out.println("#     |1  - Add Desktop                            |      #");
            System.out.println("#     |2  - Add Laptop                             |      #");
            System.out.println("#     |3  - Add Phone                              |      #");
            System.out.println("#     |4  - Show All Products                      |      #");
            System.out.println("#     |5  - Shopping                               |      #");
            System.out.println("#     |6  - Sort Products by ID                    |      #");
            System.out.println("#     |7  - Sort Products by Price                 |      #");
            System.out.println("#     |8  - View Orders                            |      #");
            System.out.println("#     |9  - Find Most Expensive Product            |      #");
            System.out.println("#     |10 - Search Product by ID                   |      #");
            System.out.println("#     |0  - Exit                                   |      #");
            System.out.println("#     ==============================================      #");
            System.out.println("#                                                         #");
            System.out.println("###########################################################");
            System.out.println("");

            // Prompt the user to enter their choice from the menu
            choice = CheckData.getInteger("Enter your choice: ", "Invalid choice!", 0, 10);

            // Execute the corresponding action based on the user's choice
            switch (choice) {
                case 1:
                    manager.AddDesktop(); // Call method to add a Desktop product
                    break;
                case 2:
                    manager.AddLaptop(); // Call method to add a Laptop product
                    break;
                case 3:
                    manager.AddPhone(); // Call method to add a Phone product
                    break;
                case 4:
                    manager.printListOfProduct(); // Call method to display all products
                    break;
                case 5:
                    manager.shopping(); // Call method to handle shopping process
                    break;
                case 6:
                    manager.sortProductsById(); // Call method to sort products by ID
                    break;
                case 7:
                    manager.sortProductsByPrice(); // Call method to sort products by price
                    break;
                case 8:
                    manager.viewOrder(); // Call method to view all customer orders
                    break;
                case 9:
                    manager.findMostExpensiveProduct(); // Call method to find the most expensive product
                    break;
                case 10:
                    manager.searchProductById(); // Call method to search for a product by ID
                    break;
                case 0:
                    System.out.println("Exiting..."); // Print exit message
                    System.out.println("THANK YOU FOR USING OUR APPLICATION!");
                    System.out.println("SEE YOU AGAIN!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again."); // Print invalid choice message
            }
        } while (choice != 0); // Repeat the menu loop until the user chooses to exit
    }

}
