/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_3;

import com.sun.jndi.url.iiop.iiopURLContext;
import java.util.Scanner;

/**
 *
 * @author aakpi
 */
public class Project_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the size of compAlien population: ");
        int num = scn.nextInt();
        System.out.println("Simulating compAlien species…");

        String[] population = createPopulation(num);
        printPopulation(population);
        System.out.println("compAlien population is generated!");
        System.out.println("");
        boolean flag = true;

        while (flag) {
            printMenu();
            System.out.print("Enter an option: ");
            int choice = scn.nextInt();
            System.out.println("");

            if (choice == 1) {
                System.out.println("Mating two compAliens");
                System.out.println("---------------------");

                System.out.print("Enter ID of first compAlien: ");
                int id1 = scn.nextInt() - 1;
                System.out.print("Enter ID of second compAlien: ");
                int id2 = scn.nextInt() - 1;
                population = reproduce(population, id1, id2);

            } else if (choice == 2) {
                System.out.println("Simulating Random compAlien Reproduction");
                System.out.println("----------------------------------------");

                System.out.print("Enter number of compAlien pairs to reproduce: ");
                int numPairs = scn.nextInt();
                population = multipleMating(numPairs, population.length, population);

            } else if (choice == 3) {
                System.out.println("compAlien Population Statistics");
                System.out.println("-------------------------------");
                printStatitics(population);

            } else if (choice == 4) {
                System.out.println("0 Health compAliens are dying");
                System.out.println("-----------------------------");
                population = death(population);

            } else if (choice == 5) {
                System.out.println("Mutating compAlien");
                System.out.println("------------------");

                System.out.print("Enter ID of the compAlien you want to mutate: ");
                int idToMutate = scn.nextInt();
                population = mutation(idToMutate, population);

            } else if (choice == 6) {
                System.out.println("Ending the session..");
                System.out.println("--------------------");
                flag = false;

            }
        }
    }

    public static int findHealth(String genetic) {
        int health = 0;
        for (int i = 0; i < 126; i++) {
            if (genetic.charAt(i) == 'C') {
                if (genetic.charAt(i + 1) == 'S' && genetic.charAt(i + 2) == 'E') {
                    health++;
                }
            }
        }
        return health;
    }

    public static String findGender(String genetic) {
        String gender = "";
        if (genetic.charAt(genetic.length() - 1) == 'S') {
            gender = "Male";
        } else {
            gender = "Female";
        }
        return gender;
    }

    public static String createAlien() {
        String[] chars = {"C", "S", "E"};

        String genetic = "";
        for (int i = 0; i < 128; i++) {
            int n = (int) (Math.random() * 3);
            genetic += chars[n];
        }
        return genetic;
    }

    public static String[] createPopulation(int size) {
        String[] genetics = new String[size];

        for (int i = 0; i < size; i++) {
            String genetic = createAlien();
            genetics[i] = genetic;
        }
        return genetics;
    }

    public static String[] reproduce(String[] genetics, int id1, int id2) {
        double N = 15;
        double health1 = findHealth(genetics[id1]);
        double health2 = findHealth(genetics[id2]);
        String gender1 = findGender(genetics[id1]);
        String gender2 = findGender(genetics[id2]);
        boolean flag = false;

        if (gender1.equals(gender2)) {
            System.out.println("no mate");
        } else {
            double offspringChance = (double) ((health1 + health2) / N);
            if (Math.random() < offspringChance) {
                flag = true;
                genetics = addAlien(genetics, createAlien());
            }
            printMethod(id1, id2, gender1, gender2, offspringChance, flag);
        }
        return genetics;
    }

    public static String[] addAlien(String[] population, String newAlien) {
        String[] newPopulation = new String[population.length + 1];
        System.arraycopy(population, 0, newPopulation, 0, population.length);
        newPopulation[population.length] = newAlien;

        return newPopulation;
    }

    public static void printMethod(int id1, int id2, String gender1, String gender2, double offspringChance, boolean flag) {
        if (flag) {

            System.out.println("compAlien " + id1 + "(" + gender1.charAt(0) + ") and " + id2
                    + "(" + gender2.charAt(0) + ") Mate: Offspring chance " + (int) (offspringChance * 100)
                    + "%. They have 1 offspring :)");
        } else {
            System.out.println("compAlien " + (id1 + 1) + "(" + gender1.charAt(0) + ") and " + (id2 + 1)
                    + "(" + gender2.charAt(0) + ") Mate: Offspring chance " + (int) (offspringChance * 100)
                    + "%. no offspring :(");
        }
    }

    public static String[] multipleMating(int num, int size, String[] genetics) {
        System.out.println("Number of compAlien pairs to reproduce: " + num);
        for (int i = 0; i < num; i++) {
            int n1 = (int) (Math.random() * size);
            int n2 = (int) (Math.random() * size);
            while (n1 == n2) {
                n2 = (int) (Math.random() * size);
            }
            genetics = reproduce(genetics, n1, n2);
        }
        return genetics;
    }

    public static void printStatitics(String[] population) {
        double numOfMale = 0;
        double numOfFemale = 0;
        double t = 0;
        int max = findHealth(population[0]);
        double average = 0;
        System.out.print("Enter a health threshold : ");
        Scanner scn = new Scanner(System.in);
        int threshold = scn.nextInt();

        for (int i = 0; i < population.length; i++) {
            if ("Female".equals(findGender(population[i]))) {
                numOfFemale++;
            } else {
                numOfMale++;
            }
            if (findHealth(population[i]) > threshold) {
                t++;
            }
            if (findHealth(population[i]) > max) {
                max = findHealth(population[i]);
            }
            average += findHealth(population[i]) / (double) population.length;
        }
        System.out.println("Population size: " + population.length + "\nFEMALE population = " + (int) ((numOfFemale / population.length) * 100) + "% \n"
                + "MALE population " + (int) ((numOfMale / population.length) * 100) + "% \n"
                + (int) ((t / population.length) * 100) + "% population have a health of " + threshold + " or higher." + " \n"
                + "Greatest health in the population " + max + " \n"
                + "Average health of population: " + Math.round(average * 100.0) / 100.0);
    }

    public static String[] death(String[] population) {
        int count = 0;
        for (int i = 0; i < population.length; i++) {
            if (findHealth(population[i]) == 0) {
                population = delete(population, i);
                count++;
            }
        }
        System.out.println(count + " number of aliens have 0 health and died");
        return population;
    }

    public static String[] delete(String[] population, int index) {
        String[] toBeAdd = new String[population.length - 1];
        for (int i = 0; i < index; i++) {
            toBeAdd[i] = population[i];
        }
        for (int j = index; j < population.length - 1; j++) {
            toBeAdd[j] = population[j + 1];
        }
        return toBeAdd;
    }

    public static String[] mutation(int id, String[] population) {
        id = id - 1;
        if (id > population.length - 1) {
            System.out.println("Id can't be greater than the population size!");
            return population;
        }
        String alien = population[id];
        System.out.println("Before mutation: Health: " + findHealth(alien) + " Gender: " + findGender(alien));
        alien = createAlien();
        System.out.println("After mutation: Health: " + findHealth(alien) + " Gender: " + findGender(alien));
        population[id] = alien;
        id = id + 1;
        System.out.println("compAlien " + id + " has mutated. ");
        return population;
    }

    public static void printMenu() {
        System.out.println("Choose an option:\n"
                + "(1)Mate two compAliens\n"
                + "(2)Randomly mate a set of compAliens\n"
                + "(3)Show statistics\n"
                + "(4)Clear population from death(0 health) compAliens\n"
                + "(5)Mutate a compAlien\n"
                + "(6)Quit!");
    }

    public static void printPopulation(String[] population) {
        System.out.println("----------------------------------");
        for (int i = 0; i < population.length; i++) {
            String genetic = population[i];
            int health = findHealth(genetic);
            String gender = findGender(genetic);
            int tmp = i + 1;
            System.out.println("ID:" + tmp + ", " + gender + ", Health: " + health);
        }
        System.out.println("----------------------------------");
    }
}
