package Hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Input {
    static char word[];
    static char getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            inputLine = read.readLine();
            if (inputLine.length() == 0 || inputLine.length() > 1) {
                System.out.println("Please, enter only one symbol!");
                return ' ';
            }
            word = inputLine.toCharArray();
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException: " + e);
        }
        return word[0];
    }
}
