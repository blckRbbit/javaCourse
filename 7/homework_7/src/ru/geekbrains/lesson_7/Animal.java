package ru.geekbrains.lesson_7;

public abstract class Animal {
    protected String name;
    protected int hunger;
    protected boolean satiety = false;

    Animal(String name, int hunger, boolean satiety) {
        this.name = name;
        this.hunger = hunger;
        this.satiety = satiety;
    }

    protected abstract int eat(Bowl bowl);
    protected abstract boolean isSatiety();
}
