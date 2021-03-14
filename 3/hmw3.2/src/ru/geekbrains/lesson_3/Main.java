package ru.geekbrains.lesson_3;

import java.util.*;

public class Main {

    static final Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    static String[] wordsInComputerMemory = new String[]{
            "apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli",
            "\ncarrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "\nmushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple",
            "\npumpkin", "potato",
    };

    private static final int hiddenWord = random.nextInt(wordsInComputerMemory.length);

    public static void main(String[] args) {
        String computerWord = wordsInComputerMemory[hiddenWord];

        System.out.println("Привет! Давай сыграем в игру угадай слово!");
        System.out.println("Вот все слова, которые я знаю :( ");
        System.out.println(Arrays.toString(wordsInComputerMemory));
        System.out.println("Какое слово я загадал?");

        while (true)
        {
            String userWord = scanner.nextLine();
            userWord = userWord.toLowerCase();

            int differenceLengthUserWord = 15 - userWord.length();
            int differenceLengthComputerWord = 15 - computerWord.length();

            String sharpsToUserWord = ("#").repeat(differenceLengthUserWord);
            String sharpsToComputerWord = ("#").repeat(differenceLengthComputerWord);

            userWord = userWord + sharpsToUserWord;
            computerWord = computerWord + sharpsToComputerWord;

            if (Objects.equals(computerWord, userWord)) {
                System.out.println("Вы угадали!");
                return;
            }
            else {
                System.out.println(computerWord.length());
                for (int i = 0; i < computerWord.length(); i++) {
                    if (userWord.charAt(i) != computerWord.charAt(i)) {
                        userWord = userWord.replace(userWord.charAt(i), '#');
                    }
                }

                System.out.println("Вот все слова, которые я знаю :( ");
                System.out.println(Arrays.toString(wordsInComputerMemory));
                System.out.println("Не угадал! Но кое-что совпало: ");
                System.out.println();
                System.out.println(userWord);
                System.out.println("Попробуй ещё раз! ;-)");
            }
        }
    }
}
