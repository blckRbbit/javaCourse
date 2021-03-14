package ru.geekbrains.lesson_7;;

public class Cat extends Animal{
    Cat(String name, int hunger, boolean satiety ) {
        super(name, hunger, satiety);
    }

    @Override
    protected int eat (Bowl bowl) {
        if (bowl.fullness < hunger) {
            hunger = hunger - bowl.fullness;
            bowl.fullness = 0;
            System.out.println(name + " ещё испытывает голод! Добавьте " + hunger + " еды.");
            satiety = false;
            return hunger;
        } else {
            System.out.println(name + " больше не испытывает голода.");
            bowl.fullness = bowl.fullness - hunger;
            hunger = 0;
            satiety = true;
        }
        return hunger;
    }

    @Override
    protected boolean isSatiety() {
        return satiety;
    }
}
