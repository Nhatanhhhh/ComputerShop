/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop; // Define the package name

/**
 * The Desktop class represents a specific type of computer, a desktop. It
 * extends the Computer class by adding an additional attribute, Radiators,
 * which is specific to desktops. This class provides constructors to initialize
 * desktop objects and getter and setter methods for the Radiators attribute.
 *
 * @author Group 4 - Assignment
 */
public class Desktop extends Computer {

    private String Radiators; // Variable to store the radiator type of the desktop

    /**
     * Constructor to initialize a Desktop object with all attributes, including
     * radiators.
     *
     * @param ID The ID of the desktop
     * @param Price The price of the desktop
     * @param Quantity The quantity of the desktop
     * @param RAM The RAM size of the desktop
     * @param ROM The ROM size of the desktop
     * @param VGA The VGA information of the desktop
     * @param CPU The CPU information of the desktop
     * @param Radiators The radiator type of the desktop
     *
     */
    public Desktop(String ID, double Price, int Quantity, int RAM, int ROM, String VGA, String CPU, String Radiators) {
        super(ID, Price, Quantity, RAM, ROM, VGA, CPU); // Call the constructor of the superclass Computer
        this.Radiators = Radiators; // Initialize the Radiators attribute
    }

    /**
     * Getter method to get the radiator type of the desktop.
     *
     * @return The radiator type
     */
    public String getRadiators() {
        return Radiators;
    }

    /**
     * Setter method to set the radiator type of the desktop.
     *
     * @param Radiators The radiator type to set
     */
    public void setRadiators(String Radiators) {
        this.Radiators = Radiators;
    }

}
