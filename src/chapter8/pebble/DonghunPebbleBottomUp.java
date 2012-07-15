package chapter8.pebble;

public class DonghunPebbleBottomUp implements PebbleBottomUp {

	//양립할 수 있는 패턴정보 배열 (문제의 row값이 변경이 되면 동적으로 변경할 필요있음)
	static int[][] availablePattern = {
		{1,2}, 		//0번 패턴  (1,2 패턴 양립가능)
		{0,2,3},		//1번 패턴  (0,2,3 패턴 양립가능)
		{0,1},		//2번 패턴  (2 패턴 양립 가능)
		{1}			//3번 패턴  (1 패턴 양립가능)
	};

	@Override
	public int pebble(int[][] dataA, int[][] resultA) {

		//첫번째 열 데이터 설정
		for(int p=0; p < 4; p++){
			resultA[0][p] = w(dataA, 0, p);
		}
		
		int tmp = 0;
		int result = 0; 
		
		for(int i=1; i < dataA[0].length; i++){
			result = Integer.MIN_VALUE;
			
			for(int p=0; p < 4; p++){
				//p와 양립하는 패턴 q
				int[] q = availablePattern[p];
				tmp = maxPreviosValue(resultA, i-1, q) + w(dataA, i, p);
				resultA[i][p] = tmp;//결과저장
				
				if(tmp > result){
					result = tmp;
				}
			}
		}
		
		return result;
	}
	
	private int maxPreviosValue(int[][] resultA, int col, int[] q){
		
		int result = Integer.MIN_VALUE;
		int tmp = 0;
		
		for(int k=0; k < q.length; k++){
			tmp = resultA[col][q[k]];
			if(tmp > result){
				result = tmp;
			}
		}
		
		return result;
	}
	
	
	private int w(int[][] dataA, int i, int p){
		switch(p){
		case 0:
			return dataA[0][i];
		case 1:	
			return dataA[1][i];
		case 2:
			return dataA[2][i];
		case 3:	
		default:
			return dataA[0][i] + dataA[2][i];
		}
	}


}
