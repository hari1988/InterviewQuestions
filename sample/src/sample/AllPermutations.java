package sample;

public class AllPermutations {

	public static void main(String[] args) {
		String str = "zu6";
		printPermu(str);
	}
	
	private static void printPermu(String str){
		/*for(int i=0;i<str.length();i++){
			printAll(str.substring(i, i+1),str.substring(0, i)+str.substring(i+1));
		}*/
		printAll("",str);
	}
	
	private static void printAll(String left,String rest){
		if(rest.length()==1){
			System.out.println(left+rest);
			return;
		}
		for(int i=0;i<rest.length();i++){
			 String l = left + rest.substring(i, i+1);
			 String r = rest.substring(0, i)+ rest.substring(i+1);
			printAll(l,r);
		}
	}

}
