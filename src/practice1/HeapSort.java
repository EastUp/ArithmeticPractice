package practice1;

import java.util.Arrays;

public class HeapSort {

    // for test
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            heapSort(arr1,0,arr1.length);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        heapSort(arr,0,arr.length);
        printArray(arr);
    }

    public static void heapSort(int arr[],int index,int size){
        // 先调整为大根堆  1
        /*for (int i=0;i<size;i++){
            int k = i;
            while (arr[k] > arr[(k-1)/2]){
                swap(arr,k,(k-1)/2);
                k = (k-1)/2;
            }
        }*/
        // 先调整为大根堆  2
        for(int i = size/2-1;i>=0;i--){
            heapify(arr,i,size);
        }


        // 将第一个和最后一个进行交换,从上往下调整为大根堆
        for(int j = size - 1;j>0;j--){
            swap(arr,0,j);
            heapify(arr,0,j);
        }
    }

    public static void heapify(int[] arr,int index,int size){
        int left = index*2+1;
        while (left < size){
            int largest = ((left+1) < size && arr[left+1] > arr[left]) ? left+1 :left;
            largest = arr[largest] > arr[index] ? largest:index;
            if(largest == index)
                break;
            swap(arr,largest,index);
            index = largest;
            left = index*2+1;
        }
    }


    public static void swap(int[] arr,int i,int j){
        arr[i] = arr[i]+arr[j];
        arr[j] = arr[i]-arr[j];
        arr[i] = arr[i]-arr[j];
    }
}
