package sample;

import java.util.Arrays;

public class BuildTreeFromLevelOrderInOrder {
	
	public static void main(String[] args){
		int in[] = {4,8,10,12,14,20,22};
		int level[] = {20,8,22,4,12,10,14};
		
		buildTree(in,level,0,in.length-1,0);
	}
	
	private static Tree buildTree(int[] in,int[] level,int start,int end,int levelIndex){
		if(in.length==0 || level.length==0)
			return null;
		
		Tree root = new Tree();
		root.val = level[levelIndex];
		
		int index = find(in,level[start],start,end);
		if(index>=0){
			int[] left = Arrays.copyOfRange(in, start, index-1);
			int[] right = Arrays.copyOfRange(in, index+1, end);
			root.left = buildTree(left,level,start,index-1,levelIndex+1);
			root.right = buildTree(right,level,index+1,end,levelIndex+1);
		}
		return root;
	}
	
	private static int find(int[] in,int elem,int start,int end){
		for(int i=start;i<=end;i++){
			if(in[i]==elem)
				return i;
		}
		return -1;
	}

}
