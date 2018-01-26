
import java.util.Arrays;
import java.util.Scanner;

public class TheCipherOfCaesar {

    public static void main(String[] arguments) {

        String text = getCorrectText();

        char[] outputText = text.toCharArray();
        char[] modifiedText = new char[outputText.length];
        System.arraycopy(outputText, 0, modifiedText, 0, outputText.length);
        Arrays.sort(modifiedText);

        String a = Arrays.toString(outputText);
        String b = Arrays.toString(modifiedText);
        System.out.println("outputText -> " + a + '\n' + "modifiedText -> " + b);

        char commonSymbol = mostPopularSymbol(modifiedText);
        System.out.println("CommonSymbol -> " + commonSymbol);

        veryOftenDecrypting(outputText, modifiedText, commonSymbol);

        Scanner scan = new Scanner(System.in);
        String temporary = "";
        while(!temporary.equals("Y")&&!temporary.equals("N")){
            System.out.print("ИМА ЛИ ПРАВИЛНО РАЗКОДИРАН ТЕКСТ ТУК? ( Y or N )");
            temporary = scan.nextLine();
        }


    }

    private static String getCorrectText() {
        Scanner input = new Scanner(System.in);
        String text = "";
        int counter;
        boolean isRepeatInputText = true;
        while (isRepeatInputText) {
            System.out.print("Past TEXT for DECRYPTING here, or <0> for EXIT: ");
            text = (input.nextLine()).trim();
            if (text.equals(" ") || text.isEmpty()) {
                System.out.println("This is INCORRECT text! Please try again!\n");
                continue;
            }
            if (text.length() == 1 && text.equals("0")) {
                System.out.println("Thank you! Good By!");
                isRepeatInputText = false;
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
        System.out.println("Your text -> " + text);
        return text;
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

    private static void veryOftenDecrypting(char[]outputText, char[]modifiedText,char symbol){
        int tempKey = 0;
        if((96<(int)symbol) && ((int)symbol<123)){ // Lower Latins Alphabet
            tempKey = ((int)symbol) - 101;         // This is symbol'e'
        }
        if((64<(int)symbol) && ((int)symbol<91)){ // Biggest Latins Alphabet
            tempKey = ((int)symbol) - 69;         // This is symbol'E'
        }
        decriptingUnit(outputText, modifiedText, tempKey);


    }

    private static void decriptingUnit(char[]outputText, char[]modifiedText, int key){
        for(int i=0;i<outputText.length;i++){

        }


    }

}
