package quize.number02;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import org.junit.Test;


public class TaeHeeAlienNumbersTest {
	TaeHeeAlienNumbers alienNumbers = new TaeHeeAlienNumbers();
	@Test
	public void testToAlienNumber(){
		assertEquals( "Foo", alienNumbers.toAlienNumber("9 0123456789 oF8") );			
		assertEquals( "9", alienNumbers.toAlienNumber("Foo oF8 0123456789") );
		assertEquals( "10011", alienNumbers.toAlienNumber("13 0123456789abcdef 01") );
		assertEquals( "JAM!", alienNumbers.toAlienNumber("CODE O!CDE? A?JM!.") );
	}
	
	@Test
	public void testParsingInt(){
		assertEquals(12345, alienNumbers.parsingInt("12345"));
	}
	
	@Test
	public void codeJamExecute() throws Exception{
		BufferedReader in = new BufferedReader(new FileReader("c:/A-large-practice.in"));
		String  readLine = null;
		int lineCount = 0;
		StringBuilder result = new StringBuilder();
		while ((readLine = in.readLine()) != null) {
			if(readLine.isEmpty()) {
				return;
			}
			if(lineCount > 0) {
				System.out.println(readLine);
				result.append( "Case #" + lineCount + ": " + alienNumbers.toAlienNumber(readLine) + "\n" );
			}
			lineCount++;
		}
		in.close();

		System.out.println(result.toString());

		BufferedWriter out = new BufferedWriter(new FileWriter("c:/A-large-practice.out"));
		out.write(result.toString());
		out.close();
	}
	

}
