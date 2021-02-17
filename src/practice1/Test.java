package practice1;

import java.util.Arrays;

/**
 * @author : East
 * @date : 2021/2/11
 * @description :
 */
public class Test {
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
            mergeSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }



    private static void mergeSort(int arr[]){
        if(arr == null || arr.length < 2)
            return;
        int l = 0;
        int r = arr.length - 1;
        mergeSort(arr,l,r);
    }

    private static void mergeSort(int arr[],int l,int r){
        if(l == r)
            return;
        int mid = l + ((r-l) >> 1);
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);
        if(arr[mid]>arr[mid+1])
            merge(arr,l,mid,r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1<=mid && p2<=r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while(p1 <= mid)
            help[i++] = arr[p1++];

        while (p2 <= r)
            help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) {
            arr[l+i] = help[i];
        }
    }

    private static void swap(int[] arr, int i,int j){
        if(i == j)
            return;
//        System.out.println("之前 a = " + arr[i] + "， b = "+arr[j]);
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
//        System.out.println("之后 a = " + arr[i] + "， b = "+arr[j]);
    }
}
