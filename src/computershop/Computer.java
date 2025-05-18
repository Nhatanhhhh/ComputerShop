/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; 

/**
 * The Computer class is an abstract class that extends the Product class. It
 * represents a generic computer with additional attributes such as VGA and CPU.
 * This class serves as a base class for more specific types of computers like
 * Desktop and Laptop.
 *
 * @author Group 4 - Assignment
 */
public abstract class Computer extends Product {

    protected String VGA; // Variable to store the VGA information of the computer
    protected String CPU; // Variable to store the CPU information of the computer

    /**
     * Constructor to initialize the Computer object with specified attributes.
     *
     * @param ID The ID of the computer
     * @param Price The price of the computer
     * @param Quantity The quantity of the computer
     * @param RAM The RAM size of the computer
     * @param ROM The ROM size of the computer
     * @param VGA The VGA information of the computer
     * @param CPU The CPU information of the computer
     */
    public Computer(String ID, double Price, int Quantity, int RAM, int ROM, String VGA, String CPU) {
        super(ID, Price, Quantity, RAM, ROM); // Call the constructor of the superclass Product
        this.VGA = VGA; // Initialize the VGA attribute
        this.CPU = CPU; // Initialize the CPU attribute
    }

    /**
     * Getter method to get the VGA information of the computer.
     *
     * @return The VGA information
     */
    public String getVGA() {
        return VGA;
    }

    /**
     * Setter method to set the VGA information of the computer.
     *
     * @param VGA The VGA information to set
     */
    public void setVGA(String VGA) {
        this.VGA = VGA;
    }

    /**
     * Getter method to get the CPU information of the computer.
     *
     * @return The CPU information
     */
    public String getCPU() {
        return CPU;
    }

    /**
     * Setter method to set the CPU information of the computer.
     *
     * @param CPU The CPU information to set
     */
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

}
