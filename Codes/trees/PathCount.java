package trees;

public class PathCount {
	
	XNode root;
	
	public static void main(String args[]) {
		PathCount tree = new PathCount();
		tree.root = new XNode(10);
		tree.root.left = new XNode(5);
		tree.root.right = new XNode(-3);
		tree.root.left.left = new XNode(3);
		tree.root.left.right = new XNode(1);
		tree.root.right.right = new XNode(11);
		tree.root.left.left.left = new XNode(3);
		tree.root.left.left.right = new XNode(-2);
		tree.root.left.right.right = new XNode(2);
		
		System.out.println(tree.pathCount(8));
	}
	
	public int pathCount(int sum) {
		return count(root, sum);
	}
	
	private int count(XNode n, int sum) {
		if (n == null)
			return 0;
		
		int countFromRoot = pathCountFromNode(n, sum, 0);
		
		int countFromLeft = count(n.left, sum);
		int countFromRight = count(n.right, sum);
		
		return countFromRoot + countFromLeft + countFromRight;
	}
	
	private int pathCountFromNode(XNode root, int sum, int currentSum) {
		if (root == null)
			return 0;
		currentSum += root.data;
		int totalPaths = 0;
		if (sum == currentSum) {
			totalPaths++;
			
		}
		totalPaths += pathCountFromNode(root.left, sum, currentSum);
		totalPaths += pathCountFromNode(root.right, sum, currentSum);
		return totalPaths;
	}
}
class XNode {
	XNode left, right;
	int data;
	public XNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
