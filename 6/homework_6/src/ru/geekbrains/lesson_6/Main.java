package ru.geekbrains.lesson_6;

public class Main {

    public static void main(String[] args) {

	Cat barsic = new Cat("Барсик", "сиамский", "чёрный", "два");
	Animal panteley = new Cat("Пантелей", "мэйнкун", "серый", "два с половиной");
	Dog sharik = new Dog("Шарик", "дворняга", "пятнистый", "3");

        var catCount = Cat.catCount;
        var dogCount = Dog.dogCount;
        var animalCount = Animal.animalCount;

        System.out.println("==== Кошки ====");

        barsic.voice();
        panteley.voice();

        barsic.run();
        panteley.run();

        barsic.sail();
        panteley.sail();

        System.out.println("==== Собаки ====");

        sharik.voice();
        sharik.run();
        sharik.sail();

        System.out.println("========");
        System.out.println("Создано животных: " + animalCount);
        System.out.println("Создано кошек: " + catCount);
        System.out.println("Создано собак: " + dogCount);

    }
}
