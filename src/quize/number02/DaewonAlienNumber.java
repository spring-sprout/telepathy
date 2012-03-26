package quize.number02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DaewonAlienNumber {

	public static void main(String[] args) throws IOException {

		FileWriter writer = new FileWriter("/large.out");
		BufferedReader reader = new BufferedReader(new FileReader("/large.in"));

		DaewonAlienNumber number = new DaewonAlienNumber();
		int inputCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < inputCount; i++) {
			String result = number.solve(reader.readLine());
			writer.write(String.format("Case #%d: %s\n", i+1, result));
		}

		writer.close();
		reader.close();
	}

	public String solve(String input) {
		String result = "";

		String[] datas = input.split(" ");
		String digits = datas[0];
		String srcLang = datas[1];
		String targetLang = datas[2];

		int targetDigitCount = targetLang.length();

		int decimal = toDecimal(digits, srcLang);

		int div = decimal;
		while (div >= targetDigitCount) {
			int mod = div % targetDigitCount;
			div = div / targetDigitCount;

			result = targetLang.charAt(mod) + result;
		}
		result = targetLang.charAt(div) + result;

		return result;
	}

	public int toDecimal(String digits, String srcLang) {
		int decimal = 0;
		int srcDigitCount = srcLang.length();
		int exp = 0;
		for (int i = digits.length() - 1; i >= 0; i--) {
			char digit = digits.charAt(i);
			int digitNum = srcLang.indexOf(digit);
			decimal += digitNum * Math.pow(srcDigitCount, exp++);
		}

		return decimal;
	}
}
