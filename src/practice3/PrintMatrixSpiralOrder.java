package practice3;

public class PrintMatrixSpiralOrder {
    public static void spiralOrderPrint(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while(tr <= dr && tc <= dc){
            sprint(matrix,tr++,tc++,dr--,dc--);
        }

    }

    private static void sprint(int[][] matrix, int tr, int tc, int dr, int dc) {
        if(tr == dr){
            for (int i=tc; i<=dc;i++)
                System.out.println(matrix[tr][i]);
        }else if(tc == dc){
            for (int i=tr; i<=dr;i++)
                System.out.println(matrix[i][tc]);
        }else{
            int sr = tr;
            int sc = tc;
            while (sc < dc){
                System.out.println(matrix[tr][sc++]);
            }

            while (sr < dr){
                System.out.println(matrix[sr++][dc]);
            }

            while (sc > tc){
                System.out.println(matrix[dr][sc--]);
            }

            while (sr > tr){
                System.out.println(matrix[sr--][sc]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        spiralOrderPrint(matrix);

    }
}
