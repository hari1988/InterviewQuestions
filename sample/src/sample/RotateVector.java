package sample;

public class RotateVector {

	public static void main(String[] args) {
		String str= "abcdefgh";
		int i =5;
		str =rotate(str,i);
		System.out.println(str);
	}
	
	private static String rotate(String s,int i){
		int n = s.length();
		if(i>=n)
			i=i%n;
		String str = reverse(s,0,i-1);
		str = reverse(str,i,n-1);
		str = reverse(str,0,n-1);
		return str;
	}
	
	private static String reverse(String s, int i,int j){
		if(i>=j)
			return s;
		
		StringBuffer buf = new StringBuffer();
		if(s.charAt(i)==s.charAt(j))
			return reverse(s,i+1,j-1);
		else{
			if(i>0)
				buf.append(s.substring(0,i));
			buf.append(s.charAt(j)+s.substring(i+1, j)+s.charAt(i)+s.substring(j+1));
			return reverse(buf.toString(),i+1,j-1);
		}
	}

}
