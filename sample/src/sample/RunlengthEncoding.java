package sample;

public class RunlengthEncoding {

	public static void main(String[] args) {

		String abc = "aabbbcd";
		printRunLength(abc.toCharArray(),abc.charAt(0));
		
	}
	
	private static void printRunLength(char[] a,char curr){
		
		int count = 1;int i=0;
		for(i=1;i<a.length;i++){
			if(a[i]==curr){
				count++;
			}
			else{
				System.out.print(a[i-1]);
				System.out.print(count);
				curr = a[i];
				count=1;
			}
		}
		System.out.print(a[i-1]);
		System.out.print(count);
	}

}
