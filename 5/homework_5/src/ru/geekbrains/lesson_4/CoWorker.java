package ru.geekbrains.lesson_4;

public class CoWorker {

    private String firstName;
    private String lastName;
    private String patronymic;
    private String position;
    private String email;
    private long phone;
    private int salary;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;


    public String outCoWorkerInfo () {
        return ("Сотрудник \n имя: " +
                lastName + ", " +
                "фамилия: " + firstName + ", " +
                "отчество: " + patronymic + ", " +
                "должность: " + position + ", " +
                "email: " + email + ", " +
                "телефон: " + phone + ", " +
                "зарплата: " + salary + ", " +
                "возраст: " + age + ". ");
    }

    CoWorker (
            String firstName,
            String lastName,
            String patronymic,
            String position,
            String email,
            long phone, int salary,
            int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

}
