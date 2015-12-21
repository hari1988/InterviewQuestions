package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MimimumCoinChange {
	
	public static void main(String[] args)throws Exception {
		int amount = 7;
		int[] coins={2,3,4};
		
		System.out.println(findChanges(amount,coins));
		
	}
	
	private static List<Integer> findChanges(int amount,int[] coins){
		ArrayList<Integer>[] group = (ArrayList<Integer>[])new ArrayList[amount+1];
		
		for(int i=0;i<=amount;i++){
			group[i] = new ArrayList<Integer>();
		}
		
		for(int i=0;i<coins.length;i++){
			if(coins[i]<group.length){
				group[coins[i]].add(coins[i]);
			}
		}

		if(group[amount].size()>0)
			return group[amount];
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i<=amount;i++){
			min = Integer.MAX_VALUE;
			for(int j=0;j<coins.length;j++){
				if(i>coins[j] && group[i-coins[j]].size()>0){
					
					int r = 1+group[i-coins[j]].size();
					if(r<min){
						min = r;
						group[i].clear();
						group[i].add(coins[j]);
						group[i].addAll(group[i-coins[j]]);
					}
				}
			}
		}
		return group[amount];
	}
	
	private static int findChange(int amount, int[] coins){
		int[] res = new int[amount+1];
		Arrays.fill(res, -1);
		for(int i=0;i<coins.length;i++){
			if(coins[i]<res.length)
				res[coins[i]] = 1;
		}
		
		
		if(res[amount]!=-1)
			return res[amount];
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=amount;i++){
			min = Integer.MAX_VALUE;
			
			if(res[i]==-1){
				for(int j=0;j<coins.length;j++){
					if(i>coins[j] && res[i-coins[j]]!=-1){
						int r = 1+res[i-coins[j]];
						if(r<min)
							min=r;
					}
				}
				if(min!=Integer.MAX_VALUE){
					res[i] = min;
				}
			}
		}
		return res[amount];
		
	}

}
