
import java.util.Arrays;
import java.util.Scanner;

public class TheCipherOfCaesar {

    public static void main(String[] arguments) {
        Scanner scan = new Scanner(System.in);
        String text;
        String temporary = "";
// Input menu
        while (!temporary.equals("Y") && !temporary.equals("N") && !temporary.equals("y") && !temporary.equals("n")) {
            System.out.print("HELLO! Before decrypting, would you like to first encrypt any your text? ( <Y> or <N> )");
            temporary = scan.nextLine();
        }
        if (temporary.equals("Y") || temporary.equals("y")) {
            text = getCorrectText("Input TEXT for ENCRYPTING here: ");
            int encodKey = getCorrectKey();
// Encoder Unit
            coderUnit(text, encodKey);
        }

// Input verification
        text = getCorrectText("\nPast TEXT for DECRYPTING here: ");

        char[] outputText = text.toCharArray();
        char[] modifiedText = new char[outputText.length];
        System.arraycopy(outputText, 0, modifiedText, 0, outputText.length);
        Arrays.sort(modifiedText);

// Searching for most popular symbol in the string
        char commonSymbol = mostPopularSymbol(modifiedText);
        System.out.println("CommonSymbol -> " + commonSymbol);

// Decryption with 'e', 't' or 'h'
        veryOftenDecrypting(outputText, modifiedText, commonSymbol);

// Ending menu
        temporary = "";
        while (!temporary.equals("Y") && !temporary.equals("N") && !temporary.equals("y") && !temporary.equals("n")) {
            System.out.print("Is there a CORRECTLY DECODED TEXT here? ( <Y> or <N> )");
            temporary = scan.nextLine();
        }
        if (temporary.equals("N") || temporary.equals("n")) {
            System.out.println("\n OK! Then look AT ALL POSSIBLE decoding versions.\n");
            for (int key = 1; key < 27; key++) {
                decriptingUnit(outputText, modifiedText, (key + 1));
                System.out.print("Numb." + key + ": ");
                printingDecriptionText(modifiedText);
            }
        }
        System.out.println('\n' + "THANKS! IT WAS NICE to be useful to you!!!");

    } // The end

    private static String getCorrectText(String message) {
        Scanner input = new Scanner(System.in);
        String text = "";
        int counter;
        boolean isRepeatInputText = true;
        while (isRepeatInputText) {
            System.out.print(message);
            text = (input.nextLine()).trim();
            if (text.equals(" ") || text.isEmpty()) {
                System.out.println("This is INCORRECT text! Please try again!\n");
                continue;
            }
            counter = 0;
            while (counter < text.length()) {
                isRepeatInputText = false;
                if (text.charAt(counter) > 31 && text.charAt(counter) < 123) {
                    counter++;
                } else {
                    System.out.println("Please USE ONLY Latin alphabet, numbers and punctuation marks!");
                    System.out.println("Please try again!\n");
                    isRepeatInputText = true;
                    break;
                }

            }

        }
        System.out.println("Your text to encrypting is: " + text);
        return text;
    }

    private static int getCorrectKey() {
        Scanner input = new Scanner(System.in);
        String text = "";
        int counter;
        boolean isRepeatInputText = true;
        while (isRepeatInputText) {
            System.out.print("Please, input key for ENCRYPTING here (1 to 26): ");
            text = (input.nextLine()).trim();
            if (text.equals(" ") || text.isEmpty()) {
                System.out.println("This is INCORRECT key! Please try again!\n");
                continue;
            }
            counter = 0;
            while (counter < text.length()) {
                isRepeatInputText = false;
                if ((int) text.charAt(counter) > 47 && (int) text.charAt(counter) < 58) {
                    counter++;
                } else {
                    System.out.println("Please USE ONLY numbers from 0 to 26!");
                    System.out.println("Please try again!\n");
                    isRepeatInputText = true;
                    break;
                }
            }
            if (!isRepeatInputText && (Integer.valueOf(text) < 0 || Integer.valueOf(text) > 26)) {
                System.out.println("This is INCORRECT key! Please try again!\n");
                isRepeatInputText = true;
            }
        }
        return Integer.valueOf(text);
    }

