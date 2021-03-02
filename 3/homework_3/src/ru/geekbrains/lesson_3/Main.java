package ru.geekbrains.lesson_3;

import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int userChoice = choiceOfDifficultyLevel();

        while (true) {
            if(userChoice == 0) {
                System.out.println("До встречи!");
                break;
            } else if (userChoice == 1) {
                int range = (int) (Math.random() * (300 - 10)) + 10;
                int number = (int) (Math.random() * range);
                int count = binlog(range) + 1;
                System.out.println("Ваша задача угадать целое число от 1 до " + range);
                System.out.println("Отгадайте число с " + count + " попыток ");
                System.out.println("Загаданное число (Ваш ответ) -> ");
                playLevel(number, count);
            } else if (userChoice == 2) {
                int range = (int) (Math.random() * (1000 - 10)) + 10;
                int number = (int) (Math.random() * range);
                int count = binlog(range);
                System.out.println("Ваша задача угадать целое число от 1 до " + range);
                System.out.println("Отгадайте число с " + count + " попыток ");
                System.out.println("Загаданное число (Ваш ответ) -> ");
                playLevel(number, count);
            } else if (userChoice == 3){
                int range = (int) (Math.random() * (1000 - 10)) + 10;
                int number = (int) (Math.random() * range);
                int count = binlog(range) - 1;
                System.out.println("Ваша задача угадать целое число от 1 до " + range);
                System.out.println("Отгадайте число с " + count + " попыток ");
                System.out.println("Загаданное число (Ваш ответ) -> ");
                playLevel(number, count);
            } else {
                System.out.println("Такой сложности в этой игре я ещё не придумал :(");
                break;
            }
            System.exit(0);
        }
        scanner.close();
    }


    private static int choiceOfDifficultyLevel()
//  Предлагает выбрать уровень сложности
    {
        System.out.println("Это игра 'Угадай число'. Выберите сложность: ");
        System.out.println("1 - очень легко");
        System.out.println("2 - легко");
        System.out.println("3 - сложно");
        System.out.println("Для выхода нажмите 0");
        return scanner.nextInt();
    }

    private void playLevel(int number, int count)
//  Основной игровой цикл
    {
        while (true) {
            int enteredNumber = scanner.nextInt();
            if (enteredNumber == number) {
                System.out.println("Вы угадали!");
                boolean answer = whetherToContinue();
                if (answer) choiceOfDifficultyLevel();
                else {
                    System.out.println("До встречи!");
                    System.exit(0);
                }
            } else if (count == 1) {
                System.out.println("Попытки закончились. Вы проиграли :( ");
                boolean answer = whetherToContinue();
                if (answer) choiceOfDifficultyLevel();
                else {
                    System.out.println("До встречи!");
                    System.exit(0);
                }
            } else if (enteredNumber > number) {
                count--;
                System.out.println("Загаданное число меньше! Попробуйте ещё раз! (осталось попыток: " + count + ")");
            } else if (enteredNumber == 0) {
                System.out.println("До встречи!");
                break;
            } else {
                count--;
                System.out.println("Загаданное число больше! Попробуйте ещё раз! (осталось попыток: " + count + ")");
            }
        }
    }

    private static boolean whetherToContinue ()
//  Предлагает сыграть еще или закончить игру
    {
        System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");
        int userEnter = scanner.nextInt();
        return userEnter == 1;
    }

    private static int binlog(int bits)
//  Логарифм нужен, чтобы узнать, за какое кол-во попыток реально угадать число.
//  Формула: count = log2(range)
    {
        int log = 0;
        if ((bits & 0xffff0000) != 0) {
            bits >>>= 16;
            log = 16;
        }
        if (bits >= 256) {
            bits >>>= 8;
            log += 8;
        }
        if (bits >= 16) {
            bits >>>= 4;
            log += 4;
        }
        if (bits >= 4) {
            bits >>>= 2;
            log += 2;
        }
        return log + (bits >>> 1);
    }
}

