package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {
		int sum = 5;
		int[] numbers = {1,2,3};
		
		findAllPossibleSum(sum,numbers);
	}
	
	private static void findAllPossibleSum(int sum,int[] numbers){
		List<Integer> nums = new ArrayList<Integer>();
		for(int i : numbers)
			nums.add(i);
		findAllPossibleSum(sum, nums,new ArrayList<Integer>());
	}
	
	private static void findAllPossibleSum(int sum,List<Integer> numbers, List<Integer> numSoFar){
		int s = findSum(numSoFar);
		if(sum==s){
			System.out.println(numSoFar);
		}
		
		if(s>=sum)
			return;
		
		for(int i=0;i<numbers.size();i++){
			ArrayList<Integer> newNumbers = new ArrayList<Integer>();
			
			/*for(int j=i+1;j<numbers.size();j++){
				newNumbers.add(numbers.get(j));
			}*/
			
			ArrayList<Integer> newList = new ArrayList<Integer>(numSoFar);
			newList.add(numbers.get(i));
			findAllPossibleSum(sum, numbers, newList);
			
		}
	}
	
	private static int findSum(List<Integer> numSoFar){
		int sum = 0;
		for(int i : numSoFar){
			sum+=i;
		}
		return sum;
	}

}
