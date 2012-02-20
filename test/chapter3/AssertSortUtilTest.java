package chapter3;

import org.junit.Test;
import static chapter3.AssertSortUtil.*;
import junit.framework.TestCase;

/**
 * 정렬 검증 관련 유틸리티 클래스의 테스트 케이스.
 * @author rotoshine
 *
 */
public class AssertSortUtilTest extends TestCase {

	@Test
			public void testAssertSort(){
				assertSort(new int[]{1, 2, 3, 4, 5});
				assertSort(new int[]{1, 1, 1, 1, 1});
				try{
					assertSort(new int[]{1, 2, -1});
					fail();
				}catch(AssertionError ae){
					
				}
				
			}
}
