package sample;

public class AllPossibleSortedArrays {

	public static void main(String[] args) {
		int[] A = {10,15,25};
		int[] B = {1,5,20,30};
		
		int[] c = new int[A.length+B.length];
		for(int i=0;i<A.length;i++)
			findCombination(A,B,c,i,A.length,0,B.length,0,true);

	}
	
	private static void findCombination(int[] A,int[] B,int[] C,int aIndexStart,int aIndexEnd,int bIndexStart,int bIndexEnd,int cIndex,boolean flag){
		//If u have at least one element from B, then print it
		if(cIndex>0 && cIndex%2==0)
			printArr(C,cIndex);
		
		if(flag){
			//get next element from A
			if(cIndex>0){
				for(int k = aIndexStart;k<aIndexEnd;k++){
					if(A[k]>C[cIndex-1]){
						C[cIndex] = A[k];
						findCombination(A,B,C,k+1,aIndexEnd,bIndexStart,bIndexEnd,cIndex+1,!flag);
					}
				}
			}
			else{
				C[cIndex] = A[aIndexStart];
				findCombination(A, B, C, aIndexStart+1, aIndexEnd, bIndexStart, bIndexEnd, cIndex+1, !flag);
			}
		}
		
		else{
			//get next element from B
			for(int l = bIndexStart;l<bIndexEnd;l++){
				if(B[l]>C[cIndex-1]){
					C[cIndex] = B[l];
					findCombination(A, B, C, aIndexStart, aIndexEnd, bIndexStart+1, bIndexEnd, cIndex+1, !flag);
				}
			}
		}
	}
	
	private static void printArr(int[] c,int len){
		for(int i=0;i<len;i++)
			System.out.print(c[i]+" ");
		
		System.out.println();
	}

}
