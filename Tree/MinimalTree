import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


class TreeNode
{
	int data;
	TreeNode left,right;
	TreeNode(int item)
	{
		data=item;
		left=null;
		right=null;
	}
}

public class MinimalTree
{
	 public TreeNode sortedArrayToBST(int[] nums) {
	        return createMininalBST(nums,0,nums.length-1);
	        
	    }
	    
	    public TreeNode createMininalBST(int arr[],int start,int end)
	    {
	        if(end<start)
	            return null;
	        int mid=(start+end)/2;
	        TreeNode n=new TreeNode(arr[mid]);
	        n.left=createMininalBST(arr,start,mid-1);
	        n.right=createMininalBST(arr,mid+1,end);
	        return n;
	    }
	    void preOrder(TreeNode root)
		{
			if(root==null)
			{
				return;
			}
			
			if(root!=null)
			{
				System.out.print(root.data+" ");
				preOrder(root.left);
				preOrder(root.right);
			}
			
		}
	    
	    public ArrayList<Integer> levelOrder(TreeNode root) {
	        ArrayList<Integer> result=new ArrayList<>();
	        
	        if(root==null)
	            return result;
	        
	        Queue<TreeNode> queue=new LinkedList<>();
	        queue.add(root);
	        
	        while(!queue.isEmpty())
	        {
	            int size=queue.size();
	            ArrayList<Integer> currentlevel=new ArrayList<>();
	            for(int i=0;i<size;i++)
	            {
	                TreeNode current=queue.remove();
	                currentlevel.add(current.data);
	                if(current.left!=null)
	                {
	                    queue.add(current.left);
	                }
	                if(current.right!=null)
	                {
	                    queue.add(current.right);
	                }
	            }
	            result.addAll(currentlevel);   
	        }
	        return result;
	    }
	    
	public static void main(String args[])
	{
		MinimalTree t=new MinimalTree();
		int arr[]= {-10,-3,0,5,9};
		TreeNode n=t.sortedArrayToBST(arr);
		
		ArrayList<Integer> a=t.levelOrder(n);
		System.out.print(a);
		
		
	}
}
