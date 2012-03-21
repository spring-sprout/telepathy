package quize.number02;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class KeesunAlienNumbersTest {

	@Test
	public void alienize() throws Exception {
		KeesunAlienNumbers numbers = new KeesunAlienNumbers();
		String result = numbers.alienize("12345", "0123456789", "0123456789");
		assertThat(result, is("12345"));

		// 9 0123456789 oF8
		result = numbers.alienize("9", "0123456789", "oF8");
		assertThat(result, is("Foo"));

		// Foo oF8 0123456789
		result = numbers.alienize("Foo", "oF8", "0123456789");
		assertThat(result, is("9"));

		// 13 0123456789abcdef 01
		result = numbers.alienize("13", "0123456789abcdef", "01");
		assertThat(result, is("10011"));

		// CODE O!CDE? A?JM!.
		result = numbers.alienize("CODE", "O!CDE?", "A?JM!.");
		assertThat(result, is("JAM!"));
	}

	@Test
	public void googleCodeJam() throws IOException {
		KeesunAlienNumbers alienNumbers = new KeesunAlienNumbers();
		BufferedReader in = new BufferedReader(new FileReader("/workspace/telepathy/test/quize/number02/A-large-practice.in"));
		String s;
		int lineNum = 0;
		int problemNum = 0;
		String answer = "";
		while ((s = in.readLine()) != null) {
			if(s.isEmpty()) {
				return;
			}
			if(lineNum == 0) {
				problemNum = Integer.parseInt(s);
			} else {
				String[] inputs = s.split(" ");
				answer += "Case #" + lineNum + ": " + alienNumbers.alienize(inputs[0], inputs[1], inputs[2]) + "\n";
			}
			lineNum++;
		}
		in.close();

		System.out.println(answer);

		BufferedWriter out = new BufferedWriter(new FileWriter("/workspace/telepathy/test/quize/number02/A-large-practice.out"));
		out.write(answer);
		out.close();
	}

}
