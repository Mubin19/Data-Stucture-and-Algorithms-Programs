//Recursion + Memoization
import java.util.Arrays;
import java.util.Scanner;

public class KnapSack_1 {
	
	static int knapsack(int[] wt,int[] val, int w,int n)
	{
		int t[][]=new int[n+1][w+1];
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=w;j++)
			{
				t[i][j]=-1;
			}
		}
		if(n==0 || w==0)
		{
			return 0;
		}
		if(t[n][w]!=-1)
		{
			return t[n][w];
		}
		if(wt[n-1]<=w)
		{
			return Math.max(val[n-1]+knapsack(wt,val,w-wt[n-1],n-1), knapsack(wt,val,w,n-1));	
		}
		else  //if(wt[n-1]>w)
		{
			return t[n][w]=knapsack(wt,val,w,n-1);
		}
		
		
		
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=3,w=50;
		int[] wt= {10,20,30};
		int[] val= {60,100,120};
		System.out.println(knapsack(wt,val,w,n));
		
	}
}
