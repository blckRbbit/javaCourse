package ru.geekbrains.lesson_4;

public class Main {

    public static void main(String[] args) {
        CoWorker ivan = new CoWorker(
                "Иванов",
                "Иван",
                "Иванович",
                "джуниор",
                "ivanov@gmail.com",
                87777777777L,
                60000,
                21
        );

        CoWorker petr = new CoWorker(
                "Петров",
                "Пётр",
                "Петрович",
                "джуниор",
                "petrov@gmail.com",
                87776666666L,
                60000,
                19
        );

        CoWorker sidor = new CoWorker(
                "Сидоров",
                "Сидор",
                "Сидорович",
                "джуниор",
                "sidorov@gmail.com",
                87775555555L,
                60000,
                44
        );

        CoWorker yemelyanov = new CoWorker(
                "Емельянов",
                "Емельян",
                "Емельянович",
                "мидл",
                "yemelyanov@gmail.com",
                87778888888L,
                80000,
                41
        );

        CoWorker graph = new CoWorker(
                "Граф",
                "Людвиг",
                "Аристархович",
                "синьор",
                "graph@gmail.com",
                87779999999L,
                120000,
                32
        );

        CoWorker[] staff = {graph, yemelyanov, sidor, petr, ivan};

        for (int i = 0; i < staff.length; i++) {
            if (staff[i].getAge() > 40)
                System.out.println(staff[i].outCoWorkerInfo());
        }
    }
}
