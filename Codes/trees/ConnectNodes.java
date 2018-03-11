package trees;

/* Write a function to connect all the adjacent nodes at the same level in a binary tree.  */
/* https://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/ */

public class ConnectNodes {
	public static void main(String args[]) {
		
		/* Constructed binary tree is
        	  10
      		/   \
    	   8      2
  		  / \      \
		 3   4     90
		*/
		
		TreeX tree = new TreeX();
		tree.root = new NodeX(10);
        tree.root.left = new NodeX(8);
        tree.root.right = new NodeX(2);
        tree.root.left.left = new NodeX(3);
        tree.root.left.right = new NodeX(4);
        tree.root.right.right = new NodeX(90);
        tree.connect(tree.root);
        NodeX p = tree.root.left.left;
        while (p != null) {
        	System.out.print(p.data + " ");
        	p = p.nextRight;
        }
	}	
}
class TreeX {
	NodeX root;
	public void connect(NodeX root) {
		root.nextRight = null;
		NodeX p = root;
		while (p != null) {
			NodeX q = p;
			while (q != null) {
				if (q.left != null) {
					if (q.right != null)
						q.left.nextRight = q.right;
					else
						q.left.nextRight = getNextRight(q);
				}
				if (q.right != null)
					q.right.nextRight = getNextRight(q);
				q = q.nextRight;
			}
			if (p.left != null)
				p = p.left;
			else if (p.right != null)
				p = p.right;
			else
				p = getNextRight(p);
		}
	}
	private NodeX getNextRight(NodeX node) {
		node = node.nextRight;
		while (node != null) {
			if (node.right != null)
				return node.right;
			if (node.left != null)
				return node.left;
			node = node.nextRight;
		}
		return null;
	}
}
class NodeX {
	NodeX left, right, nextRight;
	int data;
	public NodeX(int data) {
		this.data = data;
		left = null;
		right = null;
		nextRight = null;
	}
}