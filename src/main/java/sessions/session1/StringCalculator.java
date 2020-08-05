package sessions.session1;

import java.util.ArrayList;

public class StringCalculator {


    public int add(String numbersString){
        if(numbersString.equals("")){
            return 0;
        }

        String delimiter = "[,\n]";

        if(numbersString.startsWith("//")){
            String[] splitArray = numbersString.split("\n", 2);

            delimiter = splitArray[0].split("//")[1];
            numbersString = splitArray[1];
        }

        String[] numberStringArray = numbersString.split(delimiter);
        int total = 0;
        ArrayList<String> negatives = new ArrayList<>();

        for(String s: numberStringArray){
            int nextInt = Integer.parseInt(s);
            if(nextInt < 0){
                negatives.add(s);
            }

            if(nextInt <= 1000) {
                total += nextInt;
            }
        }

        if(negatives.size() > 0){
            throw new IllegalStateException("negatives not allowed: " + String.join(", ", negatives));
        }

        return total;
    }

}
