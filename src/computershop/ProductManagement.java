/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * ProductManagement class manages the products in the computer shop.
 *
 * @author Group 4 - Assignment
 */
public class ProductManagement {

    // List of all products available in the shop
    private ArrayList<Product> listProduct;
    
    // List to store order times
    private ArrayList<Hashtable<String, String>> listOrderTime = new ArrayList<>();

    // List of all customer orders, each order is represented as a hashtable of product IDs and their quantities
    private ArrayList<Hashtable<String, Hashtable<String, Integer>>> listOrder = new ArrayList<>();

    // Hashtable to keep track of the quantities of products ordered by a customer in a single session
    private Hashtable<String, Integer> listProductOrders = new Hashtable<>();



    // Total quantity of all products available in the shop
    int totalProductQuantity;

    /**
     * Constructor to initialize the ProductManagement object. Initializes the
     * list of products and populates sample data.
     */
    public ProductManagement() {
        listProduct = new ArrayList<>();
        totalProductQuantity = 0;
        populateSampleData();
    }

    /**
     * Method to add a desktop product. Prompts the user for product details and
     * adds the product to the list.
     */
    public void AddDesktop() {
        boolean keepAdding = true;
        while (keepAdding) {
            printListOfProduct();
            String ID = CheckData.getString("Please enter product id: ", "Product id cannot be empty!");

            // Check if the ID starts with 'D'
            if (!ID.startsWith("D")) {
                System.out.println("Product id must start with 'D'. Please try again.");
                continue; // Skip the rest of the loop and prompt for ID again
            }

            boolean duplicateId = false;

            // Check for duplicate product ID
            for (Product product : listProduct) {
                if (product.getID().equals(ID)) {
                    System.out.println("This product id already exists in the product list!");
                    String op = CheckData.getString("Do you want to update the quantity of this product (y/n)?", "Your input cannot be empty!");
                    if (op.equalsIgnoreCase("y")) {
                        // Update quantity if user chooses 'y'
                        int additionalQuantity = CheckData.getInteger("Please enter additional quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                        product.setQuantity(product.getQuantity() + additionalQuantity);
                        totalProductQuantity += additionalQuantity;
                        printListOfProduct();
                        System.out.println("Quantity updated.");
                        duplicateId = true;
                        break;
                    } else {
                        // Prompt user to enter a new product ID if they choose 'n'
                        System.out.println("Please enter a new product ID.");
                        duplicateId = true;
                        break;
                    }
                }
            }

            if (!duplicateId) {
                // Prompt user for product details and add the new product
                double Price = CheckData.getDouble1("Please enter product price: ", "Price must be a positive number!");
                int Quantity = CheckData.getInteger("Please enter product quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                int RAM = CheckData.getInteger("Please enter RAM: ", "RAM must be a positive integer!", 1, Integer.MAX_VALUE);
                int ROM = CheckData.getInteger("Please enter ROM: ", "ROM must be a positive integer!", 1, Integer.MAX_VALUE);
                String VGA = CheckData.getString("Please enter VGA: ", "VGA cannot be empty!");
                String CPU = CheckData.getString("Please enter CPU: ", "CPU cannot be empty!");
                String Radiators = CheckData.getString("Please enter Radiators: ", "Radiators cannot be empty!");

                listProduct.add(new Desktop(ID, Price, Quantity, RAM, ROM, VGA, CPU, Radiators));
                totalProductQuantity += Quantity;
                printListOfProduct();
                System.out.println("New product added.");
            }

            String op2 = CheckData.getString("Do you want to continue adding products (y/n)?", "Your input cannot be empty!");
            keepAdding = op2.equalsIgnoreCase("y");
        }

    }

    /**
     * Method to add a laptop product. Prompts the user for product details and
     * adds the product to the list.
     */
    public void AddLaptop() {
        boolean keepAdding = true;
        while (keepAdding) {
            printListOfProduct();

            // Prompt user to enter product ID
            String ID = CheckData.getString("Please enter product id: ", "Product id cannot be empty!");

            // Check if the ID starts with 'L'
            if (!ID.startsWith("L")) {
                System.out.println("Product id must start with 'L'. Please try again.");
                continue; // Skip the rest of the loop and prompt for ID again
            }

            boolean duplicateId = false;

            // Check for duplicate product ID
            for (Product product : listProduct) {
                if (product.getID().equals(ID)) {
                    System.out.println("This product id already exists in the product list!");
                    // Ask if the user wants to update the quantity of the existing product
                    String op = CheckData.getString("Do you want to update the quantity of this product (y/n)?", "Your input cannot be empty!");
                    if (op.equalsIgnoreCase("y")) {
                        // Update quantity if user chooses 'y'
                        int additionalQuantity = CheckData.getInteger("Please enter additional quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                        product.setQuantity(product.getQuantity() + additionalQuantity);
                        totalProductQuantity += additionalQuantity;
                        printListOfProduct();
                        System.out.println("Quantity updated.");
                        duplicateId = true;
                        break;
                    } else {
                        // Prompt user to enter a new product ID if they choose 'n'
                        System.out.println("Please enter a new product ID.");
                        duplicateId = true;
                        break;
                    }
                }
            }

            if (!duplicateId) {
                // Prompt user for product details and add the new product
                double Price = CheckData.getDouble1("Please enter product price: ", "Price must be a positive number!");
                int Quantity = CheckData.getInteger("Please enter product quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                int RAM = CheckData.getInteger("Please enter RAM: ", "RAM must be a positive integer!", 1, Integer.MAX_VALUE);
                int ROM = CheckData.getInteger("Please enter ROM: ", "ROM must be a positive integer!", 1, Integer.MAX_VALUE);
                String VGA = CheckData.getString("Please enter VGA: ", "VGA cannot be empty!");
                String CPU = CheckData.getString("Please enter CPU: ", "CPU cannot be empty!");
                String Name = CheckData.getString("Please enter Name of Laptop: ", "Name of Laptop cannot be empty!");
                double Screen = CheckData.getDouble("Please enter Screen size: ", "Screen size must be a positive number!", 0.0, 20.0);
                double Weight = CheckData.getDouble("Please enter Weight: ", "Weight must be a positive number!", 0.0, 10.0);

                // Add new laptop to the product list
                listProduct.add(new Laptop(ID, Price, Quantity, RAM, ROM, VGA, CPU, Name, Screen, Weight));
                totalProductQuantity += Quantity;
                printListOfProduct();
                System.out.println("New laptop added.");
            }

            // Ask if the user wants to continue adding products
            String op2 = CheckData.getString("Do you want to continue adding products (y/n)?", "Your input cannot be empty!");
            keepAdding = op2.equalsIgnoreCase("y");
        }
    }

    /**
     * Method to add a phone product. Prompts the user for product details and
     * adds the product to the list.
     */
    public void AddPhone() {
        boolean keepAdding = true;
        while (keepAdding) {
            printListOfProduct();

            // Prompt user to enter product ID
            String ID = CheckData.getString("Please enter product id: ", "Product id cannot be empty!");

            // Check if the ID starts with 'P'
            if (!ID.startsWith("P")) {
                System.out.println("Product id must start with 'P'. Please try again.");
                continue; // Skip the rest of the loop and prompt for ID again
            }

            boolean duplicateId = false;

            // Check for duplicate product ID
            for (Product product : listProduct) {
                if (product.getID().equals(ID)) {
                    System.out.println("This product id already exists in the product list!");
                    // Ask if the user wants to update the quantity of the existing product
                    String op = CheckData.getString("Do you want to update the quantity of this product (y/n)?", "Your input cannot be empty!");
                    if (op.equalsIgnoreCase("y")) {
                        // Update quantity if user chooses 'y'
                        int additionalQuantity = CheckData.getInteger("Please enter additional quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                        product.setQuantity(product.getQuantity() + additionalQuantity);
                        totalProductQuantity += additionalQuantity;
                        printListOfProduct();
                        System.out.println("Quantity updated.");
                        duplicateId = true;
                        break;
                    } else {
                        // Prompt user to enter a new product ID if they choose 'n'
                        System.out.println("Please enter a new product ID.");
                        duplicateId = true;
                        break;
                    }
                }
            }

            if (!duplicateId) {
                // Prompt user for product details and add the new product
                double Price = CheckData.getDouble1("Please enter product price: ", "Price must be a positive number!");
                int Quantity = CheckData.getInteger("Please enter product quantity: ", "Quantity must be a positive integer!", 1, Integer.MAX_VALUE);
                int RAM = CheckData.getInteger("Please enter RAM: ", "RAM must be a positive integer!", 1, Integer.MAX_VALUE);
                int ROM = CheckData.getInteger("Please enter ROM: ", "ROM must be a positive integer!", 1, Integer.MAX_VALUE);
                String Name = CheckData.getString("Please enter Name of Phone: ", "Name of Phone cannot be empty!");
                String Chip = CheckData.getString("Please enter Chip of phone: ", "Chip cannot be empty!");
                double Screen = CheckData.getDouble("Please enter Screen size: ", "Screen size must be a positive number!", 0.0, 20.0);
                double Weight = CheckData.getDouble("Please enter Weight: ", "Weight must be a positive number!", 0.0, 10.0);

                // Add new phone to the product list
                listProduct.add(new Phone(ID, Price, Quantity, Name, Chip, RAM, ROM, Screen, Weight));
                totalProductQuantity += Quantity;
                printListOfProduct();
                System.out.println("New phone added.");
            }

            // Ask if the user wants to continue adding products
            String op2 = CheckData.getString("Do you want to continue adding products (y/n)?", "Your input cannot be empty!");
            keepAdding = op2.equalsIgnoreCase("y");
        }
    }

    /**
     * Method for shopping. Allows customers to buy products from the shop.
     */
    public void shopping() {
        // Check if the shop is open by verifying if the product list is empty
        if (listProduct.isEmpty()) {
            System.out.println("Shop is not open yet!");
            return;
        }

        int quantity; // Variable to store the quantity of the product to be purchased
        String input; // Variable to store the product ID input by the user
        boolean keepBuy = true; // Flag to control the shopping loop

        while (keepBuy) {
            // Check if the shop is out of stock
            if (totalProductQuantity == 0) {
                System.out.println("Shop is out of stock, please come back later!");
                return;
            }

            printListForBuyer(); // Print the list of products available for buyers
            boolean foundProduct = false; // Flag to indicate if the requested product is found

            while (true) {
                // Prompt the user to enter the product ID
                input = CheckData.getString("Please enter product id: ", "Product id cannot be empty!");

                // Check if the entered product ID exists in the product list
                for (Product product : listProduct) {
                    if (product.getID().equals(input)) {
                        // Flag to control the quantity input loop
                        boolean loopEntryQuantity = true;

                        do {
                            // Prompt the user to enter the quantity of the product they want to buy
                            quantity = CheckData.getInteger1("Please input quantity: ", "Quantity must be a positive integer!", 1);
                            if (quantity <= product.getQuantity()) {
                                // Update the quantity if the requested quantity is available
                                if (listProductOrders.containsKey(input)) {
                                    // Add quantity to existing order
                                    listProductOrders.put(input, listProductOrders.get(input) + quantity);
                                } else {
                                    // Create a new order entry
                                    listProductOrders.put(input, quantity);
                                }
                                // Decrease the total product quantity
                                totalProductQuantity -= quantity;
                                // Update product's available quantity
                                product.setQuantity(product.getQuantity() - quantity);
                                // Exit the quantity input loop
                                loopEntryQuantity = false;
                            } else if (product.getQuantity() == 0) {
                                // Inform the user if the product is out of stock
                                System.out.println("This product is out of stock, please choose another one!");
                                break;
                            } else {
                                // Inform the user if there is not enough stock for the requested quantity
                                System.out.println("Not enough stock for this product!");
                                System.out.printf("The maximum quantity available is %d!\n", product.getQuantity());
                            }
                        } // Repeat until a valid quantity is entered
                        while (loopEntryQuantity);

                        // Product found
                        foundProduct = true;
                        break;
                    }
                }

                if (foundProduct) {
                    // Exit the product ID input loop if the product is found
                    break;
                } else {
                    System.out.println("Product with the given ID not found. Please try again!");
                }
            }

            if (totalProductQuantity == 0) {
                // If the shop is out of stock after the order, finalize the order
                System.out.println("Shop is out of stock!\nPlease pay for the items you have ordered and come back later!");
                // Print the customer's order details
                printCustomerOrder();
                // Prompt for customer name
                String customerName = CheckData.getString("Input your name: ", "Name cannot be empty!");
                // Create a new order entry
                Hashtable<String, Hashtable<String, Integer>> customerOrder = new Hashtable<>();
                // Add order details to the customer's order
                customerOrder.put(customerName, new Hashtable<>(listProductOrders));
                // Store the order time
                Hashtable<String, String> orderTime = new Hashtable<>();
                orderTime.put("Order Time", new SimpleDateFormat("'Date is' EEE dd-MMM-yyyy, 'Lock is' HH:mm:ss").format(new Date()));
                // Add the order to the list of orders
                listOrder.add(customerOrder);
                // Add the order time to the list of orders
                listOrderTime.add(orderTime);
                // Clear the current order
                listProductOrders.clear();
                // Exit the shopping loop
                keepBuy = false;
            } else {
                System.out.println("Do you want to order now?");
                // Prompt the user to either finalize the order or continue shopping
                String op = CheckData.getString("Press 'y' or 'yes' to accept, other key to keep buying!\n", "Your input cannot be empty!");
                if (op.equalsIgnoreCase("y") || op.equalsIgnoreCase("yes")) {
                    // Print the customer's order details
                    printCustomerOrder();
                    // Prompt for customer name
                    String customerName = CheckData.getString("Input your name: ", "Name cannot be empty!");
                    // Create a new order entry
                    Hashtable<String, Hashtable<String, Integer>> customerOrder = new Hashtable<>();
                    // Add order details to the customer's order
                    customerOrder.put(customerName, new Hashtable<>(listProductOrders));
                    // Store the order time
                    Hashtable<String, String> orderTime = new Hashtable<>();
                    orderTime.put("Order Time", new SimpleDateFormat("'Date is' EEE dd-MMM-yyyy, 'Lock is' HH:mm:ss").format(new Date()));
                    // Add the order to the list of orders
                    listOrder.add(customerOrder);
                    // Add the order time to the list of orders
                    listOrderTime.add(orderTime);
                    // Clear the current order
                    listProductOrders.clear();
                    // Exit the shopping loop
                    keepBuy = false;
                }
            }
        }
    }

    /**
     * Method to print the list of products. Displays the details of all
     * products in the product list.
     */
    public void printListOfProduct() {
        // Check if the product list is empty and print a message if there are no products
        if (listProduct.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        // Print the header for the product list
        System.out.println("List of Products:");
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| No.| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Iterate through the product list to display each product's details
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            String name = "-"; // Initialize name with default value
            String vga = "-"; // Initialize VGA with default value
            String cpu = "-"; // Initialize CPU with default value
            String radiators = "-"; // Initialize radiators with default value
            String screen = "-"; // Initialize screen with default value
            String weight = "-"; // Initialize weight with default value
            String chip = "-"; // Initialize chip with default value

            // Set product details based on the type of product
            if (product instanceof Desktop) {
                name = "Desktop";
                vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
            } else if (product instanceof Laptop) {
                name = ((Laptop) product).getName(); // Get name for Laptop
                vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
            } else if (product instanceof Phone) {
                name = ((Phone) product).getName(); // Get name for Phone
                chip = ((Phone) product).getChip(); // Get chip details for Phone
                screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
            }

            // Format the price to include commas and two decimal places
            String price = String.format("%,.2f $", product.getPrice());

            // Print the product details in a formatted table row
            System.out.println(String.format("|%3d | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s |",
                    i + 1, product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));
        }

        // Print the footer for the product list
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to print the list of products for buyers. Displays only the
     * products that have a quantity greater than zero.
     */
    public void printListForBuyer() {
        // Check if the product list is empty
        if (listProduct.isEmpty()) {
            System.out.println("No products available."); // Print a message if there are no products
            return; // Exit the method if there are no products
        }

        System.out.println("List of Products:");
        // Print the table header
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| No.| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Iterate through the product list and display the products with quantity > 0
        for (int i = 0; i < listProduct.size(); i++) {
            // Check if the product quantity is greater than zero
            if (listProduct.get(i).getQuantity() > 0) {
                Product product = listProduct.get(i);
                String name = "-"; // Initialize name with default value
                String vga = "-"; // Initialize VGA with default value
                String cpu = "-"; // Initialize CPU with default value
                String radiators = "-"; // Initialize radiators with default value
                String screen = "-"; // Initialize screen with default value
                String weight = "-"; // Initialize weight with default value
                String chip = "-"; // Initialize chip with default value

                // Set product details based on product type
                if (product instanceof Desktop) {
                    name = "Desktop"; // Set name for Desktop
                    vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                    cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                    radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
                } else if (product instanceof Laptop) {
                    name = ((Laptop) product).getName(); // Set name for Laptop
                    vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                    cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                    screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                    weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
                } else if (product instanceof Phone) {
                    name = ((Phone) product).getName(); // Set name for Phone
                    chip = ((Phone) product).getChip(); // Get chip details for Phone
                    screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                    weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
                }

                // Format the price to include commas and two decimal places
                String price = String.format("%,.2f $", product.getPrice());

                // Print the product details in a formatted table row
                System.out.println(String.format("|%3d | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s |",
                        i + 1, product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));
            }
        }

        // Print the table footer
        System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to find and display the most expensive product. Iterates through
     * the product list to determine the product with the highest price.
     */
    public void findMostExpensiveProduct() {
        // Check if the product list is empty and print a message if there are no products
        if (listProduct.isEmpty()) {
            System.out.println("No products available!");
            return;
        }

        // Initialize the most expensive product as the first product in the list
        Product mostExpensiveProduct = listProduct.get(0);

        // Iterate through the product list to find the most expensive product
        for (Product product : listProduct) {
            // Compare the price of each product with the current most expensive product
            if (product.getPrice() > mostExpensiveProduct.getPrice()) {
                // Update the most expensive product if a higher price is found
                mostExpensiveProduct = product;
            }
        }

        // Print the header for the most expensive product details
        System.out.println("The most expensive product is:");
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Initialize product details with default values
        String name = "-";
        String vga = "-";
        String cpu = "-";
        String radiators = "-";
        String screen = "-";
        String weight = "-";
        String chip = "-";

        // Set product details based on the type of the most expensive product
        if (mostExpensiveProduct instanceof Desktop) {
            name = "Desktop";
            vga = ((Desktop) mostExpensiveProduct).getVGA(); // Get VGA details for Desktop
            cpu = ((Desktop) mostExpensiveProduct).getCPU(); // Get CPU details for Desktop
            radiators = ((Desktop) mostExpensiveProduct).getRadiators(); // Get Radiators details for Desktop
        } else if (mostExpensiveProduct instanceof Laptop) {
            name = ((Laptop) mostExpensiveProduct).getName(); // Get Name for Laptop
            vga = ((Laptop) mostExpensiveProduct).getVGA(); // Get VGA details for Laptop
            cpu = ((Laptop) mostExpensiveProduct).getCPU(); // Get CPU details for Laptop
            screen = String.valueOf(((Laptop) mostExpensiveProduct).getScreen()); // Get Screen size for Laptop
            weight = String.valueOf(((Laptop) mostExpensiveProduct).getWeight()); // Get Weight for Laptop
        } else if (mostExpensiveProduct instanceof Phone) {
            name = ((Phone) mostExpensiveProduct).getName(); // Get Name for Phone
            chip = ((Phone) mostExpensiveProduct).getChip(); // Get Chip details for Phone
            screen = String.valueOf(((Phone) mostExpensiveProduct).getScreen()); // Get Screen size for Phone
            weight = String.valueOf(((Phone) mostExpensiveProduct).getWeight()); // Get Weight for Phone
        }

        // Format the price to include commas and two decimal places
        String price = String.format("%,.2f $", mostExpensiveProduct.getPrice());

        // Print the most expensive product details in a formatted table row
        System.out.println(String.format("| %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s |",
                mostExpensiveProduct.getID(), name, mostExpensiveProduct.getRAM(), mostExpensiveProduct.getROM(), mostExpensiveProduct.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));

        // Print the footer for the most expensive product details
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to sort products by ID using Bubble Sort algorithm. Sorts the list
     * of products in ascending order based on their IDs.
     */
    public void sortProductsById() {
        // Check if the product list is empty
        if (listProduct.isEmpty()) {
            System.out.println("No products available!"); // Print a message if there are no products
            return; // Exit the method if there are no products
        }

        // Bubble Sort algorithm to sort products by ID
        for (int i = 0; i < listProduct.size() - 1; i++) {
            for (int j = 0; j < listProduct.size() - 1 - i; j++) {
                // Compare the IDs of adjacent products
                if (listProduct.get(j).getID().compareTo(listProduct.get(j + 1).getID()) > 0) {
                    // Swap the products if they are in the wrong order
                    Product temp = listProduct.get(j);
                    listProduct.set(j, listProduct.get(j + 1));
                    listProduct.set(j + 1, temp);
                }
            }
        }

        // Print the header for the sorted product list
        System.out.println("Products sorted by ID:");
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| No. | Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Iterate through the sorted product list and print each product's details
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            String name = "-"; // Initialize name with default value
            String vga = "-"; // Initialize VGA with default value
            String cpu = "-"; // Initialize CPU with default value
            String radiators = "-"; // Initialize radiators with default value
            String screen = "-"; // Initialize screen with default value
            String weight = "-"; // Initialize weight with default value
            String chip = "-"; // Initialize chip with default value

            // Set product details based on product type
            if (product instanceof Desktop) {
                name = "Desktop"; // Set name for Desktop
                vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
            } else if (product instanceof Laptop) {
                name = ((Laptop) product).getName(); // Set name for Laptop
                vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
            } else if (product instanceof Phone) {
                name = ((Phone) product).getName(); // Set name for Phone
                chip = ((Phone) product).getChip(); // Get chip details for Phone
                screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
            }

            // Format the price to include commas and two decimal places
            String price = String.format("%,.2f $", product.getPrice());

            // Print the product details in a formatted table row
            System.out.println(String.format("| %3d | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s |",
                    i + 1, product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));
        }

        // Print the footer for the sorted product list
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to sort products by Price using Bubble Sort algorithm. Sorts the
     * list of products in descending order based on their prices.
     */
    public void sortProductsByPrice() {
        // Check if the product list is empty
        if (listProduct.isEmpty()) {
            System.out.println("No products available!"); // Print a message if there are no products
            return; // Exit the method if there are no products
        }

        // Bubble Sort algorithm to sort products by Price
        for (int i = 0; i < listProduct.size() - 1; i++) {
            for (int j = 0; j < listProduct.size() - 1 - i; j++) {
                // Compare the prices of adjacent products
                if (listProduct.get(j).getPrice() < listProduct.get(j + 1).getPrice()) {
                    // Swap the products if they are in the wrong order
                    Product temp = listProduct.get(j);
                    listProduct.set(j, listProduct.get(j + 1));
                    listProduct.set(j + 1, temp);
                }
            }
        }

        // Print the header for the sorted product list
        System.out.println("Products sorted by Price:");
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| No. | Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Iterate through the sorted product list and print each product's details
        for (int i = 0; i < listProduct.size(); i++) {
            Product product = listProduct.get(i);
            String name = "-"; // Initialize name with default value
            String vga = "-"; // Initialize VGA with default value
            String cpu = "-"; // Initialize CPU with default value
            String radiators = "-"; // Initialize radiators with default value
            String screen = "-"; // Initialize screen with default value
            String weight = "-"; // Initialize weight with default value
            String chip = "-"; // Initialize chip with default value

            // Set product details based on product type
            if (product instanceof Desktop) {
                name = "Desktop"; // Set name for Desktop
                vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
            } else if (product instanceof Laptop) {
                name = ((Laptop) product).getName(); // Set name for Laptop
                vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
            } else if (product instanceof Phone) {
                name = ((Phone) product).getName(); // Set name for Phone
                chip = ((Phone) product).getChip(); // Get chip details for Phone
                screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
            }

            // Format the price to include commas and two decimal places
            String price = String.format("%,.2f $", product.getPrice());

            // Print the product details in a formatted table row
            System.out.println(String.format("| %3d | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s |",
                    i + 1, product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));
        }

        // Print the footer for the sorted product list
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to print the details of a customer's order. Displays each product
     * in the order along with the total amount.
     */
    public void printCustomerOrder() {
        double totalAmount = 0; // Variable to store the total amount of the order
        double amount; // Variable to store the amount for each product

        System.out.println("Your Order:");
        // Print the table header for the order details
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
        System.out.println("| No. | Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |                Amount |");
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");

        int no = 1; // Variable to store the product number in the order
        // Iterate through the product orders
        for (String productId : listProductOrders.keySet()) {
            for (Product product : listProduct) {
                // Check if the product ID in the order matches the current product
                if (productId.equalsIgnoreCase(product.getID())) {
                    int quantity = listProductOrders.get(productId); // Get the quantity of the product in the order
                    amount = product.getPrice() * quantity; // Calculate the amount for the current product
                    String formattedPrice = String.format("%,.1f $", product.getPrice()); // Format the price with commas and one decimal place
                    String formattedAmount = String.format("%,.1f $", amount); // Format the amount with commas and one decimal place
                    totalAmount += amount; // Add the amount to the total amount

                    // Initialize product details with default values
                    String name = "-";
                    String vga = "-";
                    String cpu = "-";
                    String radiators = "-";
                    String screen = "-";
                    String weight = "-";
                    String chip = "-";

                    // Set product details based on product type
                    if (product instanceof Desktop) {
                        name = "Desktop"; // Set name for Desktop
                        vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                        cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                        radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
                    } else if (product instanceof Laptop) {
                        name = ((Laptop) product).getName(); // Set name for Laptop
                        vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                        cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                        screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                        weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
                    } else if (product instanceof Phone) {
                        name = ((Phone) product).getName(); // Set name for Phone
                        chip = ((Phone) product).getChip(); // Get chip details for Phone
                        screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                        weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
                    }

                    // Print the product details in a formatted table row
                    System.out.println(String.format("|%3d  | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s | %21s |",
                            no++, product.getID(), name, product.getRAM(), product.getROM(), quantity, formattedPrice, vga, cpu, radiators, screen, weight, chip, formattedAmount));
                }
            }
        }

        // Format the total amount with commas and one decimal place
        String formattedTotalAmount = String.format("%,.1f $", totalAmount);
        // Print the table footer with the total amount
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
        System.out.printf("|                                                                                                                                                                                                                                     TOTAL      | %21s |\n", formattedTotalAmount);
        System.out.println("+-----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
        System.out.println(""); // Print a new line for spacing
    }

    /**
     * Method to display the details of customer orders. Iterates through each
     * customer order and displays the products and total amount for each order.
     */
    public void viewOrder() {
        // Check if there are any customer orders.
        if (listOrder.isEmpty()) {
            System.out.println("No customer order yet!"); // Print a message if there are no orders
            return; // Exit the method if there are no orders
        }

        // Instance variables to store information.
        int customerIndex = 0; // Variable to keep track of the customer index

        // Iterate through each customer order in the list of orders
        for (int i = 0; i < listOrder.size(); i++) {
            Hashtable<String, Hashtable<String, Integer>> customer = listOrder.get(i);
            Hashtable<String, String> orderTime = listOrderTime.get(i);
            // Extract customer name and increment the customer index.
            String customerName = customer.keys().nextElement(); // Get the customer name
            customerIndex++; // Increment the customer index

            // Display the customer's name.
            System.out.printf("Customer %d: %s\n", customerIndex, customerName);
            // Display the order creation time.
            System.out.printf("Order Time: %s\n", orderTime.get("Order Time"));

            // Display the header of the customer's order table.
            System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
            System.out.println("| No.| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |                Amount |");
            System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");

            // Initialize total amount and product index.
            int productIndex = 0; // Variable to keep track of the product index
            double totalAmount = 0; // Variable to store the total amount for the current order

            // Iterate through each product in the customer's order.
            for (String productId : customer.get(customerName).keySet()) {
                productIndex++; // Increment the product index

                // Extract product details from the order.
                int quantity = customer.get(customerName).get(productId); // Get the quantity of the product

                // Find the corresponding product in the list of available products.
                Product currentProduct = null; // Initialize the current product as null
                for (Product product : listProduct) {
                    if (productId.equals(product.getID())) { // Check if the product ID matches
                        currentProduct = product; // Set the current product
                        break; // Exit the loop once the product is found
                    }
                }

                // If the product is found, display its details in the formatted table.
                if (currentProduct != null) {
                    double amount = currentProduct.getPrice() * quantity; // Calculate the amount for the current product
                    totalAmount += amount; // Add the amount to the total amount

                    // Format price and amount with commas and one decimal place.
                    String formattedPrice = String.format("%,.1f $", currentProduct.getPrice()); // Format the price
                    String formattedAmount = String.format("%,.1f $", amount); // Format the amount

                    // Initialize product details with default values
                    String name = "-";
                    String vga = "-";
                    String cpu = "-";
                    String radiators = "-";
                    String screen = "-";
                    String weight = "-";
                    String chip = "-";

                    // Set product details based on product type
                    if (currentProduct instanceof Desktop) {
                        name = "Desktop"; // Set name for Desktop
                        vga = ((Desktop) currentProduct).getVGA(); // Get VGA details for Desktop
                        cpu = ((Desktop) currentProduct).getCPU(); // Get CPU details for Desktop
                        radiators = ((Desktop) currentProduct).getRadiators(); // Get radiators details for Desktop
                    } else if (currentProduct instanceof Laptop) {
                        name = ((Laptop) currentProduct).getName(); // Set name for Laptop
                        vga = ((Laptop) currentProduct).getVGA(); // Get VGA details for Laptop
                        cpu = ((Laptop) currentProduct).getCPU(); // Get CPU details for Laptop
                        screen = String.valueOf(((Laptop) currentProduct).getScreen()); // Get screen size for Laptop
                        weight = String.valueOf(((Laptop) currentProduct).getWeight()); // Get weight for Laptop
                    } else if (currentProduct instanceof Phone) {
                        name = ((Phone) currentProduct).getName(); // Set name for Phone
                        chip = ((Phone) currentProduct).getChip(); // Get chip details for Phone
                        screen = String.valueOf(((Phone) currentProduct).getScreen()); // Get screen size for Phone
                        weight = String.valueOf(((Phone) currentProduct).getWeight()); // Get weight for Phone
                    }

                    // Print the product details in a formatted table row
                    System.out.println(String.format("|%3d | %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16sKg | %-16s | %21s |",
                            productIndex, currentProduct.getID(), name, currentProduct.getRAM(), currentProduct.getROM(), quantity, formattedPrice, vga, cpu, radiators, screen, weight, chip, formattedAmount));
                }
            }

            // Display the total amount for the current customer's order.
            String formattedTotalAmount = String.format("%,.1f $", totalAmount); // Format the total amount
            System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
            System.out.printf("|                                                                                                                                                                                                                                    TOTAL      | %21s |\n", formattedTotalAmount);
            System.out.println("+----+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+-----------------------+");
            System.out.println(""); // Print a new line for spacing
        }
    }

    /**
     * Method to search for a product by ID. Allows the user to search for a
     * product in the list by entering the product ID.
     */
    public void searchProductById() {
        // Check if the product list is empty
        if (listProduct.isEmpty()) {
            System.out.println("No products available!"); // Print a message if there are no products
        } else {
            boolean continueSearch; // Variable to control the search loop

            // Loop to allow the user to perform multiple searches
            do {
                // Prompt the user to enter a product ID to search for
                String idToSearch = CheckData.getString("Enter Product ID to search (You should search ID with first key 'D', 'L', 'P'): ", "Product ID to search cannot be empty!");
                boolean exactIdFound = false; // Variable to track if an exact match is found

                // Iterate through the list of products to find an exact match
                for (Product product : listProduct) {
                    if (product.getID().equals(idToSearch)) {
                        exactIdFound = true; // Set exactIdFound to true if an exact match is found
                        displayProduct(product); // Display the details of the matched product
                        break; // Exit the loop once an exact match is found
                    }
                }

                // If no exact match is found, search for similar IDs
                if (!exactIdFound) {
                    boolean similarIdsFound = false; // Variable to track if similar IDs are found
                    String lowerCaseId = idToSearch.toLowerCase(); // Convert the search ID to lower case

                    // Collect similar products
                    ArrayList<Product> similarProducts = new ArrayList<>();
                    for (Product product : listProduct) {
                        // Check if the product ID contains the search string (case-insensitive)
                        if (product.getID().toLowerCase().contains(lowerCaseId)) {
                            similarProducts.add(product); // Add the product to the list of similar products
                            similarIdsFound = true; // Set similarIdsFound to true if a similar ID is found
                        }
                    }

                    // Display the results of the search
                    if (similarIdsFound) {
                        System.out.println("No exact match found for the ID \"" + idToSearch + "\". Displaying similar IDs:");
                        displayProductList(similarProducts); // Display the list of similar products
                    } else {
                        System.out.println("No products found with ID \"" + idToSearch + "\"."); // Print a message if no similar IDs are found
                    }
                }

                // Prompt the user to continue searching or exit the loop
                System.out.print("Do you want to search for another product? Press Y to continue, any other key to exit: ");
                String continueChoice = CheckData.sc.nextLine(); // Get the user's choice
                continueSearch = continueChoice.equalsIgnoreCase("y"); // Set continueSearch based on the user's choice

            } while (continueSearch); // Continue the loop if the user wants to search more products
        }
    }

    /**
     * Helper method to display product details. Prints the details of the given
     * product in a formatted table.
     *
     * @param product The product to display.
     */
    private void displayProduct(Product product) {
        // Initialize product details with default values
        String name = "-";
        String vga = "-";
        String cpu = "-";
        String radiators = "-";
        String screen = "-";
        String weight = "-";
        String chip = "-";

        // Set product details based on product type
        if (product instanceof Desktop) {
            name = "Desktop"; // Set name for Desktop
            vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
            cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
            radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
        } else if (product instanceof Laptop) {
            name = ((Laptop) product).getName(); // Set name for Laptop
            vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
            cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
            screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
            weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
        } else if (product instanceof Phone) {
            name = ((Phone) product).getName(); // Set name for Phone
            chip = ((Phone) product).getChip(); // Get chip details for Phone
            screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
            weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
        }

        // Format the price to include commas and two decimal places
        String price = String.format("%,.2f $", product.getPrice());

        // Print the header for the product details table
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Print the product details in a formatted table row
        System.out.println(String.format("| %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16skg | %-16s |",
                product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));

        // Print the footer for the product details table
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Helper method to display a list of products. Prints the details of each
     * product in the provided list in a formatted table.
     *
     * @param products The list of products to display.
     */
    private void displayProductList(ArrayList<Product> products) {
        // Print the header for the product list table
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
        System.out.println("| Product ID       | Name                 | RAM          | ROM          | Quantity      | Price                | VGA                  | CPU              | Radiators        | Screen               | Weight             | Chip             |");
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");

        // Iterate through the list of products and print the details of each product
        for (Product product : products) {
            // Initialize product details with default values
            String name = "-";
            String vga = "-";
            String cpu = "-";
            String radiators = "-";
            String screen = "-";
            String weight = "-";
            String chip = "-";

            // Set product details based on product type
            if (product instanceof Desktop) {
                name = "Desktop"; // Set name for Desktop
                vga = ((Desktop) product).getVGA(); // Get VGA details for Desktop
                cpu = ((Desktop) product).getCPU(); // Get CPU details for Desktop
                radiators = ((Desktop) product).getRadiators(); // Get radiators details for Desktop
            } else if (product instanceof Laptop) {
                name = ((Laptop) product).getName(); // Set name for Laptop
                vga = ((Laptop) product).getVGA(); // Get VGA details for Laptop
                cpu = ((Laptop) product).getCPU(); // Get CPU details for Laptop
                screen = String.valueOf(((Laptop) product).getScreen()); // Get screen size for Laptop
                weight = String.valueOf(((Laptop) product).getWeight()); // Get weight for Laptop
            } else if (product instanceof Phone) {
                name = ((Phone) product).getName(); // Set name for Phone
                chip = ((Phone) product).getChip(); // Get chip details for Phone
                screen = String.valueOf(((Phone) product).getScreen()); // Get screen size for Phone
                weight = String.valueOf(((Phone) product).getWeight()); // Get weight for Phone
            }

            // Format the price to include commas and two decimal places
            String price = String.format("%,.2f $", product.getPrice());

            // Print the product details in a formatted table row
            System.out.println(String.format("| %-16s | %-20s | %-10dGB | %-10dGB |    %10d | %20s | %-20s | %-16s | %-16s | %-16sinch | %-16skg | %-16s |",
                    product.getID(), name, product.getRAM(), product.getROM(), product.getQuantity(), price, vga, cpu, radiators, screen, weight, chip));
        }

        // Print the footer for the product list table
        System.out.println("+------------------+----------------------+--------------+--------------+---------------+----------------------+----------------------+------------------+------------------+----------------------+--------------------+------------------+");
    }

    /**
     * Method to populate sample data for the product list. Adds predefined
     * Desktop, Laptop, and Phone products to the listProduct array. Updates the
     * totalProductQuantity based on the quantities of the added products.
     */
    public void populateSampleData() {
        // Add sample Desktop products to the product list
        listProduct.add(new Desktop("D001", 2500.00, 5, 32, 1024, "NVIDIA RTX 3080", "Intel i9", "Liquid Cooling")); // Add Desktop with ID D001
        listProduct.add(new Desktop("D002", 1500.00, 3, 16, 512, "AMD RX 6800", "AMD Ryzen 7", "Air Cooling")); // Add Desktop with ID D002
        listProduct.add(new Desktop("D003", 800.00, 10, 8, 256, "NVIDIA GTX 1660", "Intel i5", "Air Cooling")); // Add Desktop with ID D003
        listProduct.add(new Desktop("D004", 1200.00, 4, 16, 512, "AMD RX 5700", "AMD Ryzen 5", "Liquid Cooling")); // Add Desktop with ID D004

        // Add sample Laptop products to the product list
        listProduct.add(new Laptop("L001", 1200.00, 10, 16, 512, "Intel Iris Xe", "Intel i7", "Dell XPS 15", 15.6, 1.8)); // Add Laptop with ID L001
        listProduct.add(new Laptop("L002", 1800.00, 7, 32, 1024, "Apple Integrated", "Apple M1 Pro", "MacBook Pro 16", 16.0, 2.0)); // Add Laptop with ID L002
        listProduct.add(new Laptop("L003", 1000.00, 12, 8, 256, "Intel UHD Graphics", "Intel i5", "HP Spectre x360", 13.3, 1.3)); // Add Laptop with ID L003
        listProduct.add(new Laptop("L004", 1400.00, 8, 16, 512, "Intel Iris Xe", "Intel i7", "Lenovo ThinkPad X1", 14.0, 1.2)); // Add Laptop with ID L004

        // Add sample Phone products to the product list
        listProduct.add(new Phone("P001", 999.00, 20, "iPhone 13 Pro", "A15 Bionic", 6, 128, 6.1, 0.204)); // Add Phone with ID P001
        listProduct.add(new Phone("P002", 799.00, 15, "Samsung Galaxy S21", "Exynos 2100", 8, 256, 6.2, 0.171)); // Add Phone with ID P002
        listProduct.add(new Phone("P003", 699.00, 25, "Google Pixel 5", "Snapdragon 765G", 8, 128, 6.0, 0.151)); // Add Phone with ID P003
        listProduct.add(new Phone("P004", 499.00, 30, "OnePlus Nord", "Snapdragon 765G", 12, 256, 6.44, 0.184)); // Add Phone with ID P004

        // Update the total product quantity by summing the quantities of all products
        totalProductQuantity = 0; // Initialize total product quantity to zero
        for (Product product : listProduct) {
            totalProductQuantity += product.getQuantity(); // Add each product's quantity to the total
        }
    }
}
