package chapter3.radixsort;

import java.util.ArrayList;
import java.util.List;

import chapter3.Sort;

public class KimTaeHeeRadixSort implements Sort{

	@Override
	public void sort(int[] input) {
		List<String> stringNumberList =	toStringNumberList(input);
		int maxCipher = getMaxNumberLength(input);
		
		for(int i = 1; i <= maxCipher; i++){
			System.out.println(i + "번째 자릿수 기수 정렬");
			radixSort(stringNumberList, i);
			System.out.println(i + "번째 자릿수 기수 정렬 후 " + stringNumberList.size());			
			for(String s : stringNumberList){
				System.out.print(s + " ");
			}
			System.out.println("");
		}
		
		for(int i = 0; i < stringNumberList.size(); i++){
			input[i] = Integer.parseInt( stringNumberList.get(i) );
		}
	}

	private int getMaxNumberLength(int [] input){
		int maxNumberLength = 0;
		for(int i : input){
			if( maxNumberLength < Integer.toString(i).length() ){
				maxNumberLength = Integer.toString(i).length();
			}
		}
		return maxNumberLength;
	}
	
	// 자릿수로 비교하여 정렬
	public void radixSort(List<String> stringNumberList, int numberLength){
		List<String> tempList = new ArrayList<String>();
		for( int i = 0; i < 10; i++ ){
			for(int k = 0 ; k < stringNumberList.size(); k++){
				String stringNumber = stringNumberList.get(k);
				int cutPoint = stringNumber.length() - numberLength;
				int value = Integer.parseInt( stringNumber.substring(
						cutPoint, cutPoint + 1) );
			/*	System.out.println("number Length : " + numberLength + 
						" , number : " + stringNumberList.get(k) + ", value : " + value);*/
				assert value < 10;
				if( value == i ){
					tempList.add( stringNumberList.get(k) );
					stringNumberList.remove(k);
					k--;
				}
			}
		}
		
		assert stringNumberList.size() == 0;
		for(String stringNumber : tempList){
			stringNumberList.add(stringNumber);
		}
		System.out.println("stringNumberList size : " + stringNumberList.size());
		
		
	}
	
	public List<String> toStringNumberList(int[] input){
		List<String> stringNumberList = new ArrayList<String>();
		int maxNumberLength = getMaxNumberLength(input);
		for( int value : input ){
			stringNumberList.add( Integer.toString(value) );
		}
		
		// 모자란 자릿수를 채우기 위해 0 숫자 붙이는 부분
		for( int i = 0 ; i < stringNumberList.size() ; i++ ){
			String stringNumber = stringNumberList.get(i);
			if( stringNumber.length() < maxNumberLength){
				StringBuilder zeroPrefix = new StringBuilder();
				for( int k = 0; k < maxNumberLength - stringNumber.length(); k++ ){
					zeroPrefix.append("0");
				}
				stringNumber = zeroPrefix.toString() + stringNumber;
				stringNumberList.set(i, stringNumber);
			}
		}
		
		for(String s : stringNumberList){
			System.out.print(s + " ");
		}
		return stringNumberList;
	}
}
