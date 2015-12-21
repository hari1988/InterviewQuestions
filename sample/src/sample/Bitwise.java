package sample;

public class Bitwise {

	public static void main(String[] args) {
		int[] arr= {3,1,5,29,35,7,61,9};
		int N =64;
		int[] a = new int[1+N/32];
		/*for(int i=0;i<N;i++)
			clr(i,a);*/
		for(int i:arr){
			set(i,a);
		}
		for(int i=0;i<N;i++){
			if(test(i,a)){
				System.out.println(i);
			}
		}
	}
	
	private static void clr(int i,int[] a){
		a[i>>5] &= ~(1<<(i & 0x1f));
	}
	
	private static void set(int i,int[] a){
		a[i>>5] |= (1<<(i & 0x1f));
		System.out.println("set after i= "+i+" "+Integer.toBinaryString(a[i>>5]));
	}
	
	private static boolean test(int i,int[] a){
		return (a[i>>5] & (1<<(i & 0x1f)))==0?false:true;
	}
	
	private static void print(int i,int[] a){
		a[i>>5] |= (1<<(i & 0x1f));
		Integer.toBinaryString(a[i>>5]);
	}

}
