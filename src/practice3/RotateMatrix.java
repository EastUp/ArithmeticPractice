package practice3;

public class RotateMatrix {
    public static void rotate(int[][] matrix){
        int tr = 0;
        int tc = 0;
        int dr = matrix.length - 1;
        int dc = matrix[0].length - 1;
        while (tr < dr){
            rotateEdge(matrix,tr++,tc++,dr--,dc--);
        }
    }

    private static void rotateEdge(int[][] matrix, int tr, int tc, int dr, int dc) {
        int curc = 0;
        while (curc < dc-tc){
            int temp = matrix[dc - curc][tc];
            matrix[dc - curc][tc] = matrix[dr][dc - curc];
            matrix[dr][dc - curc] = matrix[curc+tc][dc];
            matrix[curc+tc][dc] = matrix[tr][curc+tc];
            matrix[tr][curc+tc] = temp;
            curc++;
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
