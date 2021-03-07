package ru.geekbrains.lesson_4;

import java.util.Scanner;

public class Main {
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    private static final boolean AI_TURN = true;
    private static final boolean HUMAN_TURN = false;

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        game();
        System.out.println("Игра закончена");
    }

    public static void game()
//  Основной игровой цикл
    {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();

            if (checkWin(DOT_X, map)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn(map);
            printMap();

            if (checkWin(DOT_O, map)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }

            if (isMapFull()) {
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

    public static void printMap()
//  Вывод игрового поля в консоль
    {
        System.out.println();
        System.out.print("             ");
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print("             ");
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
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
        map[x][y] = DOT_X;
    }

    public static boolean isNotCellValid(int x, int y)
//  Проверка на валидность ячейки
    {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return true;
        return map[x][y] != DOT_EMPTY;
    }

    public static boolean checkWin(char symbol, char[][] board)
//  Проверка победы
    {
        for (int col = 0; col < DOTS_TO_WIN; col++) {
            for (int row = 0; row < DOTS_TO_WIN; row++) {
                if (checkDiagonal(symbol) || checkLine(symbol)) return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char symbol)
//  Проверка заполненности диагоналей
    {
//        char[][] board = new char [DOTS_TO_WIN][DOTS_TO_WIN];
        boolean toRight, toLeft;
        toRight = true;
        toLeft = true;
        for (int i = 0; i < DOTS_TO_WIN; i++) {
            toRight &= (map[i][i] == symbol);
            toLeft &= (map[DOTS_TO_WIN - i - 1][i] == symbol);
        }
        return toRight || toLeft;
    }

    public static boolean checkLine(char symbol)
//  Проверка заполненности строк и столбцов
    {
//        char[][] board = new char [DOTS_TO_WIN][DOTS_TO_WIN];
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

    public static boolean isMapFull()
//  Проверка на заполненность игрового поля
    {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }

    private static void aiTurn(char[][] board)
//  Ход ИИ
    {
        int [] move = new int[2];
        int x = move[0];
        int y = move[1];
        do {
            int bestScore = Integer.MIN_VALUE;
            board = deepClone(board);
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board.length; row++) {
                    if (board[col][row] == DOT_EMPTY) {
                        board[col][row] = DOT_O;
                        int score = minimax(board, 0, HUMAN_TURN);
                        board[col][row] = DOT_EMPTY;
                        if (score > bestScore) {
                            bestScore = score;
                            x = col;
                            y = row;
                        }
                    }
                }
            }
        } while (isNotCellValid(x, y));
        System.out.println("Компьютер походил в точку " + (y + 1) + " " + (x + 1));
        map[x][y] = DOT_O;
    }

    private static int minimax(char[][] board, int depth, boolean isAiTurn)
//  Логика ИИ
    {
        int bestScore;
        if (isAiTurn){
            bestScore = Integer.MIN_VALUE/2;
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board.length; row++) {
                    if (board[col][row] == DOT_EMPTY){
                        board[col][row] = DOT_O;
                        int score = minimax(board, depth + 1, HUMAN_TURN);
                        bestScore = checkScore(board);
                        board[col][row] = DOT_EMPTY;
                        bestScore = Math.max(bestScore, score);
                        break;
                    }
                }
            }
        } else {
            bestScore = Integer.MAX_VALUE/2;
            for (int col = 0; col < board.length; col++) {
                for (int row = 0; row < board.length; row++) {
                    if (board[col][row] == DOT_EMPTY){
                        board[col][row] = DOT_X;
                        int score = minimax(board, depth + 1, AI_TURN);
                        bestScore = checkScore(board);
                        board[col][row] = DOT_EMPTY;
                        bestScore = Math.min(bestScore, score);
                        break;
                    }
                }
            }
        }
        return bestScore;
    }

    private static char[][] deepClone(char[][] originMap)
//  Создает копию многомерного массива
    {
        char[][] copy = new char[originMap.length][originMap.length];
        for (int i = 0; i < originMap.length; i++) {
            System.arraycopy(originMap[i], 0, copy[i], 0, originMap.length);
        }
        return copy;
    }

    private static int checkScore (char[][] map)
//  Определяет ценность хода
    {
        if (checkWin(DOT_O, map)) return 10;
        else if (checkWin(DOT_X, map)) return -10;
        return 0;
    }
}
