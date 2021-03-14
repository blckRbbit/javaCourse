package ru.geekbrains.lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("____task 1____");
	    int [] changeIt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(swapZeroAndOne((changeIt))));
        System.out.println("end task 1______________________________________________");

        System.out.println();
        System.out.println("____task 2____");
        int [] byThree = new int [8];
        System.out.println(Arrays.toString(increaseByThree(byThree)));
        System.out.println("end task 2______________________________________________");

        System.out.println();
        System.out.println("____task 3____");
        int [] multiplyByTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(lessThanSixMultiplyByTwo(multiplyByTwo)));
        System.out.println("end task 3______________________________________________");

        System.out.println();
        System.out.println("____task 4____");
        int [][] oneToDiagonal = {{2, 3, 4, 5}, {5, 6, 7, 8}, {2, 3, 4, 5}, {2, 3, 4, 5}};
        int [][] falseOneToDiagonal = {{2, 3, 4, 5}, {5, 6, 7, 8}, {2, 3, 4, 5}};
        mainMatrix(oneToDiagonal);
        mainMatrix(falseOneToDiagonal);
        System.out.println("end task 4______________________________________________");

        System.out.println();
        System.out.println("____task 5**____");
        int [] minMaxArray = {1, 5, 3, 2, -11, 4, 5, 2, 4, 8, 9, 1};
        getMinMaxElement(minMaxArray);
        System.out.println("end task 5______________________________________________");

        System.out.println();
        System.out.println("____task 6**____");
        int [] checkBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkEqualityOfTwoPartsOfAnArray(checkBalance));
        System.out.println("end task 6______________________________________________");

        System.out.println();
        System.out.println("____task 7****____");
        int n = -2;
        int[] shiftArray = {3, 5, 6, 1, 15};
        shiftByNPositions(shiftArray, n);
        System.out.println("end task 7______________________________________________");
    }

//    task 7

    public static int greatestCommonDivisor (int dividend, int divider)
    {
//  Вычисляем наибольший общий делитель
        while(divider != 0) {
            int temp = dividend;
            dividend = divider;
            divider = temp % dividend;
        }
        return dividend;
    }

    public static void shiftByNPositions(int[] a, int n) {
//  Сдвигает элементы массива а на n позиций
        int length = a.length;
        if (Math.abs(n) > a.length) n = n % length - 1;
        if (n < 0) n = length + n;
        int divisor = greatestCommonDivisor(length, n);
        for(int i = 0; i < divisor; i++) {
            int temp = a[i];
            for(int j = i - n + length; j != i; j = (j - n + length) % length)
                a[(j + n) % length] = a[j];
            a[i + n] = temp;
        }
        System.out.println(Arrays.toString(a));
    }

//    end task 7========================================================================


    private static boolean checkEqualityOfTwoPartsOfAnArray (int [] a)
//  Проверяет равенство левой и правой части массива
    {
        int gap = 0;
        for (int i = 0; i < a.length;) {
            gap += a[i];
            a[i] = 0;
            int sumRight = countsTheSumInArray(a);
            if (gap != sumRight) i++;
            if (sumRight == 0 && gap != sumRight) return false;
            if (gap == sumRight) return true;
        }
        return false;
    }

    private static int countsTheSumInArray (int [] a)
//  Считает сумму элементов массива;
    {
        int summ = 0;
        for (int j : a) {
            summ += j;
        }
        return summ;
    }

//    end task 6========================================================


//    task 5

    private static void getMinMaxElement (int [] a)
//  Определяет минимальный и максимальный элемент массива
    {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                int gap;
                if (a[j] > a[j + 1]) {
                    gap = a[j];
                    a[j] = a[j+1];
                    a[j + 1] = gap;
                }
            }
        }
        System.out.println("Минимальный элемент в массиве: " + a[0]);
        System.out.println("Максимальный элемент в массиве: " + a[a.length - 1]);
    }
//    end task 5========================================================


//    task 4
    private static void mainMatrix (int [][] a)
    {
        if (isSquareMatrix(a)) {
            arRangeUnitsDiagonally(a);
            printMatrix(a);
        } else {
            System.out.println("Это не квадратная матрица!");
        }
    }

    private static void printMatrix(int[][] a)
//    Распечатывает матрицу в виде таблицы
    {
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void arRangeUnitsDiagonally (int[][] a) {
//    Заполняет диагонали матрицы единицами
        for (int i = 0; i < a.length; i++) {
            a[i][i] = 1;
            a[a.length - 1 - i][i] = 1;
        }
    }

    private static boolean isSquareMatrix (int[][] a)
//  Проверяет, является ли массив квадратным;
    {
        for (int i = 0; i < a.length - 1; i++) {
            int j = 0;
            while (true) {
                int height = a.length;
                int width = a[j].length;
                if (height != width) return false;
                break;
            }
        }
        return true;
    }
//  end task 4=====================================================

//    task 3
    private static int [] lessThanSixMultiplyByTwo (int [] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i] *= 2;
        }
        return a;
    }
//    end task 3===========================================

//  task 2=================================================
    private static int [] increaseByThree (int [] a) {
        a[0] = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 3;
        }
        return a;
    }
//    end task 2==========================================

//  task 1
    private static  int [] swapZeroAndOne (int [] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] += 1;
            } else {a[i] -=1;}
        }
        return a;
    }
}
