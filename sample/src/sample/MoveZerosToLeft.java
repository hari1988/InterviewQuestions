package sample;

public class MoveZerosToLeft {
	
	public static void main(String[] args){
		int[] arr = {1,0,2,0,3,0,3,1};
		int len = arr.length;
		int zeroindex = -1;
		for(int i = len-1;i>=0;i--){
			if(arr[i]!=0 && zeroindex!=-1){
				swap(arr,i,zeroindex);
				zeroindex = zeroindex -1;
			}
			
			if(arr[i]==0 && zeroindex==-1){
				zeroindex = i;
			}
		}
		for(int i=0;i<len;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	private static void swap(int[] arr,int i,int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
