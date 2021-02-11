package practice1;

/**
 * @author : East
 * @date : 2021/2/11
 * @description :
 */
public class Test {
    public static void main(String[] args) {
        int[] arr = {2,2};
        swap(arr,0,1);
    }

    private static void swap(int[] arr, int i,int j){
        System.out.println("之前 a = " + arr[i] + "， b = "+arr[j]);
        arr[i] = arr[i]^arr[j];
        arr[j] = arr[i]^arr[j];
        arr[i] = arr[i]^arr[j];
        System.out.println("之后 a = " + arr[i] + "， b = "+arr[j]);
    }
}
