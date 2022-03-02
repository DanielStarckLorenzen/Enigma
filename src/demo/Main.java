package demo;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    Scanner in = new Scanner(System.in);

    String alphabet1 = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] alphabet2 = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};


    public void go() {
        System.out.println("Hello agent. What type of encryption/decryption method would you like to use?" +
                "\n(1)Caesar" +
                "\n(2)Vigenére OBS! TBD" +
                "\n(3)Number" +
                "\n(4)Exit");
        String menuChoice = in.nextLine();
        if (menuChoice.equals("1")) {
            caesarEncryptDecrypt();
        }
        if (menuChoice.equals("2")) {
            vigenereEncryptDecrypt();
        }
        if (menuChoice.equals("3")) {
            numberEncryptDecrypt();
        }
        if (menuChoice.equals("4")) {
            System.out.println("You exited the program. Good luck on your mission agent!");
        }
        else {

        }
    }
    public void caesarEncryptDecrypt() {
        System.out.println("Would you like to (e)ncrypt or (d)ecrypt?");
        String encryptOrDecrypt = in.nextLine();
        System.out.println("How many shift do you want?");
        int shift = in.nextInt();
        char alphabetC;
        String result = "";

        //Caesar Encryption
        if (encryptOrDecrypt.equals("e")) {
            System.out.println("What message would you like to encrypt?");
            in.nextLine();
            String message = in.nextLine().toUpperCase(Locale.ROOT);
            for (int i = 0; i < message.length(); i++) {
                alphabetC = message.charAt(i);
                if (alphabetC >= 'A' && alphabetC <= 'Z') {
                    alphabetC = (char) (alphabetC + shift);
                    if (alphabetC > 'Z') {
                        alphabetC = (char) (alphabetC + 'A' - 'Z' - 1);
                    }
                    result = result + alphabetC;
                }
            }
        }

        //Caesar Decryption
        if (encryptOrDecrypt.equals("d")) {
            System.out.println("What message would you like to decrypt?");
            in.nextLine();
            String message = in.nextLine().toUpperCase(Locale.ROOT);
            for (int i = 0; i < message.length(); i++) {
                alphabetC = message.charAt(i);
                if (alphabetC >= 'A' && alphabetC <= 'Z') {
                    alphabetC = (char) (alphabetC - shift);
                    if (alphabetC < 'A') {
                        alphabetC = (char) (alphabetC + 'Z' - 'A' + 1);
                    }
                    result = result + alphabetC;
                }
            }
        }
        System.out.println("Your encrypted message is: " + result);
    }

    public void vigenereEncryptDecrypt() {
        //TODO
    }

    public void numberEncryptDecrypt() {
        System.out.println("Would you like to encrypt or decrypt a message(e/d)?");
        String encryptOrDecrypt = in.nextLine();

        //Converting letters to number
        if (encryptOrDecrypt.equals("e")) {
            System.out.println("What message will you like to encrypt?");
            String word = in.nextLine();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                c = Character.toUpperCase(c);
                int num = alphabet1.indexOf(c);
                System.out.print(num + " ");
            }
        }

        //!DOESEN'T WORK! | Converting number to letters
        if (encryptOrDecrypt.equals("d")) {
            System.out.println("What message will you like to encrypt?");
            int[] num = new int[1];
            for (int i = 0; i < num.length; i++) {
                num[i] = in.nextInt();
                for (int j = 0; j < num.length; j++) {
                    num[j] = alphabet2[j];
                    System.out.println(num[j]);
                }
            }
        }
    }
    
    public static void main(String[] args) {
	    new Main().go();
    }
}
