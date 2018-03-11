package trees;

class MyNode {
	int data;
	MyNode left, right;
	public MyNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class TreeDiameter {
	MyNode root;
	
	boolean flag = false;
	
	public int diameter() {
		return diameter(root, new Height());
	}
	
	private int diameter(MyNode root) {
		/*
		 * O(N^2)
		 * */
		if (root == null)
			return 0;
		int lheight = height(root.left);
		int rheight = height(root.right);
		int ld = diameter(root.left);
		int rd = diameter(root.right);
		return Math.max(lheight + rheight + 1, Math.max(ld, rd));
	}
	
	class Height {
		int h;
	}
	
	private int diameter(MyNode root, Height height) {
		/*
		 * Optimized Approach (O(N))
		 * */
		if (root == null) {
			height.h = 0;
			return 0;
		}
		Height lh = new Height(), rh = new Height();
		lh.h++;
		rh.h++;
		int ld = diameter(root.left, lh);
		int rd = diameter(root.right, rh);
		height.h = Math.max(lh.h, rh.h) + 1;
		return Math.max(lh.h + rh.h + 1, Math.max(ld, rd));
	}
	
	private int height(MyNode root) {
		if (root == null)
			return 0;
		return Math.max(height(root.left), height(root.right)) + 1;
	}
	
	public void printPath(int sum) {
		path(root, sum);
		flag = false;
	}
	
	void path(MyNode root, int sum) {
		if (root == null)
			return;
		if (sum - root.data < 0)
			return;
		if (sum - root.data == 0) {
			flag = true;
			System.out.print(root.data + " ");
			return;
		}
		if (!flag)
			path(root.left, sum - root.data);
		if (flag) {
			System.out.print(root.data + " ");
			return;
		}
		if (!flag)
			path(root.right, sum - root.data);
		if (flag) {
			System.out.print(root.data + " ");
			return;
		}
	}
	
	public static void main(String args[]) {
		TreeDiameter tree = new TreeDiameter();
		tree.root = new MyNode(1);
		tree.root.left = new MyNode(2);
        tree.root.right = new MyNode(3);
        tree.root.right.left = new MyNode(7);
        tree.root.right.right = new MyNode(8);
        tree.root.right.left.left = new MyNode(4);
        tree.root.right.left.right = new MyNode(2);
        tree.root.left.left = new MyNode(4);
        tree.root.left.right = new MyNode(5);
        
        System.out.println(tree.diameter());
        tree.printPath(13);
	}
}
