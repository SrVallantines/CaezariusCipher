
import java.util.Arrays;
import java.util.Scanner;

public class TheCipherOfCaesar {

    public static void main(String[] arguments) {

        String text = "";
        text = getCorrectText(text);

        char[] outputText = text.toCharArray();
        char[] modifiedText = new char[outputText.length];
        System.arraycopy(outputText,0,modifiedText,0,outputText.length);
//        for(int i=0;i<outputText.length;i++) {
//            modifiedText[i] = outputText[i];
//        }

        Arrays.sort(modifiedText);
        String a = Arrays.toString(outputText);
        String b = Arrays.toString(modifiedText);
        System.out.println("outputText -> "+a+'\n'+"modifiedText -> "+b);

        char commonSymbol = mostPopularSymbol(modifiedText);
        System.out.println("CommonSymbol -> "+commonSymbol);

    }

    private static String getCorrectText(String text) {
        Scanner input = new Scanner(System.in);
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

    private static char mostPopularSymbol(char[] work){
        char workSymbol=work[0];
        int codeSymbol;
        int maxCounter = 0;
        int counter =0;
        for(int i=0;i<(work.length-2);i++){
           codeSymbol = (int)work[i];   // Check only from Latins letter
            if((codeSymbol >64 &&codeSymbol<91) || (codeSymbol>96 && codeSymbol<123)){
                if(work[i] == work[i+1]){
                        counter++;
                }else{
                    if(counter>maxCounter){
                        maxCounter=counter;
                        counter=0;
                        workSymbol=work[i];
                    }
                }
            }else{
                counter=0;
            }

        }
        return workSymbol;
    }


}
