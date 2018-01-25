import java.util.Scanner;

public class TheCipherOfCaesar {

    public static void main(String[] arguments) {

        StringBuilder sb = new StringBuilder();
        Scanner input = new Scanner(System.in);
        String text = "";
        boolean isRepeatInputText = true;
        int counter;

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
                    System.out.println("Please USE ONLY Latin alphabet, numbers and punctoation marks!");
                    System.out.println("Please try again!\n");
                    isRepeatInputText = true;
                    break;
                }

            }

        }
        System.out.println("Your text -> " + text);

    }

}