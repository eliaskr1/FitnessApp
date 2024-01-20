package se.nackademin;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String choice;
        label:
        while (true){


            System.out.println('\n' + "*** VÄLKOMMEN TILL FITNESSAPP ***\n");
            System.out.println("1. BMI Calculator");
            System.out.println("2. Macro tracker");
            System.out.println("3. Avsluta programmet\n");
            System.out.print("Ange 1 eller 2 för att använda appens funktioner: ");

            choice = scanner.nextLine();


            if (!choice.isEmpty()) {
                switch (choice) {
                    case "1":
                        BMI.BMIcalc();
                        break;
                    case "2":
                        MatDatabas.macroTrack();
                        break;
                    case "3":
                        break label;
                    default:
                        System.out.println("Vänligen ange giltigt val.");
                        break;
                }
            }

        }
        scanner.close();
    }
}
