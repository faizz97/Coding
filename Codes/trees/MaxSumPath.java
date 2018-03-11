package trees;

public class MaxSumPath {
	
	Node2 root = null;
	
	public int maxPathSum() {
		Result res = new Result();
		res.val = Integer.MIN_VALUE;
		maxPathSum(root, res);
		return res.val;
	}
	
	public int maxPathSum(Node2 root, Result res) {
		
		if (root == null)
			return 0;
		
		int l = maxPathSum(root.left, res);
		int r = maxPathSum(root.right, res);
		
		int max_single = Math.max(Math.max(l, r) + root.data, root.data);
		int max_top = Math.max(max_single, l + r + root.data);
		
		res.val = Math.max(res.val, max_top);
		
		return max_single;
		
	}
	
	public static void main(String args[]) {
		MaxSumPath tree = new MaxSumPath();
		tree.root = new Node2(10);
        tree.root.left = new Node2(2);
        tree.root.right = new Node2(10);
        tree.root.left.left = new Node2(20);
        tree.root.left.right = new Node2(1);
        tree.root.right.right = new Node2(-25);
        tree.root.right.right.left = new Node2(3);
        tree.root.right.right.right = new Node2(4);
        System.out.println(tree.maxPathSum());
	}
}
class Node2 {
	int data;
	Node2 left, right;
	public Node2(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}
class Result {
	public int val;
}
