import java.util.Scanner;

/**
 * Bei Eingabe x wird die kleinste natürliche Zahl zurückgegeben, deren Collatz Folge
 * unter den Collatz-Folgen aller Zahlen zwischen 1 und x die maximale Länge hat.
 */

public class CollatzNumbers {



    public static void main(String[] args) {

        //Todo:Programm mit Optimierung

        //Todo:Programm ohne Optimierung
        getInputFromUser();
    }


private static boolean checkIfInputIsOk(String input){
        boolean isInputOk = !input.isEmpty();

    if(input.startsWith("0")) isInputOk = false;

    return isInputOk;

}

private static String removeAllNonDigits(String text){


    return text.replaceAll("[^0-9]+", "");
}


    private static int getInputFromUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter until which maximum number the Collatz series" +
                "be calculated:\n");


        String userInput = scanner.next();
        String userInputOnlyDigits = removeAllNonDigits(userInput);


        while(!checkIfInputIsOk(userInputOnlyDigits)){
            System.out.println("Please enter your number only in decimal digits and it can't start with 0 ");
            userInput = scanner.next();
            userInputOnlyDigits = removeAllNonDigits(userInput);
        }
        scanner.close();
        return Integer.parseInt(userInputOnlyDigits);

    }
}
