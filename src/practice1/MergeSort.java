package practice1;

import java.util.Arrays;

public class MergeSort {


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

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            mergeSort(arr1,0,arr1.length-1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr,0,arr.length-1);
        printArray(arr);
    }

    public static void mergeSort(int arr[],int l,int r){
        if(l >=r){
            return;
        }
        int mid = (l+r)>>1;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        if(arr[mid] > arr[mid+1])
            merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r-l+1];
        for(int i = 0;i < temp.length;i++){
            temp[i] = arr[i+l];
        }

        int i = l;
        int j = mid+1;
        for (int k = l; k<=r;k++){
            if(i > mid){
                arr[k] = temp[j-l];
                j++;
            }else if(j > r){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l]<temp[j-l]){
                arr[k] = temp[i-l];
                i++;
            }else if(temp[i-l]>temp[j-l]){
                arr[k] = temp[j-l];
                j++;
            }
        }

    }
}
