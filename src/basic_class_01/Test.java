package basic_class_01;

public class Test {
    public static void main(String[] args) {
        int arr[] = {-4, 6, 10, -10, 3, 4, 5, 6};
        int num = 4;

        int x = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= num) {
                x++;
                if (x != i) {
                    arr[i] = arr[i] ^ arr[x];
                    arr[x] = arr[i] ^ arr[x];
                    arr[i] = arr[i] ^ arr[x];
                }
            }
        }

        printArray(arr);
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

}
