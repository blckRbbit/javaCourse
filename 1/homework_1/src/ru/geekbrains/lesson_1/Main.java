package ru.geekbrains.lesson_1;

public class Main {

    public static void main(String[] args) {
	    boolean boolTrue = true;
	    boolean boolFalse = false;
	    byte bytePositive = 127;
	    short shortNegative = -32768;
	    int intPositive = 2147483647;
	    long longNegative = -9223372036854775808L; // 8 byte
        double oneDouble = 8.5; // 8 byte
        float oneFloat = 1.2F; // 4 byte
        char oneChar = 'A';
        String text = "Hello, World!";
        showVariables(
                boolTrue,
                boolFalse,
                bytePositive,
                shortNegative,
                intPositive,
                longNegative,
                oneDouble,
                oneFloat,
                oneChar
        );
        System.out.println(text);
        System.out.println("end task_2===============================================================================");
        System.out.println(arithmeticOperationsOnFloat(4.4F, 5.3F, 1.2F, 7.1F));
        System.out.println("end task_3===============================================================================");
        System.out.println(moreThanTenLessThanTwenty(10, 11));
        System.out.println("end task_4===============================================================================");
        positiveOrNegativeNumber(-1);
        System.out.println("end task_5===============================================================================");
        System.out.println(booleanPositiveOrNegativeNumber(0));
        System.out.println("end task_6===============================================================================");
        helloName("Вася");
        System.out.println("end task_7===============================================================================");
        isLeapYear(300);
        System.out.println("end task_8===============================================================================");
    }

    private static void showVariables (
            boolean boolTrue,
            boolean boolFalse,
            byte bytePositive,
            short shortNegative,
            int intPositive,
            long longNegative,
            double oneDouble,
            float oneFloat,
            char oneChar
    ) {
        System.out.println(boolTrue);
        System.out.println(boolFalse);
        System.out.println(bytePositive);
        System.out.println(shortNegative);
        System.out.println(intPositive);
        System.out.println(longNegative);
        System.out.println(oneDouble);
        System.out.println(oneChar);
        System.out.println(oneFloat);
    }

    private static float arithmeticOperationsOnFloat (float a, float b, float c, float d) {
        return a * (b + (c / d));
    }

    private static boolean moreThanTenLessThanTwenty (int a, int b) {
        int sumResult = a + b;
        return sumResult >= 10 && sumResult <= 20;
    }

    private static void positiveOrNegativeNumber (int number) {
        String stringPositive = "Положительное число";
        String stringNegative = "Отрицательное число";
        if (number >= 0) {
            System.out.println(stringPositive);
        } else {
            System.out.println(stringNegative);
        }
    }

    private static boolean booleanPositiveOrNegativeNumber (int number) {
        return number <= 0;
    }

    private static void helloName (String name) {
        String hello = "Привет, ";
        System.out.println(hello + name + "!");
    }

    private static void isLeapYear (int year) {
        String leapYear = "Этот год високосный";
        if (year % 4 == 0 && year < 100) {
            System.out.println(leapYear);
        } else if (year % 4 == 0 && year >= 100 && year % 100 != 0 && year < 400) {
            System.out.println(leapYear);
        } else if (year >= 400 && year % 4 == 0 && year % 400 == 0 && year % 100 == 0) {
            System.out.println(leapYear);
        } else {
            System.out.println("Это не високосный год");
        }
    }
}
