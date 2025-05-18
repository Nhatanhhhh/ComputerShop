/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; // Define the package name

/**
 * The Product class is an abstract base class for different types of products
 * in the computer shop. It defines common attributes such as ID, Price,
 * Quantity, RAM, and ROM, and provides constructors and getter/setter methods
 * for these attributes.
 *
 * @author Group 4 - Assignment
 */
public abstract class Product {

    protected String ID; // Variable to store the ID of the product
    protected double Price; // Variable to store the price of the product
    protected int Quantity; // Variable to store the quantity of the product
    protected int RAM; // Variable to store the RAM size of the product
    protected int ROM; // Variable to store the ROM size of the product

    /**
     * Default constructor for the Product class.
     */
    public Product() {
    }

    /**
     * Constructor to initialize a Product object with all attributes.
     *
     * @param ID The ID of the product
     * @param Price The price of the product
     * @param Quantity The quantity of the product
     * @param RAM The RAM size of the product
     * @param ROM The ROM size of the product
     */
    public Product(String ID, double Price, int Quantity, int RAM, int ROM) {
        this.ID = ID; // Initialize the ID attribute
        this.Price = Price; // Initialize the Price attribute
        this.Quantity = Quantity; // Initialize the Quantity attribute
        this.RAM = RAM; // Initialize the RAM attribute
        this.ROM = ROM; // Initialize the ROM attribute
    }

    /**
     * Getter method to get the ID of the product.
     *
     * @return The ID of the product
     */
    public String getID() {
        return ID;
    }

    /**
     * Setter method to set the ID of the product.
     *
     * @param ID The ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Getter method to get the RAM size of the product.
     *
     * @return The RAM size of the product
     */
    public int getRAM() {
        return RAM;
    }

    /**
     * Setter method to set the RAM size of the product.
     *
     * @param RAM The RAM size to set
     */
    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    /**
     * Getter method to get the ROM size of the product.
     *
     * @return The ROM size of the product
     */
    public int getROM() {
        return ROM;
    }

    /**
     * Setter method to set the ROM size of the product.
     *
     * @param ROM The ROM size to set
     */
    public void setROM(int ROM) {
        this.ROM = ROM;
    }

    /**
     * Getter method to get the price of the product.
     *
     * @return The price of the product
     */
    public double getPrice() {
        return Price;
    }

    /**
     * Setter method to set the price of the product.
     *
     * @param Price The price to set
     */
    public void setPrice(double Price) {
        this.Price = Price;
    }

    /**
     * Getter method to get the quantity of the product.
     *
     * @return The quantity of the product
     */
    public int getQuantity() {
        return Quantity;
    }

    /**
     * Setter method to set the quantity of the product.
     *
     * @param Quantity The quantity to set
     */
    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }
}
