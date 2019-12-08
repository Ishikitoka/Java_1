package ru.geekbrains;
import java.util.Arrays; // для вывода массива в качестве строки

public class lesson_2 {
    public static void main(String[] args) {
        int[] testarray = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Заданный массив:\t\t" + Arrays.toString(testarray));
        changenumber(testarray);
        System.out.println("Обработанный массив:\t" + Arrays.toString(testarray));

        int[] ascArr = new int[8];
        fillArrAsc(ascArr);
        System.out.println("Заполненный массив: " + Arrays.toString(ascArr));
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

    /**
     * 2 Задать пустой
     * целочисленный массив размером 8.
     * Написать метод, который помощью цикла
     * заполнит его значениями 1 4 7 10 13 16 19 22;
     */
    private static void fillArrAsc(int[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = i * 3 + 1;
        }
    }

}

