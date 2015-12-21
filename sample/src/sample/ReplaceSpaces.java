package sample;

public class ReplaceSpaces {

	public static void main(String[] args) {
		String str = "Hi, this is a string with spaces";
		StringBuffer buf = new StringBuffer(str);
		for(int i=0;i<buf.length();i++){
			if(buf.charAt(i)==' ')
				buf.replace(i, i+1, "%20");
		}
		
		System.out.println(buf.toString());
	}

}
