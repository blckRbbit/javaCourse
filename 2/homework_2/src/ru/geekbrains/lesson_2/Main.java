package ru.geekbrains.lesson_2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	    int [] changeIt = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(swapZeroAndOne((changeIt))));

        int [] byThree = new int [8];
        System.out.println(Arrays.toString(increaseByThree(byThree)));

        int [] multiplyByTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(lessThanSixMultiplyByTwo(multiplyByTwo)));

        int [][] diagonalForOne = new int[3][3];
    }

    private static int [][] fillTheDiagonalsWithOnes (int [][] a) {
        return a;
    }

    private static int [] lessThanSixMultiplyByTwo (int [] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 6) a[i] *= 2;
        }
        return a;
    }

    private static int [] increaseByThree (int [] a) {
        a[0] = 0;
        for (int i = 0; i < a.length; i++) {
            a[i] = i * 3;
        }
        return a;
    }

    private static  int [] swapZeroAndOne (int [] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                a[i] += 1;
            } else {a[i] -=1;}
        }
        return a;
    }
}
