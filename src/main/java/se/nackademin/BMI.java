package se.nackademin;

import java.util.Optional;

//import static se.nackademin.BMI_utils.*;

public class BMI {


    public static void BMIcalc() {
        double weight = BMI_utils.getValidNumericInput(Optional.empty(), "Hur mycket väger du (i kg)?: ");
        double heightInCentimeters = BMI_utils.getValidNumericInput(Optional.empty(), "Hur lång är du (i cm)?: ");

        double heightInMeters = heightInCentimeters / 100.0;

        int bmi = (int) BMI_utils.calculateBMI(weight, heightInMeters);
        System.out.println('\n' + "Ditt BMI är: " + bmi);

        char gender = BMI_utils.getValidGenderInput(Optional.empty());
        int age = BMI_utils.getValidIntegerInput(Optional.empty(), "Ange din ålder: ");

        int activityLevel = BMI_utils.getValidActivityLevelInput();

        int suggestedCaloricIntake = BMI_utils.suggestCaloricIntake(gender, age, weight, heightInMeters, activityLevel);
        System.out.println('\n' + "Baserat på din basalmetabolism, aktivitetsnivå och ålder är den rekommenderade kaloriintaget/dag: " + suggestedCaloricIntake + " kal"+'\n');

        int goal = BMI_utils.getValidGoalInput();

        if (goal == 1) { //Behålla intag
            System.out.println("Ditt dagliga intag för att behålla din vikt är: " + suggestedCaloricIntake);
        } else if (goal == 2) { //Öka intag
            int caloriesForGain = suggestedCaloricIntake + 300;
            System.out.println("Ditt dagliga kaloriintag för att öka i vikt: " + caloriesForGain);

        } else if (goal == 3) { //Minska intag
     
            double kgAttGåNer = BMI_utils.getValidNumericInput(Optional.empty(), "Ange hur många kilo du vill gå ner: ");
            int kalorierAttMinska = BMI_utils.antalerKalorierTillDatum(kgAttGåNer);

            int totalaMängdenKalorierMinskning = suggestedCaloricIntake - kalorierAttMinska;

            System.out.println("Antal kalorier att minska: " + kalorierAttMinska + " Kalorier"
            + "\n Din totala mängd kalorier blir " + totalaMängdenKalorierMinskning);

        }
        System.out.println("Tryck på enter för att fortsätta...");
        Main.scanner.nextLine();
    }
}