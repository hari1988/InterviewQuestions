package sample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestCommonSubSequence {
	
	public static void main(String args[])throws IOException
	{
	    		LongestCommonSubSequence o=new LongestCommonSubSequence();
				String a=" "+"abba";
				String b=" "+"abzzzb";
				String[][] m=new String[a.length()][b.length()];
				for(int i=0;i<a.length();i++)
					m[i][0]="";
				for(int j=0;j<b.length();j++)
					m[0][j]="";
				for(int i=1;i<a.length();i++)
				{
					for(int j=1;j<b.length();j++)
					{
						if(a.charAt(i)==b.charAt(j))
						{
							m[i][j]=m[i-1][j-1]+a.substring(i,i+1);
						}
						else
						{
							m[i][j]=o.max(m[i][j-1],m[i-1][j]);
						}
					}
				}
				System.out.println(m[a.length()-1][b.length()-1].trim());
			
		
	}
	String max(String a,String b)
	{
		if(a.length()>b.length())return a;
		else return b;
	}

}
