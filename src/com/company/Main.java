package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите размер матрицы");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Random random = new Random();

        int[][] array = new int[n][n];
        for (int i = 0; i < array.length; i++) {           // заполняем матрицу числами
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = random.nextInt(50);
            }
        }

        for (int i = 0; i < array.length; i++) {           // выводим матрицу
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


        int sum = 0;
        for (int i = 0; i < array.length; i++) {           // сумма четных элементов на главной диагонали
            for (int j = 0; j < array[i].length; j++) {
                if (i == j && array[i][j] % 2 == 0) {
                    sum += array[i][j];
                }
            }
        }
        System.out.println("1) Сумма четных элементов на главной диагонали равна " + sum);
        System.out.println();

        System.out.print("2) Вывод нечетных элементов под главной диагональю (включительно) ");
        for (int i = 0; i < array.length; i++) {           // вывод нечетных элементов под главной диагональю (включительно)
            for (int j = 0; j <= i; j++) {
                if (array[i][j] % 2 != 0) {
                    System.out.print(+array[i][j] + " ");
                }
            }
        }
        System.out.println();

        int productGeneral = 1;
        int productSecondary = 1;
        for (int i = 0; i < array.length; i++) {           // проверка произведений элементов какой диагонали больше
            for (int j = 0; j <= i; j++) {                 // произведение элементов главной диагонали
                if (i == j) {
                    productGeneral *= array[i][j];
                }
            }
        }

        for (int i = 0; i < array.length; i++) {           // проверка произведений элементов какой диагонали больше
            int j = array[i].length - i - 1;             // произведение элементов побочной диагонали
            productSecondary *= array[i][j];
        }

        System.out.println();
        if (productGeneral > productSecondary) {
            System.out.println("3)Произведение элементов главной диагонали равно " + productGeneral + " ,произведение элементов побочной диагонали равно " +
                    +productSecondary + ". Произведение элементов главной диагонали больше.");
        } else if (productGeneral < productSecondary) {
            System.out.println("3)Произведение элементов главной диагонали равно " + productGeneral + " ,произведение элементов побочной диагонали равно " +
                    +productSecondary + ". Произведение элементов побочной диагонали больше.");
        } else {
            System.out.println("3)Произведение элементов главной диагонали равно " + productGeneral + " ,произведение элементов побочной диагонали равно " +
                    +productSecondary + ". Произведение элементов диагоналей равны.");
        }

        int sum2=0;
        for (int i = 0; i < array.length; i++) {           // сумма четных элементов над побочной диагональю не включительно
            for (int j = 0; j < array[i].length-i-1; j++) {
                if (array[i][j] % 2 ==0){
                    sum2+=array[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("4)Сумма четных элементов над побочной диагональю не включительно: "+sum2);

        System.out.println();
        System.out.println("5)Транспонированная матрица:");
        int t = 0;
        int f = 0;
        for (int i = 0; i < n; i++) {           // транспонирование матрицы
            for (int j = 0; j < i; j++) {
                t=array[i][j];
                f=array[j][i];
                array[i][j]=f;
                array[j][i]=t;

            }
        }
        for (int i = 0; i < array.length; i++) {           // выводим  новую матрицу
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }


    }
}


