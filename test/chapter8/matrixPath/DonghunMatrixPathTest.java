package chapter8.matrixPath;

import org.junit.Assert;
import org.junit.Test;

public class DonghunMatrixPathTest {

	//입력데이터 
	static int[][] dataA = {
		{ 6, 7, 12,  5},
		{ 5, 3, 11, 18},
		{ 7,17,  3,  3},
		{ 8,10, 14,  9}
	};

	@Test
	public void testMatrixPath(){
		int[][] resultA = new int[4][4];
		
		MatrixPath path = new DonghunMatrixPath();
		
		int result = path.matrixPath(dataA, resultA, 3, 3);

		System.out.println("[result Array:TopDown(Recursive)]");
		print(resultA);
		
		Assert.assertEquals(68, result);
	}
	
	@Test
	public void testMatrixPathBottomUp(){
		int[][] resultA = new int[4][4];
		
		MatrixPath path = new DonghunMatrixPathBottomUp();
		
		int result = path.matrixPath(dataA, resultA, 3, 3);

		System.out.println("[result Array:BottomUp]");
		print(resultA);
		
		Assert.assertEquals(68, result);
	}
	
	
	
	private void print(int[][] data){
		for(int i=0; i < data.length; i++){
			for(int j=0; j < data[0].length; j++){
				System.out.print(data[i][j] + " ");
			}
			System.out.print("\n");
		}		
	}
	
}
