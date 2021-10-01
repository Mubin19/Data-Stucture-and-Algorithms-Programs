import java.util.Scanner;

class Node3
{
	int data;
	Node3 left,right;
	Node3(int item)
	{
		data=item;
		left=null;
		right=null;
	}
}


public class CheckBalanced {		
		
		static Node3 root;
		CheckBalanced()
		{
			root=null;
		}
		
		static Node3 insert(Node3 root2,int x)
		{
			Node3 new_node=new Node3(x);
			if(root2==null)
			{
				return new_node;
			}
			if(x<root2.data)
			{
				root2.left=insert(root2.left,x);
			}
			else
			{
		
			root2.right=insert(root2.right,x);
			}
			return root2;
		}
	
		
		int checkHeight(Node3 root)
		{
			if(root==null)
				return -1;
			int left=checkHeight(root.left);
			if(left== Integer.MIN_VALUE)
			{
				return Integer.MIN_VALUE;
			}
			int right=checkHeight(root.right);
			if(right==Integer.MIN_VALUE)
			{
				return Integer.MIN_VALUE;
			}
			int heightDiff=left-right;
			if(Math.abs(heightDiff)>1)
			{
				return Integer.MIN_VALUE;
			}
			else
			{
				return Math.max(left, right);
			}
		}
		
		boolean isBalanced(Node3 root)
		{
			
			return checkHeight(root) != Integer.MIN_VALUE;
		}
		
		void inOrder(Node3 ne)
		{
			if(ne==null)
			{
				return;
			}
			
			if(ne!=null)
			{
				inOrder(ne.left);
				System.out.print(ne.data+" ");
				inOrder(ne.right);
			}
		}
		
		public static void main(String args[])
		{
			int n,x;
			Node3 root=new Node3(4); 
			CheckBalanced c=new CheckBalanced();
			int arr[]= {3,2,1,6,5};
			
			for(int i=0;i<arr.length;i++)
			{
				insert(root,arr[i]);
			}
			c.inOrder(root);
			boolean b=c.isBalanced(root);
			System.out.println(b);	
		}
}
