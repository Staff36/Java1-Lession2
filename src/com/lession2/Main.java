package com.lession2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        System.out.println("Задание 1:");

        int [] firstTaskArray={1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        System.out.println(Arrays.toString(firstTaskArray));

        for (int i=0;i<firstTaskArray.length;i++){
            if (firstTaskArray[i]==0) firstTaskArray[i]=1;
            else firstTaskArray[i]=0;
        }
        System.out.println(Arrays.toString(firstTaskArray));
        System.out.println();

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        System.out.println("Задание 2:");
        int [] secondTaskArray = new int[8];
        int secondTaskValue=0;
        for (int i=0;i<secondTaskArray.length;i++){
            secondTaskArray[i]=secondTaskValue;
            secondTaskValue+=3;
        }
        System.out.println(Arrays.toString(secondTaskArray));
        System.out.println();

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        System.out.println("Задание 3:");
        int [] thirdTaskArray={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(thirdTaskArray));
        for(int i=0;i<thirdTaskArray.length;i++){
            if (thirdTaskArray[i]<6) thirdTaskArray[i]*=2;
        }
        System.out.println(Arrays.toString(thirdTaskArray));
        System.out.println();

    /*
    4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое)
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
     */
        System.out.println("Задание 4:");
        int [][] fourthTaskArray=new int[10][10];

        for (int i=0;i<fourthTaskArray.length;i++){
            fourthTaskArray[i][i]=1;
            fourthTaskArray[i][fourthTaskArray.length-(i+1)]=1;
            System.out.println(Arrays.toString(fourthTaskArray[i]));
        }
        System.out.println();

        // 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        System.out.println("Задание 5:");
        int[] fifthTaskArray= new int[50];

        System.out.println("ОБъявлен массив на "+fifthTaskArray.length+ " элементов");
        //Заполняем, в интернет правда не заглядывал Math помню по ютубу)))
        for (int i=0; i<fifthTaskArray.length; i++){
            fifthTaskArray[i]=(int)(Math.random()*100);
            System.out.println("["+i+"] => "+fifthTaskArray[i]);
        }
        //Находим минимум и максимум
        int fifthTaskMin=fifthTaskArray[0];
        int fifthTaskMax=fifthTaskArray[0];
        for (int i=1; i<fifthTaskArray.length; i++){
            if (fifthTaskArray[i]<fifthTaskMin) fifthTaskMin=fifthTaskArray[i];
            if (fifthTaskArray[i]>fifthTaskMax) fifthTaskMax=fifthTaskArray[i];
        }
        System.out.println("Минимальное значение массива: "+fifthTaskMin);
        System.out.println("Максимальное значение массива: "+fifthTaskMax);
        System.out.println();

    /*6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance
    ([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||,
    эти символы в массив не входят.*/

        System.out.println("Задание 6:");
        int sixthTaskArray[] ={1, 2, 9, 3, 7, 2};
        System.out.println(checkBalance(sixthTaskArray));

    /*7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
    или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1
    (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ].
    При каком n в какую сторону сдвиг можете выбирать сами.*/

        System.out.println("Задание 7:");
        int seventhTaskArray[] ={1, 2, 9, 3, 7, 2, 6, 9, 5, 9, 9,16};
        int index = 5;
        System.out.println(Arrays.toString(seventhTaskArray));
        System.out.println("Выполняем сдвиг на "+index+" позиций");
        moveArray(seventhTaskArray,index);
        System.out.println(Arrays.toString(seventhTaskArray));
    }

    //Метод задания 6
    private static boolean checkBalance (int [] array){
        int leftCounts=0;
        int rightCounts;
        int sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        for(int i=1;i<array.length;i++){
            for (int j=0;j<i;j++){
                leftCounts+=array[j];
            }
            rightCounts=sum-leftCounts;
            if (rightCounts==leftCounts) return true;
            leftCounts=0;
        }
        return false;
    }
    //Метод задания 7
    private static int[] moveArray(int[] array, int index){
        int temp;
        if (index>0) {
            for (int i = 0; i < index; i++) {
                temp=array[array.length-1];
                for (int j=array.length-1;j>0;j--){
                    array[j]=array[j-1];
                }
                array[0]=temp;
            }
        } else if (index<0){
            for (int i = 0; i > index; i--) {
                temp = array[0];
                for (int j=1; j<array.length;j++){
                    array[j-1]=array[j];
                }
                array[array.length-1]=temp;
            }
        }

        return array;
    }



    }

