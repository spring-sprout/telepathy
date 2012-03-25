package quize.number02;

public class TaeHeeAlienNumbers {

	public String toAlienNumber(String input) {
		String[] parsingResult = parsing(input);
		String value = parsingResult[0];
		String sourceType = parsingResult[1];
		String targetType = parsingResult[2];

		int totalPlace = 0;
		System.out.println("match start!!");
		System.out.println("value : " + value + " source type : " + sourceType + " target type : " + targetType);
		for( int i = 0 ; i < value.length(); i++ ){
			char n = value.charAt( i );
			System.out.println("match character : " + n );
			int index = 0;
			for(int k = 0; k < sourceType.length(); k++ ){
				char sourceN = sourceType.charAt(k);
				if( sourceN == n ){
					index = k;
					break;
				}
			}
			// TODO 10진수로 변환하여 처리하면 될듯.
			System.out.println("index : " + index);
			int place = index;
			for(int j = 0; j < value.length() - i -1; j++){
				place *= sourceType.length();
			}
			totalPlace += place;
			System.out.println("match place : " + place + " target type length : " + targetType.length());			
		}
		
		String t = "";
		boolean isNotFinish = true;
		
		System.out.println("total : " + totalPlace);
		
		while(isNotFinish){
			if( totalPlace < targetType.length() ){
				isNotFinish = false;
			}
			int mod = totalPlace % targetType.length();
			System.out.println("mod : " + mod);
			totalPlace /= targetType.length(); 
			char convertValue = targetType.charAt(mod);
			
			System.out.println( "convert Value : " + convertValue );
			t = convertValue + t;				
		}
		return t;
		//result.reverse();
		//return result.toString();
		
	}
	
	public String[] parsing(String input){
		String[] parsingResult = input.split(" ");
		assert parsingResult.length == 3;
		return parsingResult;
	}
	
	
	
	public int parsingInt(String number){
		int result = 0;
		for(int i = 0; i < number.length(); i++){
			char n = number.charAt( number.length() - i - 1 );
			int intN = n - 48;
			if( i == 0 ){
				result += intN;
			}else{
				for( int k = 0 ; k < i; k++){
					intN *= 10;
				}
				result += intN;
			}
		}
		return result;
	}
	
	/*public String parsingString(int number){
		StringBuilder result = new StringBuilder();
		int spliceBaseNumber = 1;
		while(spliceBaseNumber > number){
			
		}
	}*/
	
}
