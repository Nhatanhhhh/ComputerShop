/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; // Define the package name

/**
 * The Phone class represents a specific type of product, a phone. It extends
 * the Product class by adding additional attributes such as Name, Chip, screen
 * size, and weight. This class provides constructors to initialize phone
 * objects and getter and setter methods for the additional attributes.
 *
 * @author Group 4 - Assignment
 */
public class Phone extends Product {

    private String Name; // Variable to store the name of the phone
    private String Chip; // Variable to store the chip type of the phone
    private double screen; // Variable to store the screen size of the phone
    private double weight; // Variable to store the weight of the phone

    /**
     * Constructor to initialize a Phone object with all attributes.
     *
     * @param ID The ID of the phone
     * @param price The price of the phone
     * @param quantity The quantity of the phone
     * @param Name The name of the phone
     * @param Chip The chip type of the phone
     * @param RAM The RAM size of the phone
     * @param ROM The ROM size of the phone
     * @param screen The screen size of the phone
     * @param weight The weight of the phone
     */
    public Phone(String ID, double price, int quantity, String Name, String Chip, int RAM, int ROM, double screen, double weight) {
        super(ID, price, quantity, RAM, ROM); // Call the constructor of the superclass Product
        this.Name = Name; // Initialize the Name attribute
        this.Chip = Chip; // Initialize the Chip attribute
        this.screen = screen; // Initialize the screen attribute
        this.weight = weight; // Initialize the weight attribute
    }

    /**
     * Getter method to get the name of the phone.
     *
     * @return The name of the phone
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter method to set the name of the phone.
     *
     * @param Name The name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Getter method to get the chip type of the phone.
     *
     * @return The chip type of the phone
     */
    public String getChip() {
        return Chip;
    }

    /**
     * Setter method to set the chip type of the phone.
     *
     * @param Chip The chip type to set
     */
    public void setChip(String Chip) {
        this.Chip = Chip;
    }

    /**
     * Getter method to get the screen size of the phone.
     *
     * @return The screen size of the phone
     */
    public double getScreen() {
        return screen;
    }

    /**
     * Setter method to set the screen size of the phone.
     *
     * @param screen The screen size to set
     */
    public void setScreen(double screen) {
        this.screen = screen;
    }

    /**
     * Getter method to get the weight of the phone.
     *
     * @return The weight of the phone
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Setter method to set the weight of the phone.
     *
     * @param weight The weight to set
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
