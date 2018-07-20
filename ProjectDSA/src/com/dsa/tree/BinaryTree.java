package com.dsa.tree;

public class BinaryTree {

	Node root;

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	void preorder(Node node) {

		if (node == null) {
			return;

		}
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}

	void preordertraversal() {
		preorder(root);
	}

	void bfs() {
		int h = height(root);
		for(int i=0;i<h;i++){
			printLevelOrder(root,i);
		}
	}

	void printLevelOrder(Node root, int i) {
		if(root ==null){
			return;
		}
		if(i==0){
			System.out.println(root.data);
		}
		if(i>0){
			printLevelOrder(root.left, i-1);
			printLevelOrder(root.right, i-1);
		}
	}

	int height(Node node) {
		if (node == null) {
			return 0;
		}
		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	
	 boolean isBST(Node node, int min, int max)
	    {
	        /* an empty tree is BST */
	        if (node == null)
	            return true;
	 
	        /* false if this node violates the min/max constraints */
	        if (node.data < min || node.data > max)
	            return false;
	 
	        /* otherwise check the subtrees recursively
	        tightening the min/max constraints */
	        // Allow only distinct values
	        return (isBST(node.left, min, node.data-1) &&
	        		isBST(node.right, node.data+1, max));
	    }
	 

	public static void main(String[] args) {

		BinaryTree bt = new BinaryTree();
		bt.root = new Node(10);
		bt.root.left = new Node(14);
		bt.root.right = new Node(64);
		bt.root.left.left = new Node(94);
		bt.root.left.right = new Node(194);
		bt.root.right.left = new Node(944);
		bt.root.right.right = new Node(1943);




		bt.preordertraversal();
		System.out.println("Height of the tree is "+bt.height(bt.root));
		System.out.println("BFS of tree");
		bt.bfs();
	}
}
