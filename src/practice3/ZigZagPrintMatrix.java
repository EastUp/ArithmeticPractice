package practice3;

public class ZigZagPrintMatrix {
    public static void printMatrixZigZag(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = 0;// 左下行
        int dc = 0;// 做下列
        boolean flag = true;
        while (dc <= tc && tr <= dr){
            print(matrix,tr,tc,dr,dc,flag);
            if(tc < matrix[0].length-1)
                tc++;
            else
                tr++;

            if(dr < matrix.length-1)
                dr++;
            else
                dc++;
            flag = !flag;
        }
    }

    private static void print(int[][] matrix, int tr, int tc, int dr, int dc,boolean flag) {
        if(flag){
            while (dc<=tc && dr >= tr){
                System.out.println(matrix[dr--][dc++]);
            }
        }else{
            while (tr<=dr && tc >= dc){
                System.out.println(matrix[tr++][tc-- ]);
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        printMatrixZigZag(matrix);

    }
}
