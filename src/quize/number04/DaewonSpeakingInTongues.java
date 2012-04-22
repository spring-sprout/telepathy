package quize.number04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DaewonSpeakingInTongues {
	static Map<String, String> languageMaps = new HashMap<String, String>(27);
	static {
		languageMaps.put(" ", " ");
		languageMaps.put("a", "y");
		languageMaps.put("b", "h");
		languageMaps.put("c", "e");
		languageMaps.put("d", "s");
		languageMaps.put("e", "o");
		languageMaps.put("f", "c");
		languageMaps.put("g", "v");
		languageMaps.put("h", "x");
		languageMaps.put("i", "d");
		languageMaps.put("j", "u");
		languageMaps.put("k", "i");
		languageMaps.put("l", "g");
		languageMaps.put("m", "l");
		languageMaps.put("n", "b");
		languageMaps.put("o", "k");
		languageMaps.put("p", "r");
		languageMaps.put("q", "z");
		languageMaps.put("r", "t");
		languageMaps.put("s", "n");
		languageMaps.put("t", "w");
		languageMaps.put("u", "j");
		languageMaps.put("v", "p");
		languageMaps.put("w", "f");
		languageMaps.put("x", "m");
		languageMaps.put("y", "a");
		languageMaps.put("z", "q");
	}

	public String solve(String readLine) {
		StringBuilder result = new StringBuilder(readLine.length());
		for(int i = 0; i < readLine.length(); i++) {
			result.append(languageMaps.get(readLine.charAt(i)+""));
		}

		return result.toString();
	}

	public static void main(String[] args) throws IOException {
		FileWriter writer = new FileWriter("/A-small-practice.out");
		BufferedReader reader = new BufferedReader(new FileReader("/A-small-practice.in"));

		DaewonSpeakingInTongues solution = new DaewonSpeakingInTongues();
		int inputCount = Integer.parseInt(reader.readLine());
		for (int i = 0; i < inputCount; i++) {
			String result = solution.solve(reader.readLine());
			writer.write(String.format("Case #%d: %s\n", i + 1, result));
		}

		writer.close();
		reader.close();

	}

}
