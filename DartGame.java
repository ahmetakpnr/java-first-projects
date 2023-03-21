/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dartgame;

import java.util.Scanner;

/**
 *
 * @author aakpi
 */
public class DartGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("DART GAME!");
        System.out.println("Enter the number of darts to be thrown: ");
        int numberOfDarts = scn.nextInt();
        int count = 0;
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countE = 0;
        int countF = 0;
        int countG = 0;
        int countU = 0;
        double pa = 0;
        double pb = 0;
        double pc = 0;
        double pd = 0;
        double pe = 0;
        double pf = 0;
        double pg = 0;
        double pu = 0;
        int nod = 1;
        while (count < numberOfDarts) {
            double x = (double) (int) (((Math.random() * 10) + (-5)) * 10) / 10;
            double y = (double) (int) (((Math.random() * 10) + (-5)) * 10) / 10;
            if (x > 0 && y > 0 && x + y < 5) {
                countA++;
                pa = (double) (100 * countA) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " A\n");

            } else if (x > 0 && y > 0 && x + y > 5) {
                countB++;
                pb = (double) (100 * countB) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " B\n");
            } else if (x < 0 && y < 0 && x < y) {
                countD++;
                pd = (double) (100 * countD) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " D\n");
            } else if (x < 0 && y < 0 && x > y) {
                countE++;
                pe = (double) (100 * countE) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " E\n");
            } else if (x > 0 && y < 0) {
                countF++;
                pf = (double) (100 * countF) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " F\n");
            } else if (x < 0 && y > 0) {
                if (Math.sqrt(Math.pow((x + 3), 2) + Math.pow((y - 3), 2)) <= 1) {
                    countC++;
                    pc = (double) (100 * countC) / numberOfDarts;
                    System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                            + " C\n");
                } else {
                    countG++;
                    pg = (double) (100 * countG) / numberOfDarts;
                    System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                            + " G\n");
                }
            } else {
                countU++;
                pu = (double) (100 * countU) / numberOfDarts;
                System.out.println("Dart " + nod + ":\n" + "Coordinates: " + "(" + x + ", " + y + ")" + "\nRegion:"
                        + " Undecided\n");
            }

            count++;
            nod++;
        }

        System.out.println("Region statistics: ");
        if (countA > 1) {
            System.out.println("A: " + countA + " darts" + "(" + pa + "%" + ")");
        } else {
            System.out.println("A: " + countA + " dart" + "(" + pa + "%" + ")");
        }
        if (countB > 1) {
            System.out.println("B: " + countB + " darts" + "(" + pb + "%" + ")");
        } else {
            System.out.println("B: " + countB + " dart" + "(" + pb + "%" + ")");
        }
        if (countC > 1) {
            System.out.println("C: " + countC + " darts" + "(" + pc + "%" + ")");
        } else {
            System.out.println("C: " + countC + " dart" + "(" + pc + "%" + ")");
        }
        if (countD > 1) {
            System.out.println("D: " + countD + " darts" + "(" + pd + "%" + ")");
        } else {
            System.out.println("D: " + countD + " dart" + "(" + pd + "%" + ")");
        }
        if (countE > 1) {
            System.out.println("E: " + countE + " darts" + "(" + pe + "%" + ")");
        } else {
            System.out.println("E: " + countE + " dart" + "(" + pe + "%" + ")");
        }
        if (countF > 1) {
            System.out.println("F: " + countF + " darts" + "(" + pf + "%" + ")");
        } else {
            System.out.println("F: " + countF + " dart" + "(" + pf + "%" + ")");
        }
        if (countG > 1) {
            System.out.println("G: " + countG + " darts" + "(" + pg + "%" + ")");
        } else {
            System.out.println("G: " + countG + " dart" + "(" + pg + "%" + ")");
        }
        if (countU > 1) {
            System.out.println("Undecided: " + countU + " darts" + "(" + pu + "%" + ")");
        } else {
            System.out.println("Undecided: " + countU + " dart" + "(" + pu + "%" + ")");
        }

    }

}
