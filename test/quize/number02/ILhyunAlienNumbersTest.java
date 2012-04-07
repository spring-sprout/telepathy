package quize.number02;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @author iLhyun
 *
 */
public class ILhyunAlienNumbersTest {

	@Test
	public void codeJamTest() throws Exception {
		ILhyunAlienNumbers numbers = new ILhyunAlienNumbers();
		String result = "";
		// 9 0123456789 oF8
		result = numbers.codeJam("9", "0123456789", "oF8");
		assertThat(result, is("Foo"));

		// Foo oF8 0123456789
		result = numbers.codeJam("Foo", "oF8", "0123456789");
		assertThat(result, is("9"));

		// 13 0123456789abcdef 01
		result = numbers.codeJam("13", "0123456789abcdef", "01");
		assertThat(result, is("10011"));

		// CODE O!CDE? A?JM!.
		result = numbers.codeJam("CODE", "O!CDE?", "A?JM!.");
		assertThat(result, is("JAM!"));
	}
	
	@Test
	public void smallInputTest() throws IOException {
		ILhyunAlienNumbers number = new ILhyunAlienNumbers();
		BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-small-practice.in"));
		String input;
		int n = 0;
		String output = "";
		while ((input = in.readLine()) != null) {
			if(n > 0){
				String[] inputs = input.split(" ");
				output += "Case #" + n + ": " + number.codeJam(inputs[0], inputs[1], inputs[2]) + "\n";
			}
			n++;
		}
		in.close();
		
		System.out.println(output);
		
		BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-small-practice.out"));
		out.write(output);
		out.close();
	}
	
	@Test
	public void largeInputTest() throws IOException {
		ILhyunAlienNumbers number = new ILhyunAlienNumbers();
		BufferedReader in = new BufferedReader(new FileReader("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-large-practice.in"));
		String input;
		int n = 0;
		String output = "";
		while ((input = in.readLine()) != null) {
			if(n > 0){
				String[] inputs = input.split(" ");
				output += "Case #" + n + ": " + number.codeJam(inputs[0], inputs[1], inputs[2]) + "\n";
			}
			n++;
		}
		in.close();

		System.out.println(output);

		BufferedWriter out = new BufferedWriter(new FileWriter("/Users/enosent7/eno-java/workspace/Test/telepathy/test/quize/number02/A-large-practice.out"));
		out.write(output);
		out.close();
	}
}
