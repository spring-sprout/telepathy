package quize.number01;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class ILhyunRankServiceTest {

	private RankingService rankingService;
	
	@Before
	public void setUp(){
		rankingService = new ILhyunRankService();
	}
	
	@Test
	public void rankTest() throws Exception {
		int[] scores = new int[] { 80, 80, 60, 100 };
		int[] output = new int[] {2, 2, 3, 1};

		int[] rank = rankingService.rank(scores);
		
		int size = rank.length;
		for(int loop = 0; loop < size; loop++){
			assertThat(rank[loop], is(output[loop]));
		}
	}
	
	@Test
	public void sortTest() throws Exception {
		int[] input  = new int[]{8, 31, 48, 73, 3, 65, 20, 29, 11, 15};
		int[] output = new int[]{9, 4, 3, 1, 10, 2, 6, 5, 8, 7};

		int[] rank = rankingService.rank(input);
		
		int size = rank.length;
		for(int loop = 0; loop < size; loop++){
			assertThat(rank[loop], is(output[loop]));
		}
	}
}
