package org.example;

import java.util.Scanner;

public class Main {
    private static int totalArea;

    public static void main(String[] args) {
            int wallsInput = 0;
            int wallLength = 0;
            int wallHeight = 0;
            int coats = 0;

            System.out.println("Hello, this program will ask you questions about your current painting job and will tell you how much it will cost and how much paint you will need.");
            System.out.println("The cost of each size tin of paint is taken from the Dulux website and used for calculating the cost.");

            Scanner reader = new Scanner(System.in);
            boolean checking = true, valid = true;

            while (checking) {
                System.out.println("Please enter how many walls you are painting, including ceilings as a wall.");
                wallsInput = reader.nextInt();
                System.out.println("You are painting " + wallsInput + " walls, is this correct?");
                System.out.println("Enter Y/N");
                while (valid) {
                    String correct = reader.next();
                    if (correct.equals("n") || correct.equals("N")) {
                        valid = false;
                        System.out.println("Please try again");
                    } else if (correct.equals("y") || correct.equals(("Y"))) {
                        checking = false;
                        valid = false;
                    } else {
                        System.out.println("Please try again");
                    }
                }
            }

            System.out.println("In millimetres, please enter the measurements, of the walls and ceilings you are painting.");

            int c = 0;

            while (c < wallsInput) {
                System.out.println("For wall " + ++c + " please enter the height");
                wallHeight = reader.nextInt();
                System.out.println("For wall " + c + " please enter the length");
                wallLength = reader.nextInt();
                System.out.println("How many coats of paint will you be applying?");
                coats = reader.nextInt();
                for (int i = 0; i < wallsInput; i++) {
                    totalArea += calcArea(wallHeight, wallLength, coats);
                }
            }

            System.out.println("The total area of the job is: " + totalArea + " metres squared with all coats of paint for each wall included.");

            System.out.format("This job will require %.0f tins of 5L paint.", calcPaintTins(totalArea));
            System.out.format("/nThis job will cost you £%.2f.", calcPaintCost(calcPaintTins(totalArea)));
        }
        //total area
        static double calcPaintCost(double x) {
            double paint5L = 62.16;
            double paintCost = x * paint5L;

            return paintCost;
        }

        static double calcPaintTins(double x) {
            double paintTins = x / 65;
            Math.round(paintTins);
            return paintTins;
        }

        static double calcArea(int x, int y, int c) {
            double area = (x * y) * c;
            area = area / 1000;
            return area;
        }
}