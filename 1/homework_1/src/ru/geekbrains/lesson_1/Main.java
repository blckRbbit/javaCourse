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
        positiveOrNegativeNumber(0);
        System.out.println("end task_5===============================================================================");
        System.out.println(booleanPositiveOrNegativeNumber(0));
        System.out.println("end task_6===============================================================================");
        helloName("Вася");
        System.out.println("end task_7===============================================================================");
        isLeapYear(2020);
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
        return number < 0;
    }

    private static void helloName (String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static void isLeapYear (int year) {
        boolean moreLess = aYearMoreOrLessThanFourHundred(year);
        if (moreLess) {
            System.out.println("Этот год високосный");
        } else {
            System.out.println("Это не високосный год");
        }
    }

    private static boolean aYearMoreOrLessThanFourHundred (int year) {

        if (year < 400) {
            return lessThanFourHundredYears(year);
        } else {
            return overFourHundredYears(year);
        }
    }

    private static boolean lessThanFourHundredYears (int year) {
        return year % 4 == 0 && year % 100 != 0;
    }

    private static boolean overFourHundredYears (int year) {
        if (year % 100 == 0 && year % 400 != 0) {
            return false;
        } else return year % 4 == 0;
    }
}
