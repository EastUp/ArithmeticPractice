package class_08;

import java.util.HashMap;

public class Code_07_MinPath {

	public static int minPath1(int[][] matrix) {
		return process1(matrix, matrix.length - 1, matrix[0].length - 1);
	}

	public static int process1(int[][] matrix, int i, int j) {
		int res = matrix[i][j];
		if (i == 0 && j == 0) {
			return res;
		}
		if (i == 0 && j != 0) {
			return res + process1(matrix, i, j - 1);
		}
		if (i != 0 && j == 0) {
			return res + process1(matrix, i - 1, j);
		}
		return res + Math.min(process1(matrix, i, j - 1), process1(matrix, i - 1, j));
	}

	public static int minPath2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] dp = new int[row][col];
		dp[0][0] = m[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i - 1][0] + m[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j - 1] + m[0][j];
		}
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
			}
		}
		return dp[row - 1][col - 1];
	}

	// for test
	public static int[][] generateRandomMatrix(int rowSize, int colSize) {
		if (rowSize < 0 || colSize < 0) {
			return null;
		}
		int[][] result = new int[rowSize][colSize];
		for (int i = 0; i != result.length; i++) {
			for (int j = 0; j != result[0].length; j++) {
				result[i][j] = (int) (Math.random() * 10);
			}
		}
		return result;
	}

	public static int walk(int[][] matrix,int i,int j){
		if(i == matrix.length-1 && j == matrix[0].length-1){
			return matrix[i][j];
		}
		if(i == matrix.length - 1){
			return matrix[i][j]+walk(matrix,i,j+1);
		}
		if(j == matrix[0].length - 1){
			return matrix[i][j] + walk(matrix,i+1,j);
		}
		int rightPath = walk(matrix,i,j+1);  // 右边位置到右下角的最短距离
		int downPath = walk(matrix,i+1,j);   // 下边位置到右下角的最短距离
		return matrix[i][j]+Math.min(rightPath,downPath);
	}

	static HashMap<String,Integer> cache = new HashMap<>();

	public static int walk2(int[][] matrix,int i,int j){
		int result = 0;
		if(i == matrix.length-1 && j == matrix[0].length-1){
			result =  matrix[i][j];
		}else if(i == matrix.length - 1){
			int next = 0;
			String nextKey = String.valueOf(i)+"_"+String.valueOf(j+1);
			if(cache.containsKey(nextKey)){
				next = cache.get(nextKey);
			}else{
				next = walk2(matrix,i,j+1);
			}
			result = matrix[i][j]+next;
		}else if(j == matrix[0].length - 1){
			int next = 0;
			String nextKey = String.valueOf(i+1)+"_"+String.valueOf(j);
			if(cache.containsKey(nextKey)){
				next = cache.get(nextKey);
			}else{
				next = walk2(matrix,i+1,j);
			}
			result = matrix[i][j] + next;
		}else{
			int rightNext = 0;
			String rightNextKey = String.valueOf(i)+"_"+String.valueOf(j+1);
			if(cache.containsKey(rightNextKey)){
				rightNext = cache.get(rightNextKey);
			}else{
				rightNext = walk2(matrix,i,j+1);
			}

			int downNext = 0;
			String downNextKey = String.valueOf(i+1)+"_"+String.valueOf(j);
			if(cache.containsKey(downNextKey)){
				downNext = cache.get(downNextKey);
			}else{
				downNext = walk2(matrix,i+1,j);// 下边位置到右下角的最短距离
			}
			result = matrix[i][j]+Math.min(rightNext,downNext);
		}
		String key = String.valueOf(i)+"_"+String.valueOf(j);
		cache.put(key,result);
		return result;
	}

	public static void main(String[] args) {
		int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));

		m = generateRandomMatrix(6, 7);
		System.out.println(minPath1(m));
		System.out.println(minPath2(m));
		System.out.println(walk(m,0,0)+"");
		System.out.println(walk2(m,0,0)+"");
	}
}
