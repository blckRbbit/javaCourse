package ru.geekbrains.lesson_7;


import java.util.Scanner;

public class Bowl {
    protected  int fullness;

    Bowl (int fullness) {
        this.fullness = fullness;
    }

    protected void addFood(Bowl bowl) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Сколько еды добавить в миску?");

        while (!scanner.hasNextInt()) {
            System.out.println("Введите целое положителное число!");
            scanner.next();
        }

        int countFood = scanner.nextInt();
        if (countFood < 0) countFood = -countFood;
        bowl.fullness += countFood;
        System.out.println("Вы успешно добавили " + bowl.fullness + " еды.");
        scanner.close();
    }

    protected void countFoodInBowl(Bowl bowl) {
        System.out.println("Количество еды в миске: " + bowl.fullness);
    }
}
