package chapter8.pebble;

/**
 * 
 * @author donghun kim
 *
 */
public class DonghunPebble implements Pebble {

	//양립할 수 있는 패턴정보 배열 (문제의 row값이 변경이 되면 동적으로 변경할 필요있음)
	static int[][] availablePattern = {
		{1,2}, 		//0번 패턴  (1,2 패턴 양립가능)
		{0,2,3},		//1번 패턴  (0,2,3 패턴 양립가능)
		{0,1},		//2번 패턴  (2 패턴 양립 가능)
		{1}			//3번 패턴  (1 패턴 양립가능)
	};
	
	@Override
	public int pebble(int[][] dataA, int[][] resultA, int col, int pattern) {

		int result = Integer.MIN_VALUE;
		
		if(col == 0){
			result = w(dataA, col, pattern);
		}else{
			//양립할 수 있는 패턴 추출
			int[] q = availablePattern[pattern];
			int tmp = 0;
			
			for(int i=0; i < q.length; i++){
				tmp = pebble(dataA, resultA, col-1, q[i]) +  w(dataA, col, pattern);
				
				if(tmp > result){
					result = tmp;
				}
			}
		}
		
		resultA[col][pattern] = result;//결과 검증용으로 중간단계 결과들 저장
		
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
