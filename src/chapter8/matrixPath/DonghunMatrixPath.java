package chapter8.matrixPath;

/**
 * 
 * @author donghun kim
 *
 */
public class DonghunMatrixPath implements MatrixPath {

	@Override
	public int  matrixPath(int[][] dataA, int[][] resultA, int i, int j) {

		int result = 0;
		
		if(i==0 && j == 0){
			result = dataA[i][j];
		}else if(i==0){
			result = dataA[i][j] + matrixPath(dataA, resultA, 0, j-1);
		}else if(j==0){
			result = dataA[i][j] + matrixPath(dataA, resultA, i-1, 0);
		}else{
			result = dataA[i][j] + max(matrixPath(dataA, resultA, i-1, j), matrixPath(dataA, resultA, i, j-1));
		}
		
		resultA[i][j] = result;
		
		return result;
	}
	
	private int max(int a, int b){
		if(a>b){
			return a;
		}else{
			return b;
		}
	}
	
}
