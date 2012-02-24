package chapter3;

import static org.junit.Assert.*;
/**
 * 정렬 검증 관련 유틸리티 클래스
 * @author rotoshine
 *
 */
public class AssertSortUtil {
	
	/**
	 * 배열이 정렬되었는지 여부를 검증한다.
	 * @param input
	 * @return
	 */
	public static void assertSort(int[] input){
		boolean isSort = true;
		for(int i = 0 ; i < input.length - 1; i++){
			isSort =  input[i] <= input[i + 1];
			if( !isSort ){
				StringBuilder failMessage = new StringBuilder();
				for(int k = 0 ; k < input.length; k++){
					failMessage.append(input[k] + " ");
				}
				fail("정렬되지 않은 배열입니다.[" + failMessage.toString() + "]");
			}
		}
	}
}
