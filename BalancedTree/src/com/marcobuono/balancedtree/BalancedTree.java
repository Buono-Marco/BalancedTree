package com.marcobuono.balancedtree;

/**
 * This class is an experiment to test if a binary
 * tree, populates with items in random order, has
 * a high probability to is balanced. The tree will
 * be populated with 1023 random int items, and then
 * will be calculated the number of leaves, the sum
 * of the depths of all the leaves, and the average depth.
 * 
 * @author Marco Buono
 *
 */
public class BalancedTree {
	
	static TreeNode root; // pointer to node
	
	public static void main(String[] args) {
		
		int countLeaves = 0; // total leaves
		int sumDepthLeaves = 0; // the sum of the depths of all the leaves
		int maxDepth = 0; // the maximum depth of all the leaves
		int averageDepth = 0; // the average depth of all the leaves in the tree
		
		for(int i = 0; i < 1023; i++) {
		//for(int i = 0; i < 8; i++) {  // populate the tree with random int values
			int item = (int)(Math.random() * 3000);
			//int item = (int)(Math.random() * 10);
			//treeInsert((int)(Math.random() * 10));
			//System.out.println("item to insert: " + item);
			treeInsert(item);
		}
		
		countLeaves = countLeaves(root);
		System.out.println("countLeaves: " + countLeaves);  // Print the root item.
		sumDepthLeaves = sumDepthLeaves(root, 0);
		System.out.println("The sum of the depth of all leaves is: " + sumDepthLeaves);  // Print the root item.
		maxDepth = maxDepth(root, 0);
		System.out.println("The max depth is: " + maxDepth);  // Print the root item.
		averageDepth = sumDepthLeaves/countLeaves;
		System.out.println("The average depth is: " + averageDepth);  // Print the root item.
	}
	
	/**
	 * Add the item to the binary sort tree to which the global variable 
	 * "root" refers.  (Note that root can't be passed as  a parameter to 
	 * this routine because the value of root might change, and a change 
	 * in the value of a formal parameter does not change the actual parameter.)
	 */
	private static void treeInsert(int newItem) {
		if(root == null) {
			// The tree is empty.  Set root to point to a new node containing
			// the new item.  This becomes the only node in the tree.
			root = new TreeNode(newItem);
			return;
		}
		TreeNode runner;  // Runs down the tree to find a place for newItem.
		runner = root;   // Start at the root.
		while(true) {
			if(newItem < runner.item) {
				// Since the new item is less than the item in runner,
				// it belongs in the left subtree of runner.  If there
				// is an open space at runner.left, add a new node there.
				// Otherwise, advance runner down one level to the left.
				if(runner.left == null) {
					runner.left = new TreeNode(newItem);
					return;  // New item has been added to the tree.
				}
				else
					runner = runner.left;
			}
			else {
				// Since the new item is greater than or equal to the item in
				// runner, it belongs in the right subtree of runner.  If there
				// is an open space at runner.right, add a new node there.
				// Otherwise, advance runner down one level to the right.
				if(runner.right == null) {
					runner.right = new TreeNode(newItem);
					return;  // New item has been added to the tree.
				}
				else
					runner = runner.right;
			}
		} // end while
	}  // end treeInsert()
	
	/**
	 * This method, starting from the root, returns
	 * the total number of leaves.
	 * 
	 * @param root, the node to start counting from.
	 * @return the number of leaves.
	 */
	public static int countLeaves(TreeNode root) {
		if(root == null) { // if the tree is empty return 0
			return 0;
		} else if(root.left == null && root.right == null) {
			// If the leaf has been reached, it returns 1
			//System.out.println("Leaf: " + root.item);
			return 1;
		} else {
			// Otherwise, it calls the function recursively
			// for each branch. 
			return countLeaves(root.left) + countLeaves(root.right);
		}
	}
	
	/**
	 * Starting from the root, this method increases the depth
	 * variable until it returns the sum of all the leaves' depths.
	 * 
	 * @param root, the binary tree's root, or a node of the tree.
	 * @param depth, set initially to 0, it is increased with each 
	 * leaves' depth. 
	 * @return the sum of all the leaves' depths.
	 */
	public static int sumDepthLeaves(TreeNode root, int depth) {
		if(root == null) { // if the tree is empty return 0
			return 0;
		} if(root.left == null && root.right == null) {
			// If the leaf has been reached, it returns the depth
			return depth;
		} else {
			// Otherwise, it calls the function recursively
			// for each branch, adding the depth of each leaf. 
			depth = sumDepthLeaves(root.left, depth + 1) +
					sumDepthLeaves(root.right, depth + 1);
			return depth;
		}
	}
	
	/**
	 * Starting from the root, this method calculate
	 * the maximum depth of all the leaves.
	 * 
	 * @param root, the binary tree's root, or a node of the tree,
	 * @param depth, set initially to 0, store the maximum depth
	 * of the leves.
	 * @return the maximum depth of all the leaves.
	 */
	public static int maxDepth(TreeNode root, int depth) {
		if(root == null) { // if the tree is empty return 0
			return 0;
		} else if(root.left == null && root.right == null) {
			// If the leaf has been reached, it returns the depth
			return depth;
		} else {
			// Otherwise, it calls the function recursively
			// for each branch, returning the depth of each leaf. 
			int leftDepth = maxDepth(root.left, depth + 1);
			int rightDepth = maxDepth(root.right, depth + 1);
			
			// returns the highest value
			return leftDepth > rightDepth ? leftDepth : rightDepth;		
		}
	}
}
