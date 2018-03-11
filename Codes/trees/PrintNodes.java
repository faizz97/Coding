package trees;

/* Given a Binary Tree and a positive integer k, print all nodes that are distance k from a leaf node. */
/* Link: https://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/ */

public class PrintNodes {
	public static void main(String args[]) {
		MyTree tree = new MyTree();
		tree.root = new MyTreeNode(1);
        tree.root.left = new MyTreeNode(2);
        tree.root.right = new MyTreeNode(3);
        tree.root.left.left = new MyTreeNode(4);
        tree.root.left.right = new MyTreeNode(5);
        tree.root.right.left = new MyTreeNode(6);
        tree.root.right.right = new MyTreeNode(7);
        tree.root.right.left.right = new MyTreeNode(8);
        
        System.out.println("Nodes at distance 1 are :");
        tree.printKDistantfromLeaf(tree.root, 1);
        
	}
}
class MyTreeNode {
	int data;
	MyTreeNode left, right;
	public MyTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class MyTree {
	MyTreeNode root;
	public void printKDistantfromLeaf(MyTreeNode root, int k) {
		int path[] = new int[1000];
		boolean visited[] = new boolean[1000];
		printKDistantfromLeafUtil(root, k, 0, path, visited);
	}
	private void printKDistantfromLeafUtil(MyTreeNode root, int k, int distance, int path[], boolean visited[]) {
		if (root == null)
			return;
		
		path[distance] = root.data;
		visited[distance] = false;
		distance++;
		
		if (root.right == null && root.left == null && (distance - k - 1 >= 0) && visited[distance - k - 1] == false) {
			System.out.println(path[distance - k - 1]);
			visited[distance - k - 1] = true;
		}
		
		printKDistantfromLeafUtil(root.left, k, distance, path, visited);
		printKDistantfromLeafUtil(root.right, k, distance, path, visited);
	}
}
