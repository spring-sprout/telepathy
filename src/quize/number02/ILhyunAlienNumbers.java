package quize.number02;

public class ILhyunAlienNumbers {

	public String codeJam(String alien, String source, String target) {
		String result = ""; // 변환 결과
		
		// alien -> source -> temp -> target -> result
		char[] alienArr = alien.toCharArray();
		int alienLength = alien.length();
		
		char[] sourceArr = source.toCharArray();
		int sourceLength = source.length();
		
		int temp = 0;
		for(int i = 0; i < alienLength; i++){
			
			int index = 0;
			
			for(int j = 0; j < sourceLength; j++){
				if(sourceArr[j] == alienArr[i]) index = j;
			}

			int digit = 1;
			for(int j = 0; j < alienLength-(i+1); j++){
				digit *= sourceLength;
			}
			temp += index*digit;
		}
		
		char[] targetArr = target.toCharArray();
		int targetLength = target.length();
		
		String tempResult = "";
		while(temp > targetLength-1){
			tempResult += targetArr[temp%targetLength];
			
			temp = temp/targetLength;
		}
		
		
		tempResult += targetArr[temp%targetLength];
		
		char[] reverseResult = tempResult.toCharArray();
		int reverseLength = tempResult.length();
		
		for(int i = reverseLength-1; i >= 0 ; i--){
			result += reverseResult[i];
		}
		
		return result;
	}

}