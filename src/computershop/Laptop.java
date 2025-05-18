/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; // Define the package name

/**
 * The Laptop class represents a specific type of computer, a laptop. It extends
 * the Computer class by adding additional attributes such as Name, Screen size,
 * and Weight. This class provides constructors to initialize laptop objects and
 * getter and setter methods for the additional attributes.
 *
 * @author Group 4 - Assignment
 */
public class Laptop extends Computer {

    private String Name; // Variable to store the name of the laptop
    private double Screen; // Variable to store the screen size of the laptop
    private double Weight; // Variable to store the weight of the laptop

    /**
     * Constructor to initialize a Laptop object with all attributes.
     *
     * @param ID The ID of the laptop
     * @param Price The price of the laptop
     * @param Quantity The quantity of the laptop
     * @param RAM The RAM size of the laptop
     * @param ROM The ROM size of the laptop
     * @param VGA The VGA information of the laptop
     * @param CPU The CPU information of the laptop
     * @param Name The name of the laptop
     * @param Screen The screen size of the laptop
     * @param Weight The weight of the laptop
     */
    public Laptop(String ID, double Price, int Quantity, int RAM, int ROM, String VGA, String CPU, String Name, double Screen, double Weight) {
        super(ID, Price, Quantity, RAM, ROM, VGA, CPU); // Call the constructor of the superclass Computer
        this.Name = Name; // Initialize the Name attribute
        this.Screen = Screen; // Initialize the Screen attribute
        this.Weight = Weight; // Initialize the Weight attribute
    }

    /**
     * Getter method to get the screen size of the laptop.
     *
     * @return The screen size
     */
    public double getScreen() {
        return Screen;
    }

    /**
     * Setter method to set the screen size of the laptop.
     *
     * @param Screen The screen size to set
     */
    public void setScreen(double Screen) {
        this.Screen = Screen;
    }

    /**
     * Getter method to get the weight of the laptop.
     *
     * @return The weight
     */
    public double getWeight() {
        return Weight;
    }

    /**
     * Getter method to get the name of the laptop.
     *
     * @return The name
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter method to set the name of the laptop.
     *
     * @param Name The name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Setter method to set the weight of the laptop.
     *
     * @param Weight The weight to set
     */
    public void setWeight(double Weight) {
        this.Weight = Weight;
    }

}
