package quize.number02;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Keesun Baik
 */
public class KeesunAlienNumbers {

	public String alienize(String alienNum, String sourceSystem, String targetSystem){
		String sourceLang = sourceSystem;
		char[] source = sourceLang.toCharArray();
		int sourceLength = source.length;

		String input = alienNum;
		int inputLength = input.length();

		int result = 0;
		int index = 1;
		for(Character num : input.toCharArray()) {
			int digit = indexOf(num, source);
			int zeros = 1;
			for(int j = 0 ; j < inputLength - index ; j++) {
				zeros *= sourceLength;
			}
			index++;
			result += digit * zeros;
		}

		char[] target = targetSystem.toCharArray();
		int targetLength = target.length;
		List<Character> resultString = new ArrayList<Character>();
		while (result/targetLength > targetLength - 1) {
			resultString.add(0, target[result%targetLength]);
			result /= targetLength;
		}
		resultString.add(0, target[result%targetLength]);
		if(result/targetLength != 0) {
			resultString.add(0, target[result/targetLength]);
		}

		String resultLang = "";
		for(Character character : resultString) {
			resultLang += character;
		}
		
		return resultLang;
	}

	private int indexOf(Character wantedNum, char[] source) {
		for(int i = 0 ; i < source.length ; i++) {
			if(source[i] == wantedNum) {
				return i;
			}
		}
		return -1;
	}

}
