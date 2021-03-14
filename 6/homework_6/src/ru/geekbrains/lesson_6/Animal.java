package ru.geekbrains.lesson_6;

import java.util.Scanner;

public abstract class Animal {

    static int animalCount = 0;
    protected String name;
    protected String breed;
    protected String color;
    protected String age;

    Animal (String name, String breed, String color, String age) {
        this.name = name;
        this.breed = breed;
        this.color = color;
        this.age = age;
        animalCount ++;
    }
    protected Scanner scanner = new Scanner(System.in);
    protected abstract void voice();
    protected abstract void run ();
    protected abstract void sail ();

    public void totalNumberOfAnimals () {
        System.out.println("Количество созданных животных " + animalCount);
    }
}
