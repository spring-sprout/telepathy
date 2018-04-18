package chapter8.pebble;

import junit.framework.Assert;

import org.junit.Test;


public class DonghunPebbleTest {

	static int[][] dataA = {
		{ 6,  7, 12, -5, 5,  3, 11, 3},
		{-8, 10, 14,  9, 7, 13,  8, 5},
		{11, 12,  7,  4, 8, -2,  9, 4}
	};

	@Test
	public void testPebble(){
		int[][] resultA = new int[8][4];//7개 열의 데이터, 4개 패턴 결과 용
		int result = Integer.MIN_VALUE;
		int tmp = 0;
		
		Pebble pebble = new DonghunPebble();
		
		for(int p=0; p < 4; p++){
			tmp = pebble.pebble(dataA, resultA, 7, p);
			if(tmp > result){
				result = tmp;
			}
		}
		
		System.out.println("result=" + result);
		Assert.assertEquals(106, result);
		print(resultA);
	}
	
	@Test
	public void testPebbleBottomUp(){
		int[][] resultA = new int[8][4];//7개 열의 데이터, 4개 패턴 결과 용
		int result = Integer.MIN_VALUE;
		
		PebbleBottomUp pebble = new DonghunPebbleBottomUp();
		
		result = pebble.pebble(dataA, resultA);
		
		System.out.println("result=" + result);
		Assert.assertEquals(106, result);
		print(resultA);
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
