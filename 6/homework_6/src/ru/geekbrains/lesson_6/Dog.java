package ru.geekbrains.lesson_6;

public class Dog extends Animal{

    static int dogCount = 0;

    Dog(String name, String breed, String color, String age) {
        super(name, breed, color, age);
        dogCount++;
    }

    @Override
    public void voice() {
        System.out.println(name + ": Wof!");
    }

    @Override
    public void run() {
        int max = 500;
        System.out.println(name + ": Сколько бежать то?.. Хозяин?");

        while (!scanner.hasNextInt()) {
            System.out.println(name + ": Я лишь животное, и воспринимаю только расстояние в целых числах :(");
            scanner.next();
        }

        int distance = scanner.nextInt();

        if (distance < 0) distance = -distance;

        if (distance == 0) {
            System.out.println(name + ": Ну... Стоять, так стоять...");
        } else if (distance > max) {
            System.out.println(name + " может пробежать лишь " + Math.abs(max) + " м.!");
        } else {
            System.out.println(name + " пробежал " + Math.abs(distance) + " м.!");
        }
    }

    @Override
    public void sail() {
        int max = 10;
        System.out.println(name + ": Сколько плыть то, хозяин?..");

        while (!scanner.hasNextInt()) {
            System.out.println(name + ": Я лишь животное, и воспринимаю только расстояние в целых числах :(");
            scanner.next();
        }

        int distance = scanner.nextInt();

        if (distance < 0) distance = -distance;

        if (distance == 0){
            System.out.println(name + ": Ну... не плыть, так не плыть...");
        }
        else if (distance > max) {
            System.out.println(name + " может проплыть лишь " + Math.abs(max) + " м.!");
        }
        else {
            System.out.println(name + " проплыл " + Math.abs(distance) + " м.!");
        }
    }

    public void totalNumberOfDog() {
        System.out.println("Количество созданных собак " + dogCount);
    }
}
