package quize.number04;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import quize.number04.DaewonSpeakingInTongues;

public class DaewonSpeakingInTonguesTest {

	@Test
	public void test() {
		DaewonSpeakingInTongues solution = new DaewonSpeakingInTongues();
		String input = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
		String output = "our language is impossible to understand";
		Assert.assertEquals(output, solution.solve(input));

		input = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
		output = "there are twenty six factorial possibilities";
		Assert.assertEquals(output, solution.solve(input));

		input = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
		output = "so it is okay if you want to just give up";
		Assert.assertEquals(output, solution.solve(input));

	}

	public static void main(String[] args) {

		String googleres = "ejp mysljylc kd kxveddknmc re jsicpdrysi" +
				"rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd" +
				"de kr kd eoya kw aej tysr re ujdr lkgc jv";

		String english = "our language is impossible to understand" +
				"there are twenty six factorial possibilities" +
				"so it is okay if you want to just give up";

		// googleres : english
		Map<String, String> g2eMaps = new HashMap<String, String>();
		for (int i = 0; i < googleres.length(); i++) {
			g2eMaps.put(googleres.charAt(i) + "", english.charAt(i) + "");
		}

		Set<String> keySet = g2eMaps.keySet();
		Object[] googleresChars = keySet.toArray();
		Arrays.sort(googleresChars);
		for (Object gChar : googleresChars) {
			System.out.println(gChar + ":" + g2eMaps.get(gChar));
		}
	}
}
