package se.nackademin;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

/**
 * En klass som räknar ut BMI
 */
public class BMI_utils {
      /**
     * En metod som räknar ut BMI med hjälp av en matematisk formel.
     * @param weight
     * @param height
     * @return
     */
    public static double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

     /**
     * Kollar om det är en med eller Kvinna med hjälp av en användarinput
     * @param testInput
     * @return valet av kön
     */
    static char getValidGenderInput(Optional<String> testInput) {
        char gender = ' ';
        boolean validInput = false;

        while (!validInput) {
            System.out.print('\n' + "M  = Man" +'\n' + "K = Kvinna" + '\n' + "Ange ditt kön (M/K)/ : ");

            String input;
            input = testInput.map(String::toUpperCase).orElseGet(() -> Main.scanner.nextLine().toUpperCase());

            if (input.equals("M") || input.equals("K")) {
                gender = input.charAt(0);
                validInput = true;
            } else {
                System.out.println("Ogiltig köninmatning. Ange endast 'M' eller 'K'.");
            }
        }

        return gender;
    }

       /**
     * En användarinput där man får skriva ett heltal.
     * @param testInput
     * @param message
     * @return
     */
    static int getValidIntegerInput(Optional<String> testInput, String message) {
        int value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                if (testInput.isPresent()) {
                    value = Integer.parseInt(testInput.get());
                    validInput = true;
                } else {
                    System.out.print(message);
                    value = Integer.parseInt(Main.scanner.nextLine());
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt val, vänligen välj en giltig siffra.");
            }
        }


        return value;
    }
    /**
     * En användarinput som ber om ett numeriskt värde.
     * @param testInput
     * @param message
     * @return
     */
    static double getValidNumericInput(Optional<String> testInput, String message) {
        double value = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                if (testInput.isPresent()){
                    value = Double.parseDouble(testInput.get());
                    validInput = true;
                } else {
                    System.out.print(message);
                    value = Double.parseDouble(Main.scanner.nextLine());
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt val, vänligen välj en giltig siffra.");
            }
        }

        return value;
    }

    /**
     * Frågar om dina mål.
     * @return
     */
    static int getValidGoalInput() {
        int goal = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print("1. Behålla" + '\n' + "2. Öka" + '\n' + "3. Minska" + '\n' + "Vad är ditt mål med din vikt? ");
            goal = getValidIntegerInput(Optional.empty(), "");
            if (goal == 1 || goal == 2 || goal == 3) {
                validInput = true;
            } else {
                System.out.println("Ogiltigt val, vänligen välj bland tillgängliga val.");
            }
        }
        return goal;
    }

    /**
     * Frågar om aktivitetsnivå
     * @return
     */
    static int getValidActivityLevelInput() {
        int activityLevel;
        boolean validInput = false;
        do {
            System.out.print('\n' + "1. Stillasittande" + '\n' + "2. Lätt" + '\n' + "3. Måttlig" + '\n' + "4. Tung" + '\n' + "Vad är din aktivitetsnivå? ");
            activityLevel = getValidIntegerInput(Optional.empty(), "");
            if (activityLevel == 1 || activityLevel == 2 || activityLevel == 3 || activityLevel == 4) {
                validInput = true;
            } else {
                System.out.println("Ogiltigt val, vänligen välj bland tillgängliga val:");
            }
        } while (!validInput);
        return activityLevel;
    }

    /**
     * Räknar ut vilken kalorimängd du bör äta.
     * @param gender
     * @param age
     * @param weight
     * @param height
     * @param activityLevel
     * @return
     */
    static int suggestCaloricIntake(char gender, int age, double weight, double height, int activityLevel) {
        int suggestedCaloricIntake;
        double bmr; //Basal Metabolic Rate, antal kalorier/dag som kroppen behöver.
        if (gender == 'M') {
            bmr = 88.362 + (13.397 * weight) + (4.799 * height * 100) - (5.677 * age);
        } else {
            bmr = 447.593 + (9.247 * weight) + (3.098 * height * 100) - (4.330 * age);
        }

        double tdee; //Total Daily Energy Expenditure, antal kalorier per dag som kroppen förbrukar.

        switch (activityLevel) {
            case 1: //stillasittande
                tdee = bmr * 1.2;
                break;
            case 2: //lätt
                tdee = bmr * 1.375;
                break;
            case 3: //måttlig
                tdee = bmr * 1.55;
                break;
            case 4: //tung
                tdee = bmr * 1.725;
                break;
            default: //Ogiltig inmatning som exempelvis negativa tal eller strängar
                tdee = bmr;
                System.out.println("Ogiltig aktivitetsnivå. Utgår ifrån stillasittande.");
                break;
        }
        // Det rekommenderade kaloriintaget kommer aldrig understiga 1400 kalorier dagligen.
        suggestedCaloricIntake = Math.max((int) tdee, 1400);
        return suggestedCaloricIntake;
    }

    /**
     * Kontrollerar hur många dagar det är från dagens till datum till det datum man har valt.
     * @return
     */
    static Long frågaOmDatum(){

        long antalDagar = 0;

        while (true) {

            try {
                System.out.println("Ange ett datum där du vill nå ditt viktmål(ÅÅÅÅ-MM-DD): ");
                String inputDatum = Main.scanner.next();

                LocalDate valtDatum = LocalDate.parse(inputDatum);
                if (valtDatum.isBefore(LocalDate.now())) {
                    System.out.println("Du har valt ett datum före dagens datum. Försök igen.");
                } else {
                    // Räknar antalet dagar från dagens datum till det valda datumet
                    antalDagar = LocalDate.now().until(valtDatum, ChronoUnit.DAYS);
                    break;
                }
            } catch (Exception e){
                System.out.println("Ogiltigt datumformat. Använd formatet ÅÅÅÅ-MM-DD.");
            }
            //Räknar dagar från från dagens datum till datum vi har valt

        }
        Main.scanner.nextLine();

        return antalDagar;

    }
    /**
     * Hur många kalorier fram till datum man bör minska.
     * @param kilogramsToLose
     * @return
     */
    static int antalerKalorierTillDatum(double kilogramsToLose) {
        return (int) Math.ceil((kilogramsToLose * 7700) / frågaOmDatum());
    }
}
