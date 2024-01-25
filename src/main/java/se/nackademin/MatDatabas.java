package se.nackademin;

/**
 * Klass som skriver ut avbildningnstabell, tar emot user input och returnerar totalt intagna kalorier
 */

public class MatDatabas {
    public static void macroTrack() {
        // Vi lägger in nycklar och värden i HashMap med metoden addfood.
        MatDatabas_utils matDB = new MatDatabas_utils();
        matDB.addFood("Kyckling", 165);
        matDB.addFood("Nötfärs", 250);
        matDB.addFood("Lax", 206);
        matDB.addFood("Ris", 130);
        matDB.addFood("Pasta", 130);
        matDB.addFood("Ägg", 155);
        matDB.addFood("Mjölk", 61);
        matDB.addFood("Broccoli", 55);
        matDB.addFood("Potatis", 77);
        matDB.addFood("Banan", 89);
        matDB.addFood("Avokado", 160);
        matDB.addFood("Havregryn", 68);
        matDB.addFood("Mandel", 579);
        matDB.addFood("Mörkchoklad", 604);
        matDB.addFood("Granatäpple", 83);
        matDB.addFood("Blåbär", 57);
        matDB.addFood("Havrebröd", 68);
        matDB.addFood("Paprika", 31);
        matDB.addFood("Olivolja", 884);
        matDB.addFood("Fetaost", 264);
        matDB.addFood("Yoghurt", 59);
        matDB.addFood("Ärtor", 81);
        matDB.addFood("Kalkonbröst", 135);
        matDB.addFood("Quinoa", 120);
        matDB.addFood("Cashewnötter", 553);

        //Initiera variabeln
        double totalCalories = 0.0;

        /*
        Evighetsloop som tar emot inmatning av produkt och intagna kalorimängder, avbryts med "nej".
         */

        while (true) {
            System.out.print("Lägga till mer mat?(Ja/Nej) ");
            String appendFood = Main.scanner.nextLine().toLowerCase();
            if (appendFood.equals("nej"))
                break;

            /*
            Utskrift av map och scanning av user input.
             */
            System.out.println('\n' + "---------------------------------------------------------MATLISTAN---------------------------------------------------");
            MatDatabas_utils.displayFoodList(); // Skriva ut matlistan
            System.out.println('\n' + "---------------------------------------------------------------------------------------------------------------------");
            System.out.print('\n' + "Välj en produkt: ");
            String selectedFoodInput = Main.scanner.nextLine().toLowerCase();// Convert to lowercase


            double amountInGrams;

            /*
            Här kontrolleras det om inmatningen endast innehåller mellanslag eller är tom.
             */
            if (selectedFoodInput.trim().isEmpty()) {
                System.out.println("Felaktig inmatning. Vänligen ange en giltig produkt.");
                continue; // Gå till nästa steg
            }

            System.out.print("Hur många gram åt du?: ");
            try {
                amountInGrams = Main.scanner.nextDouble();
            } catch (Exception e) {
                System.out.println("Ej giltigt tal, antar 100g...");
                amountInGrams = 100;
            }
            Main.scanner.nextLine();

            /*
            If sats som blir sann och körs om metoden isInteger returnerar värdet sant.
             */
            if (MatDatabas_utils.isInteger(selectedFoodInput))
            // Användaren har angett en siffra som motsvarar produktnummer;
                selectedFoodInput = MatDatabas_utils.convertIntToFood(selectedFoodInput);

            /*
            Utifrån användarens val av produkt skickar vi värdet till calculateCalories metoden som första parameter.
            Användares val i gram finns i amountInGrams, värde skickas till calculateCalories metoden som andra parameter.
             */
            double calories;

            if (selectedFoodInput != null) {
                calories = MatDatabas_utils.calculateCalories(selectedFoodInput, amountInGrams);
                System.out.println("Calories: " + calories);
            } else {
                calories = 0;
            }

            /*
            Summering av kalorier.
             */
            totalCalories += calories;
        }
        /*
        Utskrift av totala mängd kalorier.
         */
        System.out.println("Totala kalorier: " + totalCalories);
    }

}



                /*
                 Vi låter användaren ange vikt i gram efter inmatning av produkt som siffra

                System.out.print("Hur många gram åt du?: ");
    amountInGrams = Main.scanner.nextDouble();
                Main.scanner.nextLine(); // Läs upp överblivet nyttelinjetangent

} else {
                /*
                 Vi låter användaren ange vikt i gram efter inmatning av produkt som sträng

        System.out.print("Hur många gram åt du?: ");
amountInGrams = Main.scanner.nextDouble();
                Main.scanner.nextLine(); // Läs upp överblivet nyttelinjetangent
            }
 */
