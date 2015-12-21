package sample;

public class PhoneNumbers {

	static String[] arr={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	public static void main(String[] args) {
		String num = "789";
		printCombinations(num);
	}
	
	private static void printCombinations(String num){
		char[] output = new char[num.length()];
		printAll(num.toCharArray(),num.length(),0,output);
	}
	
	private static void printAll(char[] input,int n,int curr,char[] output){
		if(curr==n){
			System.out.println(output);
			return;
		}
		int index = input[curr]-'0';
		for(int i=0;i<arr[index].length();i++){
			output[curr] = arr[index].charAt(i);
			printAll(input,n,curr+1,output);
		}
	}

}
