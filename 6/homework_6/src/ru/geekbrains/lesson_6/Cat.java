package ru.geekbrains.lesson_6;

public class Cat extends Animal {

    static int catCount = 0;

    Cat(String name, String breed, String color, String age) {
        super(name, breed, color, age);
        catCount++;
    }

    @Override
    public void voice() {
        System.out.println(name + ": Meow");
    }

    @Override
    public void run() {
        int max = 200;
        System.out.println(name + ": Сколько бежать то?..");

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
            System.out.println(name + " грустно смотрит на воду, ведь кошки не умеют плавать...");
    }

    public void totalNumberOfCat() {
        System.out.println("Количество созданных котов " + catCount);
    }
}
