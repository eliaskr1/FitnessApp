package se.nackademin;


import static se.nackademin.MatDatabas_utils.displayFoodList;

public class MatDatabas {
    public static void macroTrack() {
        // Vi skapar en matdatabas
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
        matDB.addFood("Havregryn)", 68);
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
        matDB.addFood("Cashewnötter)", 553);

        //Spara totala kalorier här
        double totalCalories = 0.0;
        //  Vi låter användaren välja mat

        while (true) {
            System.out.print("Lägga till mer mat?(Ja/Nej) ");
            String appendFood = Main.scanner.nextLine().toLowerCase();
            if (appendFood.equals("nej"))
                break;

            System.out.println('\n' + "----------------------------------------------MATLISTAN---------------------------------------");
            displayFoodList(); // Antagligen en metod för att skriva ut matlistan
            System.out.println('\n' + "----------------------------------------------------------------------------------------------");
            System.out.print('\n' + "Välj en produkt: ");
            String selectedFood = Main.scanner.nextLine().toLowerCase(); // Convert to lowercase

            // Vi låter användaren ange vikt i gram
            System.out.print("Hur många gram åt du?: ");
            double amountInGrams = Main.scanner.nextDouble();

            Main.scanner.nextLine();

            // Utifrån användarens val i selectedFoods skickar vi värdet till calculateCalories metoden.
            //Användares val i gram finns i amountInGrams, värde skickas till calculateCalories metoden.
            //Detta ges till variabeln calories som sedan presenteras
            double calories = MatDatabas_utils.calculateCalories(selectedFood, amountInGrams);
            System.out.println("Calories: " + calories);

            totalCalories += calories;
        }
        System.out.println("Totala kalorier: " + totalCalories);


        Main.scanner.nextLine();

    }
}
