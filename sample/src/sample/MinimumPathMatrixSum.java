package sample;

import java.io.BufferedReader;
import java.io.FileReader;

public class MinimumPathMatrixSum {

	public static void main(String[] args)throws Exception {
		
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String str="";
		int n=0;
		int[][] arr;
		int[][] dp;
		
		while((str = br.readLine())!=null){
			n = Integer.parseInt(str.trim());
			arr = new int[n][n];
			dp = new int[n][n];
			
			for(int i=0;i<n;i++){
				str = br.readLine();
				String[] vals = str.trim().split(",");
				for(int j=0;j<n;j++){
					arr[i][j] = Integer.parseInt(vals[j].trim());
				}
			}
			
			dp[0][0] = arr[0][0];
			
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					int v1= Integer.MAX_VALUE;
					int v2= Integer.MAX_VALUE;
					if(i==0 && j==0) continue;
					if((i-1)>=0){
						v1 = arr[i][j]+dp[i-1][j];
					}
					if((j-1)>=0){
						v2 = arr[i][j]+dp[i][j-1];
					}
					dp[i][j] = Math.min(v1, v2);
				}
			}
			
			System.out.println(dp[n-1][n-1]);
			
		}
	}
}
