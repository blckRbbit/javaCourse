package ru.geekbrains.lesson_4;

import java.util.Scanner;

public class Main {
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final boolean AI_TURN = true;
    private static final boolean HUMAN_TURN = false;

    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static char[][] map;


    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
        System.out.println("Игра закончена");
    }

    public static void game()
//  Основной игровой цикл
    {
        initMap();
        printMap(map);
        while (true) {
            humanTurn();
            printMap(map);

            if (checkWin(DOT_X, map)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull(map)) {
                System.out.println("Ничья");
                break;
            }
            aiTurn(map);
            printMap(map);

            if (checkWin(DOT_O, map)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }

            if (isMapFull(map)) {
                System.out.println("Ничья");
                break;
            }
        }
        scanner.close();
    }

    public static void initMap()
//  Инициализация игрового поля
    {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap(char[][] board)
//  Вывод игрового поля в консоль
    {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn()
//  Ход игрока-человека
    {
        int x, y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (isNotCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static boolean isNotCellValid(int x, int y)
//  Проверка на валидность ячейки
    {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
        return map[y][x] != DOT_EMPTY;
    }

    public static boolean checkWin(char symbol, char[][] map)
//  Проверка победы
    {
        for (int col = 0; col < DOTS_TO_WIN; col++) {
            for (int row = 0; row < DOTS_TO_WIN; row++) {
                if (checkDiagonal(symbol, map) || checkLine(symbol, map)) return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char symbol, char[][] map)
//  Проверка заполненности диагоналей
    {
        boolean toRight, toLeft;
        toRight = true;
        toLeft = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            toRight &= (map[i][i] == symbol);
            toLeft &= (map[DOTS_TO_WIN - i - 1][i] == symbol);
        }
        return toRight || toLeft;
    }

    public static boolean checkLine(char symbol, char[][] map)
//  Проверка заполненности строк и столбцов
    {
        boolean cols, rows;
        for (int col = 0; col < DOTS_TO_WIN; col++) {
            cols = true;
            rows = true;
            for (int row = 0; row < DOTS_TO_WIN; row++) {
                cols &= (map[col][row] == symbol);
                rows &= (map[row][col] == symbol);
            }
            if (cols || rows) return true;
        }
        return false;
    }

    public static boolean isMapFull(char[][] board)
//  Проверка на заполненность игрового поля
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void aiTurn(char[][] board)
//  Ход ИИ
    {
        int x;
        int y;
        do {
            int[] move = minimax(map, 0, AI_TURN);
            x = move[1];
            y = move[0];
        } while (isNotCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    private static int[] minimax(char[][] board, int depth, boolean isAiTurn)
//  Логика ИИ
    {
        if (checkWin(DOT_O, board)) {
            return new int[] { 0, 0, 10 };
        } else if (checkWin(DOT_X, board)) {
            return new int[] { 0, 0, -10 };
        } else if (isMapFull(board)) {
            return new int[] { 0, 0, 0 };
        }

        int[] resultValues = new int[3];
        if (isAiTurn){
            int bestScore = Integer.MIN_VALUE;
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board.length; row++) {
                    if (board[col][row] == DOT_EMPTY){
                        board[col][row] = DOT_O;
                        int[] value = minimax(board, depth + 1, HUMAN_TURN);
                        board[col][row] = DOT_EMPTY;

                        if (value[2] > bestScore) {
                            bestScore = value[2];
                            resultValues[2] = bestScore;
                            resultValues[0] = col;
                            resultValues[1] = row;
                        }
                    }
                }
            }
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board.length; row++) {
                    if (board[col][row] == DOT_EMPTY){
                        board[col][row] = DOT_X;
                        int[] value = minimax(board, depth + 1, AI_TURN);
                        board[col][row] = DOT_EMPTY;

                        if (value[2] < bestScore) {
                            bestScore = value[2];
                            resultValues[2] = bestScore;
                            resultValues[0] = col;
                            resultValues[1] = row;
                        }
                    }
                }
            }
        }
        return resultValues;
    }
}
