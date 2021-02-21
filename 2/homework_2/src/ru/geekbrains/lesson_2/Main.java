package ru.geekbrains.lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int [] changeIt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(swapZeroAndOne((changeIt))));
        System.out.println("end task______________________________________________");

        int [] byThree = new int [8];
        System.out.println(Arrays.toString(increaseByThree(byThree)));
        System.out.println("end task______________________________________________");

        int [] multiplyByTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(lessThanSixMultiplyByTwo(multiplyByTwo)));
        System.out.println("end task______________________________________________");

        int [][] oneToDiagonal = {{2, 3, 4, 5}, {5, 6, 7, 8}, {2, 3, 4, 5}, {2, 3, 4, 5}};
        int [][] falseOneToDiagonal = {{2, 3, 4, 5}, {5, 6, 7, 8}, {2, 3, 4, 5}};

        mainMatrix(oneToDiagonal);
        mainMatrix(falseOneToDiagonal);
        System.out.println("end task______________________________________________");
    }

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
