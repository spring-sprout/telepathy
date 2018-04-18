package chapter8.matrixPath;

public class DonghunMatrixPathBottomUp implements MatrixPath{

	@Override
	public int matrixPath(int[][] dataA, int[][] resultA, int row, int col) {

		int result = 0;
		
		for(int i=0; i <= row; i++ ){
			for(int j=0; j <= col; j++){
				if(i==0 && j==0){
					result = dataA[0][0];
				}else if(i==0){
					result = dataA[0][j] + resultA[0][j-1];
				}else if(j==0){
					result = dataA[i][0] + resultA[i-1][0];
				}else{
					result = dataA[i][j] +  max(resultA[i-1][j], resultA[i][j-1]);
				}
				
				resultA[i][j] = result;
			}
		}
		
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
