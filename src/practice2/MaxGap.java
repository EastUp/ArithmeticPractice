package practice2;

import java.util.Arrays;

public class MaxGap {

    // for test
    public static int comparator(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int gap = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            gap = Math.max(nums[i] - nums[i - 1], gap);
        }
        return gap;
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
            if (maxGap(arr1) != comparator(arr2)) {
                printArray(arr2);
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }


    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        if(max == min){
            return 0;
        }

        int bucketLen = arr.length + 1;
        boolean[] hasNum = new boolean[bucketLen];
        int[] minBucket = new int[bucketLen];
        int[] maxBucket = new int[bucketLen];

        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i]-min) * arr.length / (max - min);
            minBucket[bucketIndex] = hasNum[bucketIndex] ? Math.min(minBucket[bucketIndex],arr[i]) : arr[i];
            maxBucket[bucketIndex] = hasNum[bucketIndex] ? Math.max(maxBucket[bucketIndex],arr[i]) : arr[i];
            hasNum[bucketIndex] = true;
        }

        int res = 0;
        int lastMax = maxBucket[0];  // 0这个值肯定有
        int i = 1;
        for (; i< bucketLen; i++){
            if(hasNum[i]){
                res = Math.max(res,minBucket[i]-lastMax);
                lastMax = maxBucket[i];
            }
        }
        return res;
    }
}
