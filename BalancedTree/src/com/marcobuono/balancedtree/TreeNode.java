package com.marcobuono.balancedtree;

/**
 * This class is a binary
 * tree of integers.
 * 
 * @author Marco Buono
 *
 */
public class TreeNode {
	
	int item; // data in the node
	TreeNode left; // pointer to left node
	TreeNode right; // pointer to right node
	
	/**
	 * This is the constructor, and make
	 * a node containing an integer
	 *  
	 * @param newItem, the integer stored
	 * in the node
	 */
	public TreeNode(int newItem) {
		item = newItem;
	}
}
