package ru.geekbrains;
import java.util.Arrays; // для вывода массива в качестве строки

public class lesson_2 {
    public static void main(String[] args) {
        int[] testarray = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Заданный массив:\t\t" + Arrays.toString(testarray));
        changenumber(testarray);
        System.out.println("Обработанный массив:\t" + Arrays.toString(testarray));
    }

    /**
     * 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод,
     * заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static void changenumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] == 1 ? 0 : 1;
        }
    }

}

