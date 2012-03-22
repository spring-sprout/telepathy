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
		char[] source = sourceSystem.toCharArray();
		int sourceLength = source.length;
		int numberLength = alienNum.length();

		// source 진수를 10 진수로 변환
		int tenDigitNumber = 0;
		int index = 1;
		for(Character num : alienNum.toCharArray()) {
			int digit = indexOf(num, source);
			int zeros = 1;
			for(int j = 0 ; j < numberLength - index ; j++) {
				zeros *= sourceLength;
			}
			index++;
			tenDigitNumber += digit * zeros;
		}

		// 10진수를 target 진수로 변환
		char[] target = targetSystem.toCharArray();
		int targetLength = target.length;
		List<Character> resultString = new ArrayList<Character>();
		while (tenDigitNumber/targetLength > targetLength - 1) {
			resultString.add(0, target[tenDigitNumber%targetLength]);
			tenDigitNumber /= targetLength;
		}
		resultString.add(0, target[tenDigitNumber%targetLength]);
		if(tenDigitNumber/targetLength != 0) {
			resultString.add(0, target[tenDigitNumber/targetLength]);
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
