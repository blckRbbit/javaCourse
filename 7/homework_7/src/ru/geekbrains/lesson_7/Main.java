package ru.geekbrains.lesson_7;

public class Main {

    public static void main(String[] args) {
        Animal murzik = new Cat("Мурзик", 17, false);
        Cat dasha = new Cat("Даша", 5, false);

        Bowl firstBowl = new Bowl(20);

        dasha.eat(firstBowl);
        firstBowl.countFoodInBowl(firstBowl);

        murzik.eat(firstBowl);
        firstBowl.countFoodInBowl(firstBowl);

        firstBowl.addFood(firstBowl);
        murzik.eat(firstBowl);
        firstBowl.countFoodInBowl(firstBowl);

        System.out.println("Сытость Даши: " + dasha.satiety);
        System.out.println("Сытость Мурзика: " + murzik.satiety);

        Cat baton = new Cat("Батон", 2, false);
        Cat bublik = new Cat("Бублик", 15, false);
        Cat vasya = new Cat("Васька", 10, false);

        Cat[] cats = {baton, bublik, vasya};
        Bowl secondBowl = new Bowl(15);

        for (Cat cat : cats) {
            cat.eat(secondBowl);
            System.out.println(cat.name + " " + cat.satiety);
        }
    }
}