    private static char mostPopularSymbol(char[] work) {
        char workSymbol = work[0];
        int codeSymbol;
        int maxCounter = 0;
        int counter = 0;

        for (int i = 0; i < (work.length - 1); i++) {
            codeSymbol = (int) work[i];   // Check only from Latins letter
            if ((codeSymbol > 64 && codeSymbol < 91) || (codeSymbol > 96 && codeSymbol < 123)) {
                if (work[i] == work[i + 1]) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > maxCounter) {
                    maxCounter = counter;
                    workSymbol = work[i];
                }
            }
        }
        return workSymbol;
    }

    private static void veryOftenDecrypting(char[] outputText, char[] modifiedText, char symbol) {
        int tempKey = 0;
        if ((96 < (int) symbol) && ((int) symbol < 123)) { // Lower Latins Alphabet
            tempKey = ((int) symbol) - 101;         // This is symbol'e'
        }
        if ((64 < (int) symbol) && ((int) symbol < 91)) { // Biggest Latins Alphabet
            tempKey = ((int) symbol) - 69;         // This is symbol'E'
        }
        decriptingUnit(outputText, modifiedText, tempKey);
        printingDecriptionText(modifiedText);


        tempKey = 0;
        if ((96 < (int) symbol) && ((int) symbol < 123)) { // Lower Latins Alphabet
            tempKey = ((int) symbol) - 116;         // This is symbol't'
        }
        if ((64 < (int) symbol) && ((int) symbol < 91)) { // Biggest Latins Alphabet
            tempKey = ((int) symbol) - 84;         // This is symbol'T'
        }
        decriptingUnit(outputText, modifiedText, tempKey);
        printingDecriptionText(modifiedText);

        tempKey = 0;
        if ((96 < (int) symbol) && ((int) symbol < 123)) { // Lower Latins Alphabet
            tempKey = ((int) symbol) - 104;         // This is symbol'h'
        }
        if ((64 < (int) symbol) && ((int) symbol < 91)) { // Biggest Latins Alphabet
            tempKey = ((int) symbol) - 72;         // This is symbol'H'
        }
        decriptingUnit(outputText, modifiedText, tempKey);
        printingDecriptionText(modifiedText);

    }

    private static void decriptingUnit(char[] outputText, char[] modifiedText, int key) {
        int workCode;
        for (int i = 0; i < outputText.length; i++) {
            workCode = (int) outputText[i] + key;
            modifiedText[i] = outputText[i];

            if ((64 < outputText[i]) && (outputText[i] < 91)) { // Bigger Latins Alphabet
                if ((workCode) > 90) {   // Increase Bigger Latins
                    workCode = (workCode % 91 + 65);
                }

                if ((workCode) < 65) {   // Decrease Bigger Latins
                    workCode = (90 - 65 % workCode);
                }
                modifiedText[i] = (char) workCode;
            }

            if ((96 < outputText[i]) && (outputText[i] < 123)) { // Lower Latins Alphabet
                if ((workCode) > 122) {   // Increase lower Latins
                    workCode = (workCode % 123 + 97);
                }

                if ((workCode) < 97) {   // Decrease lower Latins
                    workCode = (122 - 96 % workCode);
                }
                modifiedText[i] = (char) workCode;

            }
        }
    }

    private static void printingDecriptionText(char[] text) {

        StringBuilder sb = new StringBuilder();
        for (char work : text) {
            sb.append(work);
        }
        System.out.print("Decoding text =-> " + sb + '\n');
    }

    private static void coderUnit(String text, int key) {
        int work;
        char symbol;
        System.out.print("Your CODING text is: ");
        for (int i = 0; i < text.length(); i++) {
            symbol = text.charAt(i);
            work = (int) (symbol);
            if ((64 < work) && (work < 91)) { // Bigger Latins Alphabet
                if (work + key > 90) {   // Increase Bigger Latins
                    symbol = (char) ((work + key) % 91 + 65);
                } else {
                    symbol = (char) (work + key);
                }
            }

            if ((96 < work) && (work < 123)) { // Lower Latins Alphabet
                if ((work + key) > 122) {   // Increase lower Latins
                    symbol = (char) ((work + key) % 123 + 97);
                } else {
                    symbol = (char) (work + key);
                }
            }
            System.out.print(symbol);
        }

    }

}
