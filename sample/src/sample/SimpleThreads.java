package sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class SimpleThreads {

  
    public static void main(String[] args)throws Exception {
    	BufferedReader br = new BufferedReader(new FileReader(args[0]));
    	String line="";
    	while((line=br.readLine())!=null){
    		int n = Integer.parseInt(line);
    		int[][] arr = new int[n][n];
    		for(int i=0;i<n;i++){
    			line = br.readLine();
    			String[] str = line.split(",");
    			for(int j=0;j<n;j++){
    				arr[i][j] = Integer.parseInt(str[j]);
    			}
    		}
    		System.out.println(findSum(arr,0,0,n-1,n-1,0,n));
    		
    	}
    	if(br!=null)
    		br.close();
    	
    	System.exit(0);
    }
    
    private static int findSum(int[][] arr,int i,int j,int x,int y,int sum,int size){
    	
    	//System.out.println(i+","+j+","+sum+","+arr[i][j]);
    	
    	if(i==x && j==y)
    		return sum+arr[i][j];
    	
    	
    	int rightSum = (j+1)<size?findSum(arr,i,j+1,x,y,sum+arr[i][j],size):Integer.MAX_VALUE;
    	int downSum = (i+1)<size?findSum(arr,i+1,j,x,y,sum+arr[i][j],size):Integer.MAX_VALUE;
    	
    	//System.out.println("returning "+Math.min(rightSum, downSum));
    	
    	return Math.min(rightSum, downSum);
    	
    }
}