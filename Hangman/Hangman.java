package Hangman;

import java.util.Random;

public class Hangman {
    private String words[] = {"tiger", "animal", "hangman", "car", "house", "town", "city", "weapon", "elephant"};
    private int k = 0;

    private char [] getCurrentWord() {
        Random rand = new Random();
        int i = rand.nextInt(words.length);
        char[] word = words[i].toCharArray();
        return word;
    }

    private void getGuessWord(char [] word) {
        for (int i = 0; i < word.length; i++) {
            System.out.print(word[i]);
        }
        System.out.println();
        for (int i = 0; i < word.length; i++) {
            System.out.print("-");
        }
    }

    private void human_0() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
    }

    private void human_1() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("|");
        System.out.println("|");
    }

    private void human_2() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("|  |");
        System.out.println("|");
    }

    private void human_3() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("| /|");
        System.out.println("|");
    }

    private void human_4() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("| /|\\");
        System.out.println("|");
    }

    private void human_5() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("| /|\\");
        System.out.println("| /");
    }

    private void human_6() {
        System.out.println("____");
        System.out.println("|  |");
        System.out.println("|  o");
        System.out.println("| /|\\");
        System.out.println("| / \\");
    }

    private void startGame(){
        System.out.println("Hello, this is Hangman game!");
        System.out.println("Guess the word or die. Good luck!");

        char word [] = getCurrentWord();

        char [] guessWord = new char[word.length];
        char symbol;
        boolean c = false;

        guessWord[0] = word[0];
        guessWord[word.length-1] = word[word.length-1];

        for (int i = 1; i < guessWord.length-1; i++) {
            guessWord[i] = ' ';
        }

        human_0();
        System.out.println();
        getGuessWord(guessWord);

        while (true) {
            boolean j = false;
            c = false;
            symbol = Input.getUserInput("\nEnter the symbol:");
            for (int i = 1; i < guessWord.length-1; i++) {
                if (guessWord[i] == symbol) {
                    j = true;
                }
            }

            if (j){
                System.out.println("You already entered this symbol!");
                continue;
            }

            for (int i = 1; i < word.length-1; i++){
                if (symbol == word[i]){
                    guessWord[i] = symbol;
                    System.out.println();
                    c = true;
                }
            }
            if (!c) {
                k++;
                c = false;
            }

            switch(k) {
                case 0:
                    human_0();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 1:
                    human_1();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 2:
                    human_2();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 3:
                    human_3();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 4:
                    human_4();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 5:
                    human_5();
                    System.out.println();
                    getGuessWord(guessWord);
                    break;
                case 6:
                    human_6();
                    System.out.println();
                    getGuessWord(guessWord);
                    System.out.print("\nEnd game. You are dead! Current word is: ");
                    for (char s:word) {
                        System.out.print(s);
                    }
                    System.exit(0);
            }
            int l = 0;
            for (int i = 0; i < guessWord.length; i++) {
                if (guessWord[i] == word[i]){
                    l++;
                }
            }
            if (l == guessWord.length) {
                System.out.println("\nCongratulations. You are alive!");
                System.exit(0);
            }
        }
    }



    public static void main(String[] args) {
        Hangman game = new Hangman();
        game.startGame();
    }
}
