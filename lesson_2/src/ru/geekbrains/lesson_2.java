package ru.geekbrains;
import java.util.Arrays; // для вывода массива в качестве строки

public class lesson_2 {
    public static void main(String[] args) {
        int[] testArray = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        System.out.println("Заданный массив:\t\t" + Arrays.toString(testArray));
        changeNumber(testArray);
        System.out.println("Обработанный массив:\t" + Arrays.toString(testArray));

        int[] ascArr = new int[8];
        fillArrAsc(ascArr);
        System.out.println("Заполненный массив: " + Arrays.toString(ascArr));

        testArray = new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Заданный массив:\t\t" + Arrays.toString(testArray));
        multArr(testArray);
        System.out.println("Обработанный массив:\t" + Arrays.toString(testArray));

        System.out.printf("Min: %d\nMax: %d", minNumber(testArray), maxNumber(testArray));
    }

    /**
     * 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
     * Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод,
     * заменяющий в принятом массиве 0 на 1, 1 на 0;
     */
    private static void changeNumber(int[] arr) {
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

    /** 3 Задать массив
     *[ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ],
     * написать метод, принимающий на вход массив
     * и умножающий числа меньше 6 на 2;
     */
    private static void multArr(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if (arr[i] < 6){
                arr[i] *= 2;
            }
        }
    }

    /**
     * 4 Задать одномерный массив.
     * Написать методы поиска в нём минимального
     * и максимального элемента;
     */
    private static int minNumber(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    private static int maxNumber(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}