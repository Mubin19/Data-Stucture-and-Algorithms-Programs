
public class PathWithSum {

	
	Node insert(int[] arr,Node root,int i)
	{
		if(i<arr.length)
		{
			Node temp=new Node(arr[i]);
			root=temp;
			
			root.left=insert(arr,root.left,2*i+1);
			
			root.right=insert(arr,root.right,2*i+2);
			
		}
		return root;
	}
	
	
	int countPathsWithSum(Node root,int targetsum)
	{
		if (root==null)
			return 0;
		
		int pathsFromRoot=countPathsWithSumFromNode(root,targetsum,0);
		int pathsOnLeft=countPathsWithSum(root.left,targetsum);
		int pathsOnRight=countPathsWithSum(root.right, targetsum);
	
		return pathsFromRoot+pathsOnLeft+pathsOnRight;
	}
	
	
	int countPathsWithSumFromNode(Node node ,int targetsum,int currentsum)
	{
		if(node == null)
		{
			return 0;
		}
		currentsum+=node.data;
		int totalpath=0;
		if(currentsum==targetsum) {
			totalpath++;
		}
		totalpath+=countPathsWithSumFromNode(node.left,targetsum,currentsum);
		totalpath+=countPathsWithSumFromNode(node.right,targetsum,currentsum);
		return totalpath;
	}
	
	void inOrder(Node root)
	{
		if(root==null)
		{
			return;
		}
		
		if(root!=null)
		{
			inOrder(root.left);
			System.out.print(root.data+" ");
			inOrder(root.right);
		}
	}
	
	
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root==null)
	        {
	            return null;
	        }
	        if(root==p || root==q)
	        {
	            return root;
	        }
	        TreeNode left=lowestCommonAncestor(root.left,p,q);
	        System.out.println("left: "+left.data);
	        TreeNode right=lowestCommonAncestor(root.right,p,q);
	        System.out.println("right: "+right.data);
	        if(left!=null && right!=null)
	        {
	            return root;
	        }
	        if(left==null && right==null)
	        {
	            return null;
	        }
	        System.out.println("result: "+left!=null ? left:right);
	        return  left!=null ? left:right;
	    }
	 
	 
	public static void main(String args[])
	{
		PathWithSum t=new PathWithSum();
		int arr[]= {10,1,6,3,4,7,8,2};
		Node root1=new Node(0);
		 root1=t.insert(arr, root1, 0);
		 t.inOrder(root1);
		int sum= t.countPathsWithSum(root1, 5);
		 System.out.println("pathwithsum:"+sum);
	
		 
		 
	}
}
