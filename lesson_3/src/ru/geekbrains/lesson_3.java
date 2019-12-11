package ru.geekbrains;
import java.util.Random;
import java.util.Scanner;
public class lesson_3 {

    private static final char DOT_HUMAN = 'X';                       // Символ игрока, постоянная переменная (final)
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '.';                       // Символ пустой клетки
    private static final Scanner SCANNER = new Scanner(System.in);   // Чтения пользовательского ввода.
                                                                     // Создание сканера из пакета import java.util.Scanner;
                                                                     // Создали объект SCANNER и положили туда ссылку
                                                                     // Ввод информации (System.in)
    private static final Random RANDOM = new Random();              // Генерация случайных значений
    private static char[][] field;                                  // Поле для игры
    private static int fieldSizeX;                                  // Размер поля по Х
    private static int fieldSizeY;                                  // Размер поля по У

    /**
     * Инициализация переменных для игры и заполнения поля клетками
     */
    private static void initField() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                field[y][x] = DOT_EMPTY;                       // Заполнение полей символами "."
            }
        }
    }

    /**
     * Вывод содержимого поля для игры в консоль
     */
    private static void printField() {
        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++)           // Цикл по строкам
            System.out.print((i % 2 == 0) ? "-" : i / 2 + 1);  // Координаты столбцов
        System.out.println();                                 // Перенос строки

        for (int i = 0; i < fieldSizeY; i++) {                  // Цикл по столбцам внутри строки
            System.out.print(i + 1 + "|");                       // Вывод значения столбца и разделитель
            for (int j = 0; j < fieldSizeX; j++)
               System.out.print(field[i][j] + "|");             //Вывод значения столбца и разделитель
            System.out.println();                               // Переход на новую строку
        }

        for (int i = 0; i < fieldSizeX * 2 + 2; i++) // ________________
            System.out.print("-");
        System.out.println();
    }

    /**
     * Ход игрока. Запрос координат
     */
    private static void humanTurn() {
        int x; // Координаты клеточек
        int y; // Координаты клеточек
        do {
            System.out.printf("Введите координаты X (от 1 до %d) и Y (от 1 до %d) через пробел>>> ", fieldSizeX, fieldSizeY);
            // System.out.println("Р’РІРµРґРёС‚Рµ, РїРѕР¶Р°Р»СѓР№СЃС‚Р°, РєРѕРѕСЂРґРёРЅР°С‚С‹ X РѕС‚ 1 РґРѕ 3 Рё Y РѕС‚ 1 РґРѕ 3 С‡РµСЂРµР· РїСЂРѕР±РµР»");
            x = SCANNER.nextInt() - 1;                        // Пользовательский ввод и консоль. Введенное число -1
            y = SCANNER.nextInt() - 1;                        // Пользовательский ввод и консоль
        } while (!isValidCell(x, y) || !isEmptyCell(x, y));  // Возврат в цикл, если пользователь ввёл не
                                                            // валидные значения, или не попал в пустую ячейку
        field[y][x] = DOT_HUMAN;                           // По координатам Х и У - точка
    }

    /**
     * Проверка ячеек на валидность
     */
    private static boolean isValidCell(int x, int y) {  // Валидная ячека находится по координатам Х и У
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == DOT_EMPTY; // true - если поле пустое
    }

    /**
     * Ход AI
     */
    private static void aiTurn() {
        int x;
        int y;
        do {
            x = RANDOM.nextInt(fieldSizeX); // Возвращает случайные значения. Принимает границы случайности (fieldSizeX)
            y = RANDOM.nextInt(fieldSizeY); // Возвращает случайные значения. Принимает границы случайности (fieldSizeX)
        } while (!isEmptyCell(x, y));
        field[y][x] = DOT_AI;
    }

    private static boolean checkWin(char c) {
        boolean row;                         // Результат сравнения содержимого ячейки поля с символом "с"
        boolean col;
        boolean diag1 = true;
        boolean diag2 = true;
        for (int i = 0; i < fieldSizeY; i++){
            row = true;
            col = true;
            if (field[i][i] != c){
                diag1 = false;
            }
            if (field[fieldSizeY - i - 1][i] != c){
                diag2 = false;
            }
            for (int j = 0; j < fieldSizeX; j++){
                if (field[i][j] != c){
                    row = false;
                }
                if (field[j][i] != c){
                    col = false;
                }
                if (!row && !col) break;
            }
            if (row || col) return true;
        }
        return diag1 || diag2;
    }

      private static boolean isDraw() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }

    /**
     * Входа в программу
     */
    public static void main(String[] args) {
        initField();  // Старт игры
        printField(); // Старт игры
        while (true) {
            humanTurn();
            printField();
            if (checkWin(DOT_HUMAN)) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
            aiTurn();
            printField();
            if (checkWin(DOT_AI)) {
                System.out.println("Computer win!");
                break;
            }
            if (isDraw()) {
                System.out.println("Draw!");
                break;
            }
        }
    }

}
