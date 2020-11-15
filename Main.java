package bmiCalculator.application;

import java.util.Scanner;

import static java.lang.String.format;


//*************TO DO: Make it into a JavaFX GUI Application*********
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to BMI Calculator!");
        Scanner scanner = new Scanner(System.in);
        double feet = 0;
        //variables for inches and weight that will be used later for user input
        double inches =0;
        double weight = 0;
        boolean hasDouble = false;

        //Checks if the input is a double or if the value entered for feet is 0 or a negative number
        while (!hasDouble || feet <= 0){
            try{ //checks in case of error
                System.out.print("Enter your height:\nFeet: ");
                feet = scanner.nextDouble();
                if (feet <= 0){ //Takes care of 0 input for feet
                    System.out.println("Invalid input. Please try again. ");
                }
                hasDouble=true;
            } catch (Exception err){ //asks for user input if the input is not a double
                System.out.println("Invalid input. Please try again. ");
                scanner.nextLine();
            }
        }

        hasDouble = false;
        //Runs to ensure input is a double
        while (!hasDouble || inches <0) //checks if input is a double or if the inches is negative
        try {
            System.out.print("Inches: ");
            inches = scanner.nextDouble();
            if (inches <0){
                System.out.println("Invalid input. Please try again. ");
            }
            hasDouble=true;
        }   catch (Exception err){  //asks for user input if the input is not a double
            System.out.println("Invalid input. Please try again. ");
            scanner.nextLine();
        }
        hasDouble = false;

        //Runs to ensure weight entered is a double
        while (!hasDouble || weight <= 0){
            try{
                System.out.print("Enter your weight (in lbs): ");
                weight = scanner.nextDouble();
                if (weight <= 0){ //Takes care of 0 weight
                    System.out.println("Invalid input. Please try again. ");
                }
                hasDouble=true;
            } catch (Exception err){
                System.out.println("Invalid input. Please try again. ");
                scanner.nextLine();
            }
        }


        double weight_in_kg = weight * 0.454; //converts weight from lbs to kg


        System.out.println("\nWeight entered is: "+ String.format("%.2f", weight) +"lbs.");
        System.out.println("Equivalent weight in kg is: " + String.format("%.2f",weight_in_kg) +"kg.");

        //Converts height to meters by converting height to inches first
        double height_in_m = ((inches) + (feet*12)) * 0.0254;
        System.out.println("Equivalent height in m is: " + String.format("%.2f", height_in_m) + "m.");

        //Calculates and displays BMI
        double bmi = (weight_in_kg) / (height_in_m*height_in_m);// BMI = kg/m^2
        System.out.println("Your BMI is " + String.format("%.2f",bmi) +".");



    }
}

