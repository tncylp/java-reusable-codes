package Algorithms;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main(String[] args) {

        int[] arr = {3,6,8,7,5,1,4,2};

        insertionSort(arr);

        System.out.println(Arrays.toString(arr));;

    }

    public static void bubbleSort(int[] arr){
        boolean sorted = false;
        int temp;

        while(!sorted){
            sorted = true;

            for(int i = 0; i<arr.length-1; i++){
                if(arr[i]>arr[i+1]){
                    temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
    }

    public static void selectionSort(int[] arr){

        for (int i=0; i < arr.length; i++) {
            int min = arr[i];
            int minId = i;

            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<min){
                    min = arr[j];
                    minId = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minId] = temp;
        }
    }

}
