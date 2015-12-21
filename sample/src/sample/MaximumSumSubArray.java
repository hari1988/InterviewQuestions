package sample;

public class MaximumSumSubArray {

	public static void main(String[] args) {
		int[] arr = {31,-41,59,26,-53,58,97,-93,-23,84};
		
		
		int finalMax = 0;int finalStart=0;int finalEnd=0;
		int maxSum = 0;
		int currStart = 0;
		
		for(int i=0;i<arr.length;i++){
			
			maxSum = max(maxSum+arr[i],0);
			
			if(maxSum>finalMax){
				finalMax = maxSum;
				finalEnd = i;
				finalStart = currStart;
			}
			
			if(maxSum==0){
				currStart = i+1;
			}
		}
		
		System.out.println(finalMax);
		System.out.println(finalStart+", "+finalEnd);

	}
	
	private static int max(int i,int j){
		if(i>j)
			return i;
		return j;
	}

}
