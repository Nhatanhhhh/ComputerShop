/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computershop;

import java.util.Scanner;

/**
 * The CheckData class provide check input method.
 * 
 * @author Group 4 - Assignment
 */
public class CheckData {

    //Scanner for getting the user's input data from the keyboard.
    static Scanner sc = new Scanner(System.in);

    /**
     * Get the integer number with error handling. This number must be in the
     * specific range.
     *
     * @param iMgs The message prompts the users to enter a integer number.
     * @param eMgs The message prompts the users about the error if the input is
     * not a valid integer.
     * @param min The min value of the integer number.
     * @param max The max value of the integer number.
     * @return The entered integer number value which in the specific range.
     */
    public static int getInteger(String iMgs, String eMgs, int min, int max) {
        //Create a while loop to make sure the users can enter the data until it is valid.
        while (true) {
            try {
                //Prompt the user to enter a integer number.
                System.out.print(iMgs);
                //Read the user input and convert it to a integer number.
                int n = Integer.parseInt(sc.nextLine());
                //Check if the input data is in the specific range.
                if (n < min || n > max) {
                    //Throw exception if the integer number is not in the specific range.
                    throw new Exception();
                }
                //Return the valid integer number.
                return n;
            } catch (Exception e) {
                //Handle the exception if the input is not a integer number.
                System.out.println(eMgs + ", can not be empty!");
            }
        }
    }



    /**
     * Get the integer number with error handling. This number must be greater
     * than or equal specific number.
     *
     * @param iMgs The message prompts the users to enter a integer number.
     * @param eMgs The message prompts the users about the error if the input is
     * not a valid integer.
     * @param min The min value of the integer number.
     * @return The entered integer number value which satisfy the condition.
     */
    public static int getInteger1(String iMgs, String eMgs, int min) {
        //Create a while loop to make sure the users can enter the data until it is valid.
        while (true) {
            try {
                //Prompt the user to enter a integer number.
                System.out.print(iMgs);
                //Read the user input and convert it to a integer number.
                int n = Integer.parseInt(sc.nextLine());
                //Check if the input data is smaller than the specific number.
                if (n < min) {
                    //Throw exception if the integer number is smaller than the specific number.
                    throw new Exception();
                }
                //Return the valid integer number.
                return n;
            } catch (Exception e) {
                //Handle the exception if the input is not a integer number.
                System.out.println(eMgs + ", can not be empty!");
            }
        }
    }

    

    /**
     * Gets a non-empty string from the user input with error handling.
     *
     * @param iMsg The message prompts the users to enter a string.
     * @param eMgs The message prompts the users about the error if the input is
     * not a valid string.
     * @return The entered non-empty string.
     */
    public static String getString(String iMsg, String eMgs) {
        //Create a while loop to make sure the users can enter the data until it is valid.
        while (true) {
            //Use to catch the exception.
            try {
                //Prompt the user to enter a string.
                System.out.print(iMsg);
                //Read the user input and convert it to a string.
                String in = sc.nextLine().trim();
                //Check if the input is empty.
                if (in.isEmpty()) {
                    //Throw exception if the string is empty.
                    throw new Exception();
                }
                //Return the valid string.
                return in;
            } catch (Exception e) {
                //Handle the exception if the input is not a valid string.
                System.out.println(eMgs);
            }
        }
    }

    /**
     * Gets a non-empty input from the user input with error handling. This
     * method uses to make sure the input data satisfy the format of the real
     * number in the specific range.
     *
     * @param iMsg The message prompts the users to enter a real number.
     * @param eMgs The message prompts the users about the error if the input is
     * not a valid real number in the range.
     * @param min The min value of real number.
     * @param max The max value of real number.
     * @return The entered real number value in the specific range.
     */
    public static double getDouble(String iMsg, String eMgs, double min, double max) {
        //Create a while loop to make sure the users can enter the data until it is valid.
        while (true) {
            //Use to catch the exception.
            try {
                //Prompt the user to enter a real number.
                System.out.print(iMsg);
                //Read the user input and convert it to a string.
                String num1 = sc.nextLine().trim();
                //Check if the input is empty.
                if ("".equals(num1)) {
                    //Throw exception if the string is empty.
                    throw new Exception();
                }
                //Convert string in variable 'num1' to a real number.
                double num = Double.parseDouble(num1);
                //Check if the real number is in the range.
                if (num < min || num > max) {
                    //Throw exception if the real number is not in the range.
                    throw new Exception();
                }
                //Return the valid real number value in the range.
                return num;
            } catch (Exception e) {
                //Handle the exception if the input is not a valid real number in the range.
                System.out.println(eMgs + ", can not be empty!");
            }
        }
    }

    /**
     * Gets a non-empty input from the user input with error handling. This
     * method uses to make sure the input data satisfy the format of the real
     * number.
     *
     * @param iMsg The message prompts the users to enter a real number.
     * @param eMgs The message prompts the users about the error if the input is
     * not a valid real number.
     * @return The entered real number value.
     */
    public static double getDouble1(String iMsg, String eMgs) {
        //Create a while loop to make sure the users can enter the data until it is valid.
        while (true) {
            //Use to catch the exception.
            try {
                //Prompt the user to enter a real number.
                System.out.println(iMsg);
                //Read the user input and convert it to a string.
                String num1 = sc.nextLine().trim();
                //Check if the input is empty.
                if ("".equals(num1)) {
                    //Throw exception if the string is empty.
                    throw new Exception("Your input can not be empty!");
                }
                //Convert string in variable 'num1' to a real number.
                double num = Double.parseDouble(num1);
                //Check if the real number is greater than zero.
                if (num <= 0) {
                    //Throw exception if the real number is less than or equal zero.
                    throw new Exception("Your input must be greater than zero!");
                }
                //Return the valid real number value.
                return num;
            } catch (NumberFormatException e) {
                //Handle the exception if the input is not a valid real number.
                System.out.println(eMgs);
            } catch (Exception e) {
                //Handle the exception if the input is not a valid real number.
                System.out.println(e.getMessage());
            }
        }
    }
}
